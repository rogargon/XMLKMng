package kxml.logic.distributed;

/*
 * File: ./KXML/LOGIC/DISTRIBUTED/CONSISTENCYMANAGERSRVHELPER.JAVA
 * From: TODO.IDL
 * Date: Mon Jun 12 16:02:12 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class ConsistencyManagerSrvHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private ConsistencyManagerSrvHelper() { }
   public static kxml.logic.distributed.ConsistencyManagerSrv extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:kxml/logic/distributed/ConsistencyManagerSrv:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, kxml.logic.distributed.ConsistencyManagerSrv that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
   public static kxml.logic.distributed.ConsistencyManagerSrv narrow(org.omg.CORBA.Object that)
	    throws org.omg.CORBA.BAD_PARAM {
		if (that == null)
			return null;
		if (that instanceof kxml.logic.distributed.ConsistencyManagerSrv)
			return (kxml.logic.distributed.ConsistencyManagerSrv) that;
	if (!that._is_a(id())) {
	    throw new org.omg.CORBA.BAD_PARAM();
	}
		org.omg.CORBA.portable.Delegate dup = ((org.omg.CORBA.portable.ObjectImpl)that)._get_delegate();
		kxml.logic.distributed.ConsistencyManagerSrv result = new kxml.logic.distributed._ConsistencyManagerSrvStub(dup);
		return result;
   }   
	public static kxml.logic.distributed.ConsistencyManagerSrv read(org.omg.CORBA.portable.InputStream in) {
		return kxml.logic.distributed.ConsistencyManagerSrvHelper.narrow(in.read_Object());
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
		  if (_tc == null)
			 _tc = org.omg.CORBA.ORB.init().create_interface_tc(id(), "ConsistencyManagerSrv");
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, kxml.logic.distributed.ConsistencyManagerSrv that) {
		out.write_Object(that);
	}
}
