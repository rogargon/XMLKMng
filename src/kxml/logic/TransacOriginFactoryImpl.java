package kxml.logic;

import kxml.persistence.*;
import kxml.util.remote.*;
import kxml.domain.Archive;
import kxml.logic.distributed.*;
import kxml.logic.server.*;
import kxml.logic.exceptions.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.awt.*;
import javax.swing.*;
import java.net.InetAddress;

public class TransacOriginFactoryImpl extends _TransacOriginFactoryImplBase
{
	private int numClients;
	private Archive archive;
	private ConsistencyManagerSrv consistencyMngSrv;
	private TransacOriginSrv trOriginSrv;

	private static ORB orb = CORBAConfig.orb;
/**
 * Create a new archive replic and its associated acces point, TrOriginFactory.
 */
public TransacOriginFactoryImpl(String user, String passwd)
				throws IdentificationException, CORBAException
{
	super();
	 
	// Resolve references to server objects, trOriginSrv and consistencyMngSrv
	NameComponent basecomp = new NameComponent("XML_KManager","");
	NameComponent tofactcomp = new NameComponent("TransacOriginSrv","");
	NameComponent consmngcomp = new NameComponent("ConsistencyMngSrv","");
	NamingContext rootContext;
	try
	{
		orb = ORB.init(CORBAConfig.args, CORBAConfig.props);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		rootContext = NamingContextHelper.narrow(objRef);
		NameComponent[] name = {basecomp, tofactcomp};
		trOriginSrv = TransacOriginSrvHelper.narrow(rootContext.resolve(name));
		name[1] = consmngcomp;
		consistencyMngSrv = ConsistencyManagerSrvHelper.narrow(rootContext.resolve(name));
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.toString()));
	}

	// Retrieve archive xmldata from the server
	String archiveXML = trOriginSrv.getArchiveXML(user, passwd);

	// Create archive replic with archive xmldata
	String installDir = System.getProperty("user.dir");
	PersistenceManager persistenceMng = new PersistenceManager(installDir);
	this.archive = new Archive(persistenceMng);

	archive.open(new java.io.StringReader(archiveXML));

	// Incorporate copy in the consistency system
	ConsistencyManagerCltImpl consistencyMngClt = 
								new ConsistencyManagerCltImpl(this.archive);
	consistencyMngSrv.addClientManager(consistencyMngClt);
		
	// Unlock consistency system (locked due to archive xmldata retrieval requieres
	// a stable archive structure)
	consistencyMngSrv.unlock();
	
	numClients = 0;
	
	try
	{
		orb.connect(this);
		String localHost = java.net.InetAddress.getLocalHost().getHostName();
		NameComponent comp1 = new NameComponent("XML_KManager","");
		NameComponent comp2 = new NameComponent("TransacOriginFactories","");
		NameComponent comp3 = new NameComponent(localHost,"");
		NameComponent[] name = {comp1, comp2, comp3};
		rootContext.rebind(name, this);
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.getMessage()));
	}
}
/**
 * Used to create an entry point to the original archive in the server.
 * It's allways ready (it's never destroyed although there's no client
 * using it).
 */
public TransacOriginFactoryImpl(TransacOriginSrvImpl trOriginSrv)
					throws CORBAException
{
	super();
	this.archive = trOriginSrv.archive;
	this.consistencyMngSrv = trOriginSrv.consistencyMngSrv;
	this.trOriginSrv = trOriginSrv;
	numClients = 1;

	try
	{
		orb = ORB.init(CORBAConfig.args, CORBAConfig.props);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext rootContext = NamingContextHelper.narrow(objRef);

		orb.connect(this);
		String localHost = java.net.InetAddress.getLocalHost().getHostName();
		NameComponent comp1 = new NameComponent("XML_KManager","");
		NameComponent comp2 = new NameComponent("TransacOriginFactories","");
		NameComponent comp3 = new NameComponent(localHost,"");
		NameComponent[] name = {comp1, comp2, comp3};
		rootContext.rebind(name, this);
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.getMessage()));
	}
}
/*
 *
 */
public boolean destroy() throws CORBAException
{
	if (numClients == 0)
	{
	  	try
	   	{
			consistencyMngSrv.removeClientManager(archive.consistencyMngClt);
			
			org.omg.CORBA.Object objRef;
			objRef = orb.resolve_initial_references("NameService");
			NamingContext rootContext = NamingContextHelper.narrow(objRef);
			String localHost = InetAddress.getLocalHost().getHostName();
			NameComponent comp1 = new NameComponent("XML_KManager","");
			NameComponent comp2 = new NameComponent("TransacOriginFactories","");
			NameComponent comp3 = new NameComponent(localHost,"");
			NameComponent[] name = {comp1, comp2, comp3};
			rootContext.unbind(name);

			//orb.disconnect(this);
			
			System.out.println("TransacOriginFactory.destroy:"+
								" factory unregistered");
		}
	   	catch(Exception e)
	   	{
	   	 	System.out.println("TransacOriginFactory.destroy:"+
		   	 					e.getMessage());
	   	}
	}
	return (numClients == 0);
}
/**
 * 
 */
public synchronized TransacOrigin getTransacOrigin(RemoteObserver logObserver) 
{
	TransacOriginImpl trOrigin = new TransacOriginImpl(archive, 
						consistencyMngSrv, this, trOriginSrv, logObserver);
	numClients++;
	
	System.out.println("TransacOriginFactory.getTransacOrigin: total="+numClients);

	return trOrigin;
}
/**
 * 
 */
public synchronized boolean removeTransacOrigin()
{
	
	numClients--;
	System.out.println("TransacOriginFactory.removeTransacOrigin: total="+numClients);
	
/*	if (numClients == 0)
   	{
		lastClient = true;
	  	try
	   	{
			consistencyMngSrv.removeClientManager(archive.consistencyMngClt);
			
			org.omg.CORBA.Object objRef;
			objRef = orb.resolve_initial_references("NameService");
			NamingContext rootContext = NamingContextHelper.narrow(objRef);
			String localHost = InetAddress.getLocalHost().getHostName();
			NameComponent comp1 = new NameComponent("XML_KManager","");
			NameComponent comp2 = new NameComponent("TransacOriginFactories","");
			NameComponent comp3 = new NameComponent(localHost,"");
			NameComponent[] name = {comp1, comp2, comp3};
			rootContext.unbind(name);

			orb.disconnect(this);
			
			System.out.println("TransacOriginFactory.removeTransacOrigin:"+
								" factory unregistered");
		}
	   	catch(Exception e)
	   	{
	   	 	System.out.println("TransacOriginFactory.removeTransacOrigin:"+
		   	 					e.getMessage());
	   	}
   	}*/
	return (numClients == 0);
}
}
