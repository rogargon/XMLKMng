package kxml.logic.distributed;

import kxml.domain.*;
/**
 * 
 */
public class RemoveHElemDistTr extends DistributedTransaction 
{
	private IdElem id;
	private String userId;
/**
 * 
 */
public RemoveHElemDistTr(long trNum, Archive archive, IdElem id, String userId) 
{
	super(trNum, archive);
	this.id = id;
	this.userId = userId;
}
/**
 * 
 */
public void run() 
{
	Exception exception = null;
	String message = null;
	
	Element elem = archive.dictionary.getElem(id);

	if (elem != null && (elem instanceof HierarchyElement))
	{
		try
		{
			HierarchyElement parent = (HierarchyElement)elem.getParent();
			parent.unFile(elem, userId);
			elem.deleteObservers();
		}
		catch(kxml.domain.util.NonexistentKeyException e)
		{
			exception = e;
		}
	}
	else if (elem == null)
	{
		message = "RemoveHElemDistTr.run: hierarchy element not found, " + id;
		archive.logger.logMessage(message);
		exception = new kxml.domain.util.NonexistentKeyException(message);
	}
	else
	{
		message = "RemoveHElemDistTr.run: it isn't a hierarchy element, "+id;
		archive.logger.logMessage(message);
		exception = new kxml.logic.exceptions.WriteAccessException(message);
	}
	archive.consistencyMngClt.notifyTrEnd(trNum, 
								((HierarchyElement)elem).tie, exception);
}
}
