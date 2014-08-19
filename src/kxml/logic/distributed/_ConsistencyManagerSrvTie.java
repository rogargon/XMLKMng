package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERSRVTIE.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class _ConsistencyManagerSrvTie extends kxml.logic.distributed._ConsistencyManagerSrvImplBase {
	public kxml.logic.distributed._ConsistencyManagerSrvOperations servant;
	public _ConsistencyManagerSrvTie(kxml.logic.distributed._ConsistencyManagerSrvOperations servant) {
		   this.servant = servant;
	}
	public void addClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
	{
		servant.addClientManager(consistencyMngClt);
	}
	public long addUsrGrpDist(String userId, String groupId)
	{
		return servant.addUsrGrpDist(userId, groupId);
	}
	public long associateXSLDist(String xslName, String xslURL, String dtdName)
	{
		return servant.associateXSLDist(xslName, xslURL, dtdName);
	}
	public long copyElemDist(String idElemTarget, String idElemDestination)
	{
		return servant.copyElemDist(idElemTarget, idElemDestination);
	}
	public long createElemDist(String idElem, String metaxml)
	{
		return servant.createElemDist(idElem, metaxml);
	}
	public long createGroupDist(String groupId)
	{
		return servant.createGroupDist(groupId);
	}
	public long createUserDist(String userId, String password, boolean administrator)
	{
		return servant.createUserDist(userId, password, administrator);
	}
	public long defineDocTypeDist(String typeId, String command)
	{
		return servant.defineDocTypeDist(typeId, command);
	}
	public long endModifyingDist(String idElem)
	{
		return servant.endModifyingDist(idElem);
	}
	public long fileDocDist(String idElem, String metaxml)
	{
		return servant.fileDocDist(idElem, metaxml);
	}
	public void lock()
	{
		servant.lock();
	}
	public long modifyDocDist(String idElem)
	{
		return servant.modifyDocDist(idElem);
	}
	public long modifyMetaDist(String idElem, String metaxml)
	{
		return servant.modifyMetaDist(idElem, metaxml);
	}
	public long moveElemDist(String idElemTarget, String idElemDestination)
	{
		return servant.moveElemDist(idElemTarget, idElemDestination);
	}
	public void removeClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
	{
		servant.removeClientManager(consistencyMngClt);
	}
	public long removeDocDist(String idElem, boolean delContent)
	{
		return servant.removeDocDist(idElem, delContent);
	}
	public long removeGroupDist(String groupId)
	{
		return servant.removeGroupDist(groupId);
	}
	public long removeHElemDist(String idElem, String userId)
	{
		return servant.removeHElemDist(idElem, userId);
	}
	public long removeUserDist(String userId)
	{
		return servant.removeUserDist(userId);
	}
	public long removeUsrGrpDist(String userId, String groupId)
	{
		return servant.removeUsrGrpDist(userId, groupId);
	}
	public void unlock()
	{
		servant.unlock();
	}
}
