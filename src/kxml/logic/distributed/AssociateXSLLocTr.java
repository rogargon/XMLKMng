package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.domain.remote.RemoteElement;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.util.*;
import java.net.URL;

public class AssociateXSLLocTr extends LocalTransaction
{
	private String xslName;
	private URL xslURL;
	private String dtdName;
/**
 * 
 */
public AssociateXSLLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   String xslName, URL xslURL, String dtdName)
{
	super(archive, userId, consistencyMngSrv);
	this.xslName = xslName;
	this.xslURL = xslURL;
	this.dtdName = dtdName;
}
/**
 * 
 */
public void run()
{
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("CreateElemLocTr: "+
									"current user not found "+userId);
		return;
	}

	//get elem where creation will take place
	XMLType xmlType = (XMLType)archive.dictionary.getDocType("text/xml");
	if (xmlType == null)
	{
		exception = new CreationException("AssociateXSLLocTr: "+
			"XML document type not registered");
		return;
	}
	
	if (xmlType.containsDTD(dtdName))
	{
		long trNum = consistencyMngSrv.associateXSLDist(xslName, 
												xslURL.toString(), dtdName);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new CreationException("AssociateXSLLocTr: referenced "+
									"DTD isn't registered," +dtdName);
}
}
