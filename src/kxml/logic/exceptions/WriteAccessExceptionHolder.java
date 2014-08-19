package kxml.logic.exceptions;

/*
 * File: ./LOGIC/WRITEACCESSEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class WriteAccessExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public WriteAccessException value;
	//	constructors 
	public WriteAccessExceptionHolder() {
	this(null);
	}
	public WriteAccessExceptionHolder(WriteAccessException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = WriteAccessExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return WriteAccessExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		WriteAccessExceptionHelper.write(out, value);
	}
}
