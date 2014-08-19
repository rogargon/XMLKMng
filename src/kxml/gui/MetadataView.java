package kxml.gui;

import java.net.*;
import kxml.domain.*;
import kxml.domain.remote.*;
import kxml.logic.TransacOrigin;
import kxml.util.*;
import kxml.util.remote.*;
import org.omg.CORBA.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import javax.swing.table.*;
/**
 * 
 */
public class MetadataView extends kxml.gui.mvc.View 
{
	private JPanel ivjbuttonsJPan = null;
	private JPanel ivjNSsPan = null;
	private JButton ivjcancelJBtn = null;
	private JPanel ivjJFrameContentPane = null;
	private JScrollPane ivjJScrollPane = null;
	private JButton ivjOKJBtn = null;
	private JButton ivjAddNSBtn = null;
	private JComboBox ivjNSsCmb = null;
	private JTable ivjScrollPaneTable = null;

	protected MainMenuBar parent;
	protected String idElem = null;
	private boolean locked = false;

	private static final int VISIBLE_ROWS = 7;
/**
 * 
 */
public MetadataView() 
{
	super();
	initialize();
}
/**
 * MetadataViewRDF constructor comment.
 * @param title java.lang.String
 */
public MetadataView(String title) {
	super(title);
}
/**
 * 
 */
public MetadataView(MainMenuBar parent) 
{
	super();
	initialize();
	this.parent = parent;

	// Associate events to the view controler
	this.addWindowListener(this.contrl);
	//this.addComponentListener(this.contrl);
	//getScrollPaneTable().addKeyListener(this.contrl);
	getOKJBtn().addActionListener(this.contrl);
	getcancelJBtn().addActionListener(this.contrl);
	getAddNSBtn().addActionListener(this.contrl);
	getScrollPaneTable().addMouseListener((MetadataVCntrl)this.contrl);
}
/**
 * 
 */
public void accessContent(boolean write) 
{
	MetadataModel localModel = (MetadataModel)ivjScrollPaneTable.getModel();
	String idElem = localModel.getIdElem();
	String[] commAndUri;
	try
	{
		parent.internalV.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		ContentObserver contentObs = new ContentObserver(idElem, write);
		if (write)
			commAndUri = parent.trOrigin.modifyDocument(idElem, contentObs);
		else
			commAndUri = parent.trOrigin.readDocument(idElem, contentObs);

		// If command represents a Java class edit with InternalEditor
		int classExtPos = commAndUri[0].indexOf(".class");
		if (classExtPos > 0)
		{
			URL uri = new URL(commAndUri[1]);
			String className = commAndUri[0].substring(0, classExtPos);
			parent.internalV.showContent(className, uri, contentObs);
		}
		// Execute command in new process
		else
			executeCommand(commAndUri[0], commAndUri[1]);
			
		IdElem[] recent = {new IdElem(idElem)};
		parent.setRecentDocs(recent);
		parent.internalV.setCursor(Cursor.getDefaultCursor());
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
public void clearTable() 
{
	ivjScrollPaneTable.setModel(new MetadataModel(""));
}
/**
 * 
 */
public kxml.gui.mvc.Controler createControler() 
{
	return (new MetadataVCntrl());
}
/**
 * 
 */
public void enableButtons(boolean enabled) 
{
	ivjOKJBtn.setEnabled(enabled);
	ivjcancelJBtn.setEnabled(enabled);
}
/**
 * 
 */
private void executeCommand(String command, String docURL) 
{
	Process externEditor;
	try 
	{
		String completeCommand = command + " " + docURL;
		externEditor = Runtime.getRuntime().exec(completeCommand);
	}
	catch(java.io.IOException e)
	{
		JOptionPane.showMessageDialog(null, "Error running extern editor "+
								command, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
/**
 * Reshape columns width to optimize presentation.
 * The width of 1st column is minimized and the 2nd
 * expanded to use all the availabe space.
 */
public void fitColumns() 
{
	int maxWidth = 0;
	int numRows = ivjScrollPaneTable.getRowCount();
	MetadataModel model = (MetadataModel)ivjScrollPaneTable.getModel();
	TableCellRenderer renderer = 
		ivjScrollPaneTable.getDefaultRenderer(model.getColumnClass(0));
	Component comp = null;
	
	for(int i=0; i<numRows; i++)
	{
		comp = renderer.getTableCellRendererComponent(ivjScrollPaneTable, 
							model.getValueAt(i, 0), false, false, i, 0);
		maxWidth = Math.max(maxWidth, comp.getPreferredSize().width);
	}
	TableColumn col = ivjScrollPaneTable.getColumnModel().getColumn(0);
	col.setWidth(maxWidth);
	col.setPreferredWidth(maxWidth);
	col.setMinWidth(maxWidth);
	col = ivjScrollPaneTable.getColumnModel().getColumn(1);
	col.setWidth(ivjScrollPaneTable.getWidth() - maxWidth - 2);
	col.setPreferredWidth(ivjScrollPaneTable.getWidth() - maxWidth - 2);
}
/**
 * 
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected javax.swing.JButton getAddNSBtn() {
	if (ivjAddNSBtn == null) {
		try {
			ivjAddNSBtn = new javax.swing.JButton();
			ivjAddNSBtn.setName("AddNS");
			ivjAddNSBtn.setText("Add");
			ivjAddNSBtn.setFont(new java.awt.Font("dialog", 0, 10));
			ivjAddNSBtn.setMargin(new java.awt.Insets(0, 4, 0, 4));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAddNSBtn;
}
/**
 * Return the buttonsJPan property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getbuttonsPan() {
	if (ivjbuttonsJPan == null) {
		try {
			ivjbuttonsJPan = new javax.swing.JPanel();
			ivjbuttonsJPan.setName("buttonsJPan");
			ivjbuttonsJPan.setLayout(new java.awt.FlowLayout());
			getbuttonsPan().add(getOKJBtn(), getOKJBtn().getName());
			getbuttonsPan().add(getcancelJBtn(), getcancelJBtn().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjbuttonsJPan;
}
/**
 * Return the cancelJBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getcancelJBtn() {
	if (ivjcancelJBtn == null) {
		try {
			ivjcancelJBtn = new javax.swing.JButton();
			ivjcancelJBtn.setName("Cancel");
			ivjcancelJBtn.setText("Cancel");
			ivjcancelJBtn.setFont(new java.awt.Font("dialog", 0, 10));
			ivjcancelJBtn.setMargin(new java.awt.Insets(0, 2, 0, 2));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjcancelJBtn;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.BorderLayout());
			getJFrameContentPane().add(getNSsPan(), "North");
			getJFrameContentPane().add(getJScrollPane(), "Center");
			getJFrameContentPane().add(getbuttonsPan(), "South");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJFrameContentPane;
}
/**
 * Return the JScrollPane property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJScrollPane() {
	if (ivjJScrollPane == null) {
		try {
			ivjJScrollPane = new javax.swing.JScrollPane();
			ivjJScrollPane.setName("JScrollPane");
			ivjJScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			ivjJScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getJScrollPane().setViewportView(getScrollPaneTable());
			// user code begin {1}
			//ivjJScrollPane.setPreferredSize(getScrollPaneTable().getPreferredSize());
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJScrollPane;
}
/**
 * 
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected javax.swing.JComboBox getNSsCmb() {
	if (ivjNSsCmb == null) {
		try {
			ivjNSsCmb = new javax.swing.JComboBox();
			ivjNSsCmb.setName("AddNS");
			ivjNSsCmb.setPreferredSize(new java.awt.Dimension(64, 21));
			ivjNSsCmb.setMaximumSize(new java.awt.Dimension(5000, 21));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjNSsCmb;
}
/**
 * Return the buttonsJPan property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getNSsPan() {
	if (ivjNSsPan == null) {
		try {
			ivjNSsPan = new javax.swing.JPanel();
			ivjNSsPan.setName("NSsPan");
			ivjNSsPan.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsBtn = new java.awt.GridBagConstraints();
			constraintsBtn.gridx = 1; constraintsBtn.gridy = 0;
			constraintsBtn.insets = new java.awt.Insets(0, 1, 0, 1);
			ivjNSsPan.add(getAddNSBtn(), constraintsBtn);
			
			java.awt.GridBagConstraints constraintsCmb = new java.awt.GridBagConstraints();
			constraintsCmb.gridx = 0; constraintsCmb.gridy = 0;
			constraintsCmb.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsCmb.weightx = 1.0;
			constraintsCmb.insets = new java.awt.Insets(0, 1, 0, 1);
			ivjNSsPan.add(getNSsCmb(), constraintsCmb);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjNSsPan;
}
/**
 * Return the OKJBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected javax.swing.JButton getOKJBtn() {
	if (ivjOKJBtn == null) {
		try {
			ivjOKJBtn = new javax.swing.JButton();
			ivjOKJBtn.setName("OK");
			ivjOKJBtn.setText("Change");
			ivjOKJBtn.setFont(new java.awt.Font("dialog", 0, 10));
			ivjOKJBtn.setMargin(new java.awt.Insets(0, 2, 0, 2));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjOKJBtn;
}
/**
 * Return the ScrollPaneTable property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getScrollPaneTable() {
	if (ivjScrollPaneTable == null) {
		try {
			ivjScrollPaneTable = new javax.swing.JTable();
			ivjScrollPaneTable.setName("ScrollPaneTable");
			getJScrollPane().setColumnHeaderView(ivjScrollPaneTable.getTableHeader());
			getJScrollPane().getViewport().setBackingStoreEnabled(true);
			ivjScrollPaneTable.setBounds(0, 0, 200, 200);
			// user code begin {1}
			ivjScrollPaneTable.setDefaultEditor(String[].class, 
												new MetaValuesCellEditor(this));
			ivjScrollPaneTable.setDefaultRenderer(String[].class, 
												new MetaValuesCellRenderer());
			Dimension d = new Dimension(ivjScrollPaneTable.getWidth(),
				ivjScrollPaneTable.getCellRect(0,0,true).height*VISIBLE_ROWS);
			ivjScrollPaneTable.setPreferredScrollableViewportSize(d);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScrollPaneTable;
}
/**
 * Get the currently selected namespace name and uri
 * from the displayed element namespaces pool
 */
public String[] getSelectedNS() 
{
	String nsLabel = (String)ivjNSsCmb.getSelectedItem();
	StringTokenizer st = new StringTokenizer(nsLabel, "=");
	String nsName = st.nextToken();
	String nsUri = st.nextToken();
	
	String[] ns = {nsName, nsUri};
	
	return ns;
}
/**
 * 
 */
public JTable getTable() 
{
	return ivjScrollPaneTable;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * 
 */
public void init(RemoteElement elem)
{
	super.init(elem);

	if (elem != null)
	{
		viewMetadata();
		fitColumns();	// Adjust columns widths for a better presentation
		setCreating(false);
	}
	else
		clearTable();
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("MetadataViewRDF");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(426, 240);
		setContentPane(getJFrameContentPane());
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * 
 */
public void lockUpdate() 
{
	locked = true;
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		MetadataView aMetadataView;
		aMetadataView = new MetadataView();
		aMetadataView.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		aMetadataView.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JFrame");
		exception.printStackTrace(System.out);
	}
}
/**
 * Prepare the view to accept the metadata asociated to the new hierarchy
 * element or document.
 */
public void newElement(String idBaseElem, boolean isDocument)
{
	lockUpdate();

	MetadataModel tableModel = (MetadataModel)ivjScrollPaneTable.getModel();
		
	// Show empty attributes
	tableModel.newElemValues(idBaseElem, parent.currentUser(), isDocument);

	fitColumns();
	setTitle(idBaseElem+"...");
	setCreating(true);
	enableButtons(true);
}
/**
 * 
 */
public void setCreating(boolean isCreating) 
{
	if (isCreating)
		ivjOKJBtn.setText("Create");
	else
		ivjOKJBtn.setText("Change");
}
/**
 * Shows a list of all the defined namespaces for the current element
 */
public void setVisibleNSs(String[][] nss) 
{
	if (ivjNSsCmb.getItemCount() > 0)
		ivjNSsCmb.removeAllItems();
	for (int i=0; i<nss.length;  i++)
	{
		int separator = nss[i][0].indexOf(':');
		if (separator > 0)				// Don't show the basic xmlns
		{
			String nsTxt = nss[i][0].substring(separator+1);
			ivjNSsCmb.addItem(nsTxt + "=" + nss[i][1]);
		}
	}
}
/**
 * 
 */
public void unlockUpdate() 
{
	locked = false;	
}
/**
 * 
 */
public void update(org.omg.CORBA.Object remoteObservable, org.omg.CORBA.Any data) 
{
	if (!locked)
		viewMetadata();
}
/**
 * 
 */
public void viewMetadata() 
{
	boolean blocked = false;
	StringHolder metaxml = new StringHolder();

	if (model == null || model._non_existent())
		model = null;
	else
	{
		RemoteElement elem = RemoteElementHelper.narrow(model);
		
		if (elem._is_a(RemoteHierarchyElementHelper.id()))
		{
			RemoteHierarchyElement hierarchyElem = 
									RemoteHierarchyElementHelper.narrow(elem);
			blocked = hierarchyElem.getMetaXML(metaxml);
		}
		else
		{
			RemoteDocument document = RemoteDocumentHelper.narrow(elem);
			blocked = document.getMetaXML(metaxml);
		}

		if (blocked)	// Operation blocked, model recently modified. Update
			return;		// call generated has already actualised the view.
	}	
	enableButtons(false);

	int width0 = 0;
	int width1 = 0;
	try
	{
		width0 = ivjScrollPaneTable.getColumnModel().getColumn(0).getWidth();
		width1 = ivjScrollPaneTable.getColumnModel().getColumn(1).getWidth();
	}
	catch(Exception e){}

	MetadataModel model = new MetadataModel(metaxml.value);
	ivjScrollPaneTable.setModel(model);
	setTitle(model.getIdElem());
	setVisibleNSs(model.getCurrentNSs());
	
	ivjScrollPaneTable.getColumnModel().getColumn(0).setWidth(width0);
	ivjScrollPaneTable.getColumnModel().getColumn(1).setWidth(width1);
}
}
