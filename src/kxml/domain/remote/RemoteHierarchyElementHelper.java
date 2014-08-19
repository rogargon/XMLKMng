package kxml.domain.remote;

/*
 * File: ./KXML/DOMAIN/REMOTE/REMOTEHIERARCHYELEMENTHELPER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class RemoteHierarchyElementHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private RemoteHierarchyElementHelper() { }
   public static kxml.domain.remote.RemoteHierarchyElement extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:kxml/domain/remote/RemoteHierarchyElement:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, kxml.domain.remote.RemoteHierarchyElement that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
   public static kxml.domain.remote.RemoteHierarchyElement narrow(org.omg.CORBA.Object that)
	    throws org.omg.CORBA.BAD_PARAM {
		if (that == null)
			return null;
		if (that instanceof kxml.domain.remote.RemoteHierarchyElement)
			return (kxml.domain.remote.RemoteHierarchyElement) that;
	if (!that._is_a(id())) {
	    throw new org.omg.CORBA.BAD_PARAM();
	}
		org.omg.CORBA.portable.Delegate dup = ((org.omg.CORBA.portable.ObjectImpl)that)._get_delegate();
		kxml.domain.remote.RemoteHierarchyElement result = new kxml.domain.remote._RemoteHierarchyElementStub(dup);
		return result;
   }   
	public static kxml.domain.remote.RemoteHierarchyElement read(org.omg.CORBA.portable.InputStream in) {
		return kxml.domain.remote.RemoteHierarchyElementHelper.narrow(in.read_Object());
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
		  if (_tc == null)
			 _tc = org.omg.CORBA.ORB.init().create_interface_tc(id(), "RemoteHierarchyElement");
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, kxml.domain.remote.RemoteHierarchyElement that) {
		out.write_Object(that);
	}
}
