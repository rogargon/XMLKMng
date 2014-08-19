package kxml.logic.distributed;

import kxml.domain.*;
/**
 * 
 */
public class RemoveDocDistTr extends DistributedTransaction 
{
	private IdElem id;
	private boolean delContent;
/**
 * 
 */
public RemoveDocDistTr(long trNum, Archive archive, IdElem id, boolean delContent) 
{
	super(trNum, archive);
	this.id = id;
	this.delContent = delContent;
}
/**
 * 
 */
public void run() 
{
	Exception exception = null;
	String message = null;
	
	Element elem = archive.dictionary.getElem(id);

	if (elem != null && (elem instanceof Document))
	{
		try
		{
			HierarchyElement parent = (HierarchyElement)elem.getParent();
			parent.unFile(elem, "administrator");
			elem.deleteObservers();
		}
		catch(kxml.domain.util.NonexistentKeyException e)
		{
			exception = e;
		}
	}
	else if (elem == null)
	{
		message = "RemoveDocDistTr.run: document not found, " + id;
		archive.logger.logMessage(message);
		exception = new kxml.domain.util.NonexistentKeyException(message);
	}
	else
	{
		message = "RemoveDocDistTr.run: element isn't a document, "+id;
		archive.logger.logMessage(message);
		exception = new kxml.logic.exceptions.WriteAccessException(message);
	}
	archive.consistencyMngClt.notifyTrEnd(trNum, 
								((Document)elem).tie, exception);
}
}
