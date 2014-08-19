package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.util.remote.RemoteObserver;

public class CollapseTr extends Thread
{
	private Archive archive;
	private IdElem idElem;
	private RemoteObserver observer;
	public Exception exception = null;
/**
 * 
 */
public CollapseTr(Archive archive, IdElem idElem, RemoteObserver observer) 
{
	super();
	this.archive = archive;
	this.idElem = idElem;
	this.observer = observer;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem != null && observer != null && 
	   (elem instanceof HierarchyElement))
	{
		// The element isn't longer observed by the current view
		elem.deleteObserver(observer);
	}
	else if (elem == null)
		exception = new ElementNotFoundException("CollapseTr: "+
												 "element not found");
}
}
