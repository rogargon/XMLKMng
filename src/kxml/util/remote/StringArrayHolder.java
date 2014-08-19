package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/STRINGARRAYHOLDER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public final class StringArrayHolder
	implements org.omg.CORBA.portable.Streamable
{
	//	instance variable 
	public String[] value;
	//	constructors 
	public StringArrayHolder() {
	this(null);
	}
	public StringArrayHolder(String[] __arg) {
	value = __arg;
	}
	public void _read(org.omg.CORBA.portable.InputStream in) {
		value = kxml.util.remote.StringArrayHelper.read(in);
	}
	public org.omg.CORBA.TypeCode _type() {
		return kxml.util.remote.StringArrayHelper.type();
	}
	public void _write(org.omg.CORBA.portable.OutputStream out) {
		kxml.util.remote.StringArrayHelper.write(out, value);
	}
}
