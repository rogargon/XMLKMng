package kxml.logic.exceptions;

/*
 * File: ./LOGIC/CREATIONEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 12 23:50:22 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class CreationExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public CreationException value;
	//	constructors 
	public CreationExceptionHolder() {
	this(null);
	}
	public CreationExceptionHolder(CreationException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = CreationExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return CreationExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		CreationExceptionHelper.write(out, value);
	}
}
