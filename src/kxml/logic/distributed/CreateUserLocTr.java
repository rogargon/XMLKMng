package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.domain.remote.RemoteElement;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.io.*;
import java.util.*;

public class CreateUserLocTr extends LocalTransaction
{
	private String newUserId;
	private String passwd;
	private boolean makeAdmin;
/**
 * 
 */
public CreateUserLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   String newUserId, String passwd, boolean makeAdmin)
{
	super(archive, userId, consistencyMngSrv);
	this.newUserId = newUserId;
	this.passwd = passwd;
	this.makeAdmin = makeAdmin;
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
	
	// Current user is administrator or user not administrator
	// trying to change his passwd but not making himself admin.
	if (currentUser.isAdmin() || (userId.equals(newUserId) && !makeAdmin))
	{
		long trNum = consistencyMngSrv.createUserDist(newUserId, passwd, makeAdmin);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new NotAdministratorException("CreateUserLocTr: "+
											"user not administrator, "+userId);
}
}
