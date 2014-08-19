package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.util.remote.RemoteObserver;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.net.URL;
import java.util.*;

public class RemoveDocLocTr extends LocalTransaction
{
	private IdElem idElem;
	private boolean delContent;
/**
 * 
 */
public RemoveDocLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   IdElem id, boolean delContent)
{
	super(archive, userId, consistencyMngSrv);
	this.idElem = id;
	this.delContent = delContent;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem == null)
	{
		exception = new ElementNotFoundException("RemoveDocLocTr: element "+
									idElem+" not found");
		return;
	}
		
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("RemoveDocLocTr: "+
									"current user not found "+userId);
		return;
	}

	if ((elem instanceof Document) && elem.writeAccess(userId))
	{
		Element parent = elem.getParent();
		if (parent.writeAccess(userId))
		{
			long trNum = consistencyMngSrv.removeDocDist(idElem.toString(), 
														 delContent);
			archive.consistencyMngClt.waitTrEnd(trNum, this);
		}
		else
			exception = new WriteAccessException("RemoveDocLocTr: content "+
				"write access not allowed for container "+parent.getIdStr());
	}
	else
		exception = new WriteAccessException("RemoveDocLocTr: "+
				"write access not allowed for document "+idElem);
}
}
