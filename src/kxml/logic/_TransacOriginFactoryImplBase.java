package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINFACTORYIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _TransacOriginFactoryImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.logic.TransacOriginFactory {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/logic/TransacOriginFactory:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("getTransacOrigin", new java.lang.Integer(0));
	  _methods.put("removeTransacOrigin", new java.lang.Integer(1));
	 }
	// Constructor
	public _TransacOriginFactoryImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.logic.TransacOriginFactory.getTransacOrigin
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _logObserver = _orb().create_any();
			  _logObserver.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("logObserver", _logObserver, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  kxml.util.remote.RemoteObserver logObserver;
			  logObserver = kxml.util.remote.RemoteObserverHelper.extract(_logObserver);
			  kxml.logic.TransacOrigin ___result;
							___result = this.getTransacOrigin(logObserver);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.logic.TransacOriginHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 1: // kxml.logic.TransacOriginFactory.removeTransacOrigin
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
			  boolean ___result;
							___result = this.removeTransacOrigin();
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_boolean(___result);
			  r.result(__result);
			  }
			  break;
			default:
			  throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
	   }
 } 
}
