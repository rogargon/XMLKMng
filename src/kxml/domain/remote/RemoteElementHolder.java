package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/REMOTEELEMENTHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoteElementHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.domain.remote.RemoteElement value;
	//	constructors 
	public RemoteElementHolder() {
	this(null);
	}
	public RemoteElementHolder(kxml.domain.remote.RemoteElement __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.domain.remote.RemoteElementHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.domain.remote.RemoteElementHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.domain.remote.RemoteElementHelper.write(out, value);
	}
}
