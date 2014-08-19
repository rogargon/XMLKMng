package kxml.logic.distributed;

import kxml.domain.*;
import kxml.domain.util.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.util.RDFManager;
import java.io.StringReader;
import java.util.Hashtable;
import java.net.*;
/**
 * 
 */
public class FileDocDistTr extends DistributedTransaction 
{
	private IdElem id;
	private String metaxml;
/**
 * 
 */
public FileDocDistTr(long trNum, Archive archive, IdElem id, String metaxml) 
{
	super(trNum, archive);
	this.id = id;
	this.metaxml = metaxml;
}
/**
 *
 */
public void run()
{
	Exception exception = null;
	String message = null;
	archive.logger.logMessage("FileDocDistTr: creating document in " + id);

	Element elem = archive.dictionary.getElem(id);
	Document newDoc;
	
	if (elem == null || !(elem instanceof Folder))
	{
		message = "FileDocDistTr: creation point should be an existent folder";
		exception = new CreationException(message);
		archive.logger.logMessage(message);
		archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
		return;						// Log error message an return exception
	}

	// Test metadata
	RDFManager rdfMng = new RDFManager(new StringReader(this.metaxml));
	Hashtable attribs = rdfMng.getAttribsFromXML();
	String docType = null;
	if (attribs.containsKey("DC:format"))
	{
		Object[] values = (Object[])attribs.get("DC:format");
		if (!archive.dictionary.containsDocType((String)values[1]))
			message = "FileDocDistTr: new docType values[1] not found";
		else
			docType = (String)values[1];
	}
	else
		message = "FileDocDistTr: document format not specified";

	if (message != null)				// An error has been produced
	{
		exception = new CreationException(message);
		archive.logger.logMessage(message);
		archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
		return;						// Log error message an return exception
	}

	if ("text/xml".equals(docType))
	{
		String dtdName = null;
		URL dtdUri = null;
		Object[] values;
		DTD dtd = null;
		if (attribs.containsKey("kxml:DTDName"))
		{
			values = (Object[])attribs.get("kxml:DTDName");
			dtdName = (String)values[1];
			attribs.remove("kxml:DTDName");
		}
		if (attribs.containsKey("kxml:DTDUri"))
		{
			values = (Object[])attribs.get("kxml:DTDUri");
			try 
			{ 
				dtdUri = new URL((String)values[1]); 
			}
			catch(MalformedURLException e1)
			{
				dtdUri = null;
			}
			attribs.remove("kxml:DTDUri");
		}
		metaxml = RDFManager.getXMLFromAttribs(attribs, null);

		XMLType xmlType = (XMLType)archive.dictionary.
										getDocType("text/xml");
		
		if (xmlType.containsDTD(dtdName))
			dtd = xmlType.getDTD(dtdName);
		else if (dtdUri != null)
		{
			dtd = new DTD(dtdName, dtdUri);
			try
			{ xmlType.addDTD(dtd); }
			catch(RepeatedKeyException e){}
		}

		if (dtd != null)
			newDoc = new DocXML(archive, dtd);
		else
			newDoc = new Document(archive);
	}
	else
		newDoc = new Document(archive);
	
	try									// Create new document and file it
	{
		newDoc.changeMeta(metaxml);
		((HierarchyElement)elem).file(newDoc);
	}
	catch(RepeatedKeyException e)
	{
		message = "FileDocDistTr: "+"repeated key " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	catch(NonexistentKeyException e)
	{
		message = "FileDocDistTr: "+"nonexistent " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	catch(InvalidKeyException e)
	{
		message = "FileDocDistTr: "+"invalid key " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	catch(java.net.MalformedURLException e)
	{
		message = "FileDocDistTr: "+ e;
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	archive.logger.logMessage("FileDocDistTr: "+
							  "element created " + newDoc.getId());
	
	archive.consistencyMngClt.notifyTrEnd(trNum, newDoc.tie, exception);
}
}
