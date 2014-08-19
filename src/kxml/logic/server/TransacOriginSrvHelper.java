package kxml.logic.server;

/*
 * File: ./KXML/LOGIC/SERVER/TRANSACORIGINSRVHELPER.JAVA
 * From: TODO.IDL
 * Date: Tue Apr 11 16:10:48 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class TransacOriginSrvHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private TransacOriginSrvHelper() { }
   public static kxml.logic.server.TransacOriginSrv extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:kxml/logic/server/TransacOriginSrv:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, kxml.logic.server.TransacOriginSrv that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
   public static kxml.logic.server.TransacOriginSrv narrow(org.omg.CORBA.Object that)
	    throws org.omg.CORBA.BAD_PARAM {
		if (that == null)
			return null;
		if (that instanceof kxml.logic.server.TransacOriginSrv)
			return (kxml.logic.server.TransacOriginSrv) that;
	if (!that._is_a(id())) {
	    throw new org.omg.CORBA.BAD_PARAM();
	}
		org.omg.CORBA.portable.Delegate dup = ((org.omg.CORBA.portable.ObjectImpl)that)._get_delegate();
		kxml.logic.server.TransacOriginSrv result = new kxml.logic.server._TransacOriginSrvStub(dup);
		return result;
   }   
	public static kxml.logic.server.TransacOriginSrv read(org.omg.CORBA.portable.InputStream in) {
		return kxml.logic.server.TransacOriginSrvHelper.narrow(in.read_Object());
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
		  if (_tc == null)
			 _tc = org.omg.CORBA.ORB.init().create_interface_tc(id(), "TransacOriginSrv");
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, kxml.logic.server.TransacOriginSrv that) {
		out.write_Object(that);
	}
}
