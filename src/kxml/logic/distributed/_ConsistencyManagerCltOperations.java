package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/_CONSISTENCYMANAGERCLTOPERATIONS.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

/**

 */public interface _ConsistencyManagerCltOperations {
	 void addUsrGrp(long trNumber, String userId, String groupId)
;
	 void associateXSL(long trNumber, String xslName, String xslURL, String dtdName)
;
	 void copyElem(long trNumber, String idElemTarget, String idElemDestination)
;
	 void createElement(long trNumber, String idElem, String metaxml)
;
	 void createGroup(long trNumber, String groupId)
;
	 void createUser(long trNumber, String userId, String password, boolean administrator)
;
	 void defineDocType(long trNumber, String typeId, String command)
;
	 void endModifying(long trNumber, String idElem)
;
	 void fileDocument(long trNumber, String idElem, String metaxml)
;
	 void modifyDoc(long trNumber, String idElem)
;
	 void modifyMetadata(long trNumber, String idElem, String metaxml)
;
	 void moveElem(long trNumber, String idElemTarget, String idElemDestination)
;
	 void removeDoc(long trNumber, String idElem, boolean delContent)
;
	 void removeGroup(long trNumber, String groupId)
;
	 void removeHElem(long trNumber, String idElem, String userId)
;
	 void removeUser(long trNumber, String userId)
;
	 void removeUsrGrp(long trNumber, String userId, String groupId)
;
}
