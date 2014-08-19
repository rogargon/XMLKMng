package kxml.gui.mvc;

import kxml.util.remote.*;
import java.awt.event.*;

public abstract class Controler implements _RemoteObserverOperations, 
					  KeyListener, ActionListener, WindowListener
{
	private boolean activeObserver = false;
	protected RemoteObservable model = null;
	protected View view = null;
	protected _RemoteObserverTie tie;
/**
 * 
 */
public Controler() 
{
	super();
	tie = new _RemoteObserverTie(this);
}
/**
 * If this controler is an active observer, activeObserver == true,
 * it will maintain a reference to the current observed model and
 * react to model changes notified through calls to the update method.
 * The default behaviour is not active observer, obtained with the default 
 * constructor or setting activeObserver == false.
 */
public Controler(boolean activeObserver) 
{
	this.activeObserver = activeObserver;	
}
/**
 * If this is an active observer detach from the current observed model
 */
protected void destroy() 
{
	if (activeObserver && this.model != null)
		this.model.deleteObserver(this.tie);
}
/**
 * 
 */
public void init(RemoteObservable model, View view) 
{
	if (activeObserver)
	{
		if (this.model != null)
			this.model.deleteObserver(this.tie);
			
		if (model != null)
		{
			this.model = model;
			model.addObserver(this.tie);
		}
	}
	this.view = view;
}
public abstract void update(org.omg.CORBA.Object observable, org.omg.CORBA.Any data);
}
