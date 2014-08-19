package kxml.domain;

import kxml.domain.util.*;
import kxml.util.*;
import kxml.util.remote.*;
import java.net.URL;
import java.io.*;
import java.util.*;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.Any;

public class Document extends Element
					  implements kxml.domain.remote._RemoteDocumentOperations
{
	protected URL uri;
	protected DocType doctype;
	protected ContentBroker contentBroker;
	
	public kxml.domain.remote._RemoteDocumentTie tie;
/**
 * 
 */
public Document(Archive root) 
{
	super(root);
	this.contentBroker = new ContentBroker();
	
	this.tie = new kxml.domain.remote._RemoteDocumentTie(this);
}
/**
 * 
 */
public Document(Archive root, String locId, String[][] attribs, 
				 User owner,boolean publicRead, boolean publicWrite,
				HashSet aclRead, HashSet aclWrite, 
				URL uri, DocType doctype) 
{
	super(root, locId, attribs, owner, publicRead,
		  publicWrite, aclRead, aclWrite);
	
	this.uri = uri;
	this.doctype = doctype;
	this.contentBroker = new ContentBroker();

	this.tie = new kxml.domain.remote._RemoteDocumentTie(this);
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
					   URL uri,  DocType doctype)
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	writing();

	super.changeMeta(locId, attribs, owner, publicRead,
		  			 publicWrite, aclRead, aclWrite);
	this.uri = uri;
	this.doctype = doctype;
	
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
public void endWriting() 
{
	super.endWriting();
	setChanged();
	notifyObservers(this.tie, CORBAConfig.anyNull);
}
/**
 * 
 */
public void endWriting(String metaxml) 
{
	super.endWriting();
	setChanged();
	if (metaxml != null)
	{
		Any stringAny = CORBAConfig.getAny();
		stringAny.insert_string(metaxml);
		notifyObservers(this.tie, stringAny);
	}
	else
		notifyObservers(this.tie, CORBAConfig.anyNull);
}
/**
 * 
 */
public void endWriting(boolean changed) 
{
	super.endWriting();

	if (changed)
	{
		setChanged();
		notifyObservers(this.tie, CORBAConfig.anyNull);
	}
}
/**
 * 
 */
public ContentBroker getContentBroker() 
{
	return contentBroker;
}
/**
 * 
 */
public DocType getDocType() 
{
	return doctype;
}
/**
 * 
 */
public boolean getMeta(StringHolder idElem, StringArrayArrayHolder attribs, 
		StringHolder owner, BooleanHolder publicRead, 
		BooleanHolder publicWrite, StringArrayHolder aclRead, 
		StringArrayHolder aclWrite, StringHolder uri)
{
	boolean blocked = reading();

	idElem.value = getId().toString();

	attribs.value = this.attributes;

	owner.value = this.owner.getId();

	publicRead.value = this.publicRead;
	publicWrite.value = this.publicWrite;

	if (this.aclRead != null)
		aclRead.value = (String[])this.aclRead.toArray();
	else
		aclRead.value = new String[0];
	if (this.aclWrite != null)
		aclWrite.value = (String[])this.aclWrite.toArray();
	else
		aclWrite.value = new String[0];

	uri.value = this.uri.toString();
	
	endReading();
	return blocked;
}
/**
 * 
 * @return java.net.URL
 */
public URL getUri() 
{
	return this.uri;
}
/**
 * 
 */
public void setDocType(DocType newValue) 
{
	this.doctype = newValue;
}
/**
 * 
 */
public void setUri(URL newValue) 
{
	this.uri = newValue;
}
}
