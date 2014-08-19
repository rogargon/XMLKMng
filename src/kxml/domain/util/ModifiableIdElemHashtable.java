package kxml.domain.util;

import kxml.domain.*;
import kxml.util.TreekeyedHashtable;
/**
 * ModifiableIdElemHashtable is a TreekeyedHashtable with the services for
 * synchronization provided by ModifiableObj. It's also adapted to operate
 * directly with kxml.domain.IdElem as keys and kxml.domain.Element as values.
 */
public class ModifiableIdElemHashtable extends kxml.util.ModifiableObj 
{
	private TreekeyedHashtable tkHashtable;
/**
 * 
 */
public ModifiableIdElemHashtable() 
{
	super();
	this.tkHashtable = new TreekeyedHashtable();
}
/**
 * 
 */
public ModifiableIdElemHashtable(int n) 
{
	super();
	this.tkHashtable = new TreekeyedHashtable(n);
}
/**
 * 
 */
public boolean changeKey(IdElem oldId, IdElem newId) 
{
	Object[] oldKey = oldId.toArray();
	Object[] newKey = newId.toArray();
	
	return tkHashtable.changeKey(oldKey, newKey);
}
/**
 * 
 */
public boolean containsKey(IdElem id) 
{
	Object[] key = id.toArray();

	return tkHashtable.containsKey(key);
}
/**
 * 
 */
public Element get(IdElem id) 
{
	Object[] key = id.toArray();
	
	return (Element)tkHashtable.get(key);
}
/**
 * 
 */
public void put(IdElem id, Element elem) 
{
	Object[] key = id.toArray();

	tkHashtable.put(key, elem);
}
/**
 * 
 */
public void remove(IdElem id) 
{
	Object[] key = id.toArray();
	
	tkHashtable.remove(key);
}
}
