package kxml.util;

import java.util.Vector;
/**
 * Queue of numbered objects. Objects are extracted in correlative order,
 * starting from object labeled with number 0.
 */
public class CorrelativeQueue 
{
	private Vector data;
	private long current = -1;
/**
 * 
 */
public CorrelativeQueue() 
{
	data = new Vector();
}
/**
 * Blocks if the element following the last is not ordered correlatively.
 * It remains blocked until the correlative element is queued.
 */
public synchronized Object next() 
{
	while (data.isEmpty() ||
		   ((CorrelativeQueueElement)data.firstElement()).order != current+1)
	{
		try {wait();}
		catch(InterruptedException e)
		{System.out.println("CorrelativeQueue.next: "+e);}
	}
	current++;
	Object obj = ((CorrelativeQueueElement)data.firstElement()).obj;
	data.removeElementAt(0);
	return obj;
}
/**
 * 
 */
public synchronized void queue(long order, Object obj) 
{
	boolean placed = false;
	int i = data.size() - 1;
	CorrelativeQueueElement qElem = new CorrelativeQueueElement(order, obj);
		
	// The new element follows the last queued element
	if (data.isEmpty() || 
		((CorrelativeQueueElement)data.lastElement()).order < order)
		data.add(qElem);
	else
	{
		for(; i>=0 && !placed; i--)
		{
			if (i == 0 || 
				((CorrelativeQueueElement)data.elementAt(i-1)).order < order)
			{
				data.insertElementAt(qElem, i);
				placed = true;
			}
		}
	}
	//if (i == -1 || (i==0 && placed)) // When element inserted first in queue
		notifyAll();				 // unblock any thread in next
}
}
