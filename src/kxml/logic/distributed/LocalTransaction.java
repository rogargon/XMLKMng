package kxml.logic.distributed;

import kxml.domain.Archive;
/**
 *  
 */
public abstract class LocalTransaction extends Thread 
{
	protected Archive archive;
	protected String userId;
	protected ConsistencyManagerSrv consistencyMngSrv;
	public Object returnData = null;
	public Exception exception = null;
/**
 * 
 */
public LocalTransaction(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv) 
{
	super();
	this.archive = archive;
	this.userId = userId;
	this.consistencyMngSrv = consistencyMngSrv;
}
/**
 * 
 */
public abstract void run();
}
