package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.*;
import kxml.util.remote.RemoteObserver;
import java.net.URL;

public class ReadDocumentTr extends Thread
{
	private Archive archive;
	private String userId;
	private IdElem idElem;
	private RemoteObserver observer;
	public String command;
	public URL uri;
	public String docTypeId;
	public Exception exception = null;
/**
 * 
 */
public ReadDocumentTr(Archive archive, String userId, IdElem id, RemoteObserver observer) 
{
	super();
	this.archive = archive;
	this.userId = userId;
	this.idElem = id;
	this.observer = observer;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if (elem != null && (elem instanceof Document) 
		&& elem.readAccess(userId))
	{
		// Get application command to view document content and its URI
		docTypeId = ((Document)elem).getDocType().getId();
		command = ((Document)elem).getDocType().getAplication();
		uri = ((Document)elem).getUri();

		// Maintain user recently used documents list
		archive.dictionary.getUser(userId).lastDoc((Document)elem);
			
		// Register observer as reader of the document content
		if (observer != null)
			((Document)elem).getContentBroker().startRead(observer);
	}
	else if (elem == null)
		exception = new ElementNotFoundException("ReadDocumentTr: "+
												 "element not found");
	else
		exception = new ReadAccessException("ReadDocumentTr: "+
									"content read access not allowed");
}
}
