package kxml.gui;

import kxml.domain.DocType;
import kxml.util.remote.RemoteObserver;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;

public class InternalEditor extends JFrame
{
	private JPanel ivjInternalViewer = null;
	private JTabbedPane ivjViewerTabs = null;
	protected MainMenuBar parent = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public InternalEditor() {
	super();
	initialize();
}
/**
 * 
 */
public InternalEditor(MainMenuBar parent) 
{
	super("Integrated Edit Components");
	initialize();
	this.parent = parent;
}
/**
 * Return the visorInterno property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getInternalViewer() {
	if (ivjInternalViewer == null) {
		try {
			ivjInternalViewer = new javax.swing.JPanel();
			ivjInternalViewer.setName("KXMLViewer");
			ivjInternalViewer.setLayout(new java.awt.BorderLayout());
			ivjInternalViewer.add(getViewerTabsContainer(), "Center");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			System.out.println("Error en getvisorInterno");
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjInternalViewer;
}
/**
 * 
 */
private JTabbedPane getViewerTab() 
{
	JTabbedPane viewerTab = null;
	try 
	{
		viewerTab = new JTabbedPane(JTabbedPane.BOTTOM);
		ivjViewerTabs.setName("ViewerTab");
	} 
	catch (java.lang.Throwable ivjExc) 
	{
		System.out.println("Error en getViewerTab");
		handleException(ivjExc);
	}
	
	return viewerTab;
}
/**
 * Return the tabsVisorInterno property value.
 * @return javax.swing.JTabbedPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTabbedPane getViewerTabsContainer() {
	if (ivjViewerTabs == null) {
		try {
			ivjViewerTabs = new javax.swing.JTabbedPane();
						ivjViewerTabs.setFont(new java.awt.Font("dialog", 0, 10));
			ivjViewerTabs.setName("tabsKXMLViewer");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			System.out.println("Error en gettabsVisorInterno");
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjViewerTabs;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	// user code begin {1}
	try{
	// user code end
	setName("VisorInterno");
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	setSize(424, 450);
	setContentPane(getInternalViewer());
	// user code begin {2}
	} catch (java.lang.Throwable ivjExc) {
		System.out.println("Error en getvisorInterno");
	}
	// user code end
}
/**
 * 
 */
public static void main(java.lang.String[] args) {
	try 
	{
		InternalEditor aInternalViewer;
		aInternalViewer = new InternalEditor();
		aInternalViewer.addWindowListener( 
			new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e)
				{ System.exit(0); }
			});
		aInternalViewer.setVisible(true);
	} 
	catch (Throwable exception) 
	{
		System.err.println("Exception occurred in main() of javax.swing.JFrame");
		exception.printStackTrace(System.out);
	}
}
/**
 * 
 */
public void showContent(String className, URL uri, ContentObserver obs) 
{
	try
	{
		Class c = Class.forName(className);
		Class[] interfaces = c.getInterfaces();
		boolean correctImplementation = false;
		for (int i=0; i<interfaces.length; i++)
			if (interfaces[i].getName().equals("kxml.gui.EditorTab"))
				correctImplementation = true;

		if (correctImplementation)
		{	
			Object o = c.newInstance();
			if (o instanceof JComponent)
			{
				((EditorTab)o).initialize(uri, obs, this.ivjViewerTabs, 
										  parent.trOrigin);
				String title = new kxml.domain.IdElem(obs.getIdElem()).getLocId();
				ivjViewerTabs.insertTab(title, null, (JComponent)o, null, 0);
			}
			else
				JOptionPane.showMessageDialog(null, 
					"Viewer class "+className+" must extend Component",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, 
				"Viewer class "+className+" must implement EditorTab",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e.toString(),
				"Error", JOptionPane.ERROR_MESSAGE);
	}
}
}
