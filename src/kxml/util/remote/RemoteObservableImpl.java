package kxml.util.remote;

import java.util.*;
import org.omg.CORBA.ORB;

public class RemoteObservableImpl extends _RemoteObservableImplBase
{
	private static final int INITIALOBSERVERS = 2;
	
	private Vector observers;
	private boolean changed = false;
	private RemoteObserver[] arr = new RemoteObserver[2];
/**
 * Construct a RemoteObservable with zero Observers
 */
public RemoteObservableImpl() 
{
	super();
	observers = new Vector(INITIALOBSERVERS);
}
/**
 * Adds a remote observer to the set of observers for this object. 
 */
public synchronized void addObserver(RemoteObserver observer) 
{
	boolean present = false;
	Enumeration e = observers.elements();

	while(e.hasMoreElements() && !present)
	{
		if (observer._is_equivalent((RemoteObserver)e.nextElement()))
			present = true;
	}
	
	if (!present)
		observers.addElement(observer);
}
/**
 * Indicates that this object has no longer changed, or that it has 
 * already notified all of its observers of its most recent change. 
 * This method is called automatically by the 
 * <code>notifyObservers</code> methods.
 */
protected synchronized void clearChanged() 
{
	changed = false;
}
/**
 * Returns the number of remote observers of this object.
 */
public synchronized int countObservers() 
{
	return observers.size();
}
/**
 * Deletes a remote observer from the set of observers of this object.
 */
public synchronized void deleteObserver(RemoteObserver observer)
{
	int position = 0;
	boolean found = false;
	Enumeration e = observers.elements();

	while(e.hasMoreElements() && !found)
	{
		if (observer._is_equivalent((RemoteObserver)e.nextElement()))
			found = true;
		position++;
	}
	
	if (found)
		observers.removeElementAt(position-1);
}
/**
 * Clears the remote observer list so that this object no longer has any observers.
 */
public synchronized void deleteObservers() 
{
	observers.removeAllElements();
}
/**
 * Tests if this object has changed. 
 *
 * @return  <code>true</code> if the <code>setChanged</code> method
 *          has been called more recently than the <code>clearChanged</code>
 *          method on this object; <code>false</code> otherwise.
 */
public synchronized boolean hasChanged() 
{
	return changed;
}
/**
 * If this object has changed, as indicated by the 
 * <code>hasChanged</code> method, then notify all of its observers 
 * and then call the <code>clearChanged</code> method to indicate 
 * that this object has no longer changed. 
 * <p>
 * Each observer has its <code>update</code> method called with one
 * argument: a remote reference to a remotally observable object.
 */
public void notifyObservers(org.omg.CORBA.Object obj, org.omg.CORBA.Any data)
{
	int size=0;

	synchronized(this) 
	{
	    if (!changed)
			return;
	    size = observers.size();
	    if (size > arr.length) 
			arr = new RemoteObserver[size];
	    observers.copyInto(arr);
	    changed = false;
	}

	for (int i = size -1; i>=0; i--) 
	{
	    if (arr[i] != null && !arr[i]._non_existent())
			arr[i].update(obj, data);
		else
			deleteObserver(arr[i]);
	}
}
/**
 * Indicates that this object has changed.
 */
protected synchronized void setChanged() 
{
	changed = true;
}
}
