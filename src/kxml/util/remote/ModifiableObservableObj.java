package kxml.util.remote;

public class ModifiableObservableObj extends RemoteObservableImpl 
{
	private int numReaders = 0;
	private boolean waiting = false;
	private boolean writing = false;
	private Object modifierQueue = new Object();
/**
 * 
 */
public ModifiableObservableObj() 
{
	super();
}
/**
 * 
 */
public synchronized void endReading() 
{
	numReaders--;
	if (numReaders == 0 && waiting)
	{
		synchronized(modifierQueue)
		{
			modifierQueue.notify();		//Despertar al siguiente modificador
		}
	}
}
/**
 * 
 */
public synchronized void endWriting() 
{
	writing = false;
	
	notifyAll();			//Despertar a lect. y modif. esperando
}
/**
 * 
 */
public synchronized boolean reading() 
{
	boolean bloqued = false;

	while (waiting || writing)
	{
		try {wait();}					// Bloquearse en el objeto de espera
		catch(InterruptedException e){}

		bloqued = true;					// Se ha bloqueado
	}
	
	numReaders++;
	
	return bloqued;
}
/**
 * 
 */
public boolean writing() 
{
	boolean bloqued = false;
	
	synchronized(this)
	{
		while(waiting || writing)
		{
			try {wait();}					// Bloquearse en el objeto de espera
			catch(InterruptedException e){}
			
			bloqued = true;					// Se ha bloqueado
		}
		waiting = true;						// Reservar derecho escritura
	}
	
	while(numReaders > 0)
	{
		synchronized(modifierQueue)			// Bloquearse en objeto para 
		{									// siguiente modificador
			try {modifierQueue.wait();}
			catch(InterruptedException e){}
		}
		
		bloqued = true;
	}

	synchronized(this)
	{
		waiting = false;
		writing = true;
	}
	
	return bloqued;
}
}
