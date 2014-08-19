package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/_REMOTEELEMENTSTUB.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteElementStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.domain.remote.RemoteElement {

	private static final String _type_ids[] = {
		"IDL:kxml/domain/remote/RemoteElement:1.0",
		"IDL:kxml/util/remote/RemoteObservable:1.0"
	};

	public _RemoteElementStub(org.omg.CORBA.portable.Delegate d) {
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
	//	    Implementation of ::kxml::domain::remote::RemoteElement::getMetaXML
	public boolean getMetaXML(org.omg.CORBA.StringHolder metaxml)
 {
		   org.omg.CORBA.Request r = _request("getMetaXML");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
		   org.omg.CORBA.Any _metaxml = r.add_out_arg();
		   _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
		   r.invoke();
		   metaxml.value = _metaxml.extract_string();
		   boolean __result;
		   __result = r.return_value().extract_boolean();
		   return __result;
   }   
}
