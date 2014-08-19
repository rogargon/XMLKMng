package kxml.domain;

import kxml.util.*;
import kxml.domain.util.*;
import kxml.persistence.*;
import org.omg.CORBA.StringHolder;
import java.util.*;

public abstract class Element extends kxml.util.remote.ModifiableObservableObj
{
	protected String locId;

	protected String[][] attributes;

	protected String[][] namespaces;
		
	protected User owner;
	protected boolean publicRead;
	protected boolean publicWrite;
	protected HashSet aclRead;
	protected HashSet aclWrite;
	
	protected Element parent;
	protected Archive root;
/**
 * 
 */
public Element(Archive root) 
{
	super();
	this.locId = "unidentified";
	//this.id = null;				// It's no valid until the element is filed
	this.owner = null;			

	this.publicRead = true;
	this.aclRead = null;
		
	this.publicWrite = true;
	this.aclWrite = null;

	this.root = root;			// Pointer to the root of the archive and the parent
	this.parent = null;			// of this element. Not valid until filed.
	
}
/**
 * 
 * locId: element local identifier, unique only inside the parent contents, where
 * this element is filed.
 * The global identifier, valid after filed, is composed by concatenation of the
 * locIds of all the elements from the root to parent plus the current locId.
 */
public Element(Archive root, String locId, String[][] attributes,
			   User owner, boolean publicRead, boolean publicWrite,
			   HashSet aclRead, HashSet aclWrite) 
{
	super();
	this.locId = locId;
	//this.id = null;				// Not valid until filed.

	this.owner = owner;

	this.publicRead = publicRead;
	if (publicRead)
		this.aclRead = null;
	else
		this.aclRead = aclRead;
		
	this.publicWrite = publicWrite;
	if (publicWrite)
		this.aclWrite = null;
	else
		this.aclWrite = aclWrite;

	this.attributes = attributes;
		
	this.root = root;
	this.parent = null;			// Not valid until filed..
}
/**
 * All calls to this method should be encapsulated externally between 
 * calls to writing/endWriting to garantize the consistency of the element.
 */
public void changeMeta(String locId, String[][] attributes,
 					   User owner, boolean publicRead, boolean publicWrite,
					   HashSet aclRead, HashSet aclWrite)
	  throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	setLocId(locId);
	/*// if elem filed and not root update the global id
	if (parent != null && this != root)
		this.id = new IdElem(parent.getId().toString() + "/" + locId);*/
		
	this.attributes = attributes;
	
	this.owner = owner;

	this.publicRead = publicRead;
	if (publicRead)
		this.aclRead = null;
	else
		this.aclRead = aclRead;
		
	this.publicWrite = publicWrite;
	if (publicWrite)
		this.aclWrite = null;
	else
		this.aclWrite = aclWrite;
}
/**
 * All calls to this method should be encapsulated externally between 
 * calls to writing/endWriting to garantize the consistency of the element.
 */
public void changeMeta(Hashtable attribs) 
		throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	Object[] values;

	if (attribs.containsKey("NS"))
	{
		this.namespaces = (String[][])attribs.get("NS");
		attribs.remove("NS");
	}
	
	if (attribs.containsKey("DC:identifier"))
	{
		values = (Object[])attribs.get("DC:identifier");
		IdElem newId = new IdElem((String)values[1]);
		setLocId(newId.getLocId());
		attribs.remove("DC:identifier");
	}
	if (attribs.containsKey("kxml:Owner"))
	{
		values = (Object[])attribs.get("kxml:Owner");
		User newOwner = root.dictionary.getUser((String)values[1]);
		if (newOwner == null)				// If owner nonexistence, set default
			newOwner = root.dictionary.getUser("administrator");
		this.owner = newOwner;
		attribs.remove("kxml:Owner");
	}
	if (attribs.containsKey("kxml:Read"))
	{
		values = (Object[])attribs.get("kxml:Read");
		if (((String)values[1]).equals("Public"))
		{
			this.publicRead = true;
			this.aclRead = null;
		}
		else
		{
			this.publicRead = false;
			this.aclRead = new HashSet(values.length-1);
			for (int i=1; i<values.length; i++)
				if ((String)values[i] != "")
					this.aclRead.add(values[i]);
		}
		attribs.remove("kxml:Read");
	}
	if (attribs.containsKey("kxml:Write"))
	{
		values = (Object[])attribs.get("kxml:Write");
		if (((String)values[1]).equals("Public"))
		{
			this.publicWrite = true;
			this.aclWrite = null;
		}
		else
		{
			this.publicWrite = false;
			this.aclWrite = new HashSet(values.length-1);
			for (int i=1; i<values.length; i++)
				if ((String)values[i] != "")
					this.aclWrite.add(values[i]);
		}
		attribs.remove("kxml:Write");
	}
	
	if (attribs.containsKey("DC:format"))
		attribs.remove("DC:format");		// Attr. only allowed for docs
	if (attribs.containsKey("URI"))
		attribs.remove("URI");				// Attr. only allowed for docs
			
	if (!attribs.isEmpty())
	{
		// Obtain old attributes
		Hashtable currentAttr = new Hashtable(RDFManager.STANDARD_ATTRIBS);
		if (attributes != null)
			for(int i=0; i<attributes.length; i++)
				currentAttr.put(attributes[i][0], attributes[i]);

		// Merge old attributes with changes
		Enumeration e = attribs.elements();
		while(e.hasMoreElements())
		{
			Object[] value = (Object[])e.nextElement();
			if (((String)value[1]).trim().equals(""))
				currentAttr.remove(value[0]);
			else
				currentAttr.put(value[0], value);
		}

		// Store new attributes
		attributes = new String[currentAttr.size()][];
		e = currentAttr.elements();
		for(int i=0; e.hasMoreElements(); i++)
		{
			Object[] tmp = (Object[])e.nextElement();
			String[] attvalues = new String[tmp.length];
			for (int j=0; j<tmp.length; j++)
				attvalues[j] = (String)tmp[j];
			attributes[i] = attvalues;
		}
	}
}
/**
 * 
 */
