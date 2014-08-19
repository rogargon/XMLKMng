package kxml.gui;

import kxml.domain.IdElem;
import kxml.logic.TransacOrigin;
import kxml.util.StackSet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;

public class MainMenuBar extends JFrame 
						 implements ActionListener, WindowListener 
{
	private JPanel ivjJFrameContentPane = null;
	private JRadioButtonMenuItem estiloActual;
	private JMenu ivjJMenu1 = null;
	private JMenu ivjJMenu2 = null;
	private JMenu ivjAdminMenu = null;
	private JMenuBar ivjMainMenuJMenuBar = null;
	private JSeparator ivjJSeparator1 = null;
	private JMenuItem ivjjMenuAbout = null;
	private JMenuItem ivjjMenuExit = null;
	private JMenuItem ivjCreateUserMenu = null;
	private JMenu ivjjMenuHelp = null;
	private JMenu ivjjMenuLF = null;
	private JMenuItem ivjjMenuOpen = null;
	private JMenuItem ivjjMenuType = null;
	private JMenuItem ivjjMenuXSL = null;	
	private JMenu ivjjMenuRecent = null;
	private JMenuItem ivjjMenuChangePasswd = null;
	private JRadioButtonMenuItem ivjjRadioMenuWindows = null;
	private JRadioButtonMenuItem ivjjRadioMenuMetal = null;
	private JSeparator ivjJSeparator2 = null;
	private JRadioButtonMenuItem ivjjRadioMenuMotif = null;
	private JRadioButtonMenuItem ivjjRadioMenuMac = null;

	protected MetadataView metadataV = null;
	protected ArchiveView archiveV = null;
	protected InternalEditor internalV = null;
	protected LogViewer logV = null;
	protected TransacOrigin trOrigin = null;
	private java.lang.String userId = null;
	private boolean isAdmin = false;
	private StackSet recentSet = 
			new StackSet(kxml.domain.util.Configuration.USERRECENTDOCS);
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public MainMenuBar() {
	super();
	initialize();
}
/**
 * 
 */
public MainMenuBar(String userId, boolean isAdmin) 
{
	super();
	initialize();
	setTitle(getTitle() + " ("+userId+")");
	this.userId = userId;
	this.isAdmin= isAdmin;
	ivjAdminMenu.setEnabled(isAdmin);
}
/**
 * Method to handle events for the ActionListener interface.
 * @param e java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void actionPerformed(ActionEvent e) {
	// user code begin {1}
	// user code end
	if ((e.getSource() == getjMenuAbout()) ) {
		connEtoC4(e);
	}
	if ((e.getSource() == getjMenuExit()) ) {
		connEtoC5(e);
	}
	if ((e.getSource() == getjMenuOpen()) ) {
		connEtoC6(e);
	}
	if ((e.getSource() == getjRadioMenuMetal()) ) {
		connEtoC1(e);
	}
	if ((e.getSource() == getjRadioMenuWindows()) ) {
		connEtoC2(e);
	}
	if ((e.getSource() == getjRadioMenuMotif()) ) {
		connEtoC3(e);
	}
	if ((e.getSource() == getCreateUserMenu()) ) {
		connEtoC7(e);
	}
	if ((e.getSource() == getjMenuChangePasswd()) ) {
		connEtoC8(e);
	}
	if ((e.getSource() == getjMenuXSL()) ) {
		connEtoC9(e);
	}
	if ((e.getSource() == getjMenuType()) ) {
		connEtoC10(e);
	}
	// user code begin {2}
	// user code end
}
/**
 * connEtoC1:  (JRadioButtonMenuItem1.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenu.jRadioButtonMenuItem1_ActionPerformed1(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jRadioMenuMetal_ActionPerformed(null);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (jMenuOpen.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuOpen_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC10(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuType_ActionPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (JRadioButtonMenuItem2.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenu.jRadioButtonMenuItem2_ActionPerformed1(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jRadioMenuWindows_ActionPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (JRadioMenuMotif.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jRadioMenuMotif_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jRadioMenuMotif_ActionPerformed(null);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (jMenuAbout.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuAbout_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuAbout_ActionPerformed(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (jMenuExit.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuExit_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuExit_ActionPerformed(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (jMenuOpen.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuOpen_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuOpen_ActionPerformed(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (jMenuOpen.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuOpen_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC7(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuCreateUser_ActionPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (jMenuOpen.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuOpen_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC8(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuChangePasswd_ActionPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (jMenuOpen.action.actionPerformed(java.awt.event.ActionEvent) --> MainMenuBar.jMenuOpen_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC9(ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.jMenuXSL_ActionPerformed();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * 
 */
public String currentUser() 
{
	return userId;
}
/**
 * Set all GUI elements to fit the screen.
 */
public void doGUILayout(MetadataView metadataV, ArchiveView archiveV, 
						InternalEditor internalV, LogViewer logV) 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	int widthPart1 = (int)(screenWidth * 0.33);
	int widthPart2 = ((int)screenWidth) - widthPart1;

	pack();
	setSize((int)screenWidth, getSize().height);
	setVisible(true);

	metadataV.pack();
	metadataV.setLocation(0, (int)screenHeight - metadataV.getSize().height);
	metadataV.setSize(widthPart1, metadataV.getSize().height);
	metadataV.setVisible(true);
	metadataV.fitColumns();

	archiveV.pack();
	archiveV.setLocation(0, getSize().height);
	archiveV.setSize(widthPart1, 
		(int)screenHeight - getSize().height - metadataV.getSize().height);
	archiveV.setVisible(true);

	logV.pack();
	logV.setLocation(widthPart1, (int)screenHeight - logV.getSize().height);
	logV.setSize(widthPart2, logV.getSize().height);
	logV.setVisible(true);

	//internalV.pack();
	internalV.setLocation(widthPart1, getSize().height);
	internalV.setSize(widthPart2, (int)screenHeight - 
								  logV.getSize().height - getSize().height);
	internalV.setVisible(true);
}
/**
 * Return the JMenu2 property value.
 * @return javax.swing.JMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenu getAdminMenu() {
	if (ivjAdminMenu == null) {
		try {
			ivjAdminMenu = new javax.swing.JMenu();
			ivjAdminMenu.setName("JAdminMenu");
			ivjAdminMenu.setText("Administrator");
			ivjAdminMenu.add(getCreateUserMenu());
			ivjAdminMenu.add(getjMenuType());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjAdminMenu;
}
/**
 * Return the jMenuExit property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getCreateUserMenu() {
	if (ivjCreateUserMenu == null) {
		try {
			ivjCreateUserMenu = new javax.swing.JMenuItem();
			ivjCreateUserMenu.setName("ivjCreateUserMenu");
			ivjCreateUserMenu.setText("Create user");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjCreateUserMenu;
}
/**
 * Return the JRadioButtonMenuItem3 property value.
 * @return javax.swing.JRadioButtonMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JRadioButtonMenuItem getivjjRadioMenuMotif() {
	if (ivjjRadioMenuMotif == null) {
		try {
			ivjjRadioMenuMotif = new javax.swing.JRadioButtonMenuItem();
			ivjjRadioMenuMotif.setName("JRadioButtonMenuItem3");
			ivjjRadioMenuMotif.setText("Motif/DCE");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjRadioMenuMotif;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJFrameContentPane;
}
/**
 * Return the JMenu1 property value.
 * @return javax.swing.JMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenu getJMenu1() {
	if (ivjJMenu1 == null) {
		try {
			ivjJMenu1 = new javax.swing.JMenu();
			ivjJMenu1.setName("JMenu1");
			ivjJMenu1.setText("Archive");
			ivjJMenu1.add(getjMenuOpen());
			ivjJMenu1.add(getjMenuChangePasswd());
			ivjJMenu1.add(getJSeparator1());
			ivjJMenu1.add(getjMenuRecent());
			ivjJMenu1.add(getJSeparator2());
			ivjJMenu1.add(getjMenuExit());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJMenu1;
}
/**
 * Return the JMenu2 property value.
 * @return javax.swing.JMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenu getJMenu2() {
	if (ivjJMenu2 == null) {
		try {
			ivjJMenu2 = new javax.swing.JMenu();
			ivjJMenu2.setName("JMenu2");
			ivjJMenu2.setText("View");
			ivjJMenu2.add(getjMenuLF());
			ivjJMenu2.add(getjMenuXSL());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJMenu2;
}
/**
 * Return the jMenuAbout property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuAbout() {
	if (ivjjMenuAbout == null) {
		try {
			ivjjMenuAbout = new javax.swing.JMenuItem();
			ivjjMenuAbout.setName("jMenuAbout");
			ivjjMenuAbout.setText("About");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuAbout;
}
/**
 * Return the jMenuExit property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuChangePasswd() {
	if (ivjjMenuChangePasswd == null) {
		try {
			ivjjMenuChangePasswd = new javax.swing.JMenuItem();
			ivjjMenuChangePasswd.setName("jMenuChangePasswd");
			ivjjMenuChangePasswd.setText("Change password");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuChangePasswd;
}
/**
 * Return the jMenuExit property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuExit() {
	if (ivjjMenuExit == null) {
		try {
			ivjjMenuExit = new javax.swing.JMenuItem();
			ivjjMenuExit.setName("jMenuExit");
			ivjjMenuExit.setText("Exit");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuExit;
}
/**
 * Return the jMenuHelp property value.
 * @return javax.swing.JMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenu getjMenuHelp() {
	if (ivjjMenuHelp == null) {
		try {
			ivjjMenuHelp = new javax.swing.JMenu();
			ivjjMenuHelp.setName("jMenuHelp");
			ivjjMenuHelp.setAlignmentX(0.0F);
			ivjjMenuHelp.setText("Help");
			ivjjMenuHelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
			ivjjMenuHelp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
			ivjjMenuHelp.add(getjMenuAbout());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuHelp;
}
/**
 * Return the JMenu3 property value.
 * @return javax.swing.JMenu
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenu getjMenuLF() {
	if (ivjjMenuLF == null) {
		try {
			ivjjMenuLF = new javax.swing.JMenu();
			ivjjMenuLF.setName("jMenuLF");
			ivjjMenuLF.setText("Look&Feel");
			ivjjMenuLF.add(getjRadioMenuMetal());
			ivjjMenuLF.add(getjRadioMenuWindows());
			ivjjMenuLF.add(getjRadioMenuMotif());
			//ivjjMenuLF.add(getjRadioMenuMac());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuLF;
}
/**
 * Return the JMenuItem1 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuOpen() {
	if (ivjjMenuOpen == null) {
		try {
			ivjjMenuOpen = new javax.swing.JMenuItem();
			ivjjMenuOpen.setName("jMenuOpen");
			ivjjMenuOpen.setText("Open");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuOpen;
}
/**
 * 
 */
