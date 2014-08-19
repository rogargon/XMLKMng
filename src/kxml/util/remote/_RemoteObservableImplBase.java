package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVABLEIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _RemoteObservableImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.util.remote.RemoteObservable {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/util/remote/RemoteObservable:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("deleteObserver", new java.lang.Integer(0));
	  _methods.put("addObserver", new java.lang.Integer(1));
	 }
	// Constructor
	public _RemoteObservableImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.util.remote.RemoteObservable.deleteObserver
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
							this.deleteObserver(observer);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 1: // kxml.util.remote.RemoteObservable.addObserver
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
							this.addObserver(observer);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
			default:
			  throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
	   }
 } 
}
