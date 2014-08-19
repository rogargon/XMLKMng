package kxml.domain;

import java.net.URL;

public class XSL
{
	private String name;
	private URL uri;
/**
 * 
 */
public XSL(String name, URL uri) 
{
	this.name = name;
	this.uri = uri;
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
 * @return java.net.URL
 */
public java.net.URL getUri() {
	return uri;
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
public void setUri(java.net.URL newValue) {
	this.uri = newValue;
}
}
