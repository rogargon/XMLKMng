package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/_TRANSACORIGINSRVIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _TransacOriginSrvImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.logic.server.TransacOriginSrv {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/logic/server/TransacOriginSrv:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("getArchiveXML", new java.lang.Integer(0));
	 }
	// Constructor
	public _TransacOriginSrvImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.logic.server.TransacOriginSrv.getArchiveXML
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _passwd = _orb().create_any();
			  _passwd.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("passwd", _passwd, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  String passwd;
			  passwd = _passwd.extract_string();
			  String ___result;
			  try {
							___result = this.getArchiveXML(userId, passwd);
			  }
			  catch (kxml.logic.exceptions.IdentificationException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.IdentificationExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_string(___result);
			  r.result(__result);
			  }
			  break;
			default:
			  throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
	   }
 } 
}
