package kxml.logic.exceptions;

/*
 * File: ./LOGIC/CREATIONEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 12 23:50:22 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class CreationException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public CreationException() {
	super();
	}
	public CreationException(String __reason) {
	super(__reason);
	reason = __reason;
	}
}
