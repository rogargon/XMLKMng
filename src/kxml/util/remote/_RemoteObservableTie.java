package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/_REMOTEOBSERVABLETIE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteObservableTie extends kxml.util.remote._RemoteObservableImplBase {
	public kxml.util.remote._RemoteObservableOperations servant;
	public _RemoteObservableTie(kxml.util.remote._RemoteObservableOperations servant) {
		   this.servant = servant;
	}
	public void addObserver(kxml.util.remote.RemoteObserver observer)
	{
		servant.addObserver(observer);
	}
	public void deleteObserver(kxml.util.remote.RemoteObserver observer)
	{
		servant.deleteObserver(observer);
	}
}
