package kxml.logic.distributed;

import kxml.domain.*;
import kxml.domain.util.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
/**
 * 
 */
public class DefineDocTypeDistTr extends DistributedTransaction 
{
	private String typeId;
	private String command;
/**
 * 
 */
public DefineDocTypeDistTr(long trNum, Archive archive, 
						String typeId, String command) 
{
	super(trNum, archive);
	this.typeId = typeId;
	this.command = command;
}
/**
 *
 */
public void run()
{
	Exception exception = null;
	String message = null;
	DocType docType = archive.dictionary.getDocType(typeId);
	
	if (docType != null)
	{
		docType.setAplication(command);
		
		archive.logger.logMessage("DefineDocTypeDistTr.run: changed command " + typeId);
	}
	else
	{
		try
		{
			docType = new DocType(typeId);
			docType.setAplication(command);
			archive.dictionary.addDocType(docType);
			archive.logger.logMessage("DefineDocTypeDistTr.run: created docType " + typeId);
		}
		catch(RepeatedKeyException e)
		{
			message = "DefineDocTypeDistTr.run: repeated key " + e.getMessage();
			exception = new CreationException(message);
			archive.logger.logMessage(message);
		}
	}

	archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
}
}
