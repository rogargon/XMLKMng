package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/REMOTEHIERARCHYELEMENTHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoteHierarchyElementHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.domain.remote.RemoteHierarchyElement value;
	//	constructors 
	public RemoteHierarchyElementHolder() {
	this(null);
	}
	public RemoteHierarchyElementHolder(kxml.domain.remote.RemoteHierarchyElement __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.domain.remote.RemoteHierarchyElementHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.domain.remote.RemoteHierarchyElementHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.domain.remote.RemoteHierarchyElementHelper.write(out, value);
	}
}
