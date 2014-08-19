package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.domain.remote.RemoteElement;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.util.*;
import java.io.*;

public class CreateElemLocTr extends LocalTransaction
{
	private IdElem idElem;
	private String metaxml;
/**
 * 
 */
public CreateElemLocTr(Archive archive, String userId, 
					   ConsistencyManagerSrv consistencyMngSrv, 
					   IdElem id, String metaxml)
{
	super(archive, userId, consistencyMngSrv);
	this.idElem = id;
	this.metaxml = metaxml;
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
	Element elem = archive.dictionary.getElem(idElem);

	if (elem == null || elem instanceof Document)
	{
		exception = new CreationException("CreateElemLocTr: "+
			"creation point should be an existent hierarchy element");
		return;
	}
	
	if (elem.writeAccess(userId))
	{
		// Test metadata begore distributing transaction
		RDFManager rdfMng = new RDFManager(new StringReader(this.metaxml));
		Hashtable attribs = rdfMng.getAttribsFromXML();
		if (attribs.containsKey("kxml:Owner"))
		{
			Object[] values = (Object[])attribs.get("kxml:Owner");
			if (!archive.dictionary.containsUser((String)values[1]))
			{
				exception = new UserNotFoundException("CreateElemLocTr: "+
								"new element owner not found "+values[1]);
				return;
			}
		}
		else
		{
			exception = new CreationException("CreateElemLocTr: "+
								"element owner not specified");
			return;
		}
		if (attribs.containsKey("DC:identifier"))
		{
			Object[] values = (Object[])attribs.get("DC:identifier");
			String locId = new IdElem((String)values[1]).getLocId();
			if (locId.trim().equals(""))
			{
				exception = new CreationException("CreateElemLocTr: "+
								"invalid local identifier");
				return;
			}
			// Ensure new element inside the creation point element
			IdElem newId = new IdElem(elem.getIdStr() + locId + "/");

			if (archive.dictionary.containsElem(newId))
			{
				exception = new ElementExistsException("CreateElemLocTr: "+
										"element exists "+newId);
				return;
			}
		}
		else
		{
			exception = new CreationException("CreateElemLocTr: "+
								"element identifier not specified");
			return;
		}
		long trNum = consistencyMngSrv.createElemDist(idElem.toString(), metaxml);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new WriteAccessException("CreateElemLocTr: write access "+
									"not allowed for" +userId+" on "+idElem);
}
}
