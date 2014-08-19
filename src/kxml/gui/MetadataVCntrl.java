package kxml.gui;

import kxml.domain.remote.RemoteElement;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Toolkit;

public class MetadataVCntrl extends kxml.gui.mvc.Controler
							implements MouseListener
{
	private static int FIXEDHEIGHT = 280;
/**
 * 
 */
public MetadataVCntrl() 
{
	// Create controler without remote observer facility. It isn't
	// necessary an so performance is increased.
	super(false);
}
/**
 * Control MetadataView buttons
 */
public void actionPerformed(java.awt.event.ActionEvent evt) 
{
	MetadataView metaV = (MetadataView)this.view;
	MetadataModel model = (MetadataModel)metaV.getTable().getModel();

	if (evt.getSource() instanceof JMenuItem)
	{
		String itName = ((JMenuItem)evt.getSource()).getText();
		if (itName.equals("Delete"))
			model.delAttribute(metaV.getTable().getSelectedRow());
		else if (!itName.equals("Add"))
			model.addAttribute(itName);
	}
	else if (((JButton)evt.getSource()).getText().equals("Change"))
	{
		metaV.getTable().removeEditor();
		String metaxml = model.getXMLFromChanges();
		metaV.unlockUpdate();
		metaV.enableButtons(false);
		try
		{
			metaV.parent.trOrigin.modifyMetadata(model.getIdElem(), metaxml);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
			metaV.viewMetadata();			// Get real current state
		}
	}
	else if (((JButton)evt.getSource()).getText().equals("Create"))
	{
		metaV.getTable().removeEditor();
		String metaxml = model.getXMLFromModel();
		metaV.unlockUpdate();
		metaV.enableButtons(false);
		try
		{
			RemoteElement element;
			if (model.isDocument())
				element = metaV.parent.trOrigin.
							fileDocument(model.getIdElem(), metaxml);
			else
				element = metaV.parent.trOrigin.
							createElement(model.getIdElem(), metaxml);
			metaV.init(element);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
			metaV.viewMetadata();			// Return to previous elem
		}
	}
	else if (((JButton)evt.getSource()).getText().equals("Cancel"))
	{
		metaV.getTable().removeEditor();
		metaV.unlockUpdate();
		metaV.viewMetadata();
		metaV.setCreating(false);
		metaV.enableButtons(false);
	}
	else if (((JButton)evt.getSource()).getText().equals("Add"))
	{
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			
		NamespaceDlg nsDlg = new NamespaceDlg();
		nsDlg.setLocation((int)(screenWidth - nsDlg.getSize().width)/2,
	  					  (int)(screenHeight - nsDlg.getSize().height)/2);
		nsDlg.setVisible(true);
		if (nsDlg.accepted)
			model.addNamespace(nsDlg.nsName, nsDlg.nsUri);
		metaV.setVisibleNSs(model.getCurrentNSs());
	}
}
/**
 * 
 */
public void init(RemoteElement elem, MetadataView metaView) 
{
	super.init(elem, metaView);
}
/**
 * 
 */
public void keyPressed(java.awt.event.KeyEvent e) 
{
	MetadataView metaV = (MetadataView)view;
	metaV.lockUpdate();
	metaV.enableButtons(true);
	//((MetadataModel)metaV.getTable().getModel()).backupModel();
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
		MetadataView metaV = (MetadataView)this.view;
		MetadataModel model = (MetadataModel)metaV.getTable().getModel();

		String[] ns = metaV.getSelectedNS();

		String[] nsAttribs = model.getNSAttributes(ns[1]);
		
		if (nsAttribs != null)
		{
			JPopupMenu nsPopup = new JPopupMenu();
			JMenuItem delItem = new JMenuItem("Delete");
			delItem.addActionListener(this);
			nsPopup.add(delItem);

			JMenu addMenu = new JMenu("Add");
			
			for(int i=0; i<nsAttribs.length; i++)
			{
				JMenuItem attItem = new JMenuItem(ns[0]+":"+nsAttribs[i]);
				attItem.addActionListener(this);
				addMenu.add(attItem);
			}
			nsPopup.add(addMenu);
			nsPopup.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}
}
/**
 * 
 */
public void mouseReleased(MouseEvent evt) 
{
	if (evt.isPopupTrigger())
	{
		MetadataView metaV = (MetadataView)this.view;
		MetadataModel model = (MetadataModel)metaV.getTable().getModel();

		String[] ns = metaV.getSelectedNS();

		String[] nsAttribs = model.getNSAttributes(ns[1]);
		
		if (nsAttribs != null)
		{
			JPopupMenu nsPopup = new JPopupMenu();
			JMenuItem delItem = new JMenuItem("Delete");
			delItem.addActionListener(this);
			nsPopup.add(delItem);

			JMenu addMenu = new JMenu("Add");
			
			for(int i=0; i<nsAttribs.length; i++)
			{
				JMenuItem attItem = new JMenuItem(ns[0]+":"+nsAttribs[i]);
				attItem.addActionListener(this);
				addMenu.add(attItem);
			}
			nsPopup.add(addMenu);
			nsPopup.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}
}
/**
 * This method is not activated in this implementation, it's
 * not necessary and so performance is incresed
 */
public void update(org.omg.CORBA.Object remoteObservable, 
				   org.omg.CORBA.Any data) 
{
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
