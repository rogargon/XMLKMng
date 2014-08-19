package kxml.domain;

import kxml.util.remote.*;
import org.omg.CORBA.Any;
/**
 * Represents the content of a document inside the aplication.
 * Allows content modifications and reading tracking. This is 
 * acomplished implementing a RemoteObservers system over the
 * content broker differentiated between readers and writers.
 */
public class ContentBroker 
{
	private RemoteObservableImpl readers;
	private RemoteObservableImpl writers;

	private static final String WRITING_MESSAGE =
		"Warning: document content is being edited and may change";
	private static final String MODIFICATION_MESSAGE =
		"Warning: editing has finished, document content may have changed";
/**
 * 
 */
public ContentBroker() 
{
	readers = new RemoteObservableImpl();
	writers = new RemoteObservableImpl();
}
/**
 * 
 */
public void endingWriting() 
{
	Any stringAny = CORBAConfig.getAny();
	stringAny.insert_string(MODIFICATION_MESSAGE);
	readers.notifyObservers(null, stringAny);
	writers.notifyObservers(null, stringAny);
}
/**
 * 
 */
public void endRead(RemoteObserver obs) 
{
	readers.deleteObserver(obs);
}
/**
 * 
 */
public void endWrite(RemoteObserver obs) 
{
	writers.deleteObserver(obs);
}
/**
 * 
 */
public void startingWriting() 
{
	Any stringAny = CORBAConfig.getAny();
	stringAny.insert_string(WRITING_MESSAGE);
	readers.notifyObservers(null, stringAny);
	writers.notifyObservers(null, stringAny);
}
/**
 * 
 */
public void startRead(RemoteObserver obs) 
{
	readers.addObserver(obs);
	if (writers.countObservers() > 0)
	{
		Any stringAny = CORBAConfig.getAny();
		stringAny.insert_string(WRITING_MESSAGE);
		obs.update(null, stringAny);
	}
}
/**
 * 
 */
public void startWrite(RemoteObserver obs) 
{
	writers.addObserver(obs);
	if (writers.countObservers() > 1)
	{
		Any stringAny = CORBAConfig.getAny();
		stringAny.insert_string(WRITING_MESSAGE);
		obs.update(null, stringAny);
	}
}
}
