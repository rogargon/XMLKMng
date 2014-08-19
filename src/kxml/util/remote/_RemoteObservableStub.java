package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVABLESTUB.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteObservableStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.util.remote.RemoteObservable {

	private static final String _type_ids[] = {
		"IDL:kxml/util/remote/RemoteObservable:1.0"
	};

	public _RemoteObservableStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	    Implementation of ::kxml::util::remote::RemoteObservable::addObserver
	public void addObserver(kxml.util.remote.RemoteObserver observer)
 {
		   org.omg.CORBA.Request r = _request("addObserver");
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.invoke();
   }   
	//	IDL operations
	//	    Implementation of ::kxml::util::remote::RemoteObservable::deleteObserver
	public void deleteObserver(kxml.util.remote.RemoteObserver observer)
 {
		   org.omg.CORBA.Request r = _request("deleteObserver");
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.invoke();
   }   
}