public boolean equals(Object obj) 
{
	return this.getIdStr().equals(((Element)obj).getIdStr());
}
/**
 * 
 */
public HashSet getAclRead() 
{
	return aclRead;
}
/**
 * 
 */
public HashSet getAclWrite() 
{
	return aclWrite;
}
/**
 * 
 */
public String[][] getAttributes() 
{
	return attributes;
}
/**
 * 
 */
public IdElem getId() 
{
	return new IdElem(getIdStr());
}
/**
 * 
 */
public String getIdStr() 
{
	if (parent == null)				// if not filed id is not valid
		return null;
		
	String id = new String(locId);
	Element elem = this;
	
	while (elem.parent != null)		// traverse until root
	{
		elem = elem.parent;
		id = elem.locId + "/" + id;
	}
	return id;
}
/**
 * 
 */
public String getLocId() 
{
	return locId;
}
/**
 * 
 */
public boolean getMetaXML(StringHolder metaxml)
{
	boolean blocked = reading();

	metaxml.value = XMLFactory.getXMLFromElem(this);

	endReading();
	return blocked;
}
/**
 * 
 */
public String[][] getNamespaces() 
{
	return this.namespaces;
}
/**
 * 
 */
public User getOwner() 
{
	if (owner == null)
	{
		owner = this.root.dictionary.getUser("administrator");
	}
	
	return owner;
}
/**
 * 
 */
public Element getParent() 
{
	return parent;
}
/**
 * 
 */
public boolean getPublicRead() 
{
	return publicRead;
}
/**
 * 
 */
public boolean getPublicWrite() 
{
	return publicWrite;
}
/**
 * 
 */
public Archive getRoot() 
{
	return root;
}
/**
 * 
 */
public boolean isOwner(String userId) 
{
	boolean isOwner = false;
	User user = root.dictionary.getUser(userId);
	
	if (user != null)
		isOwner = owner.equals(user) || user.isAdmin();
		
	return isOwner;
}
/**
 * Devuelve cierto, se permite el acceso, si el elemento es público o el
 * usuario actual está en la la lista de control de acceso de lectura o
 * pertenece a alguno de los grupos que aparecen en ella.
 */
public boolean readAccess(String userId)
{
	boolean access = false;

	User current = root.dictionary.getUser(userId);
	
	reading();			//Evitar modificaciones mientras se produce el acceso
	
	if (publicRead || isOwner(userId) || current.isAdmin() ||
		aclRead.contains(current))
	   access = true;	
	else
	{
		Iterator it = aclRead.iterator();
		while(it.hasNext() && !access)
		{
			java.lang.Object obj = it.next();
			if (obj instanceof Group)
				if (((Group)obj).contains(current))
					access = true;
		}
	}
	endReading();
	
	return access;
}
/**
 * 
 */
public void setAttributes(String[][] newValue) 
{
	this.attributes = newValue;
}
/**
 * Change the local identificator, but if element is filed, update 
 * also the global id consequently.
 */
public void setLocId(String newLocId) 
	throws RepeatedKeyException, NonexistentKeyException, InvalidKeyException
{
	if (newLocId.indexOf('/') >= 0)
		throw (new InvalidKeyException("Local identificator can't contain '/'"));
	
	if (parent == null)				// not filed, update locId
		this.locId = newLocId;
	else							// filed, update locId and id in dictionary
	{		
		IdElem currentId = getId();
			
		if (root.dictionary.containsElem(currentId))	// in dictionary, change
		{
			IdElem newId = new IdElem(currentId.getBase() + newLocId);
			if (this instanceof HierarchyElement)
				newId.setHElement();
				
			root.dictionary.changeIdElem(currentId, newId);
			this.locId = newLocId;
		}
		else											// not in dictionary, add
		{
			String oldLocId = getLocId();
			this.locId = newLocId;
			try { root.dictionary.addElem(this); }
			catch(RepeatedKeyException e)				// undo change
			{
				this.locId = oldLocId;
				throw(e); 
			}
		}
	}

}
/**
 * 
 */
public void setOwner(User newValue) 
{
	this.owner = newValue;
}
/**
 * 
 */
public void setParent(Element newValue) 
{
	this.parent = newValue;
}
/**
 * 
 */
public void setRoot(Archive newValue) 
{
	this.root = newValue;
}
/**
 * 
 */
public String toString() 
{
	return "Element: id="+getIdStr();
}
/**
 * Mismas comprobaciones que en accesoLectura pero sobre las estructuras
 * referentes a este tipo de acceso.
 */
public boolean writeAccess(String userId) 
{
	boolean access = false;

	User current = root.dictionary.getUser(userId);
	
	reading();			//Evitar modificaciones mientras se produce el acceso
	
	if (publicWrite || isOwner(userId) || current.isAdmin() || 
		aclWrite.contains(current))
	   access = true;	
	else
	{
		Iterator it = aclWrite.iterator();
		while(it.hasNext() && !access)
		{
			java.lang.Object obj = it.next();
			if (obj instanceof Group)
				if (((Group)obj).contains(current))
					access = true;
		}
	}
	endReading();
	
	return access;
}
}
