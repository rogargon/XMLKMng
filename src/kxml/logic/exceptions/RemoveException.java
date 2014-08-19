package kxml.logic.exceptions;

/*
 * File: ./KXML/LOGIC/EXCEPTIONS/REMOVEEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoveException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public RemoveException() {
	super();
	}
	public RemoveException(String __reason) {
	super();
	reason = __reason;
	}
}
