package kxml.logic.distributed;

import kxml.domain.*;
/**
 * 
 */
public class ModifyDocDistTr extends DistributedTransaction 
{
	private IdElem id;
/**
 * 
 */
public ModifyDocDistTr(long trNum, Archive archive, IdElem id) 
{
	super(trNum, archive);
	this.id = id;
}
/**
 * 
 */
public void run() 
{
	Exception exception = null;
	String message = null;
	archive.logger.logMessage("ModifyDocDistTr.run: edition start for " + id);
	
	Element elem = archive.dictionary.getElem(id);

	if (elem != null && (elem instanceof Document))
	{
		((Document)elem).getContentBroker().startingWriting();

	}
	else if (elem == null)
	{
		message = "ModifyDocDistTr.run: document not found, " + id;
		archive.logger.logMessage(message);
		exception = new kxml.domain.util.NonexistentKeyException(message);
	}
	else
	{
		message = "ModifyDocDistTr.run: element isn't a document, "+id;
		archive.logger.logMessage(message);
		exception = new kxml.logic.exceptions.WriteAccessException(message);
	}
	archive.consistencyMngClt.notifyTrEnd(trNum, 
								((Document)elem).tie, exception);
}
}
