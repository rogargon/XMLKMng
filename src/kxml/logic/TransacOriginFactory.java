package kxml.logic;

/*
 * File: ./KXML/LOGIC/TRANSACORIGINFACTORY.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public interface TransacOriginFactory
	extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
	kxml.logic.TransacOrigin getTransacOrigin(kxml.util.remote.RemoteObserver logObserver)
;
	boolean removeTransacOrigin()
;
}
