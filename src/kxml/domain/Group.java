package kxml.domain;

import kxml.domain.util.Configuration;
import kxml.util.*;
import java.util.*;

public class Group extends ModifiableObj
{
	private String id;
	private HashSet members;
/**
 * 
 */
public Group(String id) 
{
	this.id = id;
	this.members = new HashSet(Configuration.GROUPMEMBERS);
}
/**
 * 
 */
public void add(User user) 
{
	writing();
	
	members.add(user);

	endWriting();
}
/**
 * 
 */
public boolean contains(User user) 
{
	boolean exists;

	reading();

	exists = members.contains(user);

	endReading();
	
	return exists;
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
public String[] listMembers() 
{
	reading();

	Iterator it = members.iterator();
	String[] membersIds = new String[members.size()];
	for(int i=0; it.hasNext(); i++)
		membersIds[i] = ((User)it.next()).getId();
	
	endReading();
	
	return membersIds;
}
/**
 * 
 */
public void remove(User user) 
{
	writing();
	
	members.remove(user);

	endWriting();
}
}
