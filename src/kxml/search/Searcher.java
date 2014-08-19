package kxml.search;

import edu.unika.aifb.rdfie.RDFEvaluator;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.util.Vector;

/**
 * 
 */
public class Searcher extends javax.swing.JFrame {
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JButton ivjJQueryBtn = null;
	private javax.swing.JButton ivjJRQueryBtn = null;
	private javax.swing.JButton ivjJRRdfBtn = null;
	private javax.swing.JButton ivjJRRuleBtn = null;
	private javax.swing.JSplitPane ivjJSplitPane1 = null;
	private javax.swing.JScrollPane ivjJQueryScroll = null;
	private javax.swing.JTextPane ivjJQueryTxt = null;
	private javax.swing.JScrollPane ivjJResultScroll = null;
	private javax.swing.JTextPane ivjJResultTxt = null;

	private RDFEvaluator engine = null;
/**
 * Searcher constructor comment.
 */
public Searcher() 
{
	super();
	initialize();
	startKBase();
}
/**
 * Searcher constructor comment.
 * @param title java.lang.String
 */
public Searcher(String title) {
	super(title);
}
/**
 * connEtoC1:  (JRQueryBtn.action.actionPerformed(java.awt.event.ActionEvent) --> Searcher.jRQueryBtn_ActionPerformed1()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jRQueryBtn_ActionPerformed1();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (JQueryBtn.action.actionPerformed(java.awt.event.ActionEvent) --> Searcher.jQueryBtn_ActionPerformed1()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jQueryBtn_ActionPerformed1();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
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
			getJFrameContentPane().add(getJPanel1(), "North");
			getJFrameContentPane().add(getJSplitPane1(), "Center");
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
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.FlowLayout());
			getJPanel1().add(getJRQueryBtn(), getJRQueryBtn().getName());
			getJPanel1().add(getJRRdfBtn(), getJRRdfBtn().getName());
			getJPanel1().add(getJRRuleBtn(), getJRRuleBtn().getName());
			getJPanel1().add(getJQueryBtn(), getJQueryBtn().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel1;
}
/**
 * Return the JQueryBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getJQueryBtn() {
	if (ivjJQueryBtn == null) {
		try {
			ivjJQueryBtn = new javax.swing.JButton();
			ivjJQueryBtn.setName("JQueryBtn");
			ivjJQueryBtn.setFont(new java.awt.Font("dialog.bold", 1, 14));
			ivjJQueryBtn.setText("Run Query");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJQueryBtn;
}
/**
 * Return the JQueryScroll property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJQueryScroll() {
	if (ivjJQueryScroll == null) {
		try {
			ivjJQueryScroll = new javax.swing.JScrollPane();
			ivjJQueryScroll.setName("JQueryScroll");
			getJQueryScroll().setViewportView(getJQueryTxt());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJQueryScroll;
}
/**
 * Return the JQueryTxt property value.
 * @return javax.swing.JTextPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextPane getJQueryTxt() {
	if (ivjJQueryTxt == null) {
		try {
			ivjJQueryTxt = new javax.swing.JTextPane();
			ivjJQueryTxt.setName("JQueryTxt");
			ivjJQueryTxt.setFont(new java.awt.Font("dialog", 0, 18));
			ivjJQueryTxt.setBounds(0, 0, 160, 120);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJQueryTxt;
}
/**
 * Return the JResultScroll property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJResultScroll() {
	if (ivjJResultScroll == null) {
		try {
			ivjJResultScroll = new javax.swing.JScrollPane();
			ivjJResultScroll.setName("JResultScroll");
			getJResultScroll().setViewportView(getJResultTxt());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJResultScroll;
}
/**
 * Return the JResultTxt property value.
 * @return javax.swing.JTextPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextPane getJResultTxt() {
	if (ivjJResultTxt == null) {
		try {
			ivjJResultTxt = new javax.swing.JTextPane();
			ivjJResultTxt.setName("JResultTxt");
			ivjJResultTxt.setFont(new java.awt.Font("dialog", 0, 18));
			ivjJResultTxt.setBounds(0, 0, 160, 120);
			ivjJResultTxt.setEditable(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJResultTxt;
}
/**
 * Return the JRQueryBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getJRQueryBtn() {
	if (ivjJRQueryBtn == null) {
		try {
			ivjJRQueryBtn = new javax.swing.JButton();
			ivjJRQueryBtn.setName("JRQueryBtn");
			ivjJRQueryBtn.setFont(new java.awt.Font("dialog.bold", 1, 14));
			ivjJRQueryBtn.setText("Read Query");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJRQueryBtn;
}
/**
 * Return the JRRdfBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getJRRdfBtn() {
	if (ivjJRRdfBtn == null) {
		try {
			ivjJRRdfBtn = new javax.swing.JButton();
			ivjJRRdfBtn.setName("JRRdfBtn");
			ivjJRRdfBtn.setFont(new java.awt.Font("dialog.bold", 1, 14));
			ivjJRRdfBtn.setText("Read RDF");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJRRdfBtn;
}
/**
 * Return the JRRuleBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getJRRuleBtn() {
	if (ivjJRRuleBtn == null) {
		try {
			ivjJRRuleBtn = new javax.swing.JButton();
			ivjJRRuleBtn.setName("JRRuleBtn");
			ivjJRRuleBtn.setFont(new java.awt.Font("dialog.bold", 1, 14));
			ivjJRRuleBtn.setText("Read F-Logic");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJRRuleBtn;
}
/**
 * Return the JSplitPane1 property value.
 * @return javax.swing.JSplitPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSplitPane getJSplitPane1() {
	if (ivjJSplitPane1 == null) {
		try {
			ivjJSplitPane1 = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT);
			ivjJSplitPane1.setName("JSplitPane1");
			ivjJSplitPane1.setDividerLocation(100);
			getJSplitPane1().add(getJQueryScroll(), "top");
			getJSplitPane1().add(getJResultScroll(), "bottom");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJSplitPane1;
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
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getJRQueryBtn().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			connEtoC1(e);
		};
	});
	getJQueryBtn().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			connEtoC2(e);
		};
	});
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("Searcher");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(478, 292);
		setTitle("XML-KManager Searcher");
		setContentPane(getJFrameContentPane());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Comment
 */
public void jQueryBtn_ActionPerformed1() 
{
	try
	{
		engine.compileString(ivjJQueryTxt.getText());
		engine.compileFile("base.rule");
	   	engine.stratify();
	   	engine.evaluate();
	   	printResults(engine.computeSubstitutions());
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
}
/**
 * Comment
 */
public void jRQueryBtn_ActionPerformed1() 
{
	java.io.BufferedReader f = null;
	try
	{
		String queryF = JOptionPane.showInputDialog("Input query file name:");
		f = new java.io.BufferedReader(new FileReader(queryF));

		ivjJQueryTxt.setText("");
		String line = null;
		while((line = f.readLine()) != null)
			ivjJQueryTxt.setText(ivjJQueryTxt.getText()+line+"\n");
	}
	catch(Exception e){}
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		Searcher aSearcher;
		aSearcher = new Searcher();
		aSearcher.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		aSearcher.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JFrame");
		exception.printStackTrace(System.out);
	}
}
/**
 * 
 */
public void printResults(java.util.Vector QSubst) 
{
	java.util.Enumeration e,f,g;

	ivjJResultTxt.setText("");
	
	for(e = QSubst.elements();e.hasMoreElements();)
	{
   		for(f=((Vector)(e.nextElement())).elements(); f.hasMoreElements();)
   		{
	 		for(g=((Vector)(f.nextElement())).elements(); g.hasMoreElements();)
	 		{
				ivjJResultTxt.setText(ivjJResultTxt.getText() + 
					g.nextElement().toString()+"\n");
			}
	 		ivjJResultTxt.setText(ivjJResultTxt.getText()+"\n");
  	 	}
 	}	
}
/**
 * 
 */
private void startKBase() 
{
	try
	{
		engine = new RDFEvaluator();
   		engine.init();
		engine.compileRDFFile("research-ontology-schema.xml");
		engine.compileRDFFile("archiveRDF.xml");
  		engine.compileFile("base.rule");
	}
	catch(Exception e)
	{}
}
}
