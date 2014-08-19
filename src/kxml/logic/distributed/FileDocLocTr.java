package kxml.logic.distributed;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.logic.server.TransacOriginSrv;
import kxml.util.*;
import java.util.*;
import java.io.*;
import org.apache.xerces.parsers.*;
import org.apache.xerces.dom.DocumentTypeImpl;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.xml.sax.*;
import java.net.*;

public class FileDocLocTr extends LocalTransaction
{
	private TransacOriginSrv trOriginSrv;
	private IdElem idElem;
	private String metaxml;
/**
 * 
 */
public FileDocLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv,
					   TransacOriginSrv trOriginSrv,
					   IdElem id, String metaxml)
{
	super(archive, userId, consistencyMngSrv);
	this.trOriginSrv = trOriginSrv;
	this.idElem = id;
	this.metaxml = metaxml;
}
/**
 * 
 */
public void run()
{
	String uriDoc, docType;
	
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("FileDocLocTr: "+
									"current user not found, "+userId);
		return;
	}

	//get elem where creation will take place
	Element elem = archive.dictionary.getElem(idElem);

	if (elem == null || !(elem instanceof Folder))
	{
		exception = new CreationException("FileDocLocTr: "+
						"creation point should be an existent folder");
		return;
	}
	
	if (elem.writeAccess(userId))
	{
		// Test metadata begore distributing transaction
		RDFManager rdfMng = new RDFManager(new StringReader(this.metaxml));
		Hashtable attribs = rdfMng.getAttribsFromXML();
		if (attribs.containsKey("kxml:Owner"))
		{
			Object[] values = (Object[])attribs.get("kxml:Owner");
			if (!archive.dictionary.containsUser((String)values[1]))
			{
				exception = new UserNotFoundException("FileDocLocTr: "+
								"new element owner not found, "+values[1]);
				return;
			}
		}
		else
		{
			exception = new CreationException("FileDocLocTr: "+
								"element owner not specified");
			return;
		}
		if (attribs.containsKey("DC:identifier"))
		{
			Object[] values = (Object[])attribs.get("DC:identifier");
			String locId = new IdElem((String)values[1]).getLocId();
			if (locId.trim().equals(""))
			{
				exception = new CreationException("FileDocLocTr: "+
								"invalid local identifier");
				return;
			}
			// Ensure new element inside the creation point element
			IdElem newId = new IdElem(elem.getIdStr() + locId);
			if (archive.dictionary.containsElem(newId))
			{
				exception = new ElementExistsException("FileDocLocTr: "+
										"document exists, "+newId);
				return;
			}
		}
		else
		{
			exception = new CreationException("FileDocLocTr: "+
								"element identifier not specified");
			return;
		}
		if (attribs.containsKey("DC:format"))
		{
			Object[] values = (Object[])attribs.get("DC:format");
			if (!archive.dictionary.containsDocType((String)values[1]))
			{
				exception = new CreationException("FileDocLocTr: "+
								"new document format not found, "+values[1]);
				return;
			}
			else
				docType = (String)values[1];
		}
		else
		{
			exception = new CreationException("FileDocLocTr: "+
								"document format not specified");
			return;
		}
		if (attribs.containsKey("URI"))
		{
			Object[] values = (Object[])attribs.get("URI");
			uriDoc = (String)values[1];
		}
		else
		{
			exception = new CreationException("FileDocLocTr: "+
								"document content URI not specified");
			return;
		}
		
		if (docType.equals("text/xml"))
		{
			org.w3c.dom.Document doc = null;
			String dtdName = null, dtdUri = null;
			
			try 
			{
				DOMParser ps = new DOMParser();
				ps.setFeature("http://xml.org/sax/features/validation", false);
				ps.setFeature("http://apache.org/xml/features/continue-after-fatal-error", true);
				ps.parse(new InputSource(uriDoc));
				doc = ps.getDocument();
				DocumentType xmlInfo = doc.getDoctype();
				dtdName = xmlInfo.getName();
				dtdUri = ((DocumentTypeImpl)xmlInfo).getSystemId();
			}
			catch(Exception e)
			{
				System.out.println("FileDocLocTr: "+e);
			}
			if (dtdName != null)
			{
				String[] dtdAttrib1 = {"kxml:DTDName", dtdName};
				attribs.put(dtdAttrib1[0], dtdAttrib1);
				if (dtdUri != null)
				{
					try { new URL(dtdUri); }
					catch(MalformedURLException e1)
					{
						// Realative DTD URL from XML Doc URL
						String base = uriDoc.substring(0, uriDoc.lastIndexOf('/')+1);
						dtdUri = base + dtdUri;
					}
					String[] dtdAttrib2 = {"kxml:DTDUri", dtdUri};
					attribs.put(dtdAttrib2[0], dtdAttrib2);
				}
				metaxml = RDFManager.getXMLFromAttribs(attribs, null);
			}
		}
		
		long trNum = consistencyMngSrv.fileDocDist(idElem.toString(), metaxml);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new WriteAccessException("FileDocLocTr: write access "+
									"not allowed for" +userId+" on "+idElem);
}
}
