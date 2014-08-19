package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.util.remote.RemoteObserver;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.net.URL;
import java.util.*;

public class RemoveHElemLocTr extends LocalTransaction
{
	private IdElem idElem;
/**
 * 
 */
public RemoveHElemLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, IdElem id)
{
	super(archive, userId, consistencyMngSrv);
	this.idElem = id;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem == null)
	{
		exception = new ElementNotFoundException("RemoveHElemLocTr: element "+
									idElem+" not found");
		return;
	}
		
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("RemoveHElemLocTr: "+
									"current user not found "+userId);
		return;
	}

	if ((elem instanceof HierarchyElement) && elem.writeAccess(userId))
	{
		Element parent = elem.getParent();
		if (parent.writeAccess(userId))
		{
			long trNum = consistencyMngSrv.removeHElemDist(
												idElem.toString(), userId);
			archive.consistencyMngClt.waitTrEnd(trNum, this);
		}
		else
			exception = new WriteAccessException("RemoveHElemLocTr: content "+
				"write access not allowed for container "+parent.getIdStr());
	}
	else
		exception = new WriteAccessException("RemoveHElemLocTr: "+
				"write access not allowed for hierarchy element "+idElem);
}
}
