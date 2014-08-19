package kxml.util.remote;

/*
 * File: ./KXML/UTIL/REMOTE/STRINGARRAYHELPER.JAVA
 * From: TODO.IDL
 * Date: Tue Mar 14 23:54:30 2000
 *   By: C:\JDK1.2\BIN\IDLTOJ~1.EXE Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class StringArrayHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private StringArrayHelper() { }
   public static String[] extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:kxml/util/remote/StringArray:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, String[] that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 a.type(type());
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
	public static String[] read(org.omg.CORBA.portable.InputStream in) {
		  String[] that;
		  {
			  int __length = in.read_long();
			  that = new String[__length];
			  for (int __index = 0 ; __index < that.length ; __index += 1) {
				  that[__index] = in.read_string();
			  }
		  }
		  return that;
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
		  if (_tc == null)
			 _tc = org.omg.CORBA.ORB.init().create_alias_tc(id(), "StringArray", org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string)));
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, String[] that)  {
		  {
			  out.write_long(that.length);
			  for (int __index = 0 ; __index < that.length ; __index += 1) {
				  out.write_string(that[__index]);
			  }
		  }
	}
}
