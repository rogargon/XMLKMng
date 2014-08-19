package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVERSTUB.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteObserverStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.util.remote.RemoteObserver {

	private static final String _type_ids[] = {
		"IDL:kxml/util/remote/RemoteObserver:1.0"
	};

	public _RemoteObserverStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	IDL operations
	//	    Implementation of ::kxml::util::remote::RemoteObserver::update
	public void update(org.omg.CORBA.Object observable, org.omg.CORBA.Any data)
 {
		   org.omg.CORBA.Request r = _request("update");
		   org.omg.CORBA.Any _observable = r.add_in_arg();
		   _observable.insert_Object(observable);
		   org.omg.CORBA.Any _data = r.add_in_arg();
		   _data.insert_any(data);
		   r.invoke();
   }   
}
