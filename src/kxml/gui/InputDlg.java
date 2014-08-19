package kxml.gui;

public class InputDlg extends javax.swing.JDialog implements java.awt.event.ActionListener, java.awt.event.WindowListener {
	private javax.swing.JButton ivjcancelBtn = null;
	private javax.swing.JPanel ivjJDialogContentPane = null;
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JLabel ivjJLabel2 = null;
	private javax.swing.JLabel ivjJLabel3 = null;
	private javax.swing.JLabel ivjJLabel4 = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JPanel ivjJPanel2 = null;
	private javax.swing.JTextField ivjJTextField1 = null;
	private javax.swing.JTextField ivjJTextField2 = null;
	private javax.swing.JTextField ivjJTextField3 = null;
	private javax.swing.JButton ivjokBtn = null;

	private String title = "Input Dialog";
	
	public String out1 = null;
	public String out2 = null;
	public String out3 = null;
	public int numFields = 2;
	public boolean accepted = false;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public InputDlg() {
	super();
	initialize();
}
/**
 * 
 */
public InputDlg(String title) 
{
	super();
	this.title = title;
	initialize();
}
/**
 * 
 */
public InputDlg(String title, String input1, String input2) 
{
	super();
	this.title = title;
	initialize();
	ivjJLabel1.setText(input1);
	ivjJLabel2.setText(input2);
}
/**
 * 
 */
public InputDlg(String title, String input1, String input2, 
					   	 String input3) 
{
	super();
	this.title = title;
	this.numFields = 3;
	initialize();
	ivjJLabel1.setText(input1);
	ivjJLabel2.setText(input2);
	ivjJLabel3.setText(input3);
}
/**
 * Method to handle events for the ActionListener interface.
 * @param e java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformed(java.awt.event.ActionEvent e) {
	// user code begin {1}
	// user code end
	if ((e.getSource() == getokBtn()) ) {
		connEtoC1(e);
	}
	if ((e.getSource() == getcancelBtn()) ) {
		connEtoC2(e);
	}
	// user code begin {2}
	// user code end
}
/**
 * Comment
 */
public void cancelBtn_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
	return;
}
/**
 * connEtoC1:  (okBtn.action.actionPerformed(java.awt.event.ActionEvent) --> IdentificationDlg.okBtn_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.okBtn_ActionPerformed(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (cancelBtn.action.actionPerformed(java.awt.event.ActionEvent) --> IdentificationDlg.cancelBtn_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.cancelBtn_ActionPerformed(arg1);
		connEtoM1();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (IdentificationDlg.window.windowClosing(java.awt.event.WindowEvent) --> IdentificationDlg.identificationDlg_WindowClosing(Ljava.awt.event.WindowEvent;)V)
 * @param arg1 java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.awt.event.WindowEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.identificationDlg_WindowClosing(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoM1:  ( (cancelBtn,action.actionPerformed(java.awt.event.ActionEvent) --> IdentificationDlg,cancelBtn_ActionPerformed(Ljava.awt.event.ActionEvent;)V).normalResult --> IdentificationDlg.dispose()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1() {
	try {
		// user code begin {1}
		// user code end
		this.dispose();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the cancelBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getcancelBtn() {
	if (ivjcancelBtn == null) {
		try {
			ivjcancelBtn = new javax.swing.JButton();
			ivjcancelBtn.setName("cancelBtn");
			ivjcancelBtn.setText("Cancel");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjcancelBtn;
}
/**
 * Return the JDialogContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJDialogContentPane() {
	if (ivjJDialogContentPane == null) {
		try {
			ivjJDialogContentPane = new javax.swing.JPanel();
			ivjJDialogContentPane.setName("JDialogContentPane");
			ivjJDialogContentPane.setLayout(new java.awt.BorderLayout());
			getJDialogContentPane().add(getJPanel1(), "Center");
			getJDialogContentPane().add(getJPanel2(), "South");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJDialogContentPane;
}
/**
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel1() {
	if (ivjJLabel1 == null) {
		try {
			ivjJLabel1 = new javax.swing.JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText(" ");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJLabel1;
}
/**
 * Return the JLabel2 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel2() {
	if (ivjJLabel2 == null) {
		try {
			ivjJLabel2 = new javax.swing.JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setText(" ");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJLabel2;
}
/**
 * Return the JLabel3 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel3() {
	if (ivjJLabel3 == null) {
		try {
			ivjJLabel3 = new javax.swing.JLabel();
			ivjJLabel3.setName("JLabel3");
			ivjJLabel3.setText(" ");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJLabel3;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJTextField1 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJLabel2 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJTextField2 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJLabel3 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJTextField3 = new java.awt.GridBagConstraints();
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			constraintsJLabel1.gridx = 0; constraintsJLabel1.gridy = 0;
			constraintsJLabel1.gridwidth = 1; constraintsJLabel1.gridheight = 1;
			constraintsJLabel1.anchor = java.awt.GridBagConstraints.EAST;
			constraintsJLabel1.weightx = 0.0;
			constraintsJLabel1.weighty = 0.0;
			constraintsJLabel1.insets = new java.awt.Insets(4, 5, 0, 5);
			getJPanel1().add(getJLabel1(), constraintsJLabel1);

			constraintsJTextField1.gridx = 1; constraintsJTextField1.gridy = 0;
			constraintsJTextField1.gridwidth = 1; constraintsJTextField1.gridheight = 1;
			constraintsJTextField1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJTextField1.anchor = java.awt.GridBagConstraints.CENTER;
			constraintsJTextField1.weightx = 1.0;
			constraintsJTextField1.weighty = 0.0;
			constraintsJTextField1.insets = new java.awt.Insets(4, 0, 0, 5);
			getJPanel1().add(getJTextField1(), constraintsJTextField1);

			constraintsJLabel2.gridx = 0; constraintsJLabel2.gridy = 1;
			constraintsJLabel2.gridwidth = 1; constraintsJLabel2.gridheight = 1;
			constraintsJLabel2.anchor = java.awt.GridBagConstraints.EAST;
			constraintsJLabel2.weightx = 0.0;
			constraintsJLabel2.weighty = 0.0;
			constraintsJLabel2.insets = new java.awt.Insets(5, 5, 5, 5);
			getJPanel1().add(getJLabel2(), constraintsJLabel2);

			constraintsJTextField2.gridx = 1; constraintsJTextField2.gridy = 1;
			constraintsJTextField2.gridwidth = 1; constraintsJTextField2.gridheight = 1;
			constraintsJTextField2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJTextField2.anchor = java.awt.GridBagConstraints.CENTER;
			constraintsJTextField2.weightx = 0.0;
			constraintsJTextField2.weighty = 0.0;
			constraintsJTextField2.insets = new java.awt.Insets(5, 0, 5, 5);
			getJPanel1().add(getJTextField2(), constraintsJTextField2);


			if (numFields == 3)
			{
				constraintsJLabel3.gridx = 0; constraintsJLabel3.gridy = 2;
				constraintsJLabel3.gridwidth = 1; constraintsJLabel3.gridheight = 1;
				constraintsJLabel3.anchor = java.awt.GridBagConstraints.EAST;
				constraintsJLabel3.weightx = 0.0;
				constraintsJLabel3.weighty = 0.0;
				constraintsJLabel3.insets = new java.awt.Insets(5, 5, 5, 5);
				getJPanel1().add(getJLabel3(), constraintsJLabel3);

				constraintsJTextField3.gridx = 1; constraintsJTextField3.gridy = 2;
				constraintsJTextField3.gridwidth = 1; constraintsJTextField3.gridheight = 1;
				constraintsJTextField3.fill = java.awt.GridBagConstraints.HORIZONTAL;
				constraintsJTextField3.anchor = java.awt.GridBagConstraints.CENTER;
				constraintsJTextField3.weightx = 0.0;
				constraintsJTextField3.weighty = 0.0;
				constraintsJTextField3.insets = new java.awt.Insets(5, 0, 5, 5);
				getJPanel1().add(getJTextField3(), constraintsJTextField3);	
			}
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJPanel1;
}
/**
 * Return the JPanel2 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel2() {
	if (ivjJPanel2 == null) {
		try {
			ivjJPanel2 = new javax.swing.JPanel();
			ivjJPanel2.setName("JPanel2");
			ivjJPanel2.setLayout(new java.awt.FlowLayout());
			getJPanel2().add(getokBtn(), getokBtn().getName());
			getJPanel2().add(getcancelBtn(), getcancelBtn().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJPanel2;
}
/**
 * Return the JTextField1 property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField1() {
	if (ivjJTextField1 == null) {
		try {
			ivjJTextField1 = new javax.swing.JTextField();
			ivjJTextField1.setName("JTextField1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJTextField1;
}
/**
 * Return the JPasswordField1 property value.
 * @return javax.swing.JPasswordField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField2() {
	if (ivjJTextField2 == null) {
		try {
			ivjJTextField2 = new javax.swing.JTextField();
			ivjJTextField2.setName("JPasswordField2");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJTextField2;
}
/**
 * Return the JPasswordField1 property value.
 * @return javax.swing.JPasswordField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField3() {
	if (ivjJTextField3 == null) {
		try {
			ivjJTextField3 = new javax.swing.JTextField();
			ivjJTextField3.setName("JPasswordField2");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJTextField3;
}
/**
 * Return the okBtn property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getokBtn() {
	if (ivjokBtn == null) {
		try {
			ivjokBtn = new javax.swing.JButton();
			ivjokBtn.setName("okBtn");
			ivjokBtn.setText("OK");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjokBtn;
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
 * Comment
 */
