package kxml.logic.distributed;

import kxml.domain.*;
/**
 * 
 */
public class ModifyMetaDistTr extends DistributedTransaction 
{
	private IdElem id;
	private String metaxml;
/**
 * 
 */
public ModifyMetaDistTr(long trNum, Archive archive, IdElem id, String metaxml) 
{
	super(trNum, archive);
	this.id = id;
	this.metaxml = metaxml;
}
/**
 * 
 */
public void run() 
{
	Exception exception = null;
	String message = null;
	archive.logger.logMessage("ModifyMetaDistTr.run: changing meta for " + id);
	
	Element elem = archive.dictionary.getElem(id);
	if (elem == null)
	{
		message = "ModifyMetaDistTr.run: null elem " + id;
		archive.logger.logMessage(message);
		exception = new kxml.domain.util.NonexistentKeyException(message);
		archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
		return;
	}
		
	if (elem instanceof Document)
	{
		try
		{	((Document)elem).changeMeta(metaxml);	}
		catch(Exception e)
		{
			message = "ModifyMetaDistTr.run: "+e;
			exception = e;
			archive.logger.logMessage(message);	
		}
		archive.consistencyMngClt.notifyTrEnd(trNum, 
							((Document)elem).tie, exception);
	}
	else
	{
		try
		{	((HierarchyElement)elem).changeMeta(metaxml);	}
		catch(Exception e)
		{	
			message = "ModifyMetaDistTr.run: "+e;
			exception = e;
			archive.logger.logMessage(message);	
		}
		archive.consistencyMngClt.notifyTrEnd(trNum, 
							((HierarchyElement)elem).tie, exception);
	}
}
}
