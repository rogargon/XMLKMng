package kxml.logic;

/*
 * File: ./KXML/LOGIC/TRANSACORIGINFACTORYHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class TransacOriginFactoryHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.TransacOriginFactory value;
	//	constructors 
	public TransacOriginFactoryHolder() {
	this(null);
	}
	public TransacOriginFactoryHolder(kxml.logic.TransacOriginFactory __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.TransacOriginFactoryHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.TransacOriginFactoryHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.TransacOriginFactoryHelper.write(out, value);
	}
}
