package kxml.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 */
public class MetaValuesCellRenderer extends DefaultTableCellRenderer
{
/*
 *
 */
public MetaValuesCellRenderer()
{
	super();
}
/**
 * 
 */
public Component getTableCellRendererComponent(JTable table, 
						Object value, boolean isSelected, 
						boolean hasFocus, int row, int column) 
{
	super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
										row, column);

/*	if (hasFocus && table.isCellEditable(row, column))
	{
	    table.editCellAt(row, column);
	    MetaValuesCellEditor editor = 
	    			(MetaValuesCellEditor)table.getEditorComponent();
	    editor.setSelectedIndex(0);
	    editor.getEditor().selectAll();
	    editor.setNextFocusableComponent(getNextFocusableComponent());
	}
*/			
	return this;
}
/*
 *
 */
protected void setValue(Object value) 
{
	Object[] values = (Object[])value;
	String concatStr = new String("");
	
	if (values.length > 0)
	{	
		concatStr += values[0];
		for (int i=1; i<values.length; i++)
			concatStr += ", "+values[i];
	}
	setText(concatStr);
}
}
