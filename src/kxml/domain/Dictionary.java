package kxml.domain;

import kxml.domain.util.*;
import kxml.util.ModifiableHashtable;
import java.util.Enumeration;

public class Dictionary
{
	private ModifiableIdElemHashtable elements;
	private ModifiableHashtable users;
	private ModifiableHashtable groups;
	private ModifiableHashtable docTypes;
	//private ModifiableHashtable dtds;
/**
 * 
 */
public Dictionary() 
{
	super();
	elements = new ModifiableIdElemHashtable(Configuration.DICTIONARYELEMENTS);
	users = new ModifiableHashtable(Configuration.DICTIONARYUSERS);
	groups = new ModifiableHashtable(Configuration.DICTIONARYGROUPS);
	docTypes = new ModifiableHashtable(Configuration.DICTIONARYDOCTYPES);
}
/**
 * 
 */
public void addDocType(DocType doctype) throws RepeatedKeyException
{
	docTypes.writing();
	
	if (!docTypes.data.containsKey(doctype.getId()))
		docTypes.data.put(doctype.getId(), doctype);
	else
	{
		docTypes.endWriting();
		throw(new RepeatedKeyException(doctype.getId()));
	}
	
	docTypes.endWriting();
}
/**
 * 
 */
public void addElem(Element elem) throws RepeatedKeyException
{
	elements.writing();
	
	if (!elements.containsKey(elem.getId()))
		elements.put(elem.getId(), elem);
	else
	{
		elements.endWriting();
		throw(new RepeatedKeyException(elem.getId().toString()));
	}
	
	elements.endWriting();
}
/**
 * 
 */
public void addGroup(Group group) throws RepeatedKeyException
{
	groups.writing();
	
	if (!groups.data.containsKey(group.getId()))
		groups.data.put(group.getId(), group);
	else
	{
		groups.endWriting();
		throw(new RepeatedKeyException(group.getId()));
	}

	groups.endWriting();
}
/**
 * 
 */
public void addUser(User user) throws RepeatedKeyException
{
	users.writing();
	
	if (!users.data.containsKey(user.getId()))
		users.data.put(user.getId(), user);
	else
	{
		users.endWriting();
		throw(new RepeatedKeyException(user.getId()));
	}

	users.endWriting();
}
/**
 * 
 */
public void changeIdElem(IdElem oldId, IdElem newId) 
				throws RepeatedKeyException, NonexistentKeyException
{
	elements.writing();
	
	if (elements.containsKey(newId))
	{
		elements.endWriting();
		throw(new RepeatedKeyException(newId.toString()));
	}
	else if (!elements.containsKey(oldId))
	{
		elements.endWriting();
		throw(new NonexistentKeyException(oldId.toString()));
	}
	else
		elements.changeKey(oldId, newId);

	elements.endWriting();
}
/**
 * 
 */
public boolean containsDocType(String id) 
{
	return docTypes.data.containsKey(id);
}
/**
 * 
 */
public boolean containsElem(IdElem id) 
{
	return elements.containsKey(id);
}
/**
 * 
 */
public boolean containsUser(String id) 
{
	return users.data.containsKey(id);
}
/**
 * 
 */
public DocType getDocType(String id) 
{
	return (DocType)docTypes.data.get(id);
}
/**
 * 
 */
public Element getElem(IdElem id) 
{
	return elements.get(id);
}
/**
 * 
 */
public User getUser(String id) 
{
	return (User)users.data.get(id);
}
/**
 * 
 */
public DocType[] listDocTypes() 
{
	docTypes.reading();

	Enumeration e = docTypes.data.elements();
	DocType[] docTypesArr = new DocType[docTypes.data.size()];
	for(int i=0; e.hasMoreElements(); i++)
		docTypesArr[i] = (DocType)e.nextElement();
	
	docTypes.endReading();
	
	return docTypesArr;
}
/**
 * 
 */
public Group[] listGroups() 
{
	groups.reading();

	Enumeration e = groups.data.elements();
	Group[] groupsArr = new Group[groups.data.size()];
	for(int i=0; e.hasMoreElements(); i++)
		groupsArr[i] = (Group)e.nextElement();
	
	groups.endReading();
	
	return groupsArr;
}
/**
 * 
 */
public User[] listUsers() 
{
	users.reading();

	Enumeration e = users.data.elements();
	User[] usersArr = new User[users.data.size()];
	for(int i=0; e.hasMoreElements(); i++)
		usersArr[i] = (User)e.nextElement();
	
	users.endReading();
	
	return usersArr;
}
/**
 * 
 */
public void removeElem(IdElem id) 
{
	elements.writing();
	
	elements.remove(id);

	elements.endWriting();
}
}
