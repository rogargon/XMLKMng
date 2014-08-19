package kxml.logic.local;

import kxml.domain.*;
import kxml.logic.*;
import kxml.logic.exceptions.*;

public class SetUserTr extends Thread
{
	private Archive archive;
	private String userId;
	private String passwd;
	public boolean isAdmin;
	public String[] recentDocs;
	public Exception exception = null;
/**
 * 
 */
public SetUserTr(Archive archive, String userId, String passwd) 
{
	super();
	this.archive = archive;
	this.userId = userId;
	this.passwd = passwd;
}
/**
 * Obtains the identificators of the documents most recently used by 
 * the current user. If there's none, the archive root id is returned.
 */
public void run()
{
	User user = archive.dictionary.getUser(userId);
	
	if (user != null && user.passwordControl(passwd))
	{
		this.isAdmin = user.isAdmin();
		
		IdElem[] idElemArray = user.getRecentDocs();

		if (idElemArray.length > 0)
		{
			recentDocs = new String[idElemArray.length];
			for(int i=0; i<idElemArray.length; i++)
				recentDocs[i] = idElemArray[i].toString();
		}
		else	// If new user without recent docs init with help doc
		{
			String[] minimum = {archive.getIdStr() + 
						kxml.domain.util.Configuration.HELPLOCATION};
			recentDocs = minimum;
		}
	}
	else
	{
		if (user == null)
			exception = 
				new IdentificationException("SetUserTr: user not found");
		else
			exception =
				new	IdentificationException("SetUserTr: incorrect password");
	}
}
}
