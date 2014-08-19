package kxml.logic.exceptions;

/*
 * File: ./LOGIC/ELEMENTEXISTSEXCEPTION.JAVA
 * From: TODO.IDL
 * Date: Sun Jan 09 20:09:56 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ElementExistsException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
	//	instance variables
	public String reason;
	//	constructors
	public ElementExistsException() {
	super();
	}
	public ElementExistsException(String __reason) {
	super(__reason);
	reason = __reason;
	}
}
