package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.CorrelativeQueue;
import java.util.Hashtable;

public class ConsistencyManagerCltImpl extends _ConsistencyManagerCltImplBase
									   implements Runnable
{
	private Archive archive;
	private CorrelativeQueue pendings;
	private Thread selfThread;
	private Hashtable trEndWaiters;
	private int USERSPERREPLIC = 5;
/**
 * 
 */
public ConsistencyManagerCltImpl(Archive archive) 
{
	super();
	pendings = new CorrelativeQueue();
	this.archive = archive;
	this.archive.consistencyMngClt = this;
	selfThread = new Thread(this);
	selfThread.start();
	trEndWaiters = new Hashtable(USERSPERREPLIC);
}
/**
 * 
 */
public void addUsrGrp(long trNum, String userId, String groupId) 
{
	/*Thread transaction = new AddUsrGrpDistTr(trNum, archive, userId, groupId);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void associateXSL(long trNum, String xslName, 
						 String xslURL, String dtdName) 
{
	Thread transaction = 
		new AssociateXSLDistTr(trNum, archive, xslName, xslURL, dtdName);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void copyElem(long trNum, String idElemTarget, String idElemDestination) 
{
	IdElem idTarget = new IdElem(idElemTarget);
	IdElem idDestination = new IdElem(idElemDestination);
	
	/*Thread transaction = new CopyElemDistTr(trNum, archive, idTarget, idDestination);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void createElement(long trNum, String idElem, String metaxml) 
{
	IdElem id = new IdElem(idElem);
	Thread transaction = new CreateElemDistTr(trNum, archive, id, metaxml);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void createGroup(long trNum, String groupId) 
{
	/*Thread transaction = new CreateGroupDistTr(trNum, archive, groupId);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void createUser(long trNum, String userId, String passwd, boolean admin) 
{
	Thread transaction = new CreateUserDistTr(trNum, archive, userId, passwd, admin);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void defineDocType(long trNum, String typeId, String command) 
{	
	Thread transaction = new DefineDocTypeDistTr(trNum, archive, typeId, command);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void endModifying(long trNum, String idElem) 
{
	IdElem id = new IdElem(idElem);
	Thread transaction = new EndModifyingDistTr(trNum, archive, id);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void fileDocument(long trNum, String idElem, String metaxml) 
{
	IdElem id = new IdElem(idElem);
	Thread transaction = new FileDocDistTr(trNum, archive, id, metaxml);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void modifyDoc(long trNum, String idElem) 
{
	IdElem id = new IdElem(idElem);
	Thread transaction = new ModifyDocDistTr(trNum, archive, id);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void modifyMetadata(long trNum, String idElem, String metaxml) 
{
	IdElem id = new IdElem(idElem);
	Thread transaction = new ModifyMetaDistTr(trNum, archive, id, metaxml);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void moveElem(long trNum, String idElemTarget, String idElemDestination) 
{
	IdElem idTarget = new IdElem(idElemTarget);
	IdElem idDestination = new IdElem(idElemDestination);
	
	/*Thread transaction = new MoveElemDistTr(trNum, archive, idTarget, idDestination);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void notifyTrEnd(long trNum, Object returnData, Exception exception) 
{
	if (trEndWaiters.containsKey(Long.toString(trNum)))
	{
		LocalTransaction transac = 
					(LocalTransaction)trEndWaiters.get(Long.toString(trNum));
		trEndWaiters.remove(Long.toString(trNum));
		transac.returnData = returnData;
		transac.exception = exception;
		synchronized (transac)
		{	transac.notifyAll();	}
	}
}
/**
 * 
 */
public void removeDoc(long trNum, String idElem, boolean delContent) 
{
	IdElem id = new IdElem(idElem);
	
	Thread transaction = new RemoveDocDistTr(trNum, archive, id, delContent);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void removeGroup(long trNum, String groupId) 
{
	/*Thread transaction = new RemoveGroupDistTr(trNum, archive, groupId);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void removeHElem(long trNum, String idElem, String userId) 
{
	IdElem id = new IdElem(idElem);
	
	Thread transaction = new RemoveHElemDistTr(trNum, archive, id, userId);
	pendings.queue(trNum, transaction);
}
/**
 * 
 */
public void removeUser(long trNum, String userId) 
{
	/*Thread transaction = new RemoveUserDistTr(trNum, archive, userId);
	pendings.queue(trNum, transaction);*/
}
/**
 * 
 */
public void removeUsrGrp(long trNum, String userId, String groupId) 
{
	/*Thread transaction = new RemoveUsrGrpDistTr(trNum, archive, userId, groupId);
	pendings.queue(trNum, transaction);*/
}
/**
 * Garantees distributed transactions are executed in the same
 * order in all archive copies by waiting for their termination
 */
public void run() 
{
	while(true)
	{
		Thread transaction = (Thread)pendings.next();
		transaction.start();
		
		try 
		{
			transaction.join();
		}
		catch(InterruptedException e)
		{}
	}
}
/**
 * 
 */
public void waitTrEnd(long trNum, LocalTransaction transac) 
{
	trEndWaiters.put(Long.toString(trNum), transac);
	synchronized(transac) 
	{
		try {	transac.wait();	}
		catch(InterruptedException e){}
	}
}
}
