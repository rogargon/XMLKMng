package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERCLTSTUB.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _ConsistencyManagerCltStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.logic.distributed.ConsistencyManagerClt {

	private static final String _type_ids[] = {
		"IDL:kxml/logic/distributed/ConsistencyManagerClt:1.0"
	};

	public _ConsistencyManagerCltStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::addUsrGrp
	public void addUsrGrp(long trNumber, String userId, String groupId)
 {
		   org.omg.CORBA.Request r = _request("addUsrGrp");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::associateXSL
	public void associateXSL(long trNumber, String xslName, String xslURL, String dtdName)
 {
		   org.omg.CORBA.Request r = _request("associateXSL");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _xslName = r.add_in_arg();
		   _xslName.insert_string(xslName);
		   org.omg.CORBA.Any _xslURL = r.add_in_arg();
		   _xslURL.insert_string(xslURL);
		   org.omg.CORBA.Any _dtdName = r.add_in_arg();
		   _dtdName.insert_string(dtdName);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::copyElem
	public void copyElem(long trNumber, String idElemTarget, String idElemDestination)
 {
		   org.omg.CORBA.Request r = _request("copyElem");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::createElement
	public void createElement(long trNumber, String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("createElement");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::createGroup
	public void createGroup(long trNumber, String groupId)
 {
		   org.omg.CORBA.Request r = _request("createGroup");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::createUser
	public void createUser(long trNumber, String userId, String password, boolean administrator)
 {
		   org.omg.CORBA.Request r = _request("createUser");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _password = r.add_in_arg();
		   _password.insert_string(password);
		   org.omg.CORBA.Any _administrator = r.add_in_arg();
		   _administrator.insert_boolean(administrator);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::defineDocType
	public void defineDocType(long trNumber, String typeId, String command)
 {
		   org.omg.CORBA.Request r = _request("defineDocType");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _typeId = r.add_in_arg();
		   _typeId.insert_string(typeId);
		   org.omg.CORBA.Any _command = r.add_in_arg();
		   _command.insert_string(command);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::endModifying
	public void endModifying(long trNumber, String idElem)
 {
		   org.omg.CORBA.Request r = _request("endModifying");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::fileDocument
	public void fileDocument(long trNumber, String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("fileDocument");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::modifyDoc
	public void modifyDoc(long trNumber, String idElem)
 {
		   org.omg.CORBA.Request r = _request("modifyDoc");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.invoke();
   }   
	//	IDL operations
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::modifyMetadata
	public void modifyMetadata(long trNumber, String idElem, String metaxml)
 {
		   org.omg.CORBA.Request r = _request("modifyMetadata");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::moveElem
	public void moveElem(long trNumber, String idElemTarget, String idElemDestination)
 {
		   org.omg.CORBA.Request r = _request("moveElem");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::removeDoc
	public void removeDoc(long trNumber, String idElem, boolean delContent)
 {
		   org.omg.CORBA.Request r = _request("removeDoc");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _delContent = r.add_in_arg();
		   _delContent.insert_boolean(delContent);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::removeGroup
	public void removeGroup(long trNumber, String groupId)
 {
		   org.omg.CORBA.Request r = _request("removeGroup");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::removeHElem
	public void removeHElem(long trNumber, String idElem, String userId)
 {
		   org.omg.CORBA.Request r = _request("removeHElem");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::removeUser
	public void removeUser(long trNumber, String userId)
 {
		   org.omg.CORBA.Request r = _request("removeUser");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   r.invoke();
   }   
	//	    Implementation of ::kxml::logic::distributed::ConsistencyManagerClt::removeUsrGrp
	public void removeUsrGrp(long trNumber, String userId, String groupId)
 {
		   org.omg.CORBA.Request r = _request("removeUsrGrp");
		   org.omg.CORBA.Any _trNumber = r.add_in_arg();
		   _trNumber.insert_longlong(trNumber);
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.invoke();
   }   
}
