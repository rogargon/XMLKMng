package kxml.logic;

import kxml.domain.*;
import kxml.domain.remote.*;
import kxml.logic.distributed.*;
import kxml.logic.server.*;
import kxml.logic.exceptions.*;
import kxml.util.remote.*;
import org.omg.CORBA.BooleanHolder;

public class TransacOriginImpl extends _TransacOriginImplBase
{
	private ConsistencyManagerSrv consistencyMngSrv;
   	private TransacOriginFactory trOriginFactory;
   	private TransacOriginSrv trOriginSrv;
	private Archive archive;
	private String currentUserId;
	private RemoteObserver logObserver;
/**
 * 
 */
public TransacOriginImpl(Archive archive, ConsistencyManagerSrv consistencyMngSrv, 
						 TransacOriginFactory trOriginFactory, 
						 TransacOriginSrv trOrigirSrv,
						 RemoteObserver logObserver) 
{
	super();
	this.archive = archive;
	this.consistencyMngSrv = consistencyMngSrv;
   	this.trOriginFactory = trOriginFactory;
   	this.trOriginSrv = trOriginSrv;
	this.logObserver = logObserver;
   	
	if (logObserver != null)
		archive.logger.addObserver(logObserver);
}
/**
 * 
 */
public void addUserGroup(String userId, String groupId)
	throws ElementNotFoundException, UserNotFoundException, 
		   NotAdministratorException, ElementExistsException
{	
/*	kxml.logic.distributed.AddUsrGrpLocTr transac = 
		new kxml.logic.distributed.AddUsrGrpLocTr(archive, getCurrentUser(), 
												  userId, groupId);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof ElementExistsException)
			throw((ElementExistsException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage));
	}
*/}
/**
 * 
 */
public void associateXSL(String xslName, String xslURLStr, String dtdName)
				throws ElementNotFoundException, CreationException
{
	java.net.URL xslURL = null;
	try
	{	xslURL = new java.net.URL(xslURLStr);	}
	catch(java.net.MalformedURLException e)
	{
		throw(new CreationException(e.getMessage()));
	}
	
	kxml.logic.distributed.AssociateXSLLocTr transac = 
		new kxml.logic.distributed.AssociateXSLLocTr(archive, getCurrentUser(), 
								  consistencyMngSrv, xslName, xslURL, dtdName);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else
			throw(new CreationException(transac.exception.getMessage()));
	}
}
public boolean closeArchive() 
{
	if (logObserver != null)
		archive.logger.deleteObserver(logObserver);
	
   	return trOriginFactory.removeTransacOrigin();
}
/**
 * 
 */
public void collapseElement(String idElem, RemoteObserver observer)
					throws ElementNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.local.CollapseTr transac = 
			new kxml.logic.local.CollapseTr(archive, id, observer);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}

	if (transac.exception != null)
		throw(new ElementNotFoundException(transac.exception.getMessage()));
}
/**
 * 
 */
public void copyElement(String idElemTarget, String idElemDestination)
					throws ElementNotFoundException, UserNotFoundException,
						   ReadAccessException, CreationException
{
/*	IdElem idTarget = new IdElem(idElemTarget);
	IdElem idDestination = new IdElem(idElemDestination);
	
	kxml.logic.distributed.CopyElemLocTr transac = 
			new kxml.logic.distributed.CopyElemLocTr(archive, currentUserId, 
										consistencyMngSrv, idTarget, idDestination);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof ReadAccessException)
			throw((ReadAccessException)transac.exception);
		else
			throw(new CreationException(transac.exception.getMessage()));
	}
*/}
/**
 * 
 */
public RemoteElement createElement(String idElem, String metaxml)
					throws UserNotFoundException, ElementExistsException, 
						   WriteAccessException, CreationException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.CreateElemLocTr transac = 
			new kxml.logic.distributed.CreateElemLocTr(archive, currentUserId, 
										consistencyMngSrv, id, metaxml);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else if (transac.exception instanceof ElementExistsException)
			throw((ElementExistsException)transac.exception);
		else 
			throw((CreationException)transac.exception);
	}
	return (RemoteElement)transac.returnData;
}
/**
 * 
 */
public void createGroup(String groupId)
	throws ElementExistsException, UserNotFoundException, NotAdministratorException
{	
/*	kxml.logic.distributed.CreateGroupLocTr transac = 
		new kxml.logic.distributed.CreateGroupLocTr(archive, getCurrentUser(), groupId);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementExistsException)
			throw((ElementExistsException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage));
	}
*/}
/**
 * This transaction creates the user corresponding to the provided information.
 * If the user identifier already exists the transaction may produce, 
 * considering security restrictions, the desired changes in the specified user.
 */
