package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/_REMOTEDOCUMENTIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _RemoteDocumentImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.domain.remote.RemoteDocument {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/domain/remote/RemoteDocument:1.0",
		"IDL:kxml/util/remote/RemoteObservable:1.0",
		"IDL:kxml/domain/remote/RemoteElement:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("deleteObserver", new java.lang.Integer(0));
	  _methods.put("addObserver", new java.lang.Integer(1));
	  _methods.put("getMetaXML", new java.lang.Integer(2));
	 }
	// Constructor
	public _RemoteDocumentImplBase() {
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
		   case 2: // kxml.domain.remote.RemoteElement.getMetaXML
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_OUT.value);
			  r.params(_list);
			  org.omg.CORBA.StringHolder metaxml;
			  metaxml = new org.omg.CORBA.StringHolder();
			  boolean ___result;
							___result = this.getMetaXML(metaxml);
			  _metaxml.insert_string(metaxml.value);
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
