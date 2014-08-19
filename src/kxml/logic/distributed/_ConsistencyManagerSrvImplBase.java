package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERSRVIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _ConsistencyManagerSrvImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.logic.distributed.ConsistencyManagerSrv {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/logic/distributed/ConsistencyManagerSrv:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("addClientManager", new java.lang.Integer(0));
	  _methods.put("removeClientManager", new java.lang.Integer(1));
	  _methods.put("lock", new java.lang.Integer(2));
	  _methods.put("unlock", new java.lang.Integer(3));
	  _methods.put("modifyMetaDist", new java.lang.Integer(4));
	  _methods.put("createElemDist", new java.lang.Integer(5));
	  _methods.put("fileDocDist", new java.lang.Integer(6));
	  _methods.put("modifyDocDist", new java.lang.Integer(7));
	  _methods.put("endModifyingDist", new java.lang.Integer(8));
	  _methods.put("removeHElemDist", new java.lang.Integer(9));
	  _methods.put("removeDocDist", new java.lang.Integer(10));
	  _methods.put("copyElemDist", new java.lang.Integer(11));
	  _methods.put("moveElemDist", new java.lang.Integer(12));
	  _methods.put("associateXSLDist", new java.lang.Integer(13));
	  _methods.put("defineDocTypeDist", new java.lang.Integer(14));
	  _methods.put("createUserDist", new java.lang.Integer(15));
	  _methods.put("createGroupDist", new java.lang.Integer(16));
	  _methods.put("removeUserDist", new java.lang.Integer(17));
	  _methods.put("removeGroupDist", new java.lang.Integer(18));
	  _methods.put("addUsrGrpDist", new java.lang.Integer(19));
	  _methods.put("removeUsrGrpDist", new java.lang.Integer(20));
	 }
	// Constructor
	public _ConsistencyManagerSrvImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.logic.distributed.ConsistencyManagerSrv.addClientManager
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _consistencyMngClt = _orb().create_any();
			  _consistencyMngClt.type(kxml.logic.distributed.ConsistencyManagerCltHelper.type());
			  _list.add_value("consistencyMngClt", _consistencyMngClt, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt;
			  consistencyMngClt = kxml.logic.distributed.ConsistencyManagerCltHelper.extract(_consistencyMngClt);
							this.addClientManager(consistencyMngClt);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 1: // kxml.logic.distributed.ConsistencyManagerSrv.removeClientManager
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _consistencyMngClt = _orb().create_any();
			  _consistencyMngClt.type(kxml.logic.distributed.ConsistencyManagerCltHelper.type());
			  _list.add_value("consistencyMngClt", _consistencyMngClt, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt;
			  consistencyMngClt = kxml.logic.distributed.ConsistencyManagerCltHelper.extract(_consistencyMngClt);
							this.removeClientManager(consistencyMngClt);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 2: // kxml.logic.distributed.ConsistencyManagerSrv.lock
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
							this.lock();
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 3: // kxml.logic.distributed.ConsistencyManagerSrv.unlock
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
							this.unlock();
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 4: // kxml.logic.distributed.ConsistencyManagerSrv.modifyMetaDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
			  long ___result;
							___result = this.modifyMetaDist(idElem, metaxml);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 5: // kxml.logic.distributed.ConsistencyManagerSrv.createElemDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
			  long ___result;
							___result = this.createElemDist(idElem, metaxml);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 6: // kxml.logic.distributed.ConsistencyManagerSrv.fileDocDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
			  long ___result;
							___result = this.fileDocDist(idElem, metaxml);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 7: // kxml.logic.distributed.ConsistencyManagerSrv.modifyDocDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  long ___result;
							___result = this.modifyDocDist(idElem);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 8: // kxml.logic.distributed.ConsistencyManagerSrv.endModifyingDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  long ___result;
							___result = this.endModifyingDist(idElem);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 9: // kxml.logic.distributed.ConsistencyManagerSrv.removeHElemDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  String userId;
			  userId = _userId.extract_string();
			  long ___result;
							___result = this.removeHElemDist(idElem, userId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 10: // kxml.logic.distributed.ConsistencyManagerSrv.removeDocDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _delContent = _orb().create_any();
			  _delContent.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("delContent", _delContent, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  boolean delContent;
			  delContent = _delContent.extract_boolean();
			  long ___result;
							___result = this.removeDocDist(idElem, delContent);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 11: // kxml.logic.distributed.ConsistencyManagerSrv.copyElemDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElemTarget = _orb().create_any();
			  _idElemTarget.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemTarget", _idElemTarget, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemDestination = _orb().create_any();
			  _idElemDestination.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemDestination", _idElemDestination, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElemTarget;
			  idElemTarget = _idElemTarget.extract_string();
			  String idElemDestination;
			  idElemDestination = _idElemDestination.extract_string();
			  long ___result;
							___result = this.copyElemDist(idElemTarget, idElemDestination);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 12: // kxml.logic.distributed.ConsistencyManagerSrv.moveElemDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElemTarget = _orb().create_any();
			  _idElemTarget.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemTarget", _idElemTarget, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemDestination = _orb().create_any();
			  _idElemDestination.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemDestination", _idElemDestination, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElemTarget;
			  idElemTarget = _idElemTarget.extract_string();
			  String idElemDestination;
			  idElemDestination = _idElemDestination.extract_string();
			  long ___result;
							___result = this.moveElemDist(idElemTarget, idElemDestination);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 13: // kxml.logic.distributed.ConsistencyManagerSrv.associateXSLDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _xslName = _orb().create_any();
			  _xslName.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("xslName", _xslName, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _xslURL = _orb().create_any();
			  _xslURL.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("xslURL", _xslURL, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _dtdName = _orb().create_any();
			  _dtdName.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("dtdName", _dtdName, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String xslName;
			  xslName = _xslName.extract_string();
			  String xslURL;
			  xslURL = _xslURL.extract_string();
			  String dtdName;
			  dtdName = _dtdName.extract_string();
			  long ___result;
							___result = this.associateXSLDist(xslName, xslURL, dtdName);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 14: // kxml.logic.distributed.ConsistencyManagerSrv.defineDocTypeDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _typeId = _orb().create_any();
			  _typeId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("typeId", _typeId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _command = _orb().create_any();
			  _command.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("command", _command, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String typeId;
			  typeId = _typeId.extract_string();
			  String command;
			  command = _command.extract_string();
			  long ___result;
							___result = this.defineDocTypeDist(typeId, command);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 15: // kxml.logic.distributed.ConsistencyManagerSrv.createUserDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _password = _orb().create_any();
			  _password.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("password", _password, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _administrator = _orb().create_any();
			  _administrator.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("administrator", _administrator, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  String password;
			  password = _password.extract_string();
			  boolean administrator;
			  administrator = _administrator.extract_boolean();
			  long ___result;
							___result = this.createUserDist(userId, password, administrator);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 16: // kxml.logic.distributed.ConsistencyManagerSrv.createGroupDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String groupId;
			  groupId = _groupId.extract_string();
			  long ___result;
							___result = this.createGroupDist(groupId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 17: // kxml.logic.distributed.ConsistencyManagerSrv.removeUserDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  long ___result;
							___result = this.removeUserDist(userId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 18: // kxml.logic.distributed.ConsistencyManagerSrv.removeGroupDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String groupId;
			  groupId = _groupId.extract_string();
			  long ___result;
							___result = this.removeGroupDist(groupId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 19: // kxml.logic.distributed.ConsistencyManagerSrv.addUsrGrpDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  String groupId;
			  groupId = _groupId.extract_string();
			  long ___result;
							___result = this.addUsrGrpDist(userId, groupId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
		   case 20: // kxml.logic.distributed.ConsistencyManagerSrv.removeUsrGrpDist
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  String groupId;
			  groupId = _groupId.extract_string();
			  long ___result;
							___result = this.removeUsrGrpDist(userId, groupId);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_longlong(___result);
			  r.result(__result);
			  }
			  break;
			default:
			  throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
	   }
 } 
}
