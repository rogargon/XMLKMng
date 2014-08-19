package kxml.domain;

import java.util.*;
/*
 *
 */
public class IdElem
{
	private String id;
/**
 * 
 */
public IdElem(Object[] path) 
{
	if (path.length > 0)
	{
		id = new String(path[0].toString());
	
		for (int i=1; i<path.length; i++)
			id = id + "/" + path[i].toString();
	}
	else
		id = new String("");
}
/**
 * 
 */
public IdElem(String id) 
{
	this.id = id.trim();
}
/**
 * 
 */
public boolean equals(Object obj) 
{
	return this.toString().equals(obj.toString());
}
/**
 * 
 */
public String getBase() 
{
	int lastPos = id.lastIndexOf('/', id.length()-2) + 1;
	String base = new String("");
	
	if (lastPos > 0)
		base += id.substring(0, lastPos);
	else
	{
		base += id;
		if (base.indexOf('/') < 0)
			base += "/";
	}
		
	return base;
}
/**
 * 
 */
public String getLocId() 
{
	int startLoc = id.lastIndexOf('/', id.length()-2) + 1;
	int endLoc = (id.endsWith("/")? id.length()-1: id.length());
	
	String locId = new String(id.substring(startLoc, endLoc));
	
	return locId;
}
/**
 * 
 */
public String getRootLocId() 
{
	String rootId;
	
	int end = id.indexOf('/');
	if (end < 0)
		end = id.length();
		
	rootId = new String(id.substring(0, end));
	
	return rootId;
}
/**
 * 
 */
public boolean isDocument() 
{
	return id.charAt(id.length()-1) != '/';
}
/**
 * 
 */
public boolean isHElement() 
{
	return id.charAt(id.length()-1) == '/';
}
/**
 * 
 */
public void setDocument() 
{
	if (!isDocument())
		id = id.substring(0, id.length()-1);
}
/**
 * 
 */
public void setHElement() 
{
	if (!isHElement())
		id += "/";
}
/**
 * 
 */
public void setId(String newValue) 
{
	this.id = newValue.trim();
}
/**
 * 
 */
public Object[] toArray() 
{
	StringTokenizer st = new StringTokenizer(id, "/", false);
	Object[] array = new Object[st.countTokens()];
	
	for(int i=0; st.hasMoreTokens(); i++)
		array[i] = st.nextToken();
		
	return array;
}
/**
 * 
 */
public String toString() 
{
	return id;
}
}
