package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/TRANSACORIGINSRV.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public interface TransacOriginSrv
	extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
	String getArchiveXML(String userId, String passwd)
		throws kxml.logic.exceptions.IdentificationException;
}
