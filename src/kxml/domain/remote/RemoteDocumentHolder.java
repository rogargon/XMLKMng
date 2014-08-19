package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/REMOTEDOCUMENTHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoteDocumentHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.domain.remote.RemoteDocument value;
	//	constructors 
	public RemoteDocumentHolder() {
	this(null);
	}
	public RemoteDocumentHolder(kxml.domain.remote.RemoteDocument __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.domain.remote.RemoteDocumentHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.domain.remote.RemoteDocumentHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.domain.remote.RemoteDocumentHelper.write(out, value);
	}
}
