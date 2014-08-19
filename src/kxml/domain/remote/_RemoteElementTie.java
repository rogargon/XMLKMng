package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/_REMOTEELEMENTTIE.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _RemoteElementTie extends kxml.domain.remote._RemoteElementImplBase {
	public kxml.domain.remote._RemoteElementOperations servant;
	public _RemoteElementTie(kxml.domain.remote._RemoteElementOperations servant) {
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
	public boolean getMetaXML(org.omg.CORBA.StringHolder metaxml)
	{
		return servant.getMetaXML(metaxml);
	}
}
