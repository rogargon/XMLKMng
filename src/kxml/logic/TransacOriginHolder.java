package kxml.logic;

/*
 * File: ./KXML/LOGIC/TRANSACORIGINHOLDER.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class TransacOriginHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.TransacOrigin value;
	//	constructors 
	public TransacOriginHolder() {
	this(null);
	}
	public TransacOriginHolder(kxml.logic.TransacOrigin __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.TransacOriginHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.TransacOriginHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.TransacOriginHelper.write(out, value);
	}
}
