package kxml.gui;

import java.io.*;
import kxml.util.*;
import java.util.*;
/**
 * 
 */
public class MetadataModel extends javax.swing.table.AbstractTableModel 
{
	final String[] colNames = {"Attributes","Values"};
	private Vector data = null;
	private Hashtable changes = null;
	private String idElem = null;
	private String docUri = null;
	private String docType = null;
	private boolean isDocument = false;

	private Hashtable currentNSs = new Hashtable();
	// Namespaces cache common for all instances of metadata model
	private static Hashtable nsCache = new Hashtable();
/**
 * 
 */
public MetadataModel(String metaxml) 
{
	data = new Vector();
	isDocument = false;
	// Extract "attribute-values" pairs from XML metadata
	if (metaxml == null || metaxml.length() == 0)
		return;
	
	RDFManager rdfExtr = new RDFManager(new StringReader(metaxml));
	Hashtable attribs = rdfExtr.getAttribsFromXML();

	if (attribs.containsKey("NS"))
	{
		manageNSs((String[][])attribs.get("NS"));
		attribs.remove("NS");
	}

	if (attribs.containsKey("kxml:Owner"))
	{
		data.add(attribs.get("kxml:Owner"));
		attribs.remove("kxml:Owner");
	}
	else
	{
		String[] defvals = {"kxml:Owner","not defined"};
		data.add(defvals);
	}
	if (attribs.containsKey("kxml:Read"))
	{
		data.add(attribs.get("kxml:Read"));
		attribs.remove("kxml:Read");
	}
	else
	{
		String[] defvals = {"kxml:Read","not defined"};
		data.add(defvals);
	}
	if (attribs.containsKey("kxml:Write"))
	{
		data.add(attribs.get("kxml:Write"));
		attribs.remove("kxml:Write");
	}
	else
	{
		String[] defvals = {"kxml:Read","not defined"};
		data.add(defvals);
	}
	if (attribs.containsKey("DC:identifier"))
	{
		Object[] values = (Object[])attribs.get("DC:identifier");
		data.add(values);
		attribs.remove("DC:identifier");
		this.idElem = (String)values[1];
	}
	else
	{
		String[] defvals = {"DC:identifier","not defined"};
		data.add(defvals);
		this.idElem = "not defined";
	}
	if (attribs.containsKey("DC:format"))
	{
		Object[] values = (Object[])attribs.get("DC:format");
		data.add(values);
		attribs.remove("DC:format");		// Attr. only allowed for docs
		isDocument = true;
		docType = (String)values[1];
	}
	if (attribs.containsKey("URI"))
	{
		Object[] values = (Object[])attribs.get("URI");
		data.add(values);
		attribs.remove("URI");					// Attr. only allowed for docs
		isDocument = true;
		docUri = (String)values[1];
	}
	if (!attribs.isEmpty())
	{
		Enumeration e = attribs.elements();
		while(e.hasMoreElements())
			data.add(e.nextElement());
	}

	changes = new Hashtable(data.size());
}
/**
 * 
 */
public void addAttribute(String attribName) 
{
	// Create a empty attribute entry
	String[] attribval = {attribName, ""};
	
	data.add(attribval);
	fireTableRowsInserted(data.size()-1, data.size()-1);
}
/**
 * Add a new namespace to the defined for the current element.
 * If the specified namespace is already defined change the asociated URI
 */
public void addNamespace(String nsRef, String nsUriStr) 
{
	if (!nsRef.startsWith("xmlns:"))
		nsRef = "xmlns:" + nsRef;
	if (!nsUriStr.endsWith("#"))
		nsUriStr += "#";
		
	String[] nsArray = {nsRef, nsUriStr};
	currentNSs.put(nsRef, nsArray);
	String nsKey = nsUriStr;
	
	if (!nsCache.containsKey(nsKey))
	{
		try
		{
			java.net.URL nsUri = new java.net.URL(nsUriStr);
			String[] nsAttribs = RDFManager.getDefinedAttributes(nsUri);
			nsCache.put(nsKey, nsAttribs);
		}
		catch(java.net.MalformedURLException e)
		{	
			System.out.println("MetadataModel.addNamespace ("+nsUriStr+"): " + e);
		}
	}
}
/**
 * 
 */
public void delAttribute(int row) 
{
	if (row < 0 || row > data.size()-1)
		return;
		
	String attribName = (String)((Object[])data.get(row))[0];
	
	if (changes.containsKey(attribName))
	{
		String[] empty = {attribName, ""};
		changes.put(attribName, empty);
	}
	
	data.remove(row);
	fireTableRowsDeleted(row, row);
}
/**
 *
 */
public Class getColumnClass(int c) 
{
	if (c == 0)
		return (String.class);
	else
		return (String[].class);
}
/**
 * 
 */
public int getColumnCount() 
{
	return colNames.length;
}
/**
 * 
 */
public String getColumnName(int col) 
{
	return colNames[col];
}
/**
 * 
 */
public String[][] getCurrentNSs() 
{
	String[][] nss = new String[currentNSs.size()][2];

	int i = 0;
	for(Enumeration e = currentNSs.elements(); e.hasMoreElements(); i++)
		nss[i] = (String[])e.nextElement();
	
	return nss;
}
/**
 * 
 */
public String getDocType() 
{
	return docType;
}
/**
 * 
 */
public String getDocUri() 
{
	return docUri;
}
/**
 * 
 */
public String getIdElem() 
{
	return idElem;
}
/**
 * Get a list of all the defined attributes for the specified
 * namespace, selected by its URI.
 */
public String[] getNSAttributes(String nsUri) 
{
	String[] attributes = null;

	if (nsCache.containsKey(nsUri))
		attributes = (String[])nsCache.get(nsUri);
		
	return attributes;
}
/**
 *
 */
public int getRowCount() 
{
	return data.size();
}
/**
 *
 */
public Object getValueAt(int rowIndex, int columnIndex) 
{
	if (columnIndex == 0)
		return ((Object[])data.get(rowIndex))[0];

	Object[] attrval = (Object[])data.get(rowIndex);
	String[] values = new String[attrval.length - 1];
	for(int i=1; i<attrval.length; i++)
		values[i-1] = (String)attrval[i];
	
	return values;
}
/**
 * Generates a XML-RDF representation of the attribute-values
 * in the model that have changed since the last confirm/cancel 
 * changes operation, this are, accordingly, confirmModel/restoreModel.
 */
public String getXMLFromChanges() 
{
	return RDFManager.getXMLFromAttribs(changes, getCurrentNSs());
}
/**
 * Generates a XML-RDF representation of all the attribute-values
 * in the model.
 */
public String getXMLFromModel() 
{
	Hashtable attribs = new Hashtable();

	for(Iterator it = data.iterator(); it.hasNext();)
	{
		Object[] attrib = (Object[])it.next();
		attribs.put(attrib[0], attrib);
	}
	
	return RDFManager.getXMLFromAttribs(attribs, getCurrentNSs());
}
/**
 *
 */
public boolean isCellEditable(int row, int col) 
{
	if (col > 0) 
		return true;
	else
		return false;
}
/**
 * 
 */
public boolean isDocument() 
{
	return isDocument;
}
/**
 * Scans provided Namespaces and adds to the NSCache all the attributes of 
 * the Namespaces not yet added to the NSCache
 */
public void manageNSs(String[][] nss) 
{
	currentNSs = new Hashtable(nss.length);
	
	for(int i=0; i<nss.length; i++)
	{
		currentNSs.put(nss[i][0], nss[i]);
		int separator = nss[i][0].indexOf(':');
		if (separator > 0)			// Don't add the basic xmlns namespace
		{
			String nsName = nss[i][0].substring(separator+1);
			if (!nsCache.containsKey(nss[i][1]))
			{
				try
				{
					java.net.URL nsUri = new java.net.URL(nss[i][1]);
					String[] nsAttribs = 
								RDFManager.getDefinedAttributes(nsUri);
					nsCache.put(nss[i][1], nsAttribs);
				}
				catch(java.net.MalformedURLException e)
				{	
					System.out.println("MetadataModel.manageNSs ("+
										nss[i][1]+"): " + e);   
				}
			}
		}
	}
}
/**
 * 
 */
public void newElemValues(String idBaseElem, String userId, boolean isDocument)
{
	boolean currentIsDoc = false;
	int rows = data.size();
	this.isDocument = isDocument;
	this.idElem = idBaseElem;
	
	for(int i=0; i<rows; i++)
	{
		String attrib = (String)((Object[])data.get(i))[0];
		String[] emptyAttrib = new String[2];
		emptyAttrib[0] = attrib;
		if (attrib.equals("DC:identifier"))
		{
			emptyAttrib[1] = idBaseElem + "New elem";
			if (!isDocument)
				emptyAttrib[1] += "/";
		}
		else if (attrib.equals("kxml:Owner"))
			emptyAttrib[1] = userId;
		else
		{
			if (attrib.equals("URI") || attrib.equals("DC:format"))
			{
				currentIsDoc = true;
				if (!isDocument)
					continue;
			}
			emptyAttrib[1] = "";
		}
		data.set(i, emptyAttrib);
	}
	
	if (!currentIsDoc && isDocument)
	{
		String[] uriAttrib = {"URI",""};
		String[] typeAttrib = {"DC:format",""};
		data.add(uriAttrib);
		data.add(typeAttrib);
	}
	fireTableDataChanged();
}
/**
 *
 */
public void setValueAt(Object value, int row, int col) 
{
	Object[] values = (Object[])value;
	Object[] attvalues = new Object[values.length+1];
	attvalues[0] = getValueAt(row, 0);
	for(int i=0; i<values.length; i++)
		attvalues[i+1] = values[i];
	changes.put(attvalues[0], attvalues);
	data.set(row, attvalues);
	fireTableCellUpdated(row, col);
}
}
