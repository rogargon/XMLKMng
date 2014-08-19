package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.util.remote.RemoteObserver;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.net.URL;
import java.util.*;

public class EndModifyingLocTr extends LocalTransaction
{
	private IdElem idElem;
	private RemoteObserver obs;
	private boolean hasChanged;

/**
 * 
 */
public EndModifyingLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   IdElem id, RemoteObserver obs, boolean hasChanged)
{
	super(archive, userId, consistencyMngSrv);
	this.idElem = id;
	this.obs = obs;
	this.hasChanged = hasChanged;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem == null)
	{
		exception = new ElementNotFoundException("EndModifyLocTr: element "+
									idElem+" not found");
		return;
	}
		
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("EndModifyLocTr: "+
									"current user not found "+userId);
		return;
	}

	if ((elem instanceof Document) && elem.writeAccess(userId))
	{
		// Unregister observer as writer of the document content
		((Document)elem).getContentBroker().endWrite(obs);


		// Notify globally content modification if it has changed
		if (hasChanged)
		{
			long trNum = consistencyMngSrv.endModifyingDist(idElem.toString());
			archive.consistencyMngClt.waitTrEnd(trNum, this);
		}
	}
	else
		exception = new WriteAccessException("EndModifyLocTr: "+
									"content write access not allowed");
}
}
