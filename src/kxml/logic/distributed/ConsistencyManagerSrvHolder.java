package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/CONSISTENCYMANAGERSRVHOLDER.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ConsistencyManagerSrvHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.distributed.ConsistencyManagerSrv value;
	//	constructors 
	public ConsistencyManagerSrvHolder() {
	this(null);
	}
	public ConsistencyManagerSrvHolder(kxml.logic.distributed.ConsistencyManagerSrv __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.distributed.ConsistencyManagerSrvHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.distributed.ConsistencyManagerSrvHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.distributed.ConsistencyManagerSrvHelper.write(out, value);
	}
}
