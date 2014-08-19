package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVERTIE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteObserverTie extends kxml.util.remote._RemoteObserverImplBase {
	public kxml.util.remote._RemoteObserverOperations servant;
	public _RemoteObserverTie(kxml.util.remote._RemoteObserverOperations servant) {
		   this.servant = servant;
	}
	public void update(org.omg.CORBA.Object observable, org.omg.CORBA.Any data)
	{
		servant.update(observable, data);
	}
}
