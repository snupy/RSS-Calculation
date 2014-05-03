package ru.malik.rss.Calculation.mvc.events.listners;

import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.EventObject;

public interface SaveEventListener extends EventListener{
	public void save(EventObject event);
}
