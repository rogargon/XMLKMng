package kxml.logic.exceptions;

/*
 * File: ./KXML/LOGIC/EXCEPTIONS/PARSINGEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ParsingException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public ParsingException() {
	super();
	}
	public ParsingException(String __reason) {
	super();
	reason = __reason;
	}
}
