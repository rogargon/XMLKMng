package kxml.logic.distributed;

import kxml.domain.*;
import kxml.domain.util.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;
/**
 * 
 */
public class AssociateXSLDistTr extends DistributedTransaction 
{
	private String xslName;
	private String xslURLStr;
	private String dtdName;
/**
 * 
 */
public AssociateXSLDistTr(long trNum, Archive archive, 
						String xslName, String xslURLStr, String dtdName) 
{
	super(trNum, archive);
	this.xslName = xslName;
	this.xslURLStr = xslURLStr;
	this.dtdName = dtdName;
}
/**
 *
 */
public void run()
{
	Exception exception = null;
	String message = null;
	XMLType xmlType = (XMLType)archive.dictionary.getDocType("text/xml");
	if (xmlType == null)
	{
		exception = new CreationException("AssociateXSLDistTr: "+
			"XML document type not registered");
		return;
	}

	DTD dtd = xmlType.getDTD(dtdName);
	if (dtd != null)
	{
		XSL xsl = dtd.getXSL(xslName);
		java.net.URL xslURL = null;
		try { xslURL = new java.net.URL(xslURLStr); }
		catch(java.net.MalformedURLException e){}
		if (xsl == null)
		{
			xsl = new XSL(xslName, xslURL);
			try { dtd.asociateXSL(xsl); }
			catch(RepeatedKeyException e){}
		}
		else
		{
			xsl.setUri(xslURL);
			archive.logger.logMessage("AssociateXSLDistTr.run: "+
									  "changed XSL URL " + xslURLStr);
		}
	}
	else
	{
		message = "AssociateXSLDistTr.run: referenced DTD not found " +
				   dtdName;
		exception = new CreationException(message);
		archive.logger.logMessage(message);
	}
	archive.consistencyMngClt.notifyTrEnd(trNum, null, exception);
}
}
