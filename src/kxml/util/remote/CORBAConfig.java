package kxml.util.remote;

import java.util.Properties;
import org.omg.CORBA.*;

public final class CORBAConfig
{
  public static Properties props = null;
  public static String[] args = new String[0];
  public static ORB orb = ORB.init();
  public static Any anyNull = orb.create_any();
  public static Any getAny()
  {
	  return orb.create_any();
  }  
}
