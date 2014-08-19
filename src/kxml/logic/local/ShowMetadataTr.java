package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.RemoteElement;

public class ShowMetadataTr extends Thread
{
	private Archive archive;
	private IdElem idElem;
	public RemoteElement element;
	public Exception exception = null;
/**
 * 
 */
public ShowMetadataTr(Archive archive, IdElem id) 
{
	super();
	this.archive = archive;
	this.idElem = id;
}
/**
 * 
 */
public void run() 
{
	Element elem = archive.dictionary.getElem(idElem);

	if(elem != null)
	{
		if ((elem instanceof HierarchyElement))
			this.element = ((HierarchyElement)elem).tie;
		else
			this.element = ((Document)elem).tie;			
	}
	else
		exception = 
			new ElementNotFoundException("ShowMetadataTr: element not found");
}
}
