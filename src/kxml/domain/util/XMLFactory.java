package kxml.domain.util;

import kxml.domain.*;
import kxml.util.*;
import kxml.domain.util.*;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.dom.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class XMLFactory
{
	private Object input;
	private Archive archive;

	public static String ARCHIVE_HEADER =
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE kxml:Archive SYSTEM \"archive.dtd\">\n";

	public static String ARCHIVE_FOOT = "";
/**
 * 
 */
public XMLFactory(InputStream input) 
{
	this.input = input;
}
/**
 * 
 */
public XMLFactory(Reader input) 
{
	this.input = input;
}
/**
 * 
 */
public void getArchiveFromXML(Archive archive) 
{
	this.archive = archive;
	org.w3c.dom.Node node = parse();

	try // Register itself in the dictionary
	{
		archive.dictionary.addElem(archive);
	}
	catch(RepeatedKeyException exc){}
	
	traverse(node, null);
	
	try // Ensure default user
	{
		archive.dictionary.addUser(
					new User("administrator", "", true, null));
	}
	catch(kxml.domain.util.RepeatedKeyException exc){}
	
	try // At least this doctypes
	{
		DocType xmlType = XMLType.getHandler();
		xmlType.setAplication("kxml.gui.xml.XMLEditorTab.class");
		archive.dictionary.addDocType(xmlType);
	}
	catch(RepeatedKeyException e){}
	try
	{
		DocType txtType = new DocType("text/plain");
		txtType.setAplication("kxml.gui.TextEditorTab.class");
		archive.dictionary.addDocType(txtType);
	}
	catch(RepeatedKeyException e){}
	try
	{
		DocType htmlType = new DocType("text/html");
		htmlType.setAplication("kxml.gui.HTMLEditorTab.class");
		archive.dictionary.addDocType(htmlType);
	}
	catch(RepeatedKeyException e){}	
		
	// Ensure initial structures referencing application help
	IdElem helpId = new IdElem(archive.getIdStr()+Configuration.HELPLOCATION);
	if (!archive.dictionary.containsElem(helpId))
	{
		URL helpUrl = null;
		try
		{	helpUrl = new URL("file:./help/main.html");	 }
		catch(MalformedURLException e){}
		
		Object[] hierarchySteps = helpId.toArray();
		String currentNodeId = archive.getIdStr();
		User defaultAdmin = archive.dictionary.getUser("administrator");
		HierarchyElement parent = null;
		kxml.domain.Element newElem = archive;
		for(int i=1; i<hierarchySteps.length; i++)
		{
			// Construct current node id and mark as HierarchyElement if needed
			currentNodeId = (String)hierarchySteps[i];
			/*if (i<hierarchySteps.length-1)
				currentNodeId += "/";
			*/
			parent = (HierarchyElement)newElem;
				
			if (parent instanceof Archive)
				newElem = new Cabinet(archive, currentNodeId, null, defaultAdmin,
									  true, false, null, new HashSet(0));
			else if (parent instanceof Cabinet)
				newElem = new Drawer(archive, currentNodeId, null, defaultAdmin,
									 true, false, null, new HashSet(0));
			else if (parent instanceof Drawer)
				newElem = new Folder(archive, currentNodeId, null, defaultAdmin,
									 true, false, null, new HashSet(0));
			else if (parent instanceof Folder)
				newElem = new kxml.domain.Document(archive, currentNodeId, null, 
					defaultAdmin, true, false, null, new HashSet(0), 
					helpUrl, archive.dictionary.getDocType("text/html"));
			
			try
			{
				parent.file(newElem);
			}
			catch(Exception e)
			{}
		}
	}
}
/**
 * 
 */
private void getDocTypesFromMeta(Node node) 
{
	org.w3c.dom.Element eTmp = (org.w3c.dom.Element)node;
	NodeList listE;
	DocType doctype;
	
	listE = eTmp.getElementsByTagName("kxml:DocType");
	int n = listE.getLength();
	for (int i=0; i<n; i++)
	{
		eTmp = (org.w3c.dom.Element)listE.item(i);
		String typeId = eTmp.getAttribute("id");
		if (typeId.equals("text/xml"))
			doctype = XMLType.getHandler();
		else
			doctype = new DocType(typeId);
		try
		{
			doctype.setAplication(eTmp.getAttribute("command"));
			archive.dictionary.addDocType(doctype);
		}
		catch(RepeatedKeyException e){};			// Ignore repeated doctypes
	}
}
/**
 * 
 */
private void getDTDsFromMeta(Node node) 
{
	org.w3c.dom.Element eTmp = (org.w3c.dom.Element)node;
	NodeList listE;
	XMLType xmlType = null;
	
	
	listE = eTmp.getElementsByTagName("kxml:Dtd");
	int n = listE.getLength();

	if (n > 0)
		xmlType = (XMLType)archive.dictionary.getDocType("text/xml");
	
	for (int i=0; i<n; i++)
	{
		eTmp = (org.w3c.dom.Element)listE.item(i);
		String dtdName = eTmp.getAttribute("name");
		try
		{
			URL dtdUri = new URL(eTmp.getAttribute("uri"));
			DTD dtd = new DTD(dtdName, dtdUri);
			xmlType.addDTD(dtd);

			NodeList listXSL = eTmp.getElementsByTagName("kxml:Xsl");
			int c = listXSL.getLength();
			for (int j=0; j<c; j++)
			{
				org.w3c.dom.Element xslE = (org.w3c.dom.Element)listXSL.item(j);
				try
				{
					URL xslUri = new URL(xslE.getAttribute("uri"));
					XSL xsl = new XSL(xslE.getAttribute("name"), xslUri);
					dtd.asociateXSL(xsl);
				}
				catch(RepeatedKeyException e){}		// Ignore repeated XSLs
				catch(MalformedURLException e){} 	// Ignore erroneous XSLs
			}
		}
		catch(RepeatedKeyException e){}				// Ignore repeated DTDs
		catch(MalformedURLException e){}			// Ignore erroneous DTDs
	}
}
/**
 * 
 */
private void getGroupsFromMeta(Node node) 
{
	org.w3c.dom.Element eTmp = (org.w3c.dom.Element)node;
	NodeList listE;
	
	listE = eTmp.getElementsByTagName("kxml:Group");
	int n = listE.getLength();
	for (int i=0; i<n; i++)
	{
		eTmp = (org.w3c.dom.Element)listE.item(i);
		try
		{										// Ignore repeated groups
			Group group = new Group(eTmp.getAttribute("id"));
			String userId;
			User usMember;
			
			archive.dictionary.addGroup(group);
			
			NodeList members = eTmp.getElementsByTagName("kxml:Member");
			int m = members.getLength();
			for (int j=0; j<m; j++)
			{
				userId = ((org.w3c.dom.Element)members.item(j)).getAttribute("id");
				usMember = archive.dictionary.getUser(userId);
				group.add(usMember);
			}
		} 
		catch(RepeatedKeyException e){};
	}
}
/**
 * 
 */
private static String getMetaFromContent(HierarchyElement hElem) 
{
	boolean isFolder = false;
	boolean isDocument = false;
	String metaxml = new String("<kxml:Content><Bag>\n");

	String contentType = null;
	if (hElem instanceof Archive)
		contentType = "kxml:Cabinet";
	else if (hElem instanceof Cabinet)
		contentType = "kxml:Drawer";
	else if (hElem instanceof Drawer)
		contentType = "kxml:Folder";
	else	// Especial situation, folders may contain docs or other folders
		isFolder = true;
	
	kxml.domain.Element[] content = hElem.content();
	for (int i=0; i<content.length; i++)
	{
		if (isFolder)
		{
			if (content[i] instanceof kxml.domain.Document)
			{
				isDocument = true;	contentType = "kxml:Document";
			}
			else
			{
				isDocument = false;	contentType = "kxml:Folder";
			}
		}
		metaxml += "<li><"+contentType+">\n";
		metaxml += getXMLFromElem(content[i]);
		if (!isDocument)
			metaxml += getMetaFromContent((HierarchyElement)content[i]);
		metaxml += "</"+contentType+"></li>\n";
	}
	return metaxml += "</Bag></kxml:Content>\n";
}
/**
 * 
 */
private static String getMetaFromDocTypes(Archive archive) 
{
	String metaxml = new String("<kxml:DocTypes>\n");

	DocType[] docTypes = archive.dictionary.listDocTypes();
	for(int i=0; i<docTypes.length; i++)
	{
		metaxml += "<kxml:DocType id=\""+docTypes[i].getId()+"\""+
				   " command=\""+docTypes[i].getAplication()+"\"/>\n";
	}

	return metaxml += "</kxml:DocTypes>\n";
}
/**
 * 
 */
private static String getMetaFromDtds(Archive archive) 
{
	String metaxml = new String("<kxml:Dtds>\n");

	XMLType xmlType = (XMLType)archive.dictionary.getDocType("text/xml");
	DTD[] dtds = xmlType.listDTDs();
	for(int i=0; i<dtds.length; i++)
	{
		metaxml += "<kxml:Dtd name=\""+dtds[i].getName()+"\""+
				   " uri=\""+dtds[i].getUri().toString()+"\">\n";
		
		XSL[] xsls = dtds[i].listXSLs();
		for(int j=0; j<xsls.length; j++)
			metaxml += "<kxml:Xsl name=\""+xsls[j].getName()+"\""+
				   " uri=\""+xsls[j].getUri().toString()+"\"/>\n";
		
		metaxml += "</kxml:Dtd>\n";
	}
	
	return metaxml += "</kxml:Dtds>\n";
}
/**
 * 
 */
private static String getMetaFromGroups(Archive archive) 
{
	String metaxml = new String("<kxml:Groups>\n");

	Group[] groups = archive.dictionary.listGroups();
	for(int i=0; i<groups.length; i++)
	{
		metaxml += "<kxml:Group id=\""+groups[i].getId()+"\">\n";
		
		String[] members = groups[i].listMembers();
		for(int j=0; j<members.length; j++)
			metaxml += "<kxml:Member id=\""+members[j]+"\"/>\n";
		
		metaxml += "</kxml:Group>\n";
	}
	
	return metaxml += "</kxml:Groups>\n";
}
/**
 * 
 */
private static String getMetaFromUsers(Archive archive) 
{
	String metaxml = new String("<kxml:Users>\n");
	User[] users = archive.dictionary.listUsers();
	for(int i=0; i<users.length; i++)
	{
		metaxml += "<kxml:User id=\""+users[i].getId()+"\" passwd=\""+
					users[i].getPasswd()+"\"";
		if (users[i].isAdmin())
			metaxml += " administrator=\"TRUE\"";
		metaxml += ">\n";
		
		IdElem[] recentDocs = users[i].getRecentDocs();
		for(int j=0; j<recentDocs.length; j++)
			metaxml += "<kxml:DocId id=\""+recentDocs[j].toString()+"\"/>\n";
		
		metaxml += "</kxml:User>\n";
	}
	return metaxml += "</kxml:Users>\n";
}
/**
 * 
 */
private IdElem[] getRecentDocs(Node node) 
{
	org.w3c.dom.Element eTmp = (org.w3c.dom.Element)node;
	NodeList listE;
	
	listE = eTmp.getElementsByTagName("kxml:DocId");
	int n = listE.getLength();
	n = Math.min(n, Configuration.USERRECENTDOCS);  // number of recent docs limit

	IdElem[] recentDocs = new IdElem[n];
	for (int i=0; i<n; i++)
	{
		eTmp = (org.w3c.dom.Element)listE.item(i);
		recentDocs[i] = new IdElem(eTmp.getAttribute("id"));
	}
		
	return recentDocs;
}
/**
 * 
 */
private void getUsersFromMeta(Node node) 
{
	org.w3c.dom.Element eTmp = (org.w3c.dom.Element)node;
	NodeList listE;
	
	listE = eTmp.getElementsByTagName("kxml:User");
	int n = listE.getLength();
	for (int i=0; i<n; i++)
	{
		IdElem[] recents = getRecentDocs(listE.item(i));
		eTmp = (org.w3c.dom.Element)listE.item(i);

		try{										// Ignore repeated users
		archive.dictionary.addUser(
			new User(eTmp.getAttribute("id"), eTmp.getAttribute("passwd"), 
				new Boolean(eTmp.getAttribute("administrator")).booleanValue(), recents));
		} catch(RepeatedKeyException e){};
	}
}
/**
 * 
 */
public static String getXMLFromArchive(Archive archive) 
{
	String metaxml = new String(ARCHIVE_HEADER);
	
	// Archive part
	metaxml += "<kxml:Archive>\n";
	metaxml += getMetaFromUsers(archive);
	metaxml += getMetaFromGroups(archive);
	metaxml += getMetaFromDocTypes(archive);
	metaxml += getMetaFromDtds(archive);
		
	metaxml += getXMLFromElem(archive);

	// Contents part
	metaxml += getMetaFromContent(archive);

	metaxml += "</kxml:Archive>\n";
	return metaxml += ARCHIVE_FOOT;
}
/**
 * 
 */
public static String getXMLFromElem(kxml.domain.Element elem) 
{
	Hashtable attribs = new Hashtable(Configuration.STANDARD_ATTRIBS);
		
	if (elem instanceof kxml.domain.Document)
	{
		kxml.domain.Document doc = (kxml.domain.Document)elem;
		String[] values = {"URI", doc.getUri().toString()};
		attribs.put("URI", values);
	}
	else if (elem instanceof kxml.domain.HierarchyElement)
	{
		String[] values = {"DC:identifier", elem.getIdStr()};
		attribs.put("DC:identifier", values);
	}
	
	String[] valuesOwner = {"kxml:Owner", elem.getOwner().getId()};
	attribs.put("kxml:Owner", valuesOwner);
	
	if (elem.getPublicRead())
	{
		String[] values = {"kxml:Read", "Public"};	
		attribs.put("kxml:Read", values);
	}
	else
	{
		String[] values = new String[elem.getAclRead().size()+1];
		values[0] = "kxml:Read";
		Iterator it = elem.getAclRead().iterator();
		for(int i=1; it.hasNext(); i++)
			values[i] = (String)it.next();
		attribs.put("kxml:Read", values);
	}
	if (elem.getPublicWrite())
	{
		String[] values = {"kxml:Write", "Public"};	
		attribs.put("kxml:Write", values);
	}
	else
	{
		String[] values = new String[elem.getAclWrite().size()+1];
		values[0] = "kxml:Write";
		Iterator it = elem.getAclWrite().iterator();
		for(int i=1; it.hasNext(); i++)
			values[i] = (String)it.next();
		attribs.put("kxml:Write", values);
	}
	
	if (elem instanceof kxml.domain.Document)
	{
		kxml.domain.Document doc = (kxml.domain.Document)elem;
		String doctypeId = doc.getDocType().getId();
		String[] values = {"DC:format", doctypeId};
		attribs.put("DC:format", values);
		if (doctypeId.equals("text/xml"))
		{
			DTD dtd = ((DocXML)doc).getDtd();
			if (dtd != null)
			{
				String[] valuesDTD = {"kxml:DTDName", dtd.getName()};
				attribs.put("kxml:DTDName", valuesDTD);
			}
		}
	}
	
	String[] valuesId = {"DC:identifier", elem.getIdStr()};
	attribs.put("DC:identifier", valuesId);
	
	String[][] attribsUser = elem.getAttributes();
	for(int i=0; (attribsUser!=null) && (i<attribsUser.length); i++)
		attribs.put(attribsUser[i][0], attribsUser[i]);
	
	return RDFManager.getXMLFromAttribs(attribs, elem.getNamespaces());
}
/**
 * 
 */
private void initArchive(org.w3c.dom.Element e) 
{
	getUsersFromMeta(e.getElementsByTagName("kxml:Users").item(0));
	getGroupsFromMeta(e.getElementsByTagName("kxml:Groups").item(0));
	getDocTypesFromMeta(e.getElementsByTagName("kxml:DocTypes").item(0));
	getDTDsFromMeta(e.getElementsByTagName("kxml:Dtds").item(0));

	try							// Init archive with xml data
	{
		Node rdfNode = e.getElementsByTagName("RDF").item(0);
		archive.changeMeta((org.w3c.dom.Element)rdfNode);
	}
	catch(Exception exc){}
}
/**
 * 
 */
private Cabinet makeCabinet(org.w3c.dom.Element e) 
{
	Cabinet cabinet = new Cabinet(archive);

	try
	{
		cabinet.changeMeta(e);
	}
	catch(Exception exc){}
		
	return cabinet;
}
/**
 * 
 */
private kxml.domain.Document makeDocument(org.w3c.dom.Element e)
{
	boolean isXML = false;
	
	NodeList nl = e.getElementsByTagName("DC:format");
	if (nl.getLength() > 0)
	{
		org.w3c.dom.Element formatE = (org.w3c.dom.Element)nl.item(0);
		String idDocType = formatE.getFirstChild().getNodeValue();
		if ("text/xml".equals(idDocType))
			isXML = true;
	}

	kxml.domain.Document doc = null;
	
	try
	{
		if (isXML)
		{
			DocXML docXML = new DocXML(archive, null);
			docXML.changeMeta(e);
			doc = docXML;
		}
		else
		{
			doc = new kxml.domain.Document(archive);
			doc.changeMeta(e);
		}	
	}
	catch(Exception exc){}
	
	return doc;
}
/**
 * 
 */
private Drawer makeDrawer(org.w3c.dom.Element e) 
{
	Drawer drawer = new Drawer(archive);
	
	try
	{
		drawer.changeMeta(e);
	}
	catch(Exception exc){}
	
	return drawer;
}
/**
 * 
 */
private Folder makeFolder(org.w3c.dom.Element e) 
{
	Folder folder = new Folder(archive);
	
	try
	{
		folder.changeMeta(e);
	}
	catch(Exception exc){}
	
	return folder;
}
/**
 * 
 */
private org.w3c.dom.Document parse()
{
	org.w3c.dom.Document doc = null;
	
	try 
	{
		DOMParser ps = new DOMParser();
		ps.setFeature("http://apache.org/xml/features/dom/defer-node-expansion", false);
		ps.setFeature("http://apache.org/xml/features/validation/dynamic", true);
		//ps.setFeature("http://apache.org/xml/features/continue-after-fatal-error", true);
		if (input instanceof Reader)
			ps.parse(new InputSource((Reader)input));
		else
			ps.parse(new InputSource((InputStream)input));
		doc = ps.getDocument();
	}
	catch(SAXException e)
	{
		System.out.println("XMLFactory.parse: "+e);
	}
	catch(Exception e)
	{
		System.out.println("XMLFactory.parse: "+e);
	}
	
	return doc;
}
/**
 * 
 */
private void traverse(Node node, HierarchyElement parent) 
{
	if (node == null) 
		return;

	int type = node.getNodeType();
	switch (type) 
	{
		// document
		case Node.DOCUMENT_NODE: 
		{
			// Get RDF element and traverse the kxml:Archive elem it contains
			org.w3c.dom.Element e = ((org.w3c.dom.Document)node).getDocumentElement();
			traverse(e, null);
			break;
		}
		// element with attributes
		case Node.ELEMENT_NODE: 
		{
			org.w3c.dom.Element e = (org.w3c.dom.Element)node;
			kxml.domain.Element newElem = null;
			
			if (e.getTagName().equals("kxml:Archive"))
			{
				initArchive(e);
				newElem = this.archive;
			}
			else 
			{
				Node rdfNode = e.getElementsByTagName("RDF").item(0);

				if (e.getTagName().equals("kxml:Cabinet"))
					newElem = makeCabinet((org.w3c.dom.Element)rdfNode);
				else if (e.getTagName().equals("kxml:Drawer"))
					newElem = makeDrawer((org.w3c.dom.Element)rdfNode);
				else if (e.getTagName().equals("kxml:Folder"))
					newElem = makeFolder((org.w3c.dom.Element)rdfNode);
				else if (e.getTagName().equals("kxml:Document"))
					newElem = makeDocument((org.w3c.dom.Element)rdfNode);

				try
				{
					parent.file(newElem);
				}
				catch(Exception exc)
				{ System.out.println("XMLFactory.traverse: "+exc);	}
			}

			if (newElem instanceof kxml.domain.Document)
				break;							// Docs don't have content
				
			// Get list items in the Bag element inside kxml:Content elem
			NodeList contentNodeList = e.getElementsByTagName("kxml:Content");
			Node contentNode = contentNodeList.item(0);
			Node bagNode = getFirstValidChild(contentNode);
			
			if (bagNode == null)
				break;
			
			NodeList children = bagNode.getChildNodes();
			if (children != null)
			{
				int len = children.getLength();
				for (int i = 0; i < len; i++)	// Get valid node inside li nodes
				{
					if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
					{
						Node elemNode = getFirstValidChild(children.item(i));
						traverse(elemNode, (HierarchyElement)newElem);
					}
				}
			}
			break;
		}
		default:		
	}
}
private Node getFirstValidChild(Node parent) 
{
	NodeList childs = parent.getChildNodes();
	int i, numChilds = childs.getLength();
	boolean valid = false;
	for (i=0; i<numChilds && !valid;)
	{
		if (childs.item(i).getNodeType() != Node.ELEMENT_NODE)
			i++;
		else
			valid = true;
	}
	if (valid)
		return childs.item(i);
	else
		return null;
}
}
