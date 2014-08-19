package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/_TRANSACORIGINSRVTIE.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _TransacOriginSrvTie extends kxml.logic.server._TransacOriginSrvImplBase {
	public kxml.logic.server._TransacOriginSrvOperations servant;
	public _TransacOriginSrvTie(kxml.logic.server._TransacOriginSrvOperations servant) {
		   this.servant = servant;
	}
	public String getArchiveXML(String userId, String passwd)
		throws kxml.logic.exceptions.IdentificationException    {
		return servant.getArchiveXML(userId, passwd);
	}
}
