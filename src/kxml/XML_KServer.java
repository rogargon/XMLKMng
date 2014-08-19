package kxml;

import kxml.gui.*;
import kxml.logic.*;
import kxml.logic.server.*;
import kxml.logic.exceptions.*;
import kxml.util.remote.CORBAConfig;
import javax.swing.*;
import java.awt.*;
import org.omg.CORBA.ORB;

class XML_KServer extends java.awt.event.WindowAdapter
{
	static boolean trOriginSrvStarted = false;
	static boolean trOriginFactoryStarted = false;
	static TransacOriginSrvImpl trOriginSrv = null;
	static TransacOriginFactoryImpl trOriginFactory = null;
/**
 * Starts the server part of the application.
 * Only one server in all the network.
 */
public static void main(java.lang.String[] args) 
{
	// Set default Look&Feel
	try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
	catch (Exception exc){System.err.println("Error loading L&F: " + exc);}
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
	XML_KServer server = new XML_KServer();
	XML_KServerDlg serverDlg = new kxml.gui.XML_KServerDlg(server);
	
  	// Properties specific for Visibroker Naming Service, 
  	// ignored if JavaIDL ORB and Name Service.
  	java.util.Properties props = new java.util.Properties();
	props.put("ORBservices", "CosNaming");
	props.put("SVCnameroot", "CorbaJava");
  	CORBAConfig.props = props;
  	CORBAConfig.args = args;
	
	ORB orb = ORB.init(CORBAConfig.args, CORBAConfig.props); 
	try
	{
		trOriginSrv = new TransacOriginSrvImpl();
		System.out.println("TransacOriginSrv is ready.");
		server.trOriginSrvStarted = true;
		
		trOriginFactory = new TransacOriginFactoryImpl(trOriginSrv);
	 	System.out.println("TransacOriginFactory is ready.");
	  	server.trOriginFactoryStarted = true;

	  	serverDlg.ivjJLabelMessage.setText(serverDlg.ivjJLabelMessage.getText() + 
	    				java.net.InetAddress.getLocalHost().getHostName());

	  	// Show server dialog in the middle of the screen
	  	serverDlg.setLocation((int)(screenWidth - serverDlg.getSize().width)/2,
		  					  (int)(screenHeight - serverDlg.getSize().height)/2);
		serverDlg.setVisible(true);
		
	  	Thread.currentThread().join();
	}
	catch(Exception e)
	{
		System.out.println("K_XMLServer: "+e);
		e.printStackTrace();
	  	serverDlg.ivjJLabelMessage.setText(e.getMessage());
	  	serverDlg.setVisible(true);
	    
	  	try{ Thread.currentThread().join(); }
	  	catch(Exception e2){}
	}
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
			trOriginFactory.destroy();
  	}
  	catch(Exception e)
  	{
		System.out.println("Destroying factory: "+e);
  	}
  
  	try
  	{
		if (this.trOriginSrvStarted)
	  		trOriginSrv.destroy();
	}
	catch(Exception e)
	{
		System.out.println("Destroying server: "+e);
  	}
	
	System.exit(0);
}
}
