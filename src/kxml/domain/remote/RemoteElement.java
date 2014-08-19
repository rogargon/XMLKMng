package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/REMOTEELEMENT.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public interface RemoteElement
	extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity,
	    kxml.util.remote.RemoteObservable {
	boolean getMetaXML(org.omg.CORBA.StringHolder metaxml)
;
}
