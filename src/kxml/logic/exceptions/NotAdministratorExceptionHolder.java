package kxml.logic.exceptions;

/*
 * File: ./KXML/LOGIC/EXCEPTIONS/NOTADMINISTRATOREXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class NotAdministratorExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.exceptions.NotAdministratorException value;
	//	constructors 
	public NotAdministratorExceptionHolder() {
	this(null);
	}
	public NotAdministratorExceptionHolder(kxml.logic.exceptions.NotAdministratorException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.exceptions.NotAdministratorExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.exceptions.NotAdministratorExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.exceptions.NotAdministratorExceptionHelper.write(out, value);
	}
}
