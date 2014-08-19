package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINIMPLBASE.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public abstract class _TransacOriginImplBase extends org.omg.CORBA.DynamicImplementation implements kxml.logic.TransacOrigin {
	// Type strings for this class and its superclases
	private static final String _type_ids[] = {
		"IDL:kxml/logic/TransacOrigin:1.0"
	};

	private static java.util.Dictionary _methods = new java.util.Hashtable();
	static {
	  _methods.put("setUser", new java.lang.Integer(0));
	  _methods.put("getElement", new java.lang.Integer(1));
	  _methods.put("getDocTypes", new java.lang.Integer(2));
	  _methods.put("getDTDs", new java.lang.Integer(3));
	  _methods.put("getXSLs", new java.lang.Integer(4));
	  _methods.put("expandElement", new java.lang.Integer(5));
	  _methods.put("collapseElement", new java.lang.Integer(6));
	  _methods.put("readDocument", new java.lang.Integer(7));
	  _methods.put("modifyDocument", new java.lang.Integer(8));
	  _methods.put("endReading", new java.lang.Integer(9));
	  _methods.put("endModifying", new java.lang.Integer(10));
	  _methods.put("closeArchive", new java.lang.Integer(11));
	  _methods.put("modifyMetadata", new java.lang.Integer(12));
	  _methods.put("createElement", new java.lang.Integer(13));
	  _methods.put("fileDocument", new java.lang.Integer(14));
	  _methods.put("removeDocument", new java.lang.Integer(15));
	  _methods.put("removeHElement", new java.lang.Integer(16));
	  _methods.put("copyElement", new java.lang.Integer(17));
	  _methods.put("moveElement", new java.lang.Integer(18));
	  _methods.put("associateXSL", new java.lang.Integer(19));
	  _methods.put("defineDocType", new java.lang.Integer(20));
	  _methods.put("createUser", new java.lang.Integer(21));
	  _methods.put("createGroup", new java.lang.Integer(22));
	  _methods.put("removeUser", new java.lang.Integer(23));
	  _methods.put("removeGroup", new java.lang.Integer(24));
	  _methods.put("addUserGroup", new java.lang.Integer(25));
	  _methods.put("removeUserGroup", new java.lang.Integer(26));
	 }
	// Constructor
	public _TransacOriginImplBase() {
		 super();
	}
	public String[] _ids() { return (String[]) _type_ids.clone(); }
	// DSI Dispatch call
	public void invoke(org.omg.CORBA.ServerRequest r) {
	   switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
		   case 0: // kxml.logic.TransacOrigin.setUser
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _passwd = _orb().create_any();
			  _passwd.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("passwd", _passwd, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _isAdmin = _orb().create_any();
			  _isAdmin.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("isAdmin", _isAdmin, org.omg.CORBA.ARG_OUT.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  String passwd;
			  passwd = _passwd.extract_string();
			  org.omg.CORBA.BooleanHolder isAdmin;
			  isAdmin = new org.omg.CORBA.BooleanHolder();
			  String[] ___result;
			  try {
							___result = this.setUser(userId, passwd, isAdmin);
			  }
			  catch (kxml.logic.exceptions.IdentificationException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.IdentificationExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  _isAdmin.insert_boolean(isAdmin.value);
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 1: // kxml.logic.TransacOrigin.getElement
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.domain.remote.RemoteElement ___result;
			  try {
							___result = this.getElement(idElem);
			  }
			  catch (kxml.logic.exceptions.ReadAccessException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ReadAccessExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.domain.remote.RemoteElementHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 2: // kxml.logic.TransacOrigin.getDocTypes
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
			  String[] ___result;
							___result = this.getDocTypes();
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 3: // kxml.logic.TransacOrigin.getDTDs
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
			  String[] ___result;
							___result = this.getDTDs();
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 4: // kxml.logic.TransacOrigin.getXSLs
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _dtdName = _orb().create_any();
			  _dtdName.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("dtdName", _dtdName, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String dtdName;
			  dtdName = _dtdName.extract_string();
			  String[] ___result;
			  try {
							___result = this.getXSLs(dtdName);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 5: // kxml.logic.TransacOrigin.expandElement
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  String[] ___result;
			  try {
							___result = this.expandElement(idElem, observer);
			  }
			  catch (kxml.logic.exceptions.ReadAccessException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ReadAccessExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 6: // kxml.logic.TransacOrigin.collapseElement
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  try {
							this.collapseElement(idElem, observer);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 7: // kxml.logic.TransacOrigin.readDocument
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  String[] ___result;
			  try {
							___result = this.readDocument(idElem, observer);
			  }
			  catch (kxml.logic.exceptions.ReadAccessException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ReadAccessExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 8: // kxml.logic.TransacOrigin.modifyDocument
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  String[] ___result;
			  try {
							___result = this.modifyDocument(idElem, observer);
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.util.remote.StringArrayHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 9: // kxml.logic.TransacOrigin.endReading
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  try {
							this.endReading(idElem, observer);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 10: // kxml.logic.TransacOrigin.endModifying
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _observer = _orb().create_any();
			  _observer.type(kxml.util.remote.RemoteObserverHelper.type());
			  _list.add_value("observer", _observer, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _hasChanged = _orb().create_any();
			  _hasChanged.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("hasChanged", _hasChanged, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  kxml.util.remote.RemoteObserver observer;
			  observer = kxml.util.remote.RemoteObserverHelper.extract(_observer);
			  boolean hasChanged;
			  hasChanged = _hasChanged.extract_boolean();
			  try {
							this.endModifying(idElem, observer, hasChanged);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 11: // kxml.logic.TransacOrigin.closeArchive
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  r.params(_list);
			  boolean ___result;
							___result = this.closeArchive();
			  org.omg.CORBA.Any __result = _orb().create_any();
			  __result.insert_boolean(___result);
			  r.result(__result);
			  }
			  break;
		   case 12: // kxml.logic.TransacOrigin.modifyMetadata
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
			  try {
							this.modifyMetadata(idElem, metaxml);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.NotOwnerException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotOwnerExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ParsingException e4) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ParsingExceptionHelper.insert(_except, e4);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ModificationException e5) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ModificationExceptionHelper.insert(_except, e5);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 13: // kxml.logic.TransacOrigin.createElement
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
			  kxml.domain.remote.RemoteElement ___result;
			  try {
							___result = this.createElement(idElem, metaxml);
			  }
			  catch (kxml.logic.exceptions.ElementExistsException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementExistsExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ParsingException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ParsingExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e4) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e4);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.domain.remote.RemoteElementHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 14: // kxml.logic.TransacOrigin.fileDocument
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
			  kxml.domain.remote.RemoteDocument ___result;
			  try {
							___result = this.fileDocument(idElem, metaxml);
			  }
			  catch (kxml.logic.exceptions.ElementExistsException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementExistsExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ParsingException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ParsingExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e4) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e4);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __result = _orb().create_any();
			  kxml.domain.remote.RemoteDocumentHelper.insert(__result, ___result);
			  r.result(__result);
			  }
			  break;
		   case 15: // kxml.logic.TransacOrigin.removeDocument
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _deleteContent = _orb().create_any();
			  _deleteContent.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
			  _list.add_value("deleteContent", _deleteContent, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  boolean deleteContent;
			  deleteContent = _deleteContent.extract_boolean();
			  try {
							this.removeDocument(idElem, deleteContent);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.RemoveException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.RemoveExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 16: // kxml.logic.TransacOrigin.removeHElement
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _idElem = _orb().create_any();
			  _idElem.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("idElem", _idElem, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String idElem;
			  idElem = _idElem.extract_string();
			  try {
							this.removeHElement(idElem);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.RemoveException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.RemoveExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 17: // kxml.logic.TransacOrigin.copyElement
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
			  try {
							this.copyElement(idElemTarget, idElemDestination);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ReadAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ReadAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 18: // kxml.logic.TransacOrigin.moveElement
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
			  try {
							this.moveElement(idElemTarget, idElemDestination);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ReadAccessException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ReadAccessExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.WriteAccessException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.WriteAccessExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e4) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e4);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 19: // kxml.logic.TransacOrigin.associateXSL
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _xslName = _orb().create_any();
			  _xslName.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("xslName", _xslName, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _xslUrl = _orb().create_any();
			  _xslUrl.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("xslUrl", _xslUrl, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _dtdName = _orb().create_any();
			  _dtdName.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("dtdName", _dtdName, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String xslName;
			  xslName = _xslName.extract_string();
			  String xslUrl;
			  xslUrl = _xslUrl.extract_string();
			  String dtdName;
			  dtdName = _dtdName.extract_string();
			  try {
							this.associateXSL(xslName, xslUrl, dtdName);
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 20: // kxml.logic.TransacOrigin.defineDocType
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _typeId = _orb().create_any();
			  _typeId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("typeId", _typeId, org.omg.CORBA.ARG_IN.value);
			  org.omg.CORBA.Any _defaultCommand = _orb().create_any();
			  _defaultCommand.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("defaultCommand", _defaultCommand, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String typeId;
			  typeId = _typeId.extract_string();
			  String defaultCommand;
			  defaultCommand = _defaultCommand.extract_string();
			  try {
							this.defineDocType(typeId, defaultCommand);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 21: // kxml.logic.TransacOrigin.createUser
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
			  try {
							this.createUser(userId, password, administrator);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.CreationException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.CreationExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 22: // kxml.logic.TransacOrigin.createGroup
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String groupId;
			  groupId = _groupId.extract_string();
			  try {
							this.createGroup(groupId);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementExistsException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementExistsExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 23: // kxml.logic.TransacOrigin.removeUser
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _userId = _orb().create_any();
			  _userId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("userId", _userId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String userId;
			  userId = _userId.extract_string();
			  try {
							this.removeUser(userId);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 24: // kxml.logic.TransacOrigin.removeGroup
			  {
			  org.omg.CORBA.NVList _list = _orb().create_list(0);
			  org.omg.CORBA.Any _groupId = _orb().create_any();
			  _groupId.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
			  _list.add_value("groupId", _groupId, org.omg.CORBA.ARG_IN.value);
			  r.params(_list);
			  String groupId;
			  groupId = _groupId.extract_string();
			  try {
							this.removeGroup(groupId);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 25: // kxml.logic.TransacOrigin.addUserGroup
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
			  try {
							this.addUserGroup(userId, groupId);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementExistsException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementExistsExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e3) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e3);
							r.except(_except);
							return;
			  }
			  org.omg.CORBA.Any __return = _orb().create_any();
			  __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
			  r.result(__return);
			  }
			  break;
		   case 26: // kxml.logic.TransacOrigin.removeUserGroup
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
			  try {
							this.removeUserGroup(userId, groupId);
			  }
			  catch (kxml.logic.exceptions.NotAdministratorException e0) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.NotAdministratorExceptionHelper.insert(_except, e0);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.ElementNotFoundException e1) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.ElementNotFoundExceptionHelper.insert(_except, e1);
							r.except(_except);
							return;
			  }
			  catch (kxml.logic.exceptions.UserNotFoundException e2) {
							org.omg.CORBA.Any _except = _orb().create_any();
							kxml.logic.exceptions.UserNotFoundExceptionHelper.insert(_except, e2);
							r.except(_except);
							return;
			  }
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
