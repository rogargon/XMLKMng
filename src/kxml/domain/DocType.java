package kxml.domain;

import java.net.URL;

public class DocType
{
	private String id;
	private String aplication;
/**
 * 
 */
public DocType(String id) 
{
	this.id = id;
}
/**
 * 
 */
public String getAplication() 
{
	return aplication;
}
/**
 * 
 */
public String getId() 
{
	return id;
}
/**
 * 
 */
public void setAplication(String newValue) 
{
	this.aplication = newValue;
}
}
