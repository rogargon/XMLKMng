package kxml.logic;

/*
 * File: ./KXML/LOGIC/TRANSACORIGINHELPER.JAVA
 * From: TODO.IDL
 * Date: Wed May 03 16:35:09 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class TransacOriginHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private TransacOriginHelper() { }
   public static kxml.logic.TransacOrigin extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:kxml/logic/TransacOrigin:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, kxml.logic.TransacOrigin that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
   public static kxml.logic.TransacOrigin narrow(org.omg.CORBA.Object that)
	    throws org.omg.CORBA.BAD_PARAM {
		if (that == null)
			return null;
		if (that instanceof kxml.logic.TransacOrigin)
			return (kxml.logic.TransacOrigin) that;
	if (!that._is_a(id())) {
	    throw new org.omg.CORBA.BAD_PARAM();
	}
		org.omg.CORBA.portable.Delegate dup = ((org.omg.CORBA.portable.ObjectImpl)that)._get_delegate();
		kxml.logic.TransacOrigin result = new kxml.logic._TransacOriginStub(dup);
		return result;
   }   
	public static kxml.logic.TransacOrigin read(org.omg.CORBA.portable.InputStream in) {
		return kxml.logic.TransacOriginHelper.narrow(in.read_Object());
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
		  if (_tc == null)
			 _tc = org.omg.CORBA.ORB.init().create_interface_tc(id(), "TransacOrigin");
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, kxml.logic.TransacOrigin that) {
		out.write_Object(that);
	}
}
