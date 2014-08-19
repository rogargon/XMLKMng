package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.*;
import kxml.util.remote.RemoteObserver;

public class ExpandTr extends Thread
{
	private Archive archive;
	private String userId;
	private IdElem idElem;
	private RemoteObserver observer;
	public String[] contentIds;
	public Exception exception = null;
/**
 * 
 */
public ExpandTr(Archive archive, String userId, IdElem id, RemoteObserver observer) 
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

	if (elem != null && (elem instanceof HierarchyElement) 
		&& elem.readAccess(userId))
	{
		Element[] content = ((HierarchyElement)elem).content();
		contentIds = new String[content.length];
		for(int i=0; i<content.length; i++)
			contentIds[i] = content[i].getIdStr();
			
		// The expanded node will be observed by the current view
		if (observer != null)
			elem.addObserver(observer);
	}
	else if (elem == null)
		exception = new ElementNotFoundException("ExpandTr: "+
												 "element not found");
	else
		exception = new ReadAccessException("ExpandTr: "+
									"contents read access not allowed");
}
}
