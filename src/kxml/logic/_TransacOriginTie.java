package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINTIE.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginTie extends kxml.logic._TransacOriginImplBase {
	public kxml.logic._TransacOriginOperations servant;
	public _TransacOriginTie(kxml.logic._TransacOriginOperations servant) {
		   this.servant = servant;
	}
	public void addUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		servant.addUserGroup(userId, groupId);
	}
	public void associateXSL(String xslName, String xslUrl, String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.CreationException    {
		servant.associateXSL(xslName, xslUrl, dtdName);
	}
	public boolean closeArchive()
	{
		return servant.closeArchive();
	}
	public void collapseElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException    {
		servant.collapseElement(idElem, observer);
	}
	public void copyElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.CreationException    {
		servant.copyElement(idElemTarget, idElemDestination);
	}
	public kxml.domain.remote.RemoteElement createElement(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException    {
		return servant.createElement(idElem, metaxml);
	}
	public void createGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException    {
		servant.createGroup(groupId);
	}
	public void createUser(String userId, String password, boolean administrator)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.CreationException    {
		servant.createUser(userId, password, administrator);
	}
	public void defineDocType(String typeId, String defaultCommand)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.UserNotFoundException    {
		servant.defineDocType(typeId, defaultCommand);
	}
	public void endModifying(String idElem, kxml.util.remote.RemoteObserver observer, boolean hasChanged)
		throws kxml.logic.exceptions.ElementNotFoundException    {
		servant.endModifying(idElem, observer, hasChanged);
	}
	public void endReading(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ElementNotFoundException    {
		servant.endReading(idElem, observer);
	}
	public String[] expandElement(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		return servant.expandElement(idElem, observer);
	}
	public kxml.domain.remote.RemoteDocument fileDocument(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementExistsException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.CreationException    {
		return servant.fileDocument(idElem, metaxml);
	}
	public String[] getDocTypes()
	{
		return servant.getDocTypes();
	}
	public String[] getDTDs()
	{
		return servant.getDTDs();
	}
	public kxml.domain.remote.RemoteElement getElement(String idElem)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		return servant.getElement(idElem);
	}
	public String[] getXSLs(String dtdName)
		throws kxml.logic.exceptions.ElementNotFoundException    {
		return servant.getXSLs(dtdName);
	}
	public String[] modifyDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		return servant.modifyDocument(idElem, observer);
	}
	public void modifyMetadata(String idElem, String metaxml)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.NotOwnerException, kxml.logic.exceptions.ParsingException, kxml.logic.exceptions.ModificationException    {
		servant.modifyMetadata(idElem, metaxml);
	}
	public void moveElement(String idElemTarget, String idElemDestination)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.CreationException    {
		servant.moveElement(idElemTarget, idElemDestination);
	}
	public String[] readDocument(String idElem, kxml.util.remote.RemoteObserver observer)
		throws kxml.logic.exceptions.ReadAccessException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		return servant.readDocument(idElem, observer);
	}
	public void removeDocument(String idElem, boolean deleteContent)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException    {
		servant.removeDocument(idElem, deleteContent);
	}
	public void removeGroup(String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		servant.removeGroup(groupId);
	}
	public void removeHElement(String idElem)
		throws kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException, kxml.logic.exceptions.WriteAccessException, kxml.logic.exceptions.RemoveException    {
		servant.removeHElement(idElem);
	}
	public void removeUser(String userId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		servant.removeUser(userId);
	}
	public void removeUserGroup(String userId, String groupId)
		throws kxml.logic.exceptions.NotAdministratorException, kxml.logic.exceptions.ElementNotFoundException, kxml.logic.exceptions.UserNotFoundException    {
		servant.removeUserGroup(userId, groupId);
	}
	public String[] setUser(String userId, String passwd, org.omg.CORBA.BooleanHolder isAdmin)
		throws kxml.logic.exceptions.IdentificationException    {
		return servant.setUser(userId, passwd, isAdmin);
	}
}
