package kxml.util;

/**
 * 
 */
public class CorrelativeQueueElement 
{
	protected long order;
	protected Object obj;
/**
 * 
 */
public CorrelativeQueueElement(long order, Object obj) 
{
	this.order = order;
	this.obj = obj;
}
}
