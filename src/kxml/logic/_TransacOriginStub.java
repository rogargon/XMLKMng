package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINSTUB.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginStub
	extends org.omg.CORBA.portable.ObjectImpl
		implements kxml.logic.TransacOrigin {

	private static final String _type_ids[] = {
		"IDL:kxml/logic/TransacOrigin:1.0"
	};

	public _TransacOriginStub(org.omg.CORBA.portable.Delegate d) {
		  super();
		  _set_delegate(d);
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	//	    Implementation of ::kxml::logic::TransacOrigin::addUserGroup
	public void addUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("addUserGroup");
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementExistsExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementExistsExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementExistsExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::associateXSL
	public void associateXSL(String xslName, String xslUrl, String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("associateXSL");
		   org.omg.CORBA.Any _xslName = r.add_in_arg();
		   _xslName.insert_string(xslName);
		   org.omg.CORBA.Any _xslUrl = r.add_in_arg();
		   _xslUrl.insert_string(xslUrl);
		   org.omg.CORBA.Any _dtdName = r.add_in_arg();
		   _dtdName.insert_string(dtdName);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::closeArchive
	public boolean closeArchive()
 {
		   org.omg.CORBA.Request r = _request("closeArchive");
		   r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
		   r.invoke();
		   boolean __result;
		   __result = r.return_value().extract_boolean();
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::collapseElement
	public void collapseElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException {
		   org.omg.CORBA.Request r = _request("collapseElement");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::copyElement
	public void copyElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("copyElement");
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ReadAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ReadAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ReadAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::createElement
	public kxml.domain.remote.RemoteElement createElement(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("createElement");
		   r.set_return_type(kxml.domain.remote.RemoteElementHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.exceptions().add(kxml.logic.exceptions.ElementExistsExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ParsingExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementExistsExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementExistsExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ParsingExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ParsingExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
		   kxml.domain.remote.RemoteElement __result;
		   __result = kxml.domain.remote.RemoteElementHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::createGroup
	public void createGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("createGroup");
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementExistsExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementExistsExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementExistsExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::createUser
	public void createUser(String userId, String password, boolean administrator)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("createUser");
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _password = r.add_in_arg();
		   _password.insert_string(password);
		   org.omg.CORBA.Any _administrator = r.add_in_arg();
		   _administrator.insert_boolean(administrator);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::defineDocType
	public void defineDocType(String typeId, String defaultCommand)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("defineDocType");
		   org.omg.CORBA.Any _typeId = r.add_in_arg();
		   _typeId.insert_string(typeId);
		   org.omg.CORBA.Any _defaultCommand = r.add_in_arg();
		   _defaultCommand.insert_string(defaultCommand);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::endModifying
	public void endModifying(String idElem, kxml.util.remote.RemoteObserver observer, boolean hasChanged)
		throws kxml.logic.exceptions.ElementNotFoundException {
		   org.omg.CORBA.Request r = _request("endModifying");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   org.omg.CORBA.Any _hasChanged = r.add_in_arg();
		   _hasChanged.insert_boolean(hasChanged);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::endReading
	public void endReading(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException {
		   org.omg.CORBA.Request r = _request("endReading");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::expandElement
	public String[] expandElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("expandElement");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.exceptions().add(kxml.logic.exceptions.ReadAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ReadAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ReadAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::fileDocument
	public kxml.domain.remote.RemoteDocument fileDocument(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("fileDocument");
		   r.set_return_type(kxml.domain.remote.RemoteDocumentHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.exceptions().add(kxml.logic.exceptions.ElementExistsExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ParsingExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementExistsExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementExistsExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ParsingExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ParsingExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
		   kxml.domain.remote.RemoteDocument __result;
		   __result = kxml.domain.remote.RemoteDocumentHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::getDocTypes
	public String[] getDocTypes()
 {
		   org.omg.CORBA.Request r = _request("getDocTypes");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   r.invoke();
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::getDTDs
	public String[] getDTDs()
 {
		   org.omg.CORBA.Request r = _request("getDTDs");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   r.invoke();
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::getElement
	public kxml.domain.remote.RemoteElement getElement(String idElem)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("getElement");
		   r.set_return_type(kxml.domain.remote.RemoteElementHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.exceptions().add(kxml.logic.exceptions.ReadAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ReadAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ReadAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
		   kxml.domain.remote.RemoteElement __result;
		   __result = kxml.domain.remote.RemoteElementHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::getXSLs
	public String[] getXSLs(String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException {
		   org.omg.CORBA.Request r = _request("getXSLs");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   org.omg.CORBA.Any _dtdName = r.add_in_arg();
		   _dtdName.insert_string(dtdName);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::modifyDocument
	public String[] modifyDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("modifyDocument");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::modifyMetadata
	public void modifyMetadata(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.NotOwnerException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.ModificationException {
		   org.omg.CORBA.Request r = _request("modifyMetadata");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _metaxml = r.add_in_arg();
		   _metaxml.insert_string(metaxml);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.NotOwnerExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ParsingExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ModificationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotOwnerExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotOwnerExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ParsingExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ParsingExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ModificationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ModificationExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::moveElement
	public void moveElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.CreationException {
		   org.omg.CORBA.Request r = _request("moveElement");
		   org.omg.CORBA.Any _idElemTarget = r.add_in_arg();
		   _idElemTarget.insert_string(idElemTarget);
		   org.omg.CORBA.Any _idElemDestination = r.add_in_arg();
		   _idElemDestination.insert_string(idElemDestination);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ReadAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.CreationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ReadAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ReadAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.CreationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.CreationExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::readDocument
	public String[] readDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("readDocument");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _observer = r.add_in_arg();
		   kxml.util.remote.RemoteObserverHelper.insert(_observer, observer);
		   r.exceptions().add(kxml.logic.exceptions.ReadAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ReadAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ReadAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::removeDocument
	public void removeDocument(String idElem, boolean deleteContent)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException {
		   org.omg.CORBA.Request r = _request("removeDocument");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   org.omg.CORBA.Any _deleteContent = r.add_in_arg();
		   _deleteContent.insert_boolean(deleteContent);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.RemoveExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.RemoveExceptionHelper.type())) {
				   throw kxml.logic.exceptions.RemoveExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::removeGroup
	public void removeGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("removeGroup");
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::removeHElement
	public void removeHElement(String idElem)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException {
		   org.omg.CORBA.Request r = _request("removeHElement");
		   org.omg.CORBA.Any _idElem = r.add_in_arg();
		   _idElem.insert_string(idElem);
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.WriteAccessExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.RemoveExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.WriteAccessExceptionHelper.type())) {
				   throw kxml.logic.exceptions.WriteAccessExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.RemoveExceptionHelper.type())) {
				   throw kxml.logic.exceptions.RemoveExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::removeUser
	public void removeUser(String userId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("removeUser");
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	    Implementation of ::kxml::logic::TransacOrigin::removeUserGroup
	public void removeUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException {
		   org.omg.CORBA.Request r = _request("removeUserGroup");
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _groupId = r.add_in_arg();
		   _groupId.insert_string(groupId);
		   r.exceptions().add(kxml.logic.exceptions.NotAdministratorExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type());
		   r.exceptions().add(kxml.logic.exceptions.UserNotFoundExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.NotAdministratorExceptionHelper.type())) {
				   throw kxml.logic.exceptions.NotAdministratorExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.ElementNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.ElementNotFoundExceptionHelper.extract(__userEx.except);
			   }
			   if (__userEx.except.type().equals(kxml.logic.exceptions.UserNotFoundExceptionHelper.type())) {
				   throw kxml.logic.exceptions.UserNotFoundExceptionHelper.extract(__userEx.except);
			   }
		   }
   }   
	//	IDL operations
	//	    Implementation of ::kxml::logic::TransacOrigin::setUser
	public String[] setUser(String userId, String passwd, org.omg.CORBA.BooleanHolder isAdmin)
		throws kxml.logic.exceptions.IdentificationException {
		   org.omg.CORBA.Request r = _request("setUser");
		   r.set_return_type(kxml.util.remote.StringArrayHelper.type());
		   org.omg.CORBA.Any _userId = r.add_in_arg();
		   _userId.insert_string(userId);
		   org.omg.CORBA.Any _passwd = r.add_in_arg();
		   _passwd.insert_string(passwd);
		   org.omg.CORBA.Any _isAdmin = r.add_out_arg();
		   _isAdmin.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
		   r.exceptions().add(kxml.logic.exceptions.IdentificationExceptionHelper.type());
		   r.invoke();
		   java.lang.Exception __ex = r.env().exception();
		   if (__ex instanceof org.omg.CORBA.UnknownUserException) {
			   org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
			   if (__userEx.except.type().equals(kxml.logic.exceptions.IdentificationExceptionHelper.type())) {
				   throw kxml.logic.exceptions.IdentificationExceptionHelper.extract(__userEx.except);
			   }
		   }
		   isAdmin.value = _isAdmin.extract_boolean();
		   String[] __result;
		   __result = kxml.util.remote.StringArrayHelper.extract(r.return_value());
		   return __result;
   }   
}
