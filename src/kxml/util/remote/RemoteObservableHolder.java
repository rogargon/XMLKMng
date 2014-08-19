package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/REMOTEOBSERVABLEHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class RemoteObservableHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.util.remote.RemoteObservable value;
	//	constructors 
	public RemoteObservableHolder() {
	this(null);
	}
	public RemoteObservableHolder(kxml.util.remote.RemoteObservable __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.util.remote.RemoteObservableHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.util.remote.RemoteObservableHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.util.remote.RemoteObservableHelper.write(out, value);
	}
}
