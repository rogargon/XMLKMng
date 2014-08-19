package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERCLTTIE.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _ConsistencyManagerCltTie extends kxml.logic.distributed._ConsistencyManagerCltImplBase {
	public kxml.logic.distributed._ConsistencyManagerCltOperations servant;
	public _ConsistencyManagerCltTie(kxml.logic.distributed._ConsistencyManagerCltOperations servant) {
		   this.servant = servant;
	}
	public void addUsrGrp(long trNumber, String userId, String groupId)
	{
		servant.addUsrGrp(trNumber, userId, groupId);
	}
	public void associateXSL(long trNumber, String xslName, String xslURL, String dtdName)
	{
		servant.associateXSL(trNumber, xslName, xslURL, dtdName);
	}
	public void copyElem(long trNumber, String idElemTarget, String idElemDestination)
	{
		servant.copyElem(trNumber, idElemTarget, idElemDestination);
	}
	public void createElement(long trNumber, String idElem, String metaxml)
	{
		servant.createElement(trNumber, idElem, metaxml);
	}
	public void createGroup(long trNumber, String groupId)
	{
		servant.createGroup(trNumber, groupId);
	}
	public void createUser(long trNumber, String userId, String password, boolean administrator)
	{
		servant.createUser(trNumber, userId, password, administrator);
	}
	public void defineDocType(long trNumber, String typeId, String command)
	{
		servant.defineDocType(trNumber, typeId, command);
	}
	public void endModifying(long trNumber, String idElem)
	{
		servant.endModifying(trNumber, idElem);
	}
	public void fileDocument(long trNumber, String idElem, String metaxml)
	{
		servant.fileDocument(trNumber, idElem, metaxml);
	}
	public void modifyDoc(long trNumber, String idElem)
	{
		servant.modifyDoc(trNumber, idElem);
	}
	public void modifyMetadata(long trNumber, String idElem, String metaxml)
	{
		servant.modifyMetadata(trNumber, idElem, metaxml);
	}
	public void moveElem(long trNumber, String idElemTarget, String idElemDestination)
	{
		servant.moveElem(trNumber, idElemTarget, idElemDestination);
	}
	public void removeDoc(long trNumber, String idElem, boolean delContent)
	{
		servant.removeDoc(trNumber, idElem, delContent);
	}
	public void removeGroup(long trNumber, String groupId)
	{
		servant.removeGroup(trNumber, groupId);
	}
	public void removeHElem(long trNumber, String idElem, String userId)
	{
		servant.removeHElem(trNumber, idElem, userId);
	}
	public void removeUser(long trNumber, String userId)
	{
		servant.removeUser(trNumber, userId);
	}
	public void removeUsrGrp(long trNumber, String userId, String groupId)
	{
		servant.removeUsrGrp(trNumber, userId, groupId);
	}
}
