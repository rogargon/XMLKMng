package kxml.util;

import java.util.Hashtable;
/**
 * This class implements a common hashtable with a particular system to manage
 * the keys. The keys are treepaths so it's oriented to use as a rapid access
 * structure to nodes in a tree. As a consequence of his treed keys changes in
 * a antecessor in the tree affect his successors, as it happens in a simple tree
 * structure, maintaining the correspondence between the indexed tree an the
 * TreekeyedHashtable.
 * Example: consider  a change in the name of a node in the indexed tree. 
 * This name is used, combined with the other names from the root to this node,
 * as its identifier. It's obvious this change affects the identifier of all
 * its child nodes, because it's in their treepath an his name has changed.
 * This situation is easily resolved by this structure because its treekeyed
 * orientation actualises all the affected keys, the current node key an all
 * the keys of its children.
 */
public class TreekeyedHashtable
{
	private Hashtable rootHt;
	private int htSize = 1;

	private class TkHashtableNode
	{
		private Hashtable nodeHt;
		private Object value;

		public TkHashtableNode()
		{
			nodeHt = new Hashtable(htSize);
		}
	}
/**
 * 
 */
public TreekeyedHashtable() 
{
	rootHt = new Hashtable(htSize);
}
/**
 * 
 */
public TreekeyedHashtable(int n) 
{
	htSize = n;
	rootHt = new Hashtable(htSize);	
}
/**
 * Changing the key provokes the movement of all the tree substructure
 * of the node referred by oldKey. All its successors change the initial
 * part of its keys correspondent to oldKey to the new value.
 * Return false if the change hasn´t been achieved.
 */
public boolean changeKey(Object[] oldKey, Object[] newKey) 
{
	TkHashtableNode parent, target, destination;

	// Get target node to move and remove it from its parent
	if (rootHt.containsKey(oldKey[0]))
		parent = (TkHashtableNode)rootHt.get(oldKey[0]);
	else
		return false;
		
	for(int i=1; i<oldKey.length-1; i++)
	{
		if (parent.nodeHt.containsKey(oldKey[i]))
			parent = (TkHashtableNode)parent.nodeHt.get(oldKey[i]);
		else
			return false;
	}
	if (parent.nodeHt.containsKey(oldKey[oldKey.length-1]))
		target = (TkHashtableNode)parent.nodeHt.get(oldKey[oldKey.length-1]);
	else
		return false;

	// Get destination  no where target will be moved
	if (rootHt.containsKey(newKey[0]))
		destination = (TkHashtableNode)rootHt.get(newKey[0]);
	else
		return false;
		
	for(int i=1; i<newKey.length-1; i++)
	{
		if (destination.nodeHt.containsKey(newKey[i]))
			destination = (TkHashtableNode)destination.nodeHt.get(newKey[i]);
		else
			return false;
	}

	// Move target node into destination
	parent.nodeHt.remove(oldKey[oldKey.length-1]);
	destination.nodeHt.put(newKey[newKey.length-1], target);
	return true;
}
/**
 * 
 */
public boolean containsKey(Object[] key) 
{
	TkHashtableNode node;
	
	if (rootHt.containsKey(key[0]))
		node = (TkHashtableNode)rootHt.get(key[0]);
	else
		return false;
		
	for(int i=1; i<key.length; i++)
	{
		if (node.nodeHt.containsKey(key[i]))
			node = (TkHashtableNode)node.nodeHt.get(key[i]);
		else
			return false;
	}
	return true;
}
/**
 * 
 */
public Object get(Object[] key) 
{
	TkHashtableNode node;
	
	if (rootHt.containsKey(key[0]))
		node = (TkHashtableNode)rootHt.get(key[0]);
	else
		return null;
		
	for(int i=1; i<key.length; i++)
	{
		if (node.nodeHt.containsKey(key[i]))
			node = (TkHashtableNode)node.nodeHt.get(key[i]);
		else
			return null;
	}
	return node.value;
}
/**
 * 
 */
public void put(Object[] key, Object value) 
{
	TkHashtableNode node;
	Hashtable parentHt;
	
	if (!rootHt.containsKey(key[0]))
	{
		node = new TkHashtableNode();
		rootHt.put(key[0], node);
	}
	else
		node = (TkHashtableNode)rootHt.get(key[0]);
		
	for(int i=1; i<key.length; i++)
	{
		parentHt = node.nodeHt;
		if (!parentHt.containsKey(key[i]))
		{
			node = new TkHashtableNode();
			parentHt.put(key[i], node);
		}
		else
			node = (TkHashtableNode)parentHt.get(key[i]);

	}
	node.value = value;
}
/**
 * 
 */
public void remove(Object[] key) 
{
	TkHashtableNode node;
	
	if (rootHt.containsKey(key[0]))
		node = (TkHashtableNode)rootHt.get(key[0]);
	else
		return;
		
	for(int i=1; i<key.length-1; i++)
	{
		if (node.nodeHt.containsKey(key[i]))
			node = (TkHashtableNode)node.nodeHt.get(key[i]);
		else
			return;
	}

	node.nodeHt.remove(key[key.length-1]);
	
}
}
