package kxml.logic.exceptions;

/*
 * File: ./LOGIC/ELEMENTEXISTSEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Sun Jan 09 20:09:56 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ElementExistsExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public ElementExistsException value;
	//	constructors 
	public ElementExistsExceptionHolder() {
	this(null);
	}
	public ElementExistsExceptionHolder(ElementExistsException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = ElementExistsExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return ElementExistsExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		ElementExistsExceptionHelper.write(out, value);
	}
}
