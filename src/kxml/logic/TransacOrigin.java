package kxml.logic;

/*
 * File: ./KXML/LOGIC/TRANSACORIGIN.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public interface TransacOrigin
	extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
	void addUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	void associateXSL(String xslName, String xslUrl, String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.CreationException;
	boolean closeArchive()
;
	void collapseElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException;
	void copyElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.CreationException;
	kxml.domain.remote.RemoteElement createElement(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException;
	void createGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException;
	void createUser(String userId, String password, boolean administrator)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.CreationException;
	void defineDocType(String typeId, String defaultCommand)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException;
	void endModifying(String idElem, kxml.util.remote.RemoteObserver observer, boolean hasChanged)
		throws kxml.logic.exceptions.ElementNotFoundException;
	void endReading(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException;
	String[] expandElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	kxml.domain.remote.RemoteDocument fileDocument(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException;
	String[] getDocTypes()
;
	String[] getDTDs()
;
	kxml.domain.remote.RemoteElement getElement(String idElem)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	String[] getXSLs(String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException;
	String[] modifyDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	void modifyMetadata(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.NotOwnerException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.ModificationException;
	void moveElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.CreationException;
	String[] readDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	void removeDocument(String idElem, boolean deleteContent)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException;
	void removeGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	void removeHElement(String idElem)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException;
	void removeUser(String userId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	void removeUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException;
	String[] setUser(String userId, String passwd, org.omg.CORBA.BooleanHolder isAdmin)
		throws kxml.logic.exceptions.IdentificationException;
}
