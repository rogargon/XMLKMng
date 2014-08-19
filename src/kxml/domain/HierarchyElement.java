package kxml.domain;

import kxml.util.*;
import kxml.util.remote.*;
import kxml.domain.util.*;
import java.util.*;
import org.omg.CORBA.Any;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.BooleanHolder;

public abstract class HierarchyElement extends Element
									   implements kxml.domain.remote._RemoteHierarchyElementOperations
{
	protected Vector contents;
	public kxml.domain.remote._RemoteHierarchyElementTie tie;
/**
 * 
 */
public HierarchyElement(Archive root) 
{
	super(root);
	contents = new Vector(Configuration.HIERARCHYELEMENTSIZE);
	this.tie = new kxml.domain.remote._RemoteHierarchyElementTie(this);
}
/**
 * 
 */
public HierarchyElement(Archive root, String locId, String[][] attributes,
			   			User owner, boolean publicRead, boolean publicWrite,
			   			HashSet aclRead, HashSet aclWrite)
{
	super(root, locId, attributes, owner, publicRead,
		  publicWrite, aclRead, aclWrite);
	contents = new Vector(Configuration.HIERARCHYELEMENTSIZE);
	this.tie = new kxml.domain.remote._RemoteHierarchyElementTie(this);
}
/**
 * 
 */
public void changeMeta(String metaxml) 
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	RDFManager rdfExtr = new RDFManager(new java.io.StringReader(metaxml));
	changeMeta(rdfExtr.getRDFElement());
}
/**
 * 
 */
public void changeMeta(String locId, String[][] attribs,
					   User owner, boolean publicRead, boolean publicWrite,
					   HashSet aclRead, HashSet aclWrite)
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	writing();
	
	super.changeMeta(locId, attribs, owner, publicRead, publicWrite, 
					 aclRead, aclWrite);

	endWriting();
}
/**
 * 
 */
