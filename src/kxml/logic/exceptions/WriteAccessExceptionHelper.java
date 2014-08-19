package kxml.logic.exceptions;

/*
 * File: ./LOGIC/WRITEACCESSEXCEPTIONHELPER.JAVA
 * From: TODO.IDL
 * Date: Wed Jan 05 12:31:00 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class WriteAccessExceptionHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private WriteAccessExceptionHelper() { }
   public static WriteAccessException extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:logic/WriteAccessException:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, WriteAccessException that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
	public static WriteAccessException read(org.omg.CORBA.portable.InputStream in) {
		 // read and discard the repository id
		in.read_string();
		WriteAccessException that = new WriteAccessException(in.read_string());
	return that;
	}
   synchronized public static org.omg.CORBA.TypeCode type() {
	   int _memberCount = 1;
	   org.omg.CORBA.StructMember[] _members = null;
		  if (_tc == null) {
			   _members= new org.omg.CORBA.StructMember[1];
			   _members[0] = new org.omg.CORBA.StructMember(
				 "reason",
				 org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string),
				 null);
			 _tc = org.omg.CORBA.ORB.init().create_exception_tc(id(), "WriteAccessException", _members);
		  }
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, WriteAccessException that) {
	out.write_string(id());

	out.write_string(that.reason);
	}
}
