package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.*;
import kxml.util.remote.RemoteObserver;
import java.net.URL;

public class EndReadingTr extends Thread
{
	private Archive archive;
	private String userId;
	private IdElem idElem;
	private RemoteObserver observer;
	public Exception exception = null;
/**
 * 
 */
public EndReadingTr(Archive archive, String userId, IdElem id, 
					RemoteObserver observer) 
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

	if (elem != null && (elem instanceof Document))
	{
		ContentBroker cBroker = ((Document)elem).getContentBroker();
		cBroker.endRead(this.observer);
	}
	else
		exception = new ElementNotFoundException("ReadDocumentTr: "+
										"document not found, "+idElem);
}
}
