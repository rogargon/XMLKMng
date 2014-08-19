package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERSRVSTUB.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _ConsistencyManagerSrvStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.logic.distributed.ConsistencyManagerSrv {

	private static final String _type_ids[] = {
		"IDL:kxml/logic/distributed/ConsistencyManagerSrv:1.0"
	};

	public _ConsistencyManagerSrvStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	IDL operations
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::addClientManager
	public void addClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
 {
		   org.omg.CORBA.Request r = _request("addClientManager");
		   org.omg.CORBA.Any _consistencyMngClt = r.add_in_arg();
		   kxml.logic.distributed.ConsistencyManagerCltHelper.insert(_consistencyMngClt, consistencyMngClt);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::addUsrGrpDist
	public long addUsrGrpDist(String userId, String groupId)
 {
		   org.omg.CORBA.Request r = _request("addUsrGrpDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::associateXSLDist
	public long associateXSLDist(String xslName, String xslURL, String dtdName)
 {
		   org.omg.CORBA.Request r = _request("associateXSLDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _xslName = r.add_in_arg();
		   _xslName.insert_string(xslName);
		   org.omg.CORBA.Any _xslURL = r.add_in_arg();
		   _xslURL.insert_string(xslURL);
		   org.omg.CORBA.Any _dtdName = r.add_in_arg();
		   _dtdName.insert_string(dtdName);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::copyElemDist
	public long copyElemDist(String idElemTarget, String idElemDestination)
 {
		   org.omg.CORBA.Request r = _request("copyElemDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::createElemDist
	public long createElemDist(String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("createElemDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::createGroupDist
	public long createGroupDist(String groupId)
 {
		   org.omg.CORBA.Request r = _request("createGroupDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::createUserDist
	public long createUserDist(String userId, String password, boolean administrator)
 {
		   org.omg.CORBA.Request r = _request("createUserDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _password = r.add_in_arg();
		   _password.insert_string(password);
		   org.omg.CORBA.Any _administrator = r.add_in_arg();
		   _administrator.insert_boolean(administrator);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::defineDocTypeDist
	public long defineDocTypeDist(String typeId, String command)
 {
		   org.omg.CORBA.Request r = _request("defineDocTypeDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _typeId = r.add_in_arg();
		   _typeId.insert_string(typeId);
		   org.omg.CORBA.Any _command = r.add_in_arg();
		   _command.insert_string(command);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::endModifyingDist
	public long endModifyingDist(String idElem)
 {
		   org.omg.CORBA.Request r = _request("endModifyingDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::fileDocDist
	public long fileDocDist(String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("fileDocDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::lock
	public void lock()
 {
		   org.omg.CORBA.Request r = _request("lock");
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::modifyDocDist
	public long modifyDocDist(String idElem)
 {
		   org.omg.CORBA.Request r = _request("modifyDocDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::modifyMetaDist
	public long modifyMetaDist(String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("modifyMetaDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::moveElemDist
	public long moveElemDist(String idElemTarget, String idElemDestination)
 {
		   org.omg.CORBA.Request r = _request("moveElemDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeClientManager
	public void removeClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
 {
		   org.omg.CORBA.Request r = _request("removeClientManager");
		   org.omg.CORBA.Any _consistencyMngClt = r.add_in_arg();
		   kxml.logic.distributed.ConsistencyManagerCltHelper.insert(_consistencyMngClt, consistencyMngClt);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeDocDist
	public long removeDocDist(String idElem, boolean delContent)
 {
		   org.omg.CORBA.Request r = _request("removeDocDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _delContent = r.add_in_arg();
		   _delContent.insert_boolean(delContent);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeGroupDist
	public long removeGroupDist(String groupId)
 {
		   org.omg.CORBA.Request r = _request("removeGroupDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeHElemDist
	public long removeHElemDist(String idElem, String userId)
 {
		   org.omg.CORBA.Request r = _request("removeHElemDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeUserDist
	public long removeUserDist(String userId)
 {
		   org.omg.CORBA.Request r = _request("removeUserDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::removeUsrGrpDist
	public long removeUsrGrpDist(String userId, String groupId)
 {
		   org.omg.CORBA.Request r = _request("removeUsrGrpDist");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
		   long __result;
		   __result = r.return_value().extract_longlong();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerSrv::unlock
	public void unlock()
 {
		   org.omg.CORBA.Request r = _request("unlock");
		   r.invoke();
   }   
}
