package kxml.logic.exceptions;

/*
 * File: ./LOGIC/WRITEACCESSEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class WriteAccessException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public WriteAccessException() {
	super();
	}
	public WriteAccessException(String __reason) {
	super(__reason);
	reason = __reason;
	}
}
