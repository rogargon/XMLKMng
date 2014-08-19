package kxml.gui.mvc;

import kxml.util.remote.*;
import javax.swing.JFrame;

public abstract class View extends JFrame
						   implements _RemoteObserverOperations
{
	protected RemoteObservable model = null;
	protected Controler contrl = null;
	public _RemoteObserverTie tie;
/**
 * 
 */
public View() 
{
	super();
	this.contrl = createControler();
	
	tie = new _RemoteObserverTie(this);
}
/**
 * 
 */
public View(String title) 
{
	super(title);
	this.contrl = createControler();
	
	tie = new _RemoteObserverTie(this);
}
/**
 * 
 */
public abstract Controler createControler();
/**
 * Leave observation before closing
 */
public void dispose() 
{
	if (this.contrl != null)
		this.contrl.destroy();
		
	if (this.model != null)
		this.model.deleteObserver(this.tie);
		
	super.dispose();
}
/**
 * 
 */
public Controler getControler() 
{
	return contrl;
}
/**
 * 
 */
public RemoteObserver getRemoteObserver() 
{
	return this.tie;
}
/**
 * 
 */
public void init(RemoteObservable model) 
{
	if (this.model != null)
		this.model.deleteObserver(this.tie);

	if (model != null)
	{
		this.model = model;
		model.addObserver(this.tie);
	}

	if (contrl != null)
		contrl.init(model, this);
}
public abstract void update(org.omg.CORBA.Object observable, 
						 	org.omg.CORBA.Any data);
}
