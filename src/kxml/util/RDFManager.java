package kxml.util;

import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
import java.net.*;
/**
 *  
 */
public class RDFManager 
{
	private Reader input;
	private org.w3c.dom.Element doc;
	
	public static int STANDARD_ATTRIBS = 8;
	public static String RDF_HEADER =
		"<RDF \n";
		
	/*public static String RDF_HEADER_BASIC =
		"<RDF xmlns=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
			 "xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n" +
			 "xmlns:DC=\"http://purl.org/DC/elements/1.1#\"\n" +
			 "xmlns:kxml=\"file:./kxml-ns.xml#\"\n";
	*/ 
	// Local version
	public static String RDF_HEADER_BASIC =
		"<RDF xmlns:rdf=\"file:./ns/rdf-syntax-ns.xml#\"\n" +
			 "xmlns:rdfs=\"file:./ns/rdf-schema-ns.xml#\"\n" +
			 "xmlns:DC=\"file:./ns/rec-dc-ns.xml#\"\n" +
			 "xmlns:kxml=\"file:./ns/kxml-ns.xml#\"\n";
			 
	public static String RDF_FOOTER = "</RDF>";

	/*public static String emptyElemXML = RDF_HEADER + "<Description>" +
		"<kxml:Owner></kxml:Owner><kxml:Read></kxml:Read><kxml:Write>" +
		"</kxml:Write><DC:identifier></DC:identifier><DC:title>" +
		"</DC:title><DC:description></DC:description><DC:subject>" +
		"</DC:subject>" + RDF_FOOT;
		
	public static String emptyDocXML = RDF_HEADER + "<Description>" +
		"<kxml:Owner></kxml:Owner><kxml:Read></kxml:Read><kxml:Write>" +
		"</kxml:Write><DC:identifier><DC:format></DC:format>" +
		"</DC:identifier><DC:title></DC:title><DC:description>" +
		"</DC:description><DC:subject></DC:subject><URI></URI>" + RDF_FOOT;*/
/**
 * 
 */
public RDFManager(Reader input) 
{
	this.input = input;
	this.doc = null;
}
/**
 * Manage RDF attributes from a previously parsed piece of xml data
 */
public RDFManager(Element doc) 
{
	this.input = null;
	this.doc = doc;
}
/**
 * 
 */
public Hashtable getAttribsFromXML() 
{
	return getAttribsFromXML(getDescriptionElement(), getNamespaces());
}
/**
 * Get HierachyElement and Document metadata from a RDF-Description element
 */
private static Hashtable getAttribsFromXML(Element e, String[][] nss) 
{
	Hashtable attribs = new Hashtable(STANDARD_ATTRIBS);
	NodeList listE;

	// Put into attribs the Namespace definition array
	attribs.put("NS", nss);
	
	// Get Description attribute: about
	String value[] = {"URI", e.getAttribute("about")};
	if (value[1] != "")
		attribs.put("URI", value);
	
	// Extract "attribute-values" elements under description
	listE = e.getChildNodes();
	
	for(int i=0; i<listE.getLength(); i++)
	{
		if (listE.item(i).getNodeType() != Node.ELEMENT_NODE)
			continue;
		e = (org.w3c.dom.Element)listE.item(i);		
		Vector values = new Vector();
		if (attribs.containsKey(e.getTagName()))
		{
			String[] prevalues = (String[])attribs.get(e.getTagName());
			for(int j=0; i<prevalues.length; i++)
				values.add(prevalues[i]);
		}
		else
			values.add(e.getTagName());
		
		NodeList comp = e.getChildNodes();
		if (comp.getLength() > 1)				// Has child elements
		{
			org.w3c.dom.Element ecomp = (org.w3c.dom.Element)comp.item(1);
			comp = ecomp.getElementsByTagName("li");
			if (comp.getLength() > 0)			// Get bag or seq list items
				for(int j=0; j<comp.getLength(); j++) 	
					values.add(comp.item(j).getFirstChild().getNodeValue());
			else if (ecomp.getTagName().equals("Public")) // Get "Public" tag
				values.add("Public");
			else								// If not "Public" leave empty
				values.add("");
		}
		else if (comp.getLength() == 0)
			values.add("");									// empty #PCDATA
		else
			values.add(e.getFirstChild().getNodeValue());	// get #PCDATA
			
		attribs.put(e.getTagName(), values.toArray());	
	}
	return attribs;
}
/**
 * 
 */
public static String[] getDefinedAttributes(URL nsUri) 
{
	String[] attributes = null;
	Vector attribsVec = new Vector();

	try
	{
		Reader reader = new InputStreamReader(nsUri.openStream());
		RDFManager rdfMng = new RDFManager(reader);
		Element doc = rdfMng.parse().getDocumentElement();
		NodeList nl = doc.getElementsByTagName("rdf:type");
		int nlSize = nl.getLength();
		for(int i=0; i<nlSize; i++)
		{
			Element e = (Element)nl.item(i);
			String rdfType = e.getAttribute("rdf:resource");
			if (rdfType != null && rdfType.indexOf("Property")>0)
			{
				Element parent = (Element)e.getParentNode();
				if (parent != null)
				{
					String attribName = parent.getAttribute("ID");
					if (attribName != null)
						attribsVec.add(attribName);
				}
			}
		}
		attributes = new String[attribsVec.size()];
		for(int i=0; i<attribsVec.size(); i++)
			attributes[i] = (String)attribsVec.get(i);
	}
	catch(IOException e)
	{
		System.out.println("RDFManager.getDefinedAttributes ("+nsUri+"): "+e);
	}
	
	return attributes;
}
/**
 * 
 */
private org.w3c.dom.Element getDescriptionElement() 
{
	if (this.doc == null)
  		doc = parse().getDocumentElement();
  	
	// Input XML Metadata is in RDF format, get the description element.

	NodeList listE = doc.getElementsByTagName("Description");
	
	// Description element, only one.
	Element e = (org.w3c.dom.Element)listE.item(0);		

	return e;
}
/**
 * 
 */
private String[][] getNamespaces() 
{
	if (this.doc == null)
  		doc = parse().getDocumentElement();

  	// The document node is a RDF node, get Namespaces
	NamedNodeMap nssMap = doc.getAttributes();
	
	/*nssMap.removeNamedItem("xmlns");
	nssMap.removeNamedItem("xmlns:rdf");
	nssMap.removeNamedItem("xmlns:DC");
	nssMap.removeNamedItem("xmlns:kxml");*/
	
	int nssCount = nssMap.getLength();
	String[][] nss = new String[nssCount][2];
	for (int i = 0; i < nssCount; i++)
	{
		Attr attrib = (Attr)nssMap.item(i);
		nss[i][0] = attrib.getName();
		nss[i][1] = attrib.getValue();
	}

	return nss;
}
/**
 * 
 */
public org.w3c.dom.Element getRDFElement() 
{
	if (this.doc == null)
  		doc = parse().getDocumentElement();
  	
	return doc;
}
/**
 * 
 */
private static String getRDFHeader(String[][] nss) 
{
	String rdfHeader;

	if (nss == null || nss.length == 0)
		rdfHeader = new String(RDF_HEADER_BASIC);
	else
	{
		rdfHeader = new String(RDF_HEADER);
		for(int i=0; i<nss.length; i++)
			rdfHeader += nss[i][0] + "=\"" + nss[i][1] + "\"\n";
	}
		
	rdfHeader += ">\n";
	return rdfHeader;
}
/**
 * 
 */
public static String getXMLFromAttribs(Hashtable attribs, String[][] namespaces) 
{
	// Construct RDF header with the defined Namespaces
	if (namespaces == null || namespaces.length == 0)
		namespaces = (String[][])attribs.get("NS");
	String metaxml = new String(getRDFHeader(namespaces));
	attribs.remove("NS");
	
	metaxml += "<Description";
	if (attribs.containsKey("URI"))
	{
		metaxml += " about=\""+((Object[])attribs.get("URI"))[1]+"\"";
		attribs.remove("URI");
	}
	else if (attribs.containsKey("DC:identifier"))
		metaxml += " ID=\""+((Object[])attribs.get("DC:identifier"))[1]+"\"";
	metaxml += ">\n";
	
	if (attribs.containsKey("kxml:Owner"))
	{
		metaxml += "<kxml:Owner>"+((Object[])attribs.get("kxml:Owner"))[1]+
				   "</kxml:Owner>\n";
		attribs.remove("kxml:Owner");
	}
	if (attribs.containsKey("kxml:Read"))
	{
		metaxml += "<kxml:Read>\n";
		Object[] values = (Object[])attribs.get("kxml:Read");
		if (values.length > 1 && ((String)values[1]).equals("Public"))
			metaxml += "<Public/>\n";
		else
		{
			metaxml += "<Bag>\n";
			for(int i=1; i<values.length; i++)
				if (!((String)values[i]).trim().equals(""))
					metaxml += "<li>"+values[i]+"</li>\n";
			metaxml += "</Bag>\n";
		}
		metaxml += "</kxml:Read>\n";
		attribs.remove("kxml:Read");
	}
	if (attribs.containsKey("kxml:Write"))
	{
		metaxml += "<kxml:Write>\n";
		Object[] values = (Object[])attribs.get("kxml:Write");
		if (values.length > 1 && ((String)values[1]).equals("Public"))
			metaxml += "<Public/>\n";
		else
		{
			metaxml += "<Bag>\n";
			for(int i=1; i<values.length; i++)
				if (!((String)values[i]).trim().equals(""))
					metaxml += "<li>"+values[i]+"</li>\n";
			metaxml += "</Bag>\n";
		}
		metaxml += "</kxml:Write>\n";
		attribs.remove("kxml:Write");
	}
	if (attribs.containsKey("DC:identifier"))
	{
		metaxml += "<DC:identifier>"+((Object[])attribs.get("DC:identifier"))[1]+
				   "</DC:identifier>\n";
		attribs.remove("DC:identifier");
	}
	
	Enumeration e = attribs.elements();
	while(e.hasMoreElements())
	{
		Object[] values = (Object[])e.nextElement();
		metaxml += "<"+values[0]+">";
		if (values.length > 2)				// multiple values, bag elem
		{
			metaxml += "\n<Bag>\n";
			for(int j=1; j<values.length; j++)
				metaxml += "<li>"+values[j]+"</li>\n";
			metaxml += "</Bag>\n";
		}
		else
			metaxml += values[1];
		metaxml += "</"+values[0]+">\n";
	}
	return metaxml += "</Description>" + RDF_FOOTER;
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
		ps.setFeature("http://apache.org/xml/features/dom/defer-node-expansion", true);
		//ps.setFeature("http://apache.org/xml/features/validation/dynamic", true);
		ps.setFeature("http://xml.org/sax/features/validation", false);
		ps.setFeature("http://apache.org/xml/features/continue-after-fatal-error", true);
		//ps.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
		ps.setFeature("http://xml.org/sax/features/namespaces", false);
		ps.parse(new InputSource(input));
		doc = ps.getDocument();
	}
	catch(SAXException e)
	{
		System.out.println("RDFManager.parse: "+e);
	}
	catch(Exception e)
	{
		System.out.println("RDFManager.parse: "+e);
	}
	
	return doc;
}
}
