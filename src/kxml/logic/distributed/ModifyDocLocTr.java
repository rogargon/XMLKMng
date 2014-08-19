package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.util.remote.RemoteObserver;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.net.URL;
import java.util.*;

public class ModifyDocLocTr extends LocalTransaction
{
	private IdElem idElem;
	private RemoteObserver obs;
	public String command;
	public URL uri;
	public String docTypeId;
/**
 * 
 */
public ModifyDocLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   IdElem id, RemoteObserver obs)
{
	super(archive, userId, consistencyMngSrv);
	this.idElem = id;
	this.obs = obs;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem == null)
	{
		exception = new ElementNotFoundException("ModifyDocLocTr: element "+
									idElem+" not found");
		return;
	}
		
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("ModifyDocLocTr: "+
									"current user not found "+userId);
		return;
	}

	if ((elem instanceof Document) && elem.writeAccess(userId))
	{
		// Get application command to view document content and its URI
		docTypeId = ((Document)elem).getDocType().getId();
		command = ((Document)elem).getDocType().getAplication();
		uri = ((Document)elem).getUri();

		// Maintain user recently used documents list
		archive.dictionary.getUser(userId).lastDoc((Document)elem);

		// Notify globally new edition starting
		long trNum = 
			consistencyMngSrv.modifyDocDist(idElem.toString());
		archive.consistencyMngClt.waitTrEnd(trNum, this);
		
			
		// Register observer as writer of the document content
		if (obs != null)
			((Document)elem).getContentBroker().startWrite(obs);
	}
	else
		exception = new WriteAccessException("ModifyDocLocTr: "+
									"content write access not allowed");
}
}
