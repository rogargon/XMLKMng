package kxml.logic.exceptions;

/*
 * File: ./LOGIC/IDENTIFICATIONEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class IdentificationExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public IdentificationException value;
	//	constructors 
	public IdentificationExceptionHolder() {
	this(null);
	}
	public IdentificationExceptionHolder(IdentificationException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = IdentificationExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return IdentificationExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		IdentificationExceptionHelper.write(out, value);
	}
}
