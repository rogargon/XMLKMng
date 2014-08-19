package kxml.domain;

import kxml.util.*;
import kxml.util.remote.RemoteLogger;
import kxml.logic.distributed.ConsistencyManagerCltImpl;
import kxml.persistence.PersistenceManager;
import kxml.domain.util.XMLFactory;
import java.io.*;
import java.util.*;

public class Archive extends HierarchyElement
					 implements java.rmi.Remote
{
	public Dictionary dictionary;
	public PersistenceManager persistenceMng;
	public ConsistencyManagerCltImpl consistencyMngClt;
	public RemoteLogger logger;
/**
 * 
 */
public Archive(String locId, String[][] attribs,
			   User owner, boolean publicRead, boolean publicWrite,
			   HashSet aclRead, HashSet aclWrite, PersistenceManager persistenceMng)
{
	super(null, locId, attribs, owner, publicRead,
		  publicWrite, aclRead, aclWrite);
	root = this;
	
	dictionary = new Dictionary();

	logger = new RemoteLogger();
	
	this.persistenceMng = persistenceMng;
}
/**
 * 
 */
public Archive(PersistenceManager persistenceMng) 
{
	super(null);
	root = this;

	// Initial values
	locId = "root";
	publicRead = true;
	publicWrite = true;

	dictionary = new Dictionary();

	logger = new RemoteLogger();
	
	this.persistenceMng = persistenceMng;
}
/**
 * Close the main copy of the archive and make it persistent 
 * with the PersistenceManager
 */
public void close() throws IOException
{
	persistenceMng.putArchiveXML(this.getArchiveXML());
}
/**
 * 
 */
protected boolean correctContent(Element elem) 
{
	return (elem instanceof Cabinet);
}
/**
 * 
 */
public String getArchiveXML() 
{
	return XMLFactory.getXMLFromArchive(this);
}
/**
 * Ther archive, because it is the root, has the same value for locId and id
 * and it's allways valid despite it never has a parent.
 */
public IdElem getId() 
{
	return new IdElem(locId+"/");
}
/**
 * 
 */
public String getIdStr() 
{
	return locId+"/";
}
/**
 * 
 */
public void localAplic() 
{
}
/**
 * 
 */
public void open(InputStream xmldata)
{
	XMLFactory xmlfactory = new XMLFactory(xmldata);
	xmlfactory.getArchiveFromXML(this);
}
/**
 * 
 */
public void open(Reader xmldata)
{
	XMLFactory xmlfactory = new XMLFactory(xmldata);
	xmlfactory.getArchiveFromXML(this);
}
}
