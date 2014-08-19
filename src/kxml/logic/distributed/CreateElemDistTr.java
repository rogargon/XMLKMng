package kxml.logic.distributed;

import kxml.domain.*;
import kxml.domain.util.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
/**
 * 
 */
public class CreateElemDistTr extends DistributedTransaction 
{
	private IdElem id;
	private String metaxml;
/**
 * 
 */
public CreateElemDistTr(long trNum, Archive archive, IdElem id, String metaxml) 
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
	archive.logger.logMessage("CreateElemDistTr.run: creating element in " + id);

	Element elem = archive.dictionary.getElem(id);
	HierarchyElement newElem;
	
	if (elem instanceof	Archive)
		newElem = new Cabinet(archive);
	else if (elem instanceof Cabinet)
		newElem = new Drawer(archive);
	else
		newElem = new Folder(archive);

	try
	{
		newElem.changeMeta(metaxml);
		((HierarchyElement)elem).file(newElem);
	}
	catch(RepeatedKeyException e)
	{
		message = "CreateElemDistTr.run: "+"repeated key " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	catch(NonexistentKeyException e)
	{
		message = "CreateElemDistTr.run: "+"nonexistent " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	catch(InvalidKeyException e)
	{
		message = "CreateElemDistTr.run: "+"invalid key " + e.getMessage();
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	archive.logger.logMessage("CreateElemDistTr.run: "+
							  "element created " + newElem.getIdStr());
	
	archive.consistencyMngClt.notifyTrEnd(trNum, newElem.tie, exception);
}
}