public void identificationDlg_WindowClosing(java.awt.event.WindowEvent windowEvent) {
	dispose();
}
/**
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() {
	// user code begin {1}
	// user code end
	getokBtn().addActionListener(this);
	getcancelBtn().addActionListener(this);
	this.addWindowListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	// user code begin {1}
	// user code end
	setName("IdentificationDlg");
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	setResizable(false);
	setSize(400, 150);
	setModal(true);
	setTitle(title);
	setContentPane(getJDialogContentPane());
	initConnections();
	// user code begin {2}
	pack();
	setSize(400, getSize().height);
	// user code end
}
/**
 * 
 */
public static void main(java.lang.String[] args) {
	try {
		InputDlg aIdentificationDlg;
		aIdentificationDlg = new InputDlg("title","b","c","d");
		aIdentificationDlg.setModal(true);
		
		aIdentificationDlg.show();
		if (aIdentificationDlg.accepted)
			System.out.println("o1: "+ aIdentificationDlg.out1 + 
							   "// o2: " + aIdentificationDlg.out2 +
							   "// o3: " + aIdentificationDlg.out3);
		else
			System.out.println("Dialog canceled");
		System.exit(0);
		
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JDialog");
		exception.printStackTrace(System.out);
	}
}
/**
 * Comment
 */
public void okBtn_ActionPerformed(java.awt.event.ActionEvent actionEvent) 
{
	accepted = true;
	out1 = new String(ivjJTextField1.getText());
	out2 = new String(ivjJTextField2.getText());
	if (numFields >= 3)
		out3 = new String(ivjJTextField3.getText());

	dispose();
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowActivated(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowClosed(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowClosing(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	if ((e.getSource() == this) ) {
		connEtoC3(e);
	}
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowDeactivated(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowDeiconified(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowIconified(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
/**
 * Method to handle events for the WindowListener interface.
 * @param e java.awt.event.WindowEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void windowOpened(java.awt.event.WindowEvent e) {
	// user code begin {1}
	// user code end
	// user code begin {2}
	// user code end
}
}