private JMenu getjMenuRecent() 
{
	if (ivjjMenuRecent == null) 
	{
		try 
		{
			ivjjMenuRecent = new javax.swing.JMenu();
			ivjjMenuRecent.setName("jMenuRecent");
			ivjjMenuRecent.setText("Recent");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuRecent;
}
/**
 * Return the JMenuItem1 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuType() {
	if (ivjjMenuType == null) {
		try {
			ivjjMenuType = new javax.swing.JMenuItem();
			ivjjMenuType.setName("jMenuType");
			ivjjMenuType.setText("Document types");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuType;
}
/**
 * Return the JMenuItem1 property value.
 * @return javax.swing.JMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuItem getjMenuXSL() {
	if (ivjjMenuXSL == null) {
		try {
			ivjjMenuXSL = new javax.swing.JMenuItem();
			ivjjMenuXSL.setName("jMenuType");
			ivjjMenuXSL.setText("Associate XSL");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjMenuXSL;
}
/**
 * 
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JRadioButtonMenuItem getjRadioMenuMac() {
	if (ivjjRadioMenuMac == null) {
		try {
			ivjjRadioMenuMac = new javax.swing.JRadioButtonMenuItem();
			ivjjRadioMenuMac.setName("jRadioMenuMac");
			ivjjRadioMenuMac.setText("MacOS");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjRadioMenuMac;
}
/**
 * Return the JRadioButtonMenuItem1 property value.
 * @return javax.swing.JRadioButtonMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JRadioButtonMenuItem getjRadioMenuMetal() {
	if (ivjjRadioMenuMetal == null) {
		try {
			ivjjRadioMenuMetal = new javax.swing.JRadioButtonMenuItem();
			ivjjRadioMenuMetal.setName("jRadioMenuMetal");
			ivjjRadioMenuMetal.setSelected(false);
			ivjjRadioMenuMetal.setText("Metal");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjRadioMenuMetal;
}
/**
 * Return the JRadioMenuMotif property value.
 * @return javax.swing.JRadioButtonMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JRadioButtonMenuItem getjRadioMenuMotif() {
	if (ivjjRadioMenuMotif == null) {
		try {
			ivjjRadioMenuMotif = new javax.swing.JRadioButtonMenuItem();
			ivjjRadioMenuMotif.setName("jRadioMenuMotif");
			ivjjRadioMenuMotif.setText("Motif/DCE");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjRadioMenuMotif;
}
/**
 * Return the JRadioButtonMenuItem2 property value.
 * @return javax.swing.JRadioButtonMenuItem
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JRadioButtonMenuItem getjRadioMenuWindows() {
	if (ivjjRadioMenuWindows == null) {
		try {
			ivjjRadioMenuWindows = new javax.swing.JRadioButtonMenuItem();
			ivjjRadioMenuWindows.setName("jRadioMenuWindows");
			ivjjRadioMenuWindows.setText("Windows");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjjRadioMenuWindows;
}
/**
 * Return the JSeparator1 property value.
 * @return javax.swing.JSeparator
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JSeparator getJSeparator1() {
	if (ivjJSeparator1 == null) {
		try {
			ivjJSeparator1 = new javax.swing.JSeparator();
			ivjJSeparator1.setName("JSeparator1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJSeparator1;
}
/**
 * Return the JSeparator2 property value.
 * @return javax.swing.JSeparator
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JSeparator getJSeparator2() {
	if (ivjJSeparator2 == null) {
		try {
			ivjJSeparator2 = new javax.swing.JSeparator();
			ivjJSeparator2.setName("JSeparator2");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjJSeparator2;
}
/**
 * Return the MainMenuJMenuBar property value.
 * @return javax.swing.JMenuBar
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private JMenuBar getMainMenuJMenuBar() {
	if (ivjMainMenuJMenuBar == null) {
		try {
			ivjMainMenuJMenuBar = new javax.swing.JMenuBar();
			ivjMainMenuJMenuBar.setName("MainMenuJMenuBar");
			ivjMainMenuJMenuBar.add(getJMenu1());
			ivjMainMenuJMenuBar.add(getJMenu2());
			ivjMainMenuJMenuBar.add(getAdminMenu());
			ivjMainMenuJMenuBar.add(Box.createHorizontalGlue());
			ivjMainMenuJMenuBar.add(getjMenuHelp());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	};
	return ivjMainMenuJMenuBar;
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
 * Initializes connections
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() {
	// user code begin {1}
	// user code end
	getjMenuAbout().addActionListener(this);
	getjMenuExit().addActionListener(this);
	getjMenuOpen().addActionListener(this);
	getjRadioMenuMetal().addActionListener(this);
	getjRadioMenuWindows().addActionListener(this);
	getjRadioMenuMotif().addActionListener(this);
	getCreateUserMenu().addActionListener(this);
	getjMenuChangePasswd().addActionListener(this);
	getjMenuXSL().addActionListener(this);
	getjMenuType().addActionListener(this);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	// user code begin {1}
	// user code end
	setName("MainMenu");
	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	setJMenuBar(getMainMenuJMenuBar());
	setSize(800, 20);
	setTitle("XML-KManager");
	setContentPane(getJFrameContentPane());
	initConnections();
	// user code begin {2}
	addWindowListener(this);
	setResizable(false);
	// user code end
}
/**
 * Comment
 */
public void jMenuAbout_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
	return;
}
/**
 * Comment
 */
public void jMenuChangePasswd_ActionPerformed() 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	IdentificationDlg idDlg = new IdentificationDlg("Change password");
	idDlg.setLocation((int)(screenWidth - idDlg.getSize().width)/2,
		  					  (int)(screenHeight - idDlg.getSize().height)/2);
	idDlg.predefinedUser(this.userId);
	idDlg.setVisible(true);
	if (idDlg.accepted)
	{
		try
		{
			trOrigin.createUser(this.userId, idDlg.passwd, this.isAdmin);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Creation error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
/**
 * Comment
 */
public void jMenuCreateUser_ActionPerformed() 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	IdentificationDlg idDlg = new IdentificationDlg("New user", true);
	idDlg.setLocation((int)(screenWidth - idDlg.getSize().width)/2,
		  					  (int)(screenHeight - idDlg.getSize().height)/2);

	idDlg.setVisible(true);
	if (idDlg.accepted)
	{
		try
		{
			trOrigin.createUser(idDlg.userId, idDlg.passwd, idDlg.isAdmin);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Creation error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
/**
 * Comment
 */
public void jMenuExit_ActionPerformed(java.awt.event.ActionEvent actionEvent)
{
	dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
}
/**
 * Comment
 */
public void jMenuOpen_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
	return;
}
/**
 * Comment
 */
public void jMenuType_ActionPerformed() 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	InputDlg iDlg = new InputDlg("New document type", 
									"MIME identifier:", "Editor command:");
	iDlg.setLocation((int)(screenWidth - iDlg.getSize().width)/2,
		  					  (int)(screenHeight - iDlg.getSize().height)/2);

	iDlg.setVisible(true);
	if (iDlg.accepted)
	{
		try
		{
			trOrigin.defineDocType(iDlg.out1, iDlg.out2);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Creation error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
/**
 * Comment
 */
public void jMenuXSL_ActionPerformed() 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	InputDlg iDlg = new InputDlg("New document type", 
							"XSL Name:", "XSL URL:", "DTD Name:");
	iDlg.setLocation((int)(screenWidth - iDlg.getSize().width)/2,
		  					  (int)(screenHeight - iDlg.getSize().height)/2);

	iDlg.setVisible(true);
	if (iDlg.accepted)
	{
		try
		{
			trOrigin.associateXSL(iDlg.out1, iDlg.out2, iDlg.out3);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),
							"Association error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
/**
 * Comment
 */
public void jRadioMenuMetal_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
	if (estiloActual != ivjjRadioMenuMetal)
	{
		estiloActual.setSelected(false);
		ivjjRadioMenuMetal.setSelected(true);
		estiloActual = ivjjRadioMenuMetal;
		setLandF("javax.swing.plaf.metal.MetalLookAndFeel");
	}
}
/**
 * Comment
 */
public void jRadioMenuMotif_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
	if (estiloActual != ivjjRadioMenuMotif)
	{
		estiloActual.setSelected(false);
		ivjjRadioMenuMotif.setSelected(true);
		estiloActual = ivjjRadioMenuMotif;
		setLandF("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	}
}
/**
 * Comment
 */
public void jRadioMenuWindows_ActionPerformed() {
	if (estiloActual != ivjjRadioMenuWindows)
	{
		estiloActual.setSelected(false);
		ivjjRadioMenuWindows.setSelected(true);
		estiloActual = ivjjRadioMenuWindows;
		setLandF("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	}
}
/**
 * 
 */
public static void main(java.lang.String[] args) 
{
	MainMenuBar aMainMenu;
	aMainMenu = new MainMenuBar();
	aMainMenu.setVisible(true);
}
/**
 * 
 */
public void setChildView(ArchiveView view) 
{
	this.archiveV = view;
}
/**
 * 
 */
public void setChildView(MetadataView view) 
{
	this.metadataV = view;
}
/**
 * 
 */
public void setLandF(String lf) 
{
	try
	{
		UIManager.setLookAndFeel(lf);
		SwingUtilities.updateComponentTreeUI(this);
		SwingUtilities.updateComponentTreeUI(metadataV);
		SwingUtilities.updateComponentTreeUI(archiveV);

		doGUILayout(metadataV, archiveV, internalV, logV);
	}
	catch (Exception e)
	{
		System.out.println("MainMenuBar.setLandF: " + e);
	}
}
/**
 * 
 */
public void setRecentDocs(IdElem[] recentDocs) 
{
	for(int i=recentDocs.length-1; i>=0; i--)
		recentSet.push(recentDocs[i]);
		
	showRecentDocs();
}
/**
 * 
 */
public void setTransacOrigin(TransacOrigin trOrigin) 
{
	this.trOrigin = trOrigin;
}
/**
 * 
 */
private void showRecentDocs() 
{
	ActionListener showRecent = new ActionListener()
	{
		public void actionPerformed(ActionEvent evt)
		{
			String idElemStr = ((JMenuItem)evt.getSource()).getText();
			archiveV.showElem(new IdElem(idElemStr));
			try
			{
				metadataV.init(trOrigin.getElement(idElemStr));
				metadataV.accessContent(false);
			}
			catch(Exception e)
			{
				metadataV.init(null);
			}
		}
	};


	if (ivjjMenuRecent.getItemCount() > 0)
	ivjjMenuRecent.removeAll();
	
	for(Enumeration e=recentSet.elements(); e.hasMoreElements();)
	{
		IdElem id = (IdElem)e.nextElement();
		JMenuItem recentDocItem = new JMenuItem(id.toString());
		recentDocItem.addActionListener(showRecent);
		ivjjMenuRecent.add(recentDocItem);
	}	
}
/**
 * 
 */
public void startClientGUI(IdElem[] recentDocs, TransacOrigin trOrigin, LogViewer logV) 
{
	String landfId = UIManager.getLookAndFeel().getName();
	if (landfId.equals("Metal"))
	{
		estiloActual = ivjjRadioMenuMetal;
		ivjjRadioMenuMetal.setSelected(true);
	}
	else if (landfId.equals("Windows"))
	{
		estiloActual = ivjjRadioMenuWindows;
		ivjjRadioMenuWindows.setSelected(true);
	}
	else
	{
		estiloActual = ivjjRadioMenuMotif;
		ivjjRadioMenuMotif.setSelected(true);
	}
	
	metadataV = new kxml.gui.MetadataView(this);
	archiveV = new kxml.gui.ArchiveView(this);
	internalV = new kxml.gui.InternalEditor(this);
	this.logV = logV;

	setRecentDocs(recentDocs);
	setTransacOrigin(trOrigin);

	try
	{
		metadataV.init(trOrigin.getElement(recentDocs[0].toString()));
		metadataV.accessContent(false);
	}
	catch(Exception e)
	{
		metadataV.init(null);
	}

	archiveV.init(recentDocs[0]);
	
	doGUILayout(metadataV, archiveV, internalV, logV);
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
	try
	{ 	trOrigin.closeArchive(); }
	catch(Throwable exc)
	{}
	
	metadataV.dispose();
	archiveV.dispose();
	logV.dispose();
	this.dispose();
   	System.exit(0);            // Exit from client part of application
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
