package kxml.gui;

import javax.swing.*;
/**
 *  
 */
public class ContentObserver extends kxml.util.remote._RemoteObserverImplBase 
{
	private String idElem;
	private boolean writer;
/**
 *
 */
public ContentObserver(String idElem, boolean writer) 
{
	super();
	this.idElem = idElem;
	this.writer = writer;
}
/**
 * 
 */
public String getIdElem() 
{
	return idElem;
}
/**
 * 
 */
public boolean isWriter() 
{
	return writer;
}
/**
 *
 */
public void update(org.omg.CORBA.Object observable, org.omg.CORBA.Any data) 
{
	JOptionPane.showMessageDialog(null, data.extract_string(),
						idElem, JOptionPane.ERROR_MESSAGE);
}
}
