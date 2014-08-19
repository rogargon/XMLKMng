package kxml.gui;

import kxml.domain.IdElem;
import kxml.domain.remote.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.*;
import org.omg.CORBA.Any;

public class ArchiveVCntrl extends kxml.gui.mvc.Controler 
				implements TreeSelectionListener, TreeExpansionListener,
						   MouseListener
{
	private JPopupMenu docPopup;
	private JPopupMenu hierPopup;
	private JPopupMenu folderPopup;
/**
 * 
 */
public ArchiveVCntrl() 
{
	super();

	docPopup = new JPopupMenu();
	folderPopup = new JPopupMenu();
	hierPopup = new JPopupMenu();

	/* popup menu for documents */
	JMenuItem menuItem = new JMenuItem("View");
	menuItem.addActionListener(this);
	docPopup.add(menuItem);
	menuItem = new JMenuItem("Modify");
	menuItem.addActionListener(this);
	docPopup.add(menuItem);
	menuItem = new JMenuItem("Delete");
	menuItem.addActionListener(this);
	docPopup.add(menuItem);

	/* popup menu for folders */
	menuItem = new JMenuItem("Create document");
	menuItem.addActionListener(this);
	folderPopup.add(menuItem);
	menuItem = new JMenuItem("Create element");
	menuItem.addActionListener(this);
	folderPopup.add(menuItem);
	menuItem = new JMenuItem("Delete");
	menuItem.addActionListener(this);
	folderPopup.add(menuItem);

	/* popup menu for other hierarchy elements */
	menuItem = new JMenuItem("Create element");
	menuItem.addActionListener(this);
	hierPopup.add(menuItem);
	menuItem = new JMenuItem("Delete");
	menuItem.addActionListener(this);
	hierPopup.add(menuItem);
}
/**
 * 
 */
public void actionPerformed(java.awt.event.ActionEvent evt) 
{
	MainMenuBar parent = ((ArchiveView)view).parent;
	String srcStr = ((JMenuItem)evt.getSource()).getText();
	DefaultMutableTreeNode selNode = ((ArchiveView)view).getSelectedNode();
	IdElem idBase = new IdElem(selNode.getPath());
	String idBaseStr = idBase.toString();
	
	if (srcStr.equals("Create element"))
		parent.metadataV.newElement(idBaseStr+"/", false);
	else if (srcStr.equals("Create document"))
		parent.metadataV.newElement(idBaseStr+"/", true);
	else if (srcStr.equals("Delete"))
	{
		try
		{
			if (selNode.getAllowsChildren())
				parent.trOrigin.removeHElement(idBaseStr);
			else
				parent.trOrigin.removeDocument(idBaseStr, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	else if (srcStr.equals("View"))
		parent.metadataV.accessContent(false);
	else if (srcStr.equals("Modify"))
		parent.metadataV.accessContent(true);
}
/**
 * componentHidden method comment.
 */
public void componentHidden(java.awt.event.ComponentEvent e) {
}
/**
 * componentMoved method comment.
 */
public void componentMoved(java.awt.event.ComponentEvent e) {
}
/**
 * 
 */
public void componentResized(java.awt.event.ComponentEvent e) 
{
}
/**
 * componentShown method comment.
 */
public void componentShown(java.awt.event.ComponentEvent e) {
}
/**
 * 
 */
public void keyPressed(java.awt.event.KeyEvent e) 
{

}
/**
 * keyReleased method comment.
 */
public void keyReleased(java.awt.event.KeyEvent e) 
{
}
/**
 * keyTyped method comment.
 */
public void keyTyped(java.awt.event.KeyEvent e) 
{
}
/**
 * 
 */
public void mouseClicked(MouseEvent evt) 
{
	if (evt.getClickCount() == 2)
	{
		DefaultMutableTreeNode selNode = ((ArchiveView)view).getSelectedNode();
		if (selNode == null)
			return;									// Nothing selected

		if (!selNode.getAllowsChildren())			// Document node
			((ArchiveView)view).parent.metadataV.accessContent(false);
	}
}
/**
 * 
 */
public void mouseEntered(MouseEvent evt) {}
/**
 * 
 */
public void mouseExited(MouseEvent evt) {}
/**
 * 
 */
public void mousePressed(MouseEvent evt) 
{
	if (evt.isPopupTrigger())
	{
		DefaultMutableTreeNode selNode = ((ArchiveView)view).getSelectedNode();
		if (selNode == null)
			return;								// Nothing selected, no popup

		if (selNode.getAllowsChildren())
		{
			if (selNode.getLevel() >= 3)			// Show folder popup
				folderPopup.show(evt.getComponent(), evt.getX(), evt.getY());
			else								// Show other hier. elem popup
				hierPopup.show(evt.getComponent(), evt.getX(), evt.getY());
		}
		else									// Show document popup
			docPopup.show(evt.getComponent(), evt.getX(), evt.getY());
	}
}
/**
 * 
 */
public void mouseReleased(MouseEvent evt) 
{
	if (evt.isPopupTrigger())
	{
		DefaultMutableTreeNode selNode = ((ArchiveView)view).getSelectedNode();
		if (selNode == null)
			return;								// Nothing selected, no popup

		if (selNode.getAllowsChildren())
		{
			if (selNode.getLevel() >= 3)			// Show folder popup
				folderPopup.show(evt.getComponent(), evt.getX(), evt.getY());
			else								// Show other hier. elem popup
				hierPopup.show(evt.getComponent(), evt.getX(), evt.getY());
		}
		else									// Show document popup
			docPopup.show(evt.getComponent(), evt.getX(), evt.getY());
	}
}
/**
 * 
 */
public void treeCollapsed(TreeExpansionEvent evt) 
{
	/*
	DefaultMutableTreeNode node = (DefaultMutableTreeNode)evt.getPath().
												getLastPathComponent();
	IdElem id = new IdElem(node.getUserObjectPath());
	TransacOrigin trOrigin = ((ArchiveView)view).parent.trOrigin;
	
	try
	{
		trOrigin.collapseElem(id.toString(), ((ArchiveView)view).tie);
		((ArchiveView)view).collapse(evt.getPath());
	}
	catch(logic.ElementNotFoundException e)
	{
		JOptionPane.showMessageDialog(null, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
	}
	*/
}
/**
 * 
 */
public void treeExpanded(TreeExpansionEvent evt) 
{
	DefaultMutableTreeNode node = (DefaultMutableTreeNode)evt.getPath().
												getLastPathComponent();											
	IdElem id = new IdElem(node.getUserObjectPath());
	TransacOrigin trOrigin = ((ArchiveView)view).parent.trOrigin;
	
	if (node.getChildCount() > 0)
		return;						// Node has already been expanded
	
	try
	{
		String[] contentIds =  
			trOrigin.expandElement(id.toString(), ((ArchiveView)view).tie);

		if (contentIds.length == 0)
			return;					// Empty node
			
		((ArchiveView)view).expand(node, contentIds);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
	}
}
/**
 * 
 */
public void update(org.omg.CORBA.Object remoteObservable, Any data) 
{
}
/**
 * 
 */
public void valueChanged(TreeSelectionEvent evt) 
{
	DefaultMutableTreeNode node = 
		(DefaultMutableTreeNode)evt.getPath().getLastPathComponent();
	IdElem id = new IdElem(node.getUserObjectPath());
		if (node.getAllowsChildren())
			id.setHElement();
	try
	{
		RemoteElement element = 
			((ArchiveView)view).parent.trOrigin.getElement(id.toString());
		((ArchiveView)view).parent.metadataV.init(element);
	}
	catch(Exception e)
	{
		((ArchiveView)view).parent.metadataV.init(null);
	}
}
/**
 * windowActivated method comment.
 */
public void windowActivated(java.awt.event.WindowEvent e) {
}
/**
 * 
 */
public void windowClosed(java.awt.event.WindowEvent e) 
{}
/**
 * 
 */
public void windowClosing(java.awt.event.WindowEvent e)
{
	//System.exit(0);
}
/**
 * windowDeactivated method comment.
 */
public void windowDeactivated(java.awt.event.WindowEvent e) {
}
/**
 * windowDeiconified method comment.
 */
public void windowDeiconified(java.awt.event.WindowEvent e) {
}
/**
 * windowIconified method comment.
 */
public void windowIconified(java.awt.event.WindowEvent e) {
}
/**
 * windowOpened method comment.
 */
public void windowOpened(java.awt.event.WindowEvent e) {
}
}
