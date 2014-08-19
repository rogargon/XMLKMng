package kxml.logic.exceptions;

/*
 * File: ./LOGIC/ELEMENTNOTFOUNDEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ElementNotFoundExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public ElementNotFoundException value;
	//	constructors 
	public ElementNotFoundExceptionHolder() {
	this(null);
	}
	public ElementNotFoundExceptionHolder(ElementNotFoundException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = ElementNotFoundExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return ElementNotFoundExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		ElementNotFoundExceptionHelper.write(out, value);
	}
}
