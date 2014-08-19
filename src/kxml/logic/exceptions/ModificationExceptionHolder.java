package kxml.logic.exceptions;

/*
 * File: ./LOGIC/MODIFICATIONEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Fri Feb 11 13:46:22 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ModificationExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public ModificationException value;
	//	constructors 
	public ModificationExceptionHolder() {
	this(null);
	}
	public ModificationExceptionHolder(ModificationException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = ModificationExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return ModificationExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		ModificationExceptionHelper.write(out, value);
	}
}
