package kxml.domain;

import kxml.domain.util.RepeatedKeyException;
import kxml.util.ModifiableHashtable;
import kxml.domain.util.Configuration;
import java.util.*;

public final class XMLType extends DocType
{
	private static XMLType xmltype = new XMLType("text/xml");
	//private Hashtable dtds;
	private ModifiableHashtable dtds;
/**
 * 
 */
private XMLType(String id) 
{
	super(id);
	
	dtds = new ModifiableHashtable(Configuration.XMLTYPEDTDS);
}
/**
 * 
 */
public void addDTD(DTD dtd) throws RepeatedKeyException
{
	dtds.writing();
	
	if (!dtds.data.containsKey(dtd.getName()))
		dtds.data.put(dtd.getName(), dtd);
	else
	{
		dtds.endWriting();
		throw(new RepeatedKeyException(dtd.getName()));
	}
	
	dtds.endWriting();
}
/**
 * 
 */
public boolean containsDTD(String id) 
{
	return dtds.data.containsKey(id);
}
/**
 * 
 */
public DTD getDTD(String name)
{
   return (DTD)dtds.data.get(name);
}
/**
 * 
 */
public static XMLType getHandler() 
{
	return xmltype;
}
/**
 * Sincronizado para evitar modificaciones mientras se contruye listado.
 */
public DTD[] listDTDs() 
{
	dtds.reading();
	
	DTD[] list = new DTD[dtds.data.size()];
	
	Enumeration e = dtds.data.elements();
	int i = 0;
	while(e.hasMoreElements())
	{
		list[i] = (DTD)e.nextElement();
		i++;
	}

	dtds.endReading();
	
	return list;
}
}
