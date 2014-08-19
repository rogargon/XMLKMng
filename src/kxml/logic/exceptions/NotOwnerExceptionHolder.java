package kxml.logic.exceptions;

/*
 * File: ./LOGIC/NOTOWNEREXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class NotOwnerExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public NotOwnerException value;
	//	constructors 
	public NotOwnerExceptionHolder() {
	this(null);
	}
	public NotOwnerExceptionHolder(NotOwnerException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = NotOwnerExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return NotOwnerExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		NotOwnerExceptionHelper.write(out, value);
	}
}
