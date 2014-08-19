package kxml.logic.server;

import kxml.domain.*;
import kxml.domain.util.XMLFactory;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.persistence.PersistenceManager;
import kxml.util.remote.CORBAConfig;
import kxml.logic.distributed.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.IOException;

public class TransacOriginSrvImpl extends _TransacOriginSrvImplBase
{
	public Archive archive;
	public ConsistencyManagerSrvImpl consistencyMngSrv;
/**
 * 
 */
public TransacOriginSrvImpl() throws AlreadyStartedException, CORBAException
{
	super();
	
	ORB orb = null;
	NamingContext xmlkmngCtx = null;
	// Test if server is already started, otherwise bind application
	// root namingcontext.
	try
	{
		orb = ORB.init(CORBAConfig.args, CORBAConfig.props);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext rootContext = NamingContextHelper.narrow(objRef);

		NameComponent comp = new NameComponent("XML_KManager","");
		NameComponent[] name = {comp};
		xmlkmngCtx = rootContext.bind_new_context(name);
	}
	catch(org.omg.CosNaming.NamingContextPackage.AlreadyBound e)
	{ 
		throw(new AlreadyStartedException("XML KServer already started")); 
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.toString()));
	}

	// Start server, at this point there isn't another server running and no other
	// will do because the application root namingcontext is already binded.
	String installDir = System.getProperty("user.dir");
	PersistenceManager persistenceMng = new PersistenceManager(installDir);
	this.archive = new Archive(persistenceMng);
	try
	{
		archive.open(persistenceMng.getArchiveXML());
	}
	catch(java.io.FileNotFoundException e)
	{
		System.out.println("TransacOriginSrv: XML persistence data not found");
		try 
		{ 
			archive.open(persistenceMng.newArchiveXML());
		}
		catch(Exception e2)
		{
			System.out.println("TransacOriginSrv: XML persistence "+
							   "couldn't be created");
		}
	}

	this.consistencyMngSrv = new ConsistencyManagerSrvImpl();
	ConsistencyManagerCltImpl consistencyMngClt = 
								 new ConsistencyManagerCltImpl(this.archive);
	consistencyMngSrv.addClientManager(consistencyMngClt);

	// Register object in CORBA Name Service
	try
	{
		orb.connect(this);
		NameComponent comp = new NameComponent("TransacOriginFactories","");
		NameComponent[] name = {comp};
		NamingContext trOrFactCtx = xmlkmngCtx.bind_new_context(name);
			
		name[0] = new NameComponent("TransacOriginSrv","");
		xmlkmngCtx.bind(name, this);
		name[0] = new NameComponent("ConsistencyMngSrv","");
		xmlkmngCtx.bind(name, this.consistencyMngSrv);
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.getMessage()));
	}
}
/**
 * 
 */
public void destroy() throws CORBAException, IOException
{
	//Comprobar antes que no hay ningún cliente activo...
	
	try
	{
		org.omg.CORBA.ORB orb = ORB.init(CORBAConfig.args, CORBAConfig.props);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext rootContext = NamingContextHelper.narrow(objRef);

		//orb.disconnect(this);
		NameComponent comp = new NameComponent("XML_KManager","");
		NameComponent[] name = {comp};
		rootContext.unbind(name);
		System.out.println("XML_KManager unbinded");
		archive.close();
	}
	catch(IOException e)
	{
		throw(new IOException(e.getMessage()));
	}
	catch(Exception e)
	{
		throw(new CORBAException(e.getMessage()));
	}
}
/**
 * 
 */
public String getArchiveXML(String userId, String passwd)
					throws IdentificationException
{
	String metaxml = null;
	User user = archive.dictionary.getUser(userId);
	
	if (user != null && user.isAdmin() && user.passwordControl(passwd))
	{
		consistencyMngSrv.lock();
		metaxml = archive.getArchiveXML();
	}
	else
	{
		if (user == null)
			throw(new IdentificationException("SetUserTr: user not found"));
		else
			throw(new IdentificationException("SetUserTr: incorrect password"));
	}
	return metaxml;
}
/**
 * If the uri points to a XML document with a external DTD the 
 * DTD name and URI are extracted and registered in the DTD repository. 
 * This data is returned in the return value and the StringHolder.
 */
public String registerDTD(String uriDoc, StringHolder uriDTD) 
{
	uriDTD = new StringHolder("");
	return null;
}
}
