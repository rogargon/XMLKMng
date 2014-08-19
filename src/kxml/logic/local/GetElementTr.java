package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.RemoteElement;

public class GetElementTr extends Thread
{
	private Archive archive;
	private String userId;
	private IdElem idElem;
	public RemoteElement element;
	public Exception exception = null;
/**
 * 
 */
public GetElementTr(Archive archive, String userId, IdElem id) 
{
	super();
	this.archive = archive;
	this.userId = userId;
	this.idElem = id;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if (elem != null && elem.readAccess(userId))
	{
		if ((elem instanceof HierarchyElement))
			this.element = ((HierarchyElement)elem).tie;
		else
			this.element = ((Document)elem).tie;			
	}
	else if (elem == null)
		exception = new ElementNotFoundException("ShowMetadataTr: "+
												 "element not found");
	else
		exception = new ReadAccessException("ShowMetadataTr: "+
									"contents read access not allowed");
}
}
