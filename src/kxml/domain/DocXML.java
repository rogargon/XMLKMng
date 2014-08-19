package kxml.domain;

import kxml.domain.util.*;
import kxml.util.*;
import java.net.URL;
import java.util.*;

public class DocXML extends Document
{
	private DTD dtd;
/**
 * 
 */
public DocXML(Archive root, String locId, String[][] attribs, User owner, 
			  boolean publicRead, boolean publicWrite, 
			  HashSet aclRead, HashSet aclWrite, URL uri,
			  DocType doctype, DTD dtd)
{
	super(root, locId, attribs, owner, publicRead, publicWrite, 
		  aclRead, aclWrite, uri, doctype);
	this.dtd = dtd;
}
/**
 * DocXML constructor comment.
 */
public DocXML(Archive root, DTD dtd) 
{
	super(root);
	this.dtd = dtd;
}
/**
 * 
 */
public void changeMeta(String metaxml) 
				throws java.net.MalformedURLException, RepeatedKeyException, 
					   NonexistentKeyException, InvalidKeyException
{
	RDFManager rdfExtr = new RDFManager(new java.io.StringReader(metaxml));
	changeMeta(rdfExtr.getRDFElement());
}
/**
 * 
 */
public void changeMeta(String locId, String[][] attribs, User owner, 
					   boolean publicRead, boolean publicWrite, 
					   HashSet aclRead, HashSet aclWrite, 
					   URL uri, DocType doctype, DTD dtd)
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	writing();

	super.changeMeta(locId, attribs, owner, publicRead,
		  			 publicWrite, aclRead, aclWrite);
	this.uri = uri;
	this.doctype = doctype;
	this.dtd = dtd;
	
	endWriting();
}
/**
 * 
 */
public void changeMeta(org.w3c.dom.Element rdfElem)
				throws java.net.MalformedURLException, RepeatedKeyException, 
					   NonexistentKeyException, InvalidKeyException
{
	RDFManager rdfMng = new RDFManager(rdfElem);
	Hashtable attribs = rdfMng.getAttribsFromXML();
	
	String opxml = null;
	String oldId = null;
	Object[] values, newId = null;

	if (parent != null)
		parent.writing();
	writing();

	if (attribs.containsKey("DC:identifier"))
	{
		oldId = getIdStr();
		newId = (Object[])attribs.get("DC:identifier");
	}
	if (attribs.containsKey("DC:format"))
	{
		values = (Object[])attribs.get("DC:format");
		if (root.dictionary.containsDocType((String)values[1]))
		{
			DocType docType = root.dictionary.getDocType((String)values[1]);
			this.doctype = docType;
		}
		else
			throw(new NonexistentKeyException("Document.changeMeta(): "+
									"doctype non existent, "+values[1]));
		attribs.remove("DC:format");
	}	

	if (attribs.containsKey("URI"))
	{
		values = (Object[])attribs.get("URI");
		this.uri = new URL((String)values[1]);
		attribs.remove("URI");
	}

	if (attribs.containsKey("kxml:DTDName"))
	{
		Object[] name = (Object[])attribs.get("kxml:DTDName");
		DTD dtd = ((XMLType)doctype).getDTD((String)name[1]);
		if (dtd == null && attribs.containsKey("kxml:DTDUri"))										// New DTD
		{
			Object[] uri = (Object[])attribs.get("kxml:DTDUri");
			dtd = new DTD((String)name[1],new URL((String)uri[1]));
			((XMLType)doctype).addDTD(dtd);
			attribs.remove("kxml:DTDUri");
		}
		this.dtd = dtd;
		attribs.remove("kxml:DTDName");
	}	
	
	try
	{
		changeMeta(attribs);
		if (oldId != null)
		{
			Object[] oldValue = {"kxml:OldIdentifier", oldId};
			Hashtable opAttribs = new Hashtable(2);
			opAttribs.put(newId[0], newId);
			opAttribs.put(oldValue[0], oldValue);
			opxml = RDFManager.getXMLFromAttribs(opAttribs, null);
		}
	}
	finally
	{
		endWriting(opxml);
		if (parent != null)			// Notify to parent locId change
			((HierarchyElement)parent).endWriting(opxml);
	}
}
/**
 * 
 */
public DTD getDtd() 
{
	return dtd;
}
}
