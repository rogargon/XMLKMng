package kxml;

import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.gui.*;
import kxml.domain.util.Configuration;
import kxml.util.remote.CORBAConfig;
import kxml.domain.IdElem;
import javax.swing.*;
import java.awt.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.*;

class XML_KClient
{
	private static IdElem[] recentDocs = null;
/**
 * 
 */
static public String identification(TransacOrigin trOrigin, BooleanHolder isAdmin) 
{
	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	IdentificationDlg idDlg = new IdentificationDlg();
	idDlg.setLocation((int)(screenWidth - idDlg.getSize().width)/2,
		  					  (int)(screenHeight - idDlg.getSize().height)/2);
	
	String[] arrString = null;
	boolean correct = false;
	int i = 0;

	while(i<3 && !correct)								// 3 tries
	{
		idDlg.setVisible(true);
		if (idDlg.accepted)
		{
			try
			{
				arrString = trOrigin.setUser(idDlg.userId, idDlg.passwd, isAdmin);
				correct = true;
			}
			catch(IdentificationException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),
								"Identification error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			return null;
		i++;
	}

	recentDocs = new IdElem[arrString.length];
	for (int j=0; j<arrString.length; j++)
		recentDocs[j] = new IdElem(arrString[j]);

	if (!correct)
		idDlg.userId = null;
		
	return idDlg.userId;
}
/**
 * 
 */
public static void main(String args[]) 
{
	boolean trOriginObtained = false;
	TransacOrigin trOrigin = null;
	String userId = null;
	
	// Set default Look&Feel
	try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
	catch (Exception exc){System.err.println("Error loading L&F: " + exc);}

 	java.util.Properties props = new java.util.Properties();
 	props.put("ORBservices", "CosNaming");
	props.put("SVCnameroot", "CorbaJava");
	CORBAConfig.props = props;
   	CORBAConfig.args = args;
	org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
	
	try
	{
		// Select a TransacOriginFactory
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext rootContext = NamingContextHelper.narrow(objRef);

		NameComponent comp1 = new NameComponent("XML_KManager","");
		NameComponent comp2 = new NameComponent("TransacOriginFactories","");
		NameComponent[] name = {comp1, comp2};
		objRef = rootContext.resolve(name);
		NamingContext factoriesCtx = NamingContextHelper.narrow(objRef);

		String selected = selectServer(factoriesCtx);
	  	if (selected == null)
		 	System.exit(0);

		NameComponent comp3 = new NameComponent(selected,"");
		NameComponent[] factName = {comp1, comp2, comp3};
		TransacOriginFactory trOriginFactory = 
			TransacOriginFactoryHelper.narrow(rootContext.resolve(factName));

		LogViewer logV = new kxml.gui.LogViewer();
		trOrigin = trOriginFactory.getTransacOrigin(logV.getRemoteObserver());
		trOriginObtained = true;

		BooleanHolder isAdmin = new BooleanHolder();
		if ((userId=identification(trOrigin, isAdmin)) != null)
		{
			// Start user interface
			MainMenuBar mainMenu = new kxml.gui.MainMenuBar(userId, isAdmin.value);
			mainMenu.startClientGUI(recentDocs, trOrigin, logV);
			java.lang.Object sync = new java.lang.Object();
			synchronized(sync){	sync.wait(); }
		}
		trOrigin.closeArchive();
	}
	catch(Exception e)
	{
		if (trOriginObtained)
				trOrigin.closeArchive();
				
		System.out.println("K_XMLClient: "+e);
		e.printStackTrace();
	}
  	System.exit(0);
}
/**
 * 
 */
public static String selectServer(org.omg.CosNaming.NamingContext factoriesCtx) 
{
	BindingListHolder lHolder = new BindingListHolder();
	BindingIteratorHolder itHolder = new BindingIteratorHolder();
	BindingHolder bindHolder = new BindingHolder();
	java.util.Vector factNames = new java.util.Vector();
	String local = null;
	
	try
	{
		local = java.net.InetAddress.getLocalHost().getHostName();
	}
	catch(java.net.UnknownHostException e)
	{ local = "unknown"; }

	boolean presentInLocal = false;
	factoriesCtx.list(0, lHolder, itHolder);
	BindingIterator it = itHolder.value;
	while(it.next_one(bindHolder))
	{
		String servName = bindHolder.value.binding_name[0].id;
		if(servName.equals(local))
		{
	  		servName = servName.concat(" (local)");
	  		presentInLocal = true;
		}
		factNames.addElement(servName);
	}
	if (!presentInLocal)
		factNames.addElement(local+" (new local)");
			
	String[] factIds = new String[factNames.size()];
	factNames.copyInto(factIds);
		
	String factId = (String)JOptionPane.showInputDialog(null, 
			"Choose the archive copy to use.", "XML KClient",
			JOptionPane.QUESTION_MESSAGE , null, factIds, factIds[0]);

	if (factId.indexOf("(new local)") > 0)
	{
		Process replic;
		try 
		{
			replic = Runtime.getRuntime().exec("javaw -cp xmlkmngClt.jar;"+
				"xmlkmngSrv.jar;lib/xerces.jar;lib/xml4j.jar;"+
				"lib/xml_swing11.jar;lib/icebrowserlitebean.jar;"+
				"lib/xalan.jar;lib/bsf.jar;corba/VBJCOSNM.JAR;"+
				"corba/VBJORB.JAR;corba/VBJAPP.JAR;corba/VBJTOOLS.JAR"+
				" kxml.XML_KReplicSrv");
			// Wait process output indicating process is ready
			InputStreamReader in;
			in = new InputStreamReader(replic.getInputStream());
			BufferedReader reader = new BufferedReader(in);
			String processOutput = reader.readLine();
			System.out.println("Replic output: "+processOutput);
		}
		catch(java.io.IOException e)
		{
			factId = null;
			System.out.println("Error running XML_KReplicSrv process");
		}
	}
  	if (factId.indexOf('(') > 0)
	 	factId = factId.substring(0, factId.indexOf('(')-1);
	return factId;
}
}
