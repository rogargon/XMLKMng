package kxml.logic.distributed;

import kxml.domain.*;
import kxml.domain.util.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
/**
 * 
 */
public class CreateUserDistTr extends DistributedTransaction 
{
	private String userId;
	private String passwd;
	private boolean isAdmin;
/**
 * 
 */
public CreateUserDistTr(long trNum, Archive archive, 
						String userId, String passwd, boolean isAdmin) 
{
	super(trNum, archive);
	this.userId = userId;
	this.passwd = passwd;
	this.isAdmin = isAdmin;
}
/**
 *
 */
public void run()
{
	Exception exception = null;
	String message = null;
	User user = archive.dictionary.getUser(userId);
	
	if (user != null)
	{
		user.changePassword(passwd);
		user.setAdmin(isAdmin);
		
		archive.logger.logMessage("CreateUserDistTr.run: changed user " + userId);
	}
	else
	{
		try
		{
			user = new User(userId, passwd, isAdmin, new IdElem[0]);
			archive.dictionary.addUser(user);
			archive.logger.logMessage("CreateUserDistTr.run: created user " + userId);
		}
		catch(RepeatedKeyException e)
		{
			message = "CreateUserDistTr.run: repeated key " + e.getMessage();
			exception = new CreationException(message);
			archive.logger.logMessage(message);
		}
	}

	archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
}
}
