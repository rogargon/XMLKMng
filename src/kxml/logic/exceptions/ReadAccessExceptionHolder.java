package kxml.logic.exceptions;

/*
 * File: ./LOGIC/READACCESSEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ReadAccessExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public ReadAccessException value;
	//	constructors 
	public ReadAccessExceptionHolder() {
	this(null);
	}
	public ReadAccessExceptionHolder(ReadAccessException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = ReadAccessExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return ReadAccessExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		ReadAccessExceptionHelper.write(out, value);
	}
}
