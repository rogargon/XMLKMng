package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERSRVOPERATIONS.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

/**

 */public interface _ConsistencyManagerSrvOperations {
	 void addClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
;
	 long addUsrGrpDist(String userId, String groupId)
;
	 long associateXSLDist(String xslName, String xslURL, String dtdName)
;
	 long copyElemDist(String idElemTarget, String idElemDestination)
;
	 long createElemDist(String idElem, String metaxml)
;
	 long createGroupDist(String groupId)
;
	 long createUserDist(String userId, String password, boolean administrator)
;
	 long defineDocTypeDist(String typeId, String command)
;
	 long endModifyingDist(String idElem)
;
	 long fileDocDist(String idElem, String metaxml)
;
	 void lock()
;
	 long modifyDocDist(String idElem)
;
	 long modifyMetaDist(String idElem, String metaxml)
;
	 long moveElemDist(String idElemTarget, String idElemDestination)
;
	 void removeClientManager(kxml.logic.distributed.ConsistencyManagerClt consistencyMngClt)
;
	 long removeDocDist(String idElem, boolean delContent)
;
	 long removeGroupDist(String groupId)
;
	 long removeHElemDist(String idElem, String userId)
;
	 long removeUserDist(String userId)
;
	 long removeUsrGrpDist(String userId, String groupId)
;
	 void unlock()
;
}
