package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINFACTORYSTUB.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginFactoryStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.logic.TransacOriginFactory {

	private static final String _type_ids[] = {
		"IDL:kxml/logic/TransacOriginFactory:1.0"
	};

	public _TransacOriginFactoryStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	IDL operations
	//	    Implementation of ::kxml::logic::TransacOriginFactory::getTransacOrigin
	public kxml.logic.TransacOrigin getTransacOrigin(kxml.util.remote.RemoteObserver logObserver)
 {
		   org.omg.CORBA.Request r = _request("getTransacOrigin");
		   r.set_return_type(kxml.logic.TransacOriginHelper.type());
		   org.omg.CORBA.Any _logObserver = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_logObserver, logObserver);
		   r.invoke();
		   kxml.logic.TransacOrigin __result;
		   __result = kxml.logic.TransacOriginHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOriginFactory::removeTransacOrigin
	public boolean removeTransacOrigin()
 {
		   org.omg.CORBA.Request r = _request("removeTransacOrigin");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
		   r.invoke();
		   boolean __result;
		   __result = r.return_value().extract_boolean();
		   return __result;
   }   
}
