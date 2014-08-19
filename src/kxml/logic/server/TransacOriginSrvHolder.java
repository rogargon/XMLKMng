package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/TRANSACORIGINSRVHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class TransacOriginSrvHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.server.TransacOriginSrv value;
	//	constructors 
	public TransacOriginSrvHolder() {
	this(null);
	}
	public TransacOriginSrvHolder(kxml.logic.server.TransacOriginSrv __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.server.TransacOriginSrvHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.server.TransacOriginSrvHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.server.TransacOriginSrvHelper.write(out, value);
	}
}