public void createUser(String userId, String passwd, boolean admin)
	throws UserNotFoundException, NotAdministratorException, CreationException
{	
	kxml.logic.distributed.CreateUserLocTr transac = 
		new kxml.logic.distributed.CreateUserLocTr(archive, getCurrentUser(), 
									   consistencyMngSrv, userId, passwd, admin);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof NotAdministratorException)
			throw((NotAdministratorException)transac.exception);
		else
			throw(new CreationException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void defineDocType(String typeId, String defaultCommand)
	throws UserNotFoundException, NotAdministratorException
{	
	kxml.logic.distributed.DefineDocTypeLocTr transac = 
		new kxml.logic.distributed.DefineDocTypeLocTr(archive, getCurrentUser(), 
									 consistencyMngSrv, typeId, defaultCommand);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void endModifying(String idElem, RemoteObserver observer,
						 boolean hasChanged) 
					throws ElementNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.EndModifyingLocTr transac = 
	  new kxml.logic.distributed.EndModifyingLocTr(archive, getCurrentUser(), 
  								 consistencyMngSrv, id, observer, hasChanged);
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		throw(new ElementNotFoundException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void endReading(String idElem, RemoteObserver observer) 
						throws ElementNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.local.EndReadingTr transac = 
	  new kxml.logic.local.EndReadingTr(archive, getCurrentUser(), id, observer);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		throw(new ElementNotFoundException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public String[] expandElement(String idElem, RemoteObserver observer) 
		throws ReadAccessException, ElementNotFoundException, UserNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.local.ExpandTr transac = 
			new kxml.logic.local.ExpandTr(archive, getCurrentUser(), id, observer);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new ReadAccessException(transac.exception.getMessage()));
	}
	
	return transac.contentIds;
}
/**
 * 
 */
public RemoteDocument fileDocument(String idElem, String metaxml)
					throws UserNotFoundException, ElementExistsException, 
						   WriteAccessException, CreationException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.FileDocLocTr transac = 
			new kxml.logic.distributed.FileDocLocTr(archive, currentUserId, 
							consistencyMngSrv, trOriginSrv, id, metaxml);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else if (transac.exception instanceof ElementExistsException)
			throw((ElementExistsException)transac.exception);
		else 
			throw((CreationException)transac.exception);
	}
	return (RemoteDocument)transac.returnData;
}
/**
 * 
 */
private String getCurrentUser() 
{
	return currentUserId;
}
/**
 * 
 */
public String[] getDocTypes()
{
	
/*	kxml.logic.local.GetDocTypesTr transac = 
			new kxml.logic.local.GetDocTypesTr(archive, getCurrentUser());
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	return transac.docTypes;
*/return null;}
/**
 * 
 */
public String[] getDTDs()
{
	
/*	kxml.logic.local.GetDTDsTr transac = 
			new kxml.logic.local.GetDTDsTr(archive, getCurrentUser());
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	return transac.dtds;
*/return null;}
/**
 * Returns a reference to the object identified by the element id.
 * From this reference the current metadata fields contents can be retrieved.
 */
public RemoteElement getElement(String idElem)
						throws ElementNotFoundException, ReadAccessException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.local.GetElementTr transac = 
			new kxml.logic.local.GetElementTr(archive, getCurrentUser(), id);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else
			throw((ReadAccessException)transac.exception);
	}

	return transac.element;
}
/**
 * 
 */
public String[] getXSLs(String dtdName) throws ElementNotFoundException
{
	
	kxml.logic.local.GetXSLsTr transac = 
			new kxml.logic.local.GetXSLsTr(archive, getCurrentUser(), dtdName);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}

	if (transac.exception != null)
	{
		throw((ElementNotFoundException)transac.exception);
	}
	
	return transac.xsls;
}
/**
 * 
 */
public String[] modifyDocument(String idElem, RemoteObserver observer) 
						throws WriteAccessException, ElementNotFoundException,
							   UserNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.ModifyDocLocTr transac = new kxml.logic.distributed.
		ModifyDocLocTr(archive, getCurrentUser(), consistencyMngSrv, id, observer);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else
			throw(new UserNotFoundException(transac.exception.getMessage()));	
	}

	String[] commAndUri = {transac.command, transac.uri.toString(), 
						   transac.docTypeId};
	return commAndUri;
}
/**
 * 
 */
