package kxml.domain;

import kxml.util.*;
import kxml.domain.util.Configuration;
import kxml.domain.util.RepeatedKeyException;
import java.net.URL;
import java.util.*;

public class DTD extends ModifiableObj
{
	private String name;
	private URL uri;
	private Vector xsls;
/**
 * 
 */
public DTD(String name, URL uri) 
{
	this.name = name;
	this.uri = uri;
	this.xsls = new Vector(Configuration.DTDXSLS);
}
/**
 * 
 */
public void asociateXSL(XSL xsl) throws RepeatedKeyException
{
	writing();

	if (xsls.contains(xsl))
		throw (new RepeatedKeyException(xsl.getName()));
	else
		xsls.addElement(xsl);

	endWriting();
}
/**
 * 
 */
public String getName() 
{
	return name;
}
/**
 * 
 */
public URL getUri() 
{
	return uri;
}
/**
 * 
 */
public XSL getXSL(String xslName) 
{
	reading();

	XSL xsl = null;
	Enumeration e = xsls.elements();
	boolean found = false;
	int i = 0;
	while(e.hasMoreElements() && !found)
	{
		xsl = (XSL)e.nextElement();
		if (xsl.getName().equals(xslName))
			found = true;
	}

	endReading();
	
	if (found)
		return xsl;
	else
		return null;
}
/**
 * 
 */
public XSL[] listXSLs() 
{
	reading();
	
	XSL[] list = new XSL[xsls.size()];
	
	Enumeration e = xsls.elements();
	int i = 0;
	while(e.hasMoreElements())
	{
		list[i] = (XSL)e.nextElement();
		i++;
	}

	endReading();
	
	return list;
}
/**
 * 
 */
public void setName(String newValue) 
{
	this.name = newValue;
}
/**
 * 
 * @param newValue java.net.URL
 */
public void setUri(URL newValue) 
{
	this.uri = newValue;
}
}
