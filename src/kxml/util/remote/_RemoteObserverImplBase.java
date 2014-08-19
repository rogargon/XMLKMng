package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVERIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _RemoteObserverImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.util.remote.RemoteObserver {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/util/remote/RemoteObserver:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("update", new java.lang.Integer(0));
	 }
	// Constructor
	public _RemoteObserverImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.util.remote.RemoteObserver.update
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _observable = _orb().create_any();
			  _observable.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_objref));
			  _list.add_value("observable", _observable, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _data = _orb().create_any();
			  _data.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_any));
			  _list.add_value("data", _data, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  org.omg.CORBA.Object observable;
			  observable = _observable.extract_Object();
			  org.omg.CORBA.Any data;
			  data = _data.extract_any();
							this.update(observable, data);
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
