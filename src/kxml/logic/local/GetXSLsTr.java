package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import kxml.domain.remote.RemoteElement;

public class GetXSLsTr extends Thread
{
	private Archive archive;
	private String userId;
	private String dtdName;
	public String[] xsls = null;
	public Exception exception = null;
/**
 * 
 */
public GetXSLsTr(Archive archive, String userId, String dtdName) 
{
	super();
	this.archive = archive;
	this.userId = userId;
	this.dtdName = dtdName;
}
/**
 * 
 */
public void run() 
{
	XMLType xmlType = (XMLType)archive.dictionary.getDocType("text/xml");
	DTD dtd = xmlType.getDTD(dtdName);

	if (dtd != null)
	{
		XSL[] xslsArr = dtd.listXSLs();
		this.xsls = new String[xslsArr.length*2];
		
		for(int i=0; i<xslsArr.length; i++)
		{
			xsls[i*2] = xslsArr[i].getName();
			xsls[i*2+1] = xslsArr[i].getUri().toString();
		}
	}
	else
		exception = new ElementNotFoundException("GetXSLsTr: "+
												 "DTD not found, "+dtdName);
}
}
