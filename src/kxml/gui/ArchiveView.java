package kxml.gui;

import kxml.domain.remote.*;
import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.util.RDFManager;
import org.omg.CORBA.Any;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;
import java.io.*;

public class ArchiveView extends kxml.gui.mvc.View
{
	private JTree ivjarchiveTree = null;
	private JPanel ivjJFrameArchiveView = null;
	private JScrollPane ivjscrollTree = null;
	
	protected MainMenuBar parent;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ArchiveView() 
{
	super();
	initialize();
	ivjarchiveTree.setCellRenderer(new ArchiveViewRenderer());
}
/**
 * 
 */
public ArchiveView(MainMenuBar parent) 
{
	super();
	initialize();
	this.parent = parent;
		
	//asociar controlador a los elementos de la vista a controlar
	this.addWindowListener(this.contrl);
	ivjarchiveTree.addTreeExpansionListener((ArchiveVCntrl)this.contrl);
	ivjarchiveTree.addTreeSelectionListener((ArchiveVCntrl)this.contrl);
	ivjarchiveTree.addMouseListener((ArchiveVCntrl)this.contrl);
	ivjscrollTree.setViewportView(ivjarchiveTree);

	ivjarchiveTree.setCellRenderer(new ArchiveViewRenderer());
}
/**
 * 
 */
public void collapse(TreePath treePath) 
{
	DefaultMutableTreeNode node, child = null;
	node = (DefaultMutableTreeNode)treePath.getLastPathComponent();
	ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();

	model.clearChildsChildNodes(node);
}
/**
 * 
 */
public kxml.gui.mvc.Controler createControler() 
{
	return (new ArchiveVCntrl());
}
/**
 * Expand the tree node with the local identifiers of the content
 * of the corresponding element
 */
public void expand(DefaultMutableTreeNode node, String[] contentIds) 
{
	ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();

	model.addChildNodes(node, contentIds);
}
/**
 * Return the JTree1 property value.
 * @return javax.swing.JTree
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JTree getarchiveTree() {
	if (ivjarchiveTree == null) {
		try {
			ivjarchiveTree = new javax.swing.JTree();
			ivjarchiveTree.setName("archiveTree");
			ivjarchiveTree.setBounds(0, 0, 76, 36);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjarchiveTree;
}
/**
 * Return the JFrameVistaArchivo property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JPanel getJFrameArchiveView() {
	if (ivjJFrameArchiveView == null) {
		try {
			ivjJFrameArchiveView = new javax.swing.JPanel();
			ivjJFrameArchiveView.setName("JFrameArchiveView");
			ivjJFrameArchiveView.setLayout(new java.awt.BorderLayout());
			getJFrameArchiveView().add(getscrollTree(), "Center");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJFrameArchiveView;
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JScrollPane getscrollTree() {
	if (ivjscrollTree == null) {
		try {
			ivjscrollTree = new javax.swing.JScrollPane();
			ivjscrollTree.setName("scrollTree");
			ivjscrollTree.setPreferredSize(new java.awt.Dimension(221, 300));
			ivjscrollTree.setMinimumSize(new java.awt.Dimension(171, 100));
			getscrollTree().setViewportView(getarchiveTree());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjscrollTree;
}
/**
 * 
 */
public DefaultMutableTreeNode getSelectedNode() 
{
	return (DefaultMutableTreeNode)ivjarchiveTree.
					getSelectionPath().getLastPathComponent();
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
 * This method is only called the first time the view is presented.
 * The input parameter references the initial element to show.
 */
public void init(IdElem current)
{
	// This view doesn't use the common model-view-controller design
	// pattern of the kxml.gui.mvc package. There're multiple models,
	// all the nodes visible in the TreeView. They're recognaised
	// in the update process with the first parameter of the update
	// method that identifies the originator.
	super.init(null);

	DefaultMutableTreeNode root = 
				new DefaultMutableTreeNode(current.getRootLocId());

	ArchiveModel model = new ArchiveModel(root, true);
	ivjarchiveTree.setModel(model);
	ivjarchiveTree.setShowsRootHandles(true);
	ivjarchiveTree.setEditable(false);
	ivjarchiveTree.getSelectionModel().
		setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	
	if (current != null)
		showElem(current);

	ivjscrollTree.setViewportView(ivjarchiveTree);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	// user code begin {1}
	// user code end
	setName("ArchiveView");
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	setSize(300, 300);
	setTitle("Archive View");
	setContentPane(getJFrameArchiveView());
	// user code begin {2}
	// user code end
}
/**
 * 
 */
public static void main(java.lang.String[] args) 
{
	ArchiveView aArchiveView;
	aArchiveView = new ArchiveView();
	aArchiveView.setVisible(true);
}
/**
 * Makes the needed expansions to show the indicated element, 
 * registering the view as observer of the intermediate nodes.
 */
public void showElem(kxml.domain.IdElem id) 
{
	ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();
	String[] contentIds;
	
	// Get root node and the components of the element identifier
	DefaultMutableTreeNode node = null;
	Object[] hierarchySteps = id.toArray();
	String currentNodeId = "";
	try
	{
		for(int i=0; i<hierarchySteps.length; i++)
		{
			// Construct current node id and mark as HierarchyElement if needed
			currentNodeId += hierarchySteps[i];
			if (id.isHElement() || i<hierarchySteps.length-1)
				currentNodeId += "/";
				
			node = model.getNodeFromId(currentNodeId);
			if (node == null)
				return; // Error in element identifier
			if (node.getAllowsChildren() && node.getChildCount()==0)
			{
				contentIds = 
					parent.trOrigin.expandElement(currentNodeId, this.tie);
				expand(node, contentIds);
			}
			ivjarchiveTree.expandPath(new TreePath(node.getPath()));
		}
		ivjarchiveTree.setSelectionPath(new TreePath(node.getPath()));
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
	Hashtable attribs = null;
	try
	{
		String metaxml = data.extract_string();
		RDFManager rdfExtr = new RDFManager(new StringReader(metaxml));
		attribs = rdfExtr.getAttribsFromXML();
	}
	catch (Exception e)							// No XML data parameter
	{}
	if (attribs == null)
		return;									// Nothing to do

	// Identifier has been changed
	if (attribs.containsKey("kxml:OldIdentifier"))
	{
		Object[] values = (Object[])attribs.get("DC:identifier");
		String newLocId = new IdElem((String)values[1]).getLocId();
		values = (Object[])attribs.get("kxml:OldIdentifier");
		String oldId = (String)values[1];

		ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();
		model.changeNodeId(model.getNodeFromId(oldId), newLocId);
	}
	// New node content
	else if (attribs.containsKey("kxml:NewContent"))
	{
		Object[] values = (Object[])attribs.get("DC:identifier");
		String containerId = (String)values[1];
		values = (Object[])attribs.get("kxml:NewContent");
		String[] contentIds = new String[1];
		contentIds[0] = (String)values[1];
				
		ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();
		DefaultMutableTreeNode node = model.getNodeFromId(containerId);
		model.addChildNodes(node, contentIds);
	}
	// Removed node content
	else if (attribs.containsKey("kxml:RemovedIdentifier"))
	{
		Object[] values = (Object[])attribs.get("DC:identifier");
		String containerId = (String)values[1];
		values = (Object[])attribs.get("kxml:RemovedIdentifier");
		String[] contentIds = new String[1];
		contentIds[0] = (String)values[1];
				
		ArchiveModel model = (ArchiveModel)ivjarchiveTree.getModel();
		DefaultMutableTreeNode node = model.getNodeFromId(containerId);
		model.removeChildNodes(node, contentIds);
	}
}
}
