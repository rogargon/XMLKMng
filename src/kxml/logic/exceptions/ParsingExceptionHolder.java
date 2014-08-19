package kxml.logic.exceptions;

/*
 * File: ./KXML/LOGIC/EXCEPTIONS/PARSINGEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ParsingExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.exceptions.ParsingException value;
	//	constructors 
	public ParsingExceptionHolder() {
	this(null);
	}
	public ParsingExceptionHolder(kxml.logic.exceptions.ParsingException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.exceptions.ParsingExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.exceptions.ParsingExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.exceptions.ParsingExceptionHelper.write(out, value);
	}
}
