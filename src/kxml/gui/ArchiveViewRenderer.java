package kxml.gui;

import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 * 
 */
public class ArchiveViewRenderer extends javax.swing.tree.DefaultTreeCellRenderer 
{
	ImageIcon rootIcon = null;
	ImageIcon cabinetIcon = null;
	ImageIcon drawerIcon = null;
	ImageIcon docIcon = null;
/**
 * 
 */
public ArchiveViewRenderer() 
{
	super();
	java.net.URL iconURL = null;
	
	iconURL = ClassLoader.getSystemResource("kxml/gui/images/root.gif");
	if (iconURL != null)
		rootIcon = new ImageIcon(iconURL);
	iconURL = ClassLoader.getSystemResource("kxml/gui/images/cabinet.gif");
	if (iconURL != null)
		cabinetIcon = new ImageIcon(iconURL);
	iconURL = ClassLoader.getSystemResource("kxml/gui/images/drawer.gif");
	if (iconURL != null)
		drawerIcon = new ImageIcon(iconURL);
	iconURL = ClassLoader.getSystemResource("kxml/gui/images/doc.gif");
	if (iconURL != null)
		docIcon = new ImageIcon(iconURL);
}
/**
 * 
 */
public Component getTreeCellRendererComponent(JTree tree, Object value, 
					boolean sel, boolean expanded, boolean leaf, int row, 
					boolean hasFocus) 
{
	super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, 
									   row, hasFocus);

	DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;

	if (!node.getAllowsChildren())		// Document node
		this.setIcon(docIcon);
	else
	{
		switch(node.getLevel())
		{
			case 0:	this.setIcon(rootIcon);
					break;
			case 1: this.setIcon(cabinetIcon);
					break;
			case 2: this.setIcon(drawerIcon);
					break;
			default:
		}
	}
	
	return this;
}
}
