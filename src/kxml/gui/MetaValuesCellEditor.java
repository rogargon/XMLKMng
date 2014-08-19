package kxml.gui;

import javax.swing.plaf.basic.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 * 
 */
public class MetaValuesCellEditor extends JComboBox 
				implements TableCellEditor
{
	protected boolean valueChanged = false;
	protected MetadataView metaV;
	protected MetadataModel model;
	private int row, col;
	private JTable table;
/**
 * MetaValuesCellEditor constructor comment.
 * @param items java.lang.Object[]
 */
public MetaValuesCellEditor(java.lang.Object[] items) {
	super(items);
}
/**
 * MetaValuesCellEditor constructor comment.
 * @param items java.util.Vector
 */
public MetaValuesCellEditor(java.util.Vector items) {
	super(items);
}
/**
 * MetaValuesCellEditor constructor comment.
 * @param aModel javax.swing.ComboBoxModel
 */
public MetaValuesCellEditor(javax.swing.ComboBoxModel aModel) {
	super(aModel);
}
/**
 * 
 */
public MetaValuesCellEditor(MetadataView metaV)
{
	super();
	this.metaV = metaV;
	setEditable(true);
	MetaValuesCellEditorCntrl cntrl = new MetaValuesCellEditorCntrl(this);
	this.addActionListener(cntrl);
	this.addMouseListener(cntrl);
	this.addKeyListener(cntrl);
	/*this.addFocusListener(cntrl);
	super.getEditor().getEditorComponent().addMouseListener(cntrl);
	super.getEditor().getEditorComponent().addKeyListener(cntrl);
*/}
/**
 * addCellEditorListener method comment.
 */
public void addCellEditorListener(javax.swing.event.CellEditorListener l) {}
/**
 * 
 */
public void cancelCellEditing() 
{
	table.removeEditor();
}
/**
 * getCellEditorValue method comment.
 */
public Object getCellEditorValue() {
	return null;
}
/**
 *
 */
public Component getTableCellEditorComponent(JTable table, Object value, 
						boolean isSelected, int row, int column) 
{
	if (this.getItemCount() > 0)
		this.removeAllItems();
	Object[] values = (Object[])value;
	for (int i=0; i<values.length; i++)
		this.addItem((String)values[i]);
		
	this.valueChanged = false;
	this.row = row;
	this.col = column;
	this.model = (MetadataModel)table.getModel();
	this.table = table;
	return this;
}
/**
 * 
 */
public boolean isCellEditable(java.util.EventObject anEvent) 
{
	return true;
}
/**
 * 
public boolean isManagingFocus()
{
	return true;
}
/**
 * removeCellEditorListener method comment.
 */
public void removeCellEditorListener(javax.swing.event.CellEditorListener l) {}
/**
 *
 */
public boolean shouldSelectCell(java.util.EventObject anEvent) 
{
	return true;
}
/**
 *
 */
public boolean stopCellEditing() 
{
	if (valueChanged)
	{
		Object[] newValues = new Object[getItemCount()];
		for (int i=0; i<newValues.length; i++)
			newValues[i] = (String)getItemAt(i);

		model.setValueAt(newValues, row, col);
		table.removeEditor();
	}
	return true;
}
}
