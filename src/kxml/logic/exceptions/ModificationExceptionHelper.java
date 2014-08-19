package kxml.logic.exceptions;

/*
 * File: ./LOGIC/MODIFICATIONEXCEPTIONHELPER.JAVA
 * From: TODO.IDL
 * Date: Fri Feb 11 13:46:22 2000
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

public class ModificationExceptionHelper {
   private static org.omg.CORBA.TypeCode _tc;
	 // It is useless to have instances of this class
	 private ModificationExceptionHelper() { }
   public static ModificationException extract(org.omg.CORBA.Any a) {
	 org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	 return read(in);
   }   
   public static String id() {
	   return "IDL:logic/ModificationException:1.0";
   }   
   public static void insert(org.omg.CORBA.Any a, ModificationException that) {
	 org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	 write(out, that);
	 a.read_value(out.create_input_stream(), type());
   }   
	public static ModificationException read(org.omg.CORBA.portable.InputStream in) {
		 // read and discard the repository id
		in.read_string();
		ModificationException that = new ModificationException(in.read_string());
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
			 _tc = org.omg.CORBA.ORB.init().create_exception_tc(id(), "ModificationException", _members);
		  }
	  return _tc;
   }   
	public static void write(org.omg.CORBA.portable.OutputStream out, ModificationException that) {
	out.write_string(id());

	out.write_string(that.reason);
	}
}
