package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/_TRANSACORIGINSRVSTUB.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginSrvStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.logic.server.TransacOriginSrv {

	private static final String _type_ids[] = {
		"IDL:kxml/logic/server/TransacOriginSrv:1.0"
	};

	public _TransacOriginSrvStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	IDL operations
	//	    Implementation of ::kxml::logic::server::TransacOriginSrv::getArchiveXML
	public String getArchiveXML(String userId, String passwd)
		throws kxml.logic.exceptions.IdentificationException {
		   org.omg.CORBA.Request r = _request("getArchiveXML");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _passwd = r.add_in_arg();
		   _passwd.insert_string(passwd);
		   r.exceptions().add(kxml.logic.exceptions.IdentificationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.IdentificationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.IdentificationExceptionHelper.extract(__userEx.except);
			   }
		   }
		   String __result;
		   __result = r.return_value().extract_string();
		   return __result;
   }   
}
