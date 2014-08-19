package kxml.persistence;

import java.io.*;
import java.net.URL;
import java.util.Hashtable;

public class PersistenceManager
{
	private String tmpDir;
	private String installDir;
	private int currentId;
	private Hashtable cache;
/**
 * 
 */
public PersistenceManager(String installDir) 
{
	if (!installDir.endsWith("\\"))
		installDir += "\\";
	
	this.currentId = 0;
	this.installDir = installDir;
	readLocalConfig(this.installDir);
}
/**
 * 
 */
public InputStream getArchiveXML() throws FileNotFoundException
{
	InputStream xmldata = null;
	String url = "file:///" + this.installDir + "archive.xml";
	try
	{
		xmldata = new URL(url).openStream();
		System.out.println("Reading archive xml: " + url);
	}
	catch(Exception e)
	{
		throw(new FileNotFoundException(e.getMessage()));
	}
	return xmldata;
}
/**
 * 
 */
private boolean inCache(URL uri) 
{
	return cache.containsKey(uri);
}
/**
 * 
 */
public Reader newArchiveXML() throws FileNotFoundException, IOException
{
	Reader xmldata = null;
	String loc = this.installDir + "archive.xml";

	File newXmlFile = new File(loc);
	newXmlFile.createNewFile();
	
	xmldata = new BufferedReader(new FileReader(newXmlFile));
	System.out.println("Created new archive xml: " + loc);

	return xmldata;
}
/**
 * 
 */
private String nextTmpFileID() 
{
	return "file" + (currentId++) + ".tmp";
}
/**
 * 
 */
public void putArchiveXML(String metaxml) throws IOException
{
	String path = this.installDir + "archive.xml";
	FileOutputStream fOut = null;
	try
	{
		File xmlFile = new File(path);
		fOut = new FileOutputStream(xmlFile);
		OutputStreamWriter outWriter = new OutputStreamWriter(fOut, "UTF8");
		BufferedWriter output = new BufferedWriter(outWriter);
		
		output.write(metaxml);
		output.close();
		
		System.out.println("Written xml archive: " + path);
	}
	catch(Exception e)
	{
		throw(new IOException("Archive couldn't be saved: "+ e.getMessage()));
	}
	finally
	{
		if (fOut != null) fOut.close();
	}
}
/**
 * 
 */
private void readLocalConfig(String installDir) 
{
	BufferedReader input = null;
	File configFile;

	this.tmpDir = installDir + "tmp\\";		// Default value
	
	try
	{
		input = new BufferedReader(new FileReader(installDir + "persist.cfg"));
		String s = input.readLine().trim();
		if (s != null)
		{
			if (!s.endsWith("/"))
				s.concat("/");
			this.tmpDir = s;
		}
		input.close();
	}
	catch(IOException e)
	{}
}
/**
 * 
 */
private void readServerConfig() {
}
}
