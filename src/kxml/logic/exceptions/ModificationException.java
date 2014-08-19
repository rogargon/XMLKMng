package kxml.logic.exceptions;

/*
 * File: ./LOGIC/MODIFICATIONEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Fri Feb 11 13:46:22 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ModificationException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public ModificationException() {
	super();
	}
	public ModificationException(String __reason) {
	super(__reason);
	reason = __reason;
	}
}
