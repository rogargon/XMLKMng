package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/CONSISTENCYMANAGERCLTHOLDER.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class ConsistencyManagerCltHolder
	 implements org.omg.CORBA.portable.Streamable{
	//	instance variable 
	public kxml.logic.distributed.ConsistencyManagerClt value;
	//	constructors 
	public ConsistencyManagerCltHolder() {
	this(null);
	}
	public ConsistencyManagerCltHolder(kxml.logic.distributed.ConsistencyManagerClt __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.logic.distributed.ConsistencyManagerCltHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.logic.distributed.ConsistencyManagerCltHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.logic.distributed.ConsistencyManagerCltHelper.write(out, value);
	}
}
