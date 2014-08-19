package kxml.logic;

/*
 * File: ./KXML/LOGIC/_TRANSACORIGINFACTORYTIE.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginFactoryTie extends kxml.logic._TransacOriginFactoryImplBase {
	public kxml.logic._TransacOriginFactoryOperations servant;
	public _TransacOriginFactoryTie(kxml.logic._TransacOriginFactoryOperations servant) {
		   this.servant = servant;
	}
	public kxml.logic.TransacOrigin getTransacOrigin(kxml.util.remote.RemoteObserver logObserver)
	{
		return servant.getTransacOrigin(logObserver);
	}
	public boolean removeTransacOrigin()
	{
		return servant.removeTransacOrigin();
	}
}
