package kxml.gui;

import kxml.gui.MetadataView;
import java.awt.event.*;
import javax.swing.*;
/**
 *  
 */
public class MetaValuesCellEditorCntrl
		implements ActionListener, KeyListener, MouseListener, FocusListener
{
	MetaValuesCellEditor cellEditor = null;
	private int lastIndex = -1;
	private JPopupMenu itemPopup;
/**
 * 
 */
public MetaValuesCellEditorCntrl(MetaValuesCellEditor cellEditor) 
{
	this.cellEditor = cellEditor;
	
	itemPopup = new JPopupMenu();

	JMenuItem addItem = new JMenuItem("Add");
	JMenuItem insItem = new JMenuItem("Insert");
	JMenuItem delItem = new JMenuItem("Delete");
	addItem.addActionListener(this);
	insItem.addActionListener(this);
	delItem.addActionListener(this);
	itemPopup.add(addItem);
	itemPopup.add(insItem);
	itemPopup.add(delItem);
}
/**
 * 
 */
public void actionPerformed(java.awt.event.ActionEvent evt) 
{
	MetadataModel model = cellEditor.model;
	MetadataView metaV = cellEditor.metaV;

	if (evt.getSource() instanceof MetaValuesCellEditor)
	{
		MetaValuesCellEditor cb = (MetaValuesCellEditor)evt.getSource();
		int currentIndex = cb.getSelectedIndex();

		if (currentIndex > -1)				// Selection			
			this.lastIndex = currentIndex;
		else if (cb.getItemCount() > 0)		// Modification, not a clearAllItems
		{
			String oldSelection = (String)cb.getItemAt(lastIndex);
			String newSelection = (String)cb.getSelectedItem();
			if (!oldSelection.equals(newSelection))
			{
				cb.removeItemAt(lastIndex);
				cb.insertItemAt(newSelection, lastIndex);
				cb.valueChanged = true;
				metaV.enableButtons(true);
				metaV.lockUpdate();
				cb.stopCellEditing();
			}
		}
	}
	else
	{
		String srcStr = ((JMenuItem)evt.getSource()).getText();
		if (srcStr.equals("Delete"))
		{
			cellEditor.removeItemAt(lastIndex);
			if (cellEditor.getItemCount() == 0)
				cellEditor.addItem("");
			cellEditor.valueChanged = true;
			metaV.enableButtons(true);
			metaV.lockUpdate();
			cellEditor.stopCellEditing();
		}
		else
		{
			if (cellEditor.getItemCount() == 1 &&
				((String)cellEditor.getItemAt(0)).equals(""))
				cellEditor.removeItemAt(0);
			if (srcStr.equals("Insert"))
			{
				cellEditor.insertItemAt("New", lastIndex);
				cellEditor.setSelectedIndex(lastIndex);
			}
			else if (srcStr.equals("Add"))
			{
				cellEditor.insertItemAt("New", lastIndex+1);
				cellEditor.setSelectedIndex(lastIndex+1);
			}
			cellEditor.getEditor().selectAll();
		}
	}
}
/*
 *
 */
public void focusGained(FocusEvent e)
{}
/*
 *
 */
public void focusLost(FocusEvent e)
{
	cellEditor.metaV.getTable().removeEditor();
}
/**
 * 
 */
public void keyPressed(java.awt.event.KeyEvent e) 
{
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		cellEditor.cancelCellEditing();
}
/**
 *
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
		//MetaValuesCellEditor cb = (MetaValuesCellEditor)evt.getSource();
		if (lastIndex > -1)				// An item is selected
			itemPopup.show(evt.getComponent(), evt.getX(), evt.getY());
	}
}
/**
 * 
 */
public void mouseReleased(MouseEvent evt) 
{
	if (evt.isPopupTrigger())
	{
		//MetaValuesCellEditor cb = (MetaValuesCellEditor)evt.getSource();
		if (lastIndex > -1)				// An item is selected
			itemPopup.show(evt.getComponent(), evt.getX(), evt.getY());
	}
}
}
