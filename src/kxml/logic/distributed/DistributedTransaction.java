package kxml.logic.distributed;

import kxml.domain.Archive;
/**
 *  
 */
public abstract class DistributedTransaction extends Thread 
{
	protected long trNum;
	protected Archive archive;
/**
 * 
 */
public DistributedTransaction(long trNum, Archive archive) 
{
	super();
	this.trNum = trNum;
	this.archive = archive;
}
/**
 * 
 */
public abstract void run();
}
