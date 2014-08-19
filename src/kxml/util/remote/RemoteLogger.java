package kxml.util.remote;

import org.omg.CORBA.*;
/**
 *  
 */
public class RemoteLogger extends RemoteObservableImpl
						  implements kxml.util.Logger
{
	private ORB orb;
	private Any any;
/**
 * 
 */
public RemoteLogger() 
{
	super();
	orb = ORB.init();
	any = orb.create_any();
}
/**
 * 
 */
public synchronized void logMessage(String mess) 
{
	setChanged();

	any.insert_string(mess);
	notifyObservers(null, any);
}
}
