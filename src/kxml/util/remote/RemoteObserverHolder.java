package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/REMOTEOBSERVERHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoteObserverHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.util.remote.RemoteObserver value;
	//	constructors 
	public RemoteObserverHolder() {
	this(null);
	}
	public RemoteObserverHolder(kxml.util.remote.RemoteObserver __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.util.remote.RemoteObserverHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.util.remote.RemoteObserverHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.util.remote.RemoteObserverHelper.write(out, value);
	}
}
