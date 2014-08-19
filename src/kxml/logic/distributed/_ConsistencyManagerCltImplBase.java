package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERCLTIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _ConsistencyManagerCltImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.logic.distributed.ConsistencyManagerClt {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/logic/distributed/ConsistencyManagerClt:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("modifyMetadata", new java.lang.Integer(0));
	  _methods.put("createElement", new java.lang.Integer(1));
	  _methods.put("fileDocument", new java.lang.Integer(2));
	  _methods.put("modifyDoc", new java.lang.Integer(3));
	  _methods.put("endModifying", new java.lang.Integer(4));
	  _methods.put("removeHElem", new java.lang.Integer(5));
	  _methods.put("removeDoc", new java.lang.Integer(6));
	  _methods.put("copyElem", new java.lang.Integer(7));
	  _methods.put("moveElem", new java.lang.Integer(8));
	  _methods.put("associateXSL", new java.lang.Integer(9));
	  _methods.put("defineDocType", new java.lang.Integer(10));
	  _methods.put("createUser", new java.lang.Integer(11));
	  _methods.put("createGroup", new java.lang.Integer(12));
	  _methods.put("removeUser", new java.lang.Integer(13));
	  _methods.put("removeGroup", new java.lang.Integer(14));
	  _methods.put("addUsrGrp", new java.lang.Integer(15));
	  _methods.put("removeUsrGrp", new java.lang.Integer(16));
	 }
	// Constructor
	public _ConsistencyManagerCltImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.logic.distributed.ConsistencyManagerClt.modifyMetadata
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
							this.modifyMetadata(trNumber, idElem, metaxml);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 1: // kxml.logic.distributed.ConsistencyManagerClt.createElement
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
							this.createElement(trNumber, idElem, metaxml);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 2: // kxml.logic.distributed.ConsistencyManagerClt.fileDocument
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _metaxml = _orb().create_any();
			  _metaxml.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("metaxml", _metaxml, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
			  String metaxml;
			  metaxml = _metaxml.extract_string();
							this.fileDocument(trNumber, idElem, metaxml);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 3: // kxml.logic.distributed.ConsistencyManagerClt.modifyDoc
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
							this.modifyDoc(trNumber, idElem);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 4: // kxml.logic.distributed.ConsistencyManagerClt.endModifying
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
							this.endModifying(trNumber, idElem);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 5: // kxml.logic.distributed.ConsistencyManagerClt.removeHElem
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
			  String userId;
			  userId = _userId.extract_string();
							this.removeHElem(trNumber, idElem, userId);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 6: // kxml.logic.distributed.ConsistencyManagerClt.removeDoc
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _delContent = _orb().create_any();
			  _delContent.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("delContent", _delContent, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElem;
			  idElem = _idElem.extract_string();
			  boolean delContent;
			  delContent = _delContent.extract_boolean();
							this.removeDoc(trNumber, idElem, delContent);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 7: // kxml.logic.distributed.ConsistencyManagerClt.copyElem
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemTarget = _orb().create_any();
			  _idElemTarget.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemTarget", _idElemTarget, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemDestination = _orb().create_any();
			  _idElemDestination.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemDestination", _idElemDestination, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElemTarget;
			  idElemTarget = _idElemTarget.extract_string();
			  String idElemDestination;
			  idElemDestination = _idElemDestination.extract_string();
							this.copyElem(trNumber, idElemTarget, idElemDestination);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 8: // kxml.logic.distributed.ConsistencyManagerClt.moveElem
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemTarget = _orb().create_any();
			  _idElemTarget.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemTarget", _idElemTarget, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _idElemDestination = _orb().create_any();
			  _idElemDestination.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElemDestination", _idElemDestination, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String idElemTarget;
			  idElemTarget = _idElemTarget.extract_string();
			  String idElemDestination;
			  idElemDestination = _idElemDestination.extract_string();
							this.moveElem(trNumber, idElemTarget, idElemDestination);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 9: // kxml.logic.distributed.ConsistencyManagerClt.associateXSL
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
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
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String xslName;
			  xslName = _xslName.extract_string();
			  String xslURL;
			  xslURL = _xslURL.extract_string();
			  String dtdName;
			  dtdName = _dtdName.extract_string();
							this.associateXSL(trNumber, xslName, xslURL, dtdName);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 10: // kxml.logic.distributed.ConsistencyManagerClt.defineDocType
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _typeId = _orb().create_any();
			  _typeId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("typeId", _typeId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _command = _orb().create_any();
			  _command.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("command", _command, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String typeId;
			  typeId = _typeId.extract_string();
			  String command;
			  command = _command.extract_string();
							this.defineDocType(trNumber, typeId, command);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 11: // kxml.logic.distributed.ConsistencyManagerClt.createUser
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
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
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String userId;
			  userId = _userId.extract_string();
			  String password;
			  password = _password.extract_string();
			  boolean administrator;
			  administrator = _administrator.extract_boolean();
							this.createUser(trNumber, userId, password, administrator);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 12: // kxml.logic.distributed.ConsistencyManagerClt.createGroup
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String groupId;
			  groupId = _groupId.extract_string();
							this.createGroup(trNumber, groupId);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 13: // kxml.logic.distributed.ConsistencyManagerClt.removeUser
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String userId;
			  userId = _userId.extract_string();
							this.removeUser(trNumber, userId);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 14: // kxml.logic.distributed.ConsistencyManagerClt.removeGroup
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String groupId;
			  groupId = _groupId.extract_string();
							this.removeGroup(trNumber, groupId);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 15: // kxml.logic.distributed.ConsistencyManagerClt.addUsrGrp
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String userId;
			  userId = _userId.extract_string();
			  String groupId;
			  groupId = _groupId.extract_string();
							this.addUsrGrp(trNumber, userId, groupId);
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 16: // kxml.logic.distributed.ConsistencyManagerClt.removeUsrGrp
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _trNumber = _orb().create_any();
			  _trNumber.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
			  _list.add_value("trNumber", _trNumber, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  long trNumber;
			  trNumber = _trNumber.extract_longlong();
			  String userId;
			  userId = _userId.extract_string();
			  String groupId;
			  groupId = _groupId.extract_string();
							this.removeUsrGrp(trNumber, userId, groupId);
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