public void modifyMetadata(String idElem, String metaxml)
					throws ElementNotFoundException, UserNotFoundException,
						   WriteAccessException, ModificationException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.ModifyMetaLocTr transac = 
			new kxml.logic.distributed.ModifyMetaLocTr(archive, currentUserId, 
										consistencyMngSrv, id, metaxml);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else
			throw(new ModificationException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void moveElement(String idElemTarget, String idElemDestination)
		 throws ElementNotFoundException, UserNotFoundException,
				ReadAccessException, WriteAccessException, CreationException
{
/*	IdElem idTarget = new IdElem(idElemTarget);
	IdElem idDestination = new IdElem(idElemDestination);
	
	kxml.logic.distributed.MoveElemLocTr transac = 
			new kxml.logic.distributed.MoveElemLocTr(archive, currentUserId, 
										consistencyMngSrv, idTarget, idDestination);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof ReadAccessException)
			throw((ReadAccessException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else
			throw(new CreationException(transac.exception.getMessage()));
	}
*/}
/**
 * 
 */
public String[] readDocument(String idElem, RemoteObserver observer) 
						throws ReadAccessException, ElementNotFoundException,
							   UserNotFoundException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.local.ReadDocumentTr transac = 
	  new kxml.logic.local.ReadDocumentTr(archive, getCurrentUser(), id, observer);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof ReadAccessException)
			throw((ReadAccessException)transac.exception);
		else
			throw(new UserNotFoundException(transac.exception.getMessage()));	
	}

	String[] commAndUri = {transac.command, transac.uri.toString(), transac.docTypeId};
	return commAndUri;
}
/**
 * 
 */
public void removeDocument(String idElem, boolean deleteContent)
		 throws ElementNotFoundException, UserNotFoundException,
				WriteAccessException, RemoveException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.RemoveDocLocTr transac = 
			new kxml.logic.distributed.RemoveDocLocTr(archive, currentUserId, 
									     consistencyMngSrv, id, deleteContent);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else
			throw(new RemoveException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void removeGroup(String groupId)
	throws ElementNotFoundException, UserNotFoundException, NotAdministratorException
{	
/*	kxml.logic.distributed.RemoveGroupLocTr transac = 
		new kxml.logic.distributed.RemoveGroupLocTr(archive, getCurrentUser(), groupId);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage));
	}
*/}
/**
 * 
 */
public void removeHElement(String idElem)
		 throws ElementNotFoundException, UserNotFoundException,
				WriteAccessException, RemoveException
{
	IdElem id = new IdElem(idElem);
	
	kxml.logic.distributed.RemoveHElemLocTr transac = 
			new kxml.logic.distributed.RemoveHElemLocTr(archive, currentUserId, 
													    consistencyMngSrv, id);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else if (transac.exception instanceof WriteAccessException)
			throw((WriteAccessException)transac.exception);
		else
			throw(new RemoveException(transac.exception.getMessage()));
	}
}
/**
 * 
 */
public void removeUser(String userId)
	throws ElementNotFoundException, UserNotFoundException, NotAdministratorException
{	
/*	kxml.logic.distributed.RemoveUserLocTr transac = 
		new kxml.logic.distributed.RemoveUserLocTr(archive, getCurrentUser(), userId);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage));
	}
*/}
/**
 * 
 */
public void removeUserGroup(String userId, String groupId)
	throws ElementNotFoundException, UserNotFoundException, 
		   NotAdministratorException
{	
/*	kxml.logic.distributed.RemoveUsrGrpLocTr transac = 
		new kxml.logic.distributed.RemoveUsrGrpLocTr(archive, getCurrentUser(), 
												  	 userId, groupId);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
	{
		if (transac.exception instanceof ElementNotFoundException)
			throw((ElementNotFoundException)transac.exception);
		else if (transac.exception instanceof UserNotFoundException)
			throw((UserNotFoundException)transac.exception);
		else
			throw(new NotAdministratorException(transac.exception.getMessage));
	}
*/}
/**
 * 
 */
private void setCurrentUser(String newValue) 
{
	this.currentUserId = newValue;
}
/**
 * 
 */
public String[] setUser(String userId, String passwd, BooleanHolder isAdmin) 
							throws IdentificationException
{
	kxml.logic.local.SetUserTr transac = 
			new kxml.logic.local.SetUserTr(archive, userId, passwd);
	
	transac.start();
	try 
	{
		transac.join();
	}
	catch(InterruptedException e)
	{}
	
	if (transac.exception != null)
		throw((IdentificationException)transac.exception);

	setCurrentUser(userId);
	isAdmin.value = transac.isAdmin;
	
	return transac.recentDocs;
}
}