public void changeMeta(org.w3c.dom.Element rdfElem)
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	RDFManager rdfMng = new RDFManager(rdfElem);
	Hashtable attribs = rdfMng.getAttribsFromXML();
	
	String opxml = null;
	String oldId = null;
	Object[] newValue = null;
	
	if (parent != null)
		parent.writing();
	writing();

	if (attribs.containsKey("DC:identifier"))
	{
		oldId = getIdStr();
		newValue = (Object[])attribs.get("DC:identifier");
		IdElem newId = new IdElem((String)newValue[1]);
		if (!newId.isHElement())
		{
			newId.setHElement();
			newValue[1] = newId.toString();
			attribs.put("DC:identifier", newValue);
		}
	}
	try
	{
		super.changeMeta(attribs);
		if (oldId != null)
		{
			Object[] oldValue = {"kxml:OldIdentifier", oldId};
			Hashtable opAttribs = new Hashtable(2);
			opAttribs.put(newValue[0], newValue);
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
public Element[] content() 
{
	reading();
	
	Element[] list = new Element[contents.size()];
	Enumeration e = contents.elements();
	int i = 0;
	while(e.hasMoreElements())
	{
		list[i] = (Element)e.nextElement();
		i++;
	}

	endReading();
	
	return list;
}
/**
 * 
 */
public String[] contentIds() 
{
	reading();
	
	String[] list = new String[contents.size()];
	Enumeration e = contents.elements();
	int i = 0;
	while(e.hasMoreElements())
	{
		list[i] = ((Element)e.nextElement()).getId().toString();
		i++;
	}

	endReading();
	
	return list;
}
/**
 * Asegurar que para el elemento actual en nuevo contenido a
 * archivar es del tipo inmediatamente inferior jerárquicamente.
 */
protected abstract boolean correctContent(Element elem);
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
public boolean file(Element elem) 
				throws RepeatedKeyException, NonexistentKeyException
{
	String opxml = "";
	if (!correctContent(elem))
		return false;		

	this.writing();
	elem.writing();
	
	if (this.parent == null && 	// Element has been removed, it's not filed
		!(this instanceof Archive))
	{
		elem.endWriting();
		this.endWriting();
		throw (new NonexistentKeyException(this.getId().toString()));
	}

	// Construct what will be its future id to test actual existence
	IdElem newId = new IdElem(this.getIdStr() + elem.getLocId());
	if (elem instanceof HierarchyElement)
		newId.setHElement();
	
	if (!root.dictionary.containsElem(newId))
	{
		elem.setRoot(this.root);
		Element oldParent = elem.getParent();
		elem.setParent(this);
		
		try 
		{ 
			root.dictionary.addElem(elem);
			contents.addElement(elem);				// Notify operation to obsv.
			Object[] value = {"DC:identifier", this.getIdStr()};
			Object[] contValue = {"kxml:NewContent", elem.getIdStr()};
			Hashtable opAttribs = new Hashtable(2);
			opAttribs.put(value[0], value);
			opAttribs.put(contValue[0], contValue);
			opxml = RDFManager.getXMLFromAttribs(opAttribs, null);
		}
		catch(RepeatedKeyException e)				// undo changes
		{
			elem.setParent(oldParent);
			this.endWriting();
			elem.endWriting();
			throw(e);
		}
	}
	elem.endWriting();
	this.endWriting(opxml);

	return true;
}
/**
 * 
 */
public String getIdStr() 
{
	String idStr = super.getIdStr();

	if (idStr != null)
		idStr += "/";
	
	return idStr;
}
/**
 * 
 */
public boolean getMeta(StringHolder idElem, StringArrayArrayHolder attribs,
					   StringHolder owner, BooleanHolder publicRead, 
					   BooleanHolder publicWrite, StringArrayHolder aclRead, 
					   StringArrayHolder aclWrite)
{
	boolean blocked = reading();

	idElem.value = this.getId().toString();

	attribs.value = this.attributes;
		
	owner.value = this.owner.getId();

	publicRead.value = this.publicRead;
	publicWrite.value = this.publicWrite;

	if (this.aclRead != null)
	{
		java.lang.Object[] tmpArr = this.aclRead.toArray();
		String[] strArr = new String[tmpArr.length];
		for(int i=0; i<tmpArr.length; i++)
			strArr[i] = (String)tmpArr[i];
		aclRead.value = strArr;
	}
	else
		aclRead.value = new String[0];
	if (this.aclWrite != null)
	{
		java.lang.Object[] tmpArr = this.aclWrite.toArray();
		String[] strArr = new String[tmpArr.length];
		for(int i=0; i<tmpArr.length; i++)
			strArr[i] = (String)tmpArr[i];
		aclWrite.value = strArr;
	}
	else
		aclWrite.value = new String[0];

	endReading();
	return blocked;
}
/**
 * 
 */
public boolean unFile(Element elem, String userId) 
				throws NonexistentKeyException
{
	String opxml = "";

	this.writing();
	
	if (this.parent == null && 	// Element has been removed, it's not filed
		!(this instanceof Archive))
	{
		this.endWriting();
		throw (new NonexistentKeyException(this.getId().toString()));
	}

	if (root.dictionary.containsElem(elem.getId()) && 
		elem.writeAccess(userId))
	{
		if (elem instanceof HierarchyElement)
			for(Iterator it = ((HierarchyElement)elem).contents.iterator(); it.hasNext();)
				((HierarchyElement)elem).unFile((Element)it.next(), userId);
		
		elem.writing();
		
		if ((elem instanceof HierarchyElement) && 
			((HierarchyElement)elem).contents.size() > 0)
		{
			elem.endWriting();
			this.endWriting();
			return false;
		}
		
		root.dictionary.removeElem(elem.getId());
		contents.remove(elem);
		Element oldParent = elem.getParent();
		String elemIdStr = elem.getIdStr();
		elem.setParent(null);
		
		if (elem instanceof Document)
		{
			try{((Document)elem).tie._orb().disconnect(((Document)elem).tie);}
			catch(Exception e){}
		}
		else
		{
			try{((HierarchyElement)elem).tie._orb().disconnect(((HierarchyElement)elem).tie);}
			catch(Exception e){}
		}

		// Notify change with XML string
		Object[] value = {"DC:identifier", this.getIdStr()};
		Object[] contValue = {"kxml:RemovedIdentifier", elemIdStr};
		Hashtable opAttribs = new Hashtable(2);
		opAttribs.put(value[0], value);
		opAttribs.put(contValue[0], contValue);
		opxml = RDFManager.getXMLFromAttribs(opAttribs, null);
	}
	elem.endWriting();
	this.endWriting(opxml);

	return true;
}
}
