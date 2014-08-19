package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/REMOTEOBSERVER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public interface RemoteObserver
	extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
	void update(org.omg.CORBA.Object observable, org.omg.CORBA.Any data)
;
}
