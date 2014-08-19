package kxml.logic.exceptions;

/*
 * File: ./LOGIC/USERNOTFOUNDEXCEPTIONHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class UserNotFoundExceptionHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public UserNotFoundException value;
	//	constructors 
	public UserNotFoundExceptionHolder() {
	this(null);
	}
	public UserNotFoundExceptionHolder(UserNotFoundException __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = UserNotFoundExceptionHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return UserNotFoundExceptionHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		UserNotFoundExceptionHelper.write(out, value);
	}
}
