package kxml.gui;

import kxml.util.TreekeyedHashtable;
import kxml.domain.IdElem;
import javax.swing.tree.*;
import java.util.Hashtable;
/**
 * 
 */
public class ArchiveModel extends DefaultTreeModel 
{
	TreekeyedHashtable nodeIds = new TreekeyedHashtable();
/**
 * 
 */
public ArchiveModel(DefaultMutableTreeNode root) 
{
	super(root);
	
	nodeIds.put(root.getUserObjectPath(), root);
}
/**
 * 
 */
public ArchiveModel(DefaultMutableTreeNode root, boolean asksAllowsChildren) 
{
	super(root, asksAllowsChildren);

	nodeIds.put(root.getUserObjectPath(), root);

	
}
/**
 * 
 */
public void addChildNodes(DefaultMutableTreeNode parent,String[] ids) 
{
	IdElem id = null;
	
	if (ids.length == 0)			// Nothing to do
		return;
	
	Object[] parentKey = parent.getUserObjectPath();
	Object[] childKey = new Object[parentKey.length+1];
	for(int i=0; i<parentKey.length; i++)
		childKey[i] = parentKey[i];

	DefaultMutableTreeNode child = null;
	int[] indices = new int[ids.length];
	int initChilds = parent.getChildCount();
	
	for (int i=0; i<ids.length; i++)
	{
		id = new IdElem(ids[i]);
		child = new DefaultMutableTreeNode(id.getLocId());
		child.setAllowsChildren(id.isHElement());
		parent.add(child);
		indices[i] = i + initChilds;
		childKey[childKey.length-1] = id.getLocId();
		nodeIds.put(childKey, child);
	}
	nodesWereInserted(parent, indices);
}
/**
 * 
 */
public void changeNodeId(DefaultMutableTreeNode node, String newId) 
{
	Object[] oldIdKey = node.getUserObjectPath();
	Object[] newIdKey = new Object[oldIdKey.length];
	for(int i=0; i<oldIdKey.length-1; i++)
		newIdKey[i] = oldIdKey[i];
	newIdKey[newIdKey.length-1] = newId;
	
	node.setUserObject(newId);
	nodeIds.changeKey(oldIdKey, newIdKey);	

	int[] indices = {node.getParent().getIndex(node)};
	nodesChanged(node.getParent(), indices);
}
/**
 * 
 */
public void clearChildNodes(DefaultMutableTreeNode parent) 
{
	int n = parent.getChildCount();

	if (n == 0)				// Nothing to do
		return;
	
	DefaultMutableTreeNode[] childs = new DefaultMutableTreeNode[n];
	int[] indices = new int[n];
	for (int i=0; i<n; i++)
	{
		childs[i] = (DefaultMutableTreeNode)parent.getChildAt(0);
		nodeIds.remove(childs[i].getUserObjectPath());
		parent.remove(0);
		indices[i] = i;
	}
	nodesWereRemoved(parent, indices, childs);
}
/**
 * 
 */
public void clearChildsChildNodes(DefaultMutableTreeNode parent) 
{
	int n = parent.getChildCount();

	if (n == 0)				// Nothing to do
		return;
	
	DefaultMutableTreeNode child;
	for (int i=0; i<n; i++)
	{
		child = (DefaultMutableTreeNode)parent.getChildAt(0);
		clearChildNodes(child);
	}
}
/**
 * 
 */
public DefaultMutableTreeNode getNodeFromId(String[] pathId) 
{
	kxml.domain.IdElem id = new kxml.domain.IdElem(pathId);
	
	return (DefaultMutableTreeNode)nodeIds.get(id.toArray());
}
/**
 * 
 */
public DefaultMutableTreeNode getNodeFromId(String pathId) 
{
	kxml.domain.IdElem id = new kxml.domain.IdElem(pathId);
	
	return (DefaultMutableTreeNode)nodeIds.get(id.toArray());
}
/**
 * 
 */
public void removeChildNodes(DefaultMutableTreeNode parent,String[] ids) 
{
	IdElem id = null;
	
	if (ids.length == 0)			// Nothing to do
		return;

	DefaultMutableTreeNode[] childs = new DefaultMutableTreeNode[ids.length];
	int[] indices = new int[ids.length];
	
	for (int i=0; i<ids.length; i++)
	{
		childs[i] = getNodeFromId(ids[i]);
		removeNodeFromParent(childs[i]);
		nodeIds.remove(new IdElem(ids[i]).toArray());
	}
	try
	{ nodesWereRemoved(parent, indices, childs); }
	catch(Exception e)
	{}
}
}
