package kxml.domain;

import kxml.util.*;
import java.util.*;

public class Cabinet extends HierarchyElement
{
/**
 * 
 */
public Cabinet(Archive root) 
{
	super(root);
}
/**
 * 
 */
public Cabinet(Archive root, String locId, String[][] attribs,
				User owner, boolean publicRead, boolean publicWrite,
				HashSet aclRead, HashSet aclWrite) 
{
	super(root, locId, attribs, owner, publicRead,
		  publicWrite, aclRead, aclWrite);
}
/**
 * 
 */
protected boolean correctContent(Element elem) 
{
	return (elem instanceof Drawer);
}
}
