package kxml.logic.distributed;

import kxml.domain.IdElem;
import java.util.*;

public class ConsistencyManagerSrvImpl extends _ConsistencyManagerSrvImplBase
{
	private Vector clients;

	private int users = 0;
	private int lockers = 0;
	private boolean locked = false;
	private Object queue = new Object();
	private Object lockersQueue = new Object();
	
	private long currentTrNumber = 0;
/**
 *
 */
public ConsistencyManagerSrvImpl() 
{
	clients = new Vector(1);
}
/**
 * 
 */
public void addClientManager(ConsistencyManagerClt consistencyMngClt) 
{
	lock();
	
	clients.addElement(consistencyMngClt);

	unlock();
}
/**
 * 
 */
public long addUsrGrpDist(String userId, String groupId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).addUsrGrp(trNumber, userId, groupId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long associateXSLDist(String xslName, String xslURL, String dtdName)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).
					associateXSL(trNumber, xslName, xslURL, dtdName);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long copyElemDist(String idElemTarget, String idElemDestination)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).
				copyElem(trNumber, idElemTarget, idElemDestination);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long createElemDist(String idElem, String metaxml)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).createElement(trNumber, idElem, metaxml);
	
	endUse();
	return trNumber;
}
/**
 * 
 */
public long createGroupDist(String groupId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).createGroup(trNumber, groupId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long createUserDist(String userId, String passwd, boolean admin)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).
					createUser(trNumber, userId, passwd, admin);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long defineDocTypeDist(String typeId, String command)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).defineDocType(trNumber, typeId, command);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long endModifyingDist(String idElem)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).endModifying(trNumber, idElem);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
private synchronized void endUse() 
{
	users--;
	if (users == 0 && lockers > 0)		//Last user, lockers waiting
	{
		synchronized(lockersQueue)
		{
			lockersQueue.notifyAll();	//Wakeup all lockers
		}
	}
}
/**
 * 
 */
public long fileDocDist(String idElem, String metaxml)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).fileDocument(trNumber, idElem, metaxml);
	
	endUse();
	return trNumber;
}
/**
 * 
 */
private synchronized long getTrNumber() 
{
	return currentTrNumber++;
}
/**
 * 
 */
public synchronized void lock() 
{
	// Lockers can operate simultaneously
	lockers++;							// Annotate locker waiting or operating
	
	while(users > 0)
	{
		synchronized(lockersQueue)		// While users lock in lockers queue
		{
			try {lockersQueue.wait();}
			catch(InterruptedException e){}
		}
	}

	locked = true;
}
/**
 * 
 */
public long modifyDocDist(String idElem)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).modifyDoc(trNumber, idElem);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long modifyMetaDist(String idElem, String metaxml)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).modifyMetadata(trNumber, idElem, metaxml);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long moveElemDist(String idElemTarget, String idElemDestination)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).
				moveElem(trNumber, idElemTarget, idElemDestination);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public void removeClientManager(ConsistencyManagerClt consistencyMngClt) 
{
	lock();

	boolean found = false;
	Iterator it = clients.iterator();

	while(it.hasNext() && !found)
	{
		Object current = it.next();
		if (!(current instanceof ConsistencyManagerCltImpl))
		{
			ConsistencyManagerClt currCMngClt = (ConsistencyManagerClt)current;
			if (consistencyMngClt._is_equivalent(currCMngClt))
			{
				clients.removeElement(currCMngClt);
				found = true;
			}
		}
	}

	unlock();
}
/**
 * 
 */
public long removeDocDist(String idElem, boolean delContent)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).removeDoc(trNumber, idElem, delContent);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long removeGroupDist(String groupId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).removeGroup(trNumber, groupId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long removeHElemDist(String idElem, String userId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).removeHElem(trNumber, idElem, userId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long removeUserDist(String userId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).removeUser(trNumber, userId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public long removeUsrGrpDist(String userId, String groupId)
{
	use();

	long trNumber = getTrNumber();
	
	for(Iterator it = clients.iterator(); it.hasNext();)
		((ConsistencyManagerClt)it.next()).removeUsrGrp(trNumber, userId, groupId);
	
	endUse();

	return trNumber;
}
/**
 * 
 */
public synchronized void unlock() 
{
	lockers--;

	if (lockers == 0)
	{
		locked = false;
		synchronized(queue)
		{
			queue.notifyAll();			// Wakeup users
		}
	}
}
/**
 * 
 */
private synchronized void use() 
{
	while (lockers > 0 || locked)
	{
		synchronized(queue)				// Locked or waiting lockers with 
		{								// priority.
			try {queue.wait();}
			catch(InterruptedException e){}
		}
	}
	
	users++;
}
}
