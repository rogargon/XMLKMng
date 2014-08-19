package kxml.logic.distributed;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.util.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class DefineDocTypeLocTr extends LocalTransaction
{
	private String docTypeId;
	private String command;
/**
 * 
 */
public DefineDocTypeLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv,
					   String docTypeId, String command)
{
	super(archive, userId, consistencyMngSrv);
	this.docTypeId = docTypeId;
	this.command = command;
}
/**
 * 
 */
public void run()
{
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("CreateUserLocTr: "+
									"current user not found, "+userId);
		return;
	}

	User currentUser = archive.dictionary.getUser(userId);
	
	// Current should be administrator
	if (currentUser.isAdmin())
	{
		long trNum = consistencyMngSrv.defineDocTypeDist(docTypeId, command);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new NotAdministratorException("CreateUserLocTr: "+
											"user not administrator, "+userId);
}
}
