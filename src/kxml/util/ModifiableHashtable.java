package kxml.util;

import java.util.*;
import java.io.*;

/**
 * ModifiableHashtable is a common hashtable with the services for
 * synchronization provided by ModifiableObj.
 */
public class ModifiableHashtable extends ModifiableObj
{
	public Hashtable data;
/**
 * 
 */
public ModifiableHashtable() 
{
	super();
	this.data = new Hashtable();
}
/**
 *
 */
public ModifiableHashtable(int n) 
{	
	super();
	this.data = new Hashtable(n);
}
}
