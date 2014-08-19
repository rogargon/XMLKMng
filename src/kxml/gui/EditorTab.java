package kxml.gui;

import javax.swing.JTabbedPane;
import kxml.util.remote.RemoteObserver;
import kxml.logic.TransacOrigin;
import java.net.*;
/**
 * 
 */
public interface EditorTab
{
/**
 * 
 */
public void initialize(URL uri, ContentObserver obs, 
					   JTabbedPane parent, TransacOrigin trOrigin);
}
