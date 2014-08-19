package kxml.util;

import java.util.Vector;
import java.util.Enumeration;

public class StackSet 
{
	private Vector elements;
	private int max;
/**
 * 
 */
public StackSet(int max) 
{
	this.max = max;
	elements = new Vector(max);
}
/**
 * 
 */
public synchronized Enumeration elements() 
{
	return elements.elements();
}
/**
 * 
 */
public boolean empty() 
{
	return elements.isEmpty();
}
/**
 * 
 */
public synchronized Object peek() 
{
	return elements.firstElement();
}
/**
 * 
 */
public synchronized Object pop() 
{
	Object top;
	
	top = elements.firstElement();
	elements.removeElementAt(0);
	
	return top;
}
/**
 * Se trata de un conjunto y no puede haber elementos repetidos.
 * Si se empila elemento que ya existe este se mueve a la cima.
 * Mantener capacidad máx. inicial eliminando elemento en el fondo.
 */
public synchronized Object push(Object element) 
{
	int i;
	if ((i=elements.indexOf(element)) >= 0)
		elements.removeElementAt(i);
	else if (elements.size() == max)
		elements.removeElementAt(max-1);

	elements.insertElementAt(element, 0);
	return element;
}
/**
 * 
 */
public int size() 
{
	return elements.size();
}
/**
 * 
 */
public synchronized Object[] toArray() 
{
	Object[] array = new Object[elements.size()];
	
	elements.copyInto(array);
	
	return array;
}
}
