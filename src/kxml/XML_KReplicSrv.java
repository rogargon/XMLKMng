package kxml;

import kxml.gui.*;
import kxml.logic.*;
import kxml.logic.server.*;
import kxml.logic.exceptions.*;
import kxml.util.remote.CORBAConfig;
import javax.swing.*;
import java.awt.*;
import org.omg.CORBA.ORB;
import java.net.*;

class XML_KReplicSrv extends java.awt.event.WindowAdapter
{
	static boolean trOriginFactoryStarted = false;
	static TransacOriginFactoryImpl trOriginFactory = null;
/**
 * Use main to start a replic of the archive with a new entry point,
 * the TrOriginSrv object. It will be availabe to clients connecting
 * through Corba. The archive metadata will be retrieved from the server.
 */
public static void main(String[] args) 
{
	// Set default Look&Feel
	try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
	catch (Exception exc){System.err.println("Error loading L&F: " + exc);}
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
	XML_KReplicSrv server = new XML_KReplicSrv();
	XML_KServerDlg serverDlg = new kxml.gui.XML_KServerDlg(server);

	// CORBA initialisation	
  	// Properties specific for Visibroker Naming Service, 
  	// ignored if JavaIDL ORB and Name Service.
  	java.util.Properties props = new java.util.Properties();
	props.put("ORBservices", "CosNaming");
	props.put("SVCnameroot", "CorbaJava");
  	CORBAConfig.props = props;
  	CORBAConfig.args = args;
	ORB orb = ORB.init(CORBAConfig.args, CORBAConfig.props);

	IdentificationDlg idDlg = new kxml.gui.IdentificationDlg("Replic creation (only administrators)");
	idDlg.setLocation((int)(screenWidth - idDlg.getSize().width)/2,
		  					  (int)(screenHeight - idDlg.getSize().height)/2);
	boolean correct = false;
	int i = 0;
	
	while(i<3 && !correct)								// 3 tries
	{
		idDlg.setVisible(true);
		if (idDlg.accepted)
		{
			try
			{
				trOriginFactory = 
					new TransacOriginFactoryImpl(idDlg.userId, idDlg.passwd);
				correct = true;
			}
			catch(IdentificationException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),
							"Identification error", JOptionPane.ERROR_MESSAGE);
			}
			catch(CORBAException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),
							"CORBA error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			break;
		i++;
	}
	if (correct)
	{
	 	System.out.println("TransacOriginFactory replic is ready.");
	 	trOriginFactoryStarted = true;
	 	String hostName;
	 	try
	 	{
			hostName = InetAddress.getLocalHost().getHostName();
	 	}
		catch(UnknownHostException e)
		{	hostName = "unknown";	}
	 	
	  	serverDlg.ivjJLabelMessage.setText(
		  	serverDlg.ivjJLabelMessage.getText() + hostName);

	  	// Show server dialog in the middle of the screen
	  	serverDlg.setLocation((int)(screenWidth - serverDlg.getSize().width)/2,
		  					  (int)(screenHeight - serverDlg.getSize().height)/2);
		serverDlg.setVisible(true);
		
		try												// Stay serving
		{
			java.lang.Object sync = new java.lang.Object();
			synchronized(sync){	sync.wait(); }
		}catch(Exception e){}
	}
	System.out.println("TransacOriginFactory replic finished.");
	System.exit(0);
}
/**
 * 
 */
public void windowClosing(java.awt.event.WindowEvent evt)
{
  	System.out.println("Closing...");
	try
	{
		if (this.trOriginFactoryStarted)
			if (!trOriginFactory.destroy())
				System.out.println("ReplicSrv: trOriginFactory not closed"
					+ ", clients remaining");
			else
				System.exit(0);
  	}
  	catch(Exception e)
  	{
		System.out.println("Destroying factory "+e);
		System.exit(0);
  	}
}
}
