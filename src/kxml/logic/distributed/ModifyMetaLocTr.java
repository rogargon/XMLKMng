package kxml.logic.distributed;

import kxml.domain.*;
import kxml.util.*;
import kxml.domain.remote.RemoteElement;
import kxml.logic.*;
import kxml.logic.exceptions.*;
import java.io.*;
import java.util.*;

public class ModifyMetaLocTr extends LocalTransaction
{
	private IdElem idElem;
	private String metaxml;
/**
 * 
 */
public ModifyMetaLocTr(Archive archive, String userId, 
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
	Element elem = archive.dictionary.getElem(idElem);

	if(elem == null)
	{
		exception = new ElementNotFoundException("ModifyMetaLocTr: element "+
									idElem+" not found");
		return;
	}
		
	if (!archive.dictionary.containsUser(userId))
	{
		exception = new UserNotFoundException("ModifyMetaLocTr: "+
									"current user not found "+userId);
		return;
	}
	
	if (elem.writeAccess(userId))
	{
		// Test metadata begore distributing transaction
		RDFManager rdfMng = new RDFManager(new StringReader(this.metaxml));
		Hashtable attribs = rdfMng.getAttribsFromXML();

		if (elem.isOwner(userId))
		{
			if (attribs.containsKey("kxml:Owner"))
			{
				String[] values = (String[])attribs.get("kxml:Owner");
				if (!archive.dictionary.containsUser(values[1]))
				{
					exception = new UserNotFoundException("ModifyMetaLocTr: "+
											"new owner not found "+values[1]);
					return;
				}
			}
			if (attribs.containsKey("DC:identifier"))
			{
				String[] values = (String[])attribs.get("DC:identifier");
				if (archive.dictionary.containsElem(new IdElem(values[1])))
				{
					exception = new ModificationException("ModifyMetaLocTr: "+
									"new identifier already used, "+values[1]);
					return;
				}
			}
		}
		else
		{
			if (attribs.containsKey("kxml:Owner") || attribs.containsKey("kxml:Read") ||
				attribs.containsKey("kxml:Write") || attribs.containsKey("URI") ||
				attribs.containsKey("DC:format") || attribs.containsKey("DC:identifier")
			   )
			{
				exception = new NotOwnerException("ModifyMetaLocTr: "+
											"user not owner, "+userId);
				return;
			}
		}
		
		long trNum = 
			consistencyMngSrv.modifyMetaDist(idElem.toString(), metaxml);
		archive.consistencyMngClt.waitTrEnd(trNum, this);
	}
	else
		exception = new WriteAccessException("ModifyMetaLocTr: write access "+
									"not allowed for" +userId+" on "+idElem);
}
}
