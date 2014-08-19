package kxml.domain;

import kxml.util.*;
import kxml.domain.util.Configuration;
import java.util.Enumeration;

public class User extends ModifiableObj
{
	private String id;
	private boolean admin = false;
	private String password;
	private StackSet recentDocs;
/**
 * 
 */
public User(String id, String password, boolean administrator, IdElem[] recentDocs) 
{
	this.id = id;
	this.password = password;
	this.admin = administrator;
	this.recentDocs = new StackSet(Configuration.USERRECENTDOCS);

	if (recentDocs != null)
	{
		int i = recentDocs.length - 1;
		while(i>=0)
		{
			if (recentDocs[i]!=null)
				this.recentDocs.push(recentDocs[i]);
			i--;
		}
	}
}
/**
 * 
 */
public void changePassword(String newpass) 
{
	this.password = newpass;
}
/**
 * 
 */
public String getId() 
{
	return id;
}
/**
 * 
 */
public String getPasswd() 
{
	return password;
}
/**
 * At least RecentDocs contains the archive root, it's inserted during
 * user object creation.
 */
public IdElem[] getRecentDocs() 
{
	reading();
	
	IdElem[] list = new IdElem[recentDocs.size()];
	
	Enumeration e = recentDocs.elements();
	int i = 0;
	while(e.hasMoreElements())
	{
		list[i] = (IdElem)e.nextElement();
		i++;
	}

	endReading();
	
	return list;
}
/**
 * 
 */
public boolean isAdmin() 
{
	return admin;
}
/**
 * 
 */
public void lastDoc(Document doc) 
{
	writing();
	
	this.recentDocs.push(doc.getId());
	
	endWriting();
}
/**
 * 
 */
public boolean passwordControl(String pass)
{
	return this.password.equals(pass);
}
/**
 * 
 */
public void setAdmin(boolean isAdmin) 
{
	this.admin = isAdmin;
}
}
