package kxml.gui;

public class IdentificationDlg extends javax.swing.JDialog implements java.awt.event.ActionListener, java.awt.event.WindowListener {
	private javax.swing.JButton ivjcancelBtn = null;
	private javax.swing.JPanel ivjJDialogContentPane = null;
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JLabel ivjJLabel2 = null;
	private javax.swing.JLabel ivjJLabel3 = null;
	private javax.swing.JLabel ivjJLabel4 = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JPanel ivjJPanel2 = null;
	private javax.swing.JPasswordField ivjJPasswordField1 = null;
	private javax.swing.JTextField ivjJTextField1 = null;
	private javax.swing.JButton ivjokBtn = null;
	private javax.swing.JCheckBox ivjIsAdminCheckBox = null;

	private String title = "Identification Control";
	private boolean adminRequest = false;
	
	public String userId = null;
	public String passwd = null;
	public boolean isAdmin = false;
	public boolean accepted = false;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public IdentificationDlg() {
	super();
	initialize();
}
/**
 * 
 */
public IdentificationDlg(String title) 
{
	super();
	this.title = title;
	initialize();
}
/**
 * 
 */
public IdentificationDlg(String title, boolean adminRequest) 
{
	super();
	this.title = title;
	this.adminRequest = adminRequest;
	initialize();
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
 * Return the JPasswordField1 property value.
 * @return javax.swing.JPasswordField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JCheckBox getJCheckBox() {
	if (ivjIsAdminCheckBox == null) {
		try {
			ivjIsAdminCheckBox = new javax.swing.JCheckBox("Administrator?", false);
			ivjIsAdminCheckBox.setName("JCheckBox");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjIsAdminCheckBox;
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
			ivjJLabel1.setText("User identifier:");
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
			ivjJLabel2.setText("Password:");
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
	java.awt.GridBagConstraints constraintsJPasswordField1 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJLabel3 = new java.awt.GridBagConstraints();
	java.awt.GridBagConstraints constraintsJCheckBox = new java.awt.GridBagConstraints();
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

			constraintsJPasswordField1.gridx = 1; constraintsJPasswordField1.gridy = 1;
			constraintsJPasswordField1.gridwidth = 1; constraintsJPasswordField1.gridheight = 1;
			constraintsJPasswordField1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			constraintsJPasswordField1.anchor = java.awt.GridBagConstraints.CENTER;
			constraintsJPasswordField1.weightx = 0.0;
			constraintsJPasswordField1.weighty = 0.0;
			constraintsJPasswordField1.insets = new java.awt.Insets(5, 0, 5, 5);
			getJPanel1().add(getJPasswordField1(), constraintsJPasswordField1);

			if (adminRequest)
			{
				constraintsJCheckBox.gridx = 1; constraintsJCheckBox.gridy = 2;
				constraintsJCheckBox.gridwidth = 1; constraintsJCheckBox.gridheight = 1;
				constraintsJCheckBox.anchor = java.awt.GridBagConstraints.WEST;
				constraintsJCheckBox.weightx = 0.0;
				constraintsJCheckBox.weighty = 0.0;
				constraintsJCheckBox.insets = new java.awt.Insets(0, 0, 3, 5);
				getJPanel1().add(getJCheckBox(), constraintsJCheckBox);
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
 * Return the JPasswordField1 property value.
 * @return javax.swing.JPasswordField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPasswordField getJPasswordField1() {
	if (ivjJPasswordField1 == null) {
		try {
			ivjJPasswordField1 = new javax.swing.JPasswordField();
			ivjJPasswordField1.setName("JPasswordField1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJPasswordField1;
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
		IdentificationDlg aIdentificationDlg;
		aIdentificationDlg = new IdentificationDlg();
		aIdentificationDlg.setModal(true);
		
		aIdentificationDlg.show();
		if (aIdentificationDlg.accepted)
			System.out.println("User: "+ aIdentificationDlg.userId + 
							   "// Password: " + aIdentificationDlg.passwd);
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
	userId = new String(ivjJTextField1.getText());
	passwd = new String(ivjJPasswordField1.getPassword());
	if (adminRequest)
		isAdmin = ivjIsAdminCheckBox.isSelected();
	dispose();
}
/**
 * 
 */
public void predefinedUser(String userId) 
{
	this.userId = userId;
	this.adminRequest = false;
	
	ivjJTextField1.setText(userId);
	ivjJTextField1.setEditable(false);
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
