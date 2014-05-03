package ru.malik.rss.Calculation.mvc.events.listners;

import java.util.EventListener;
import java.util.EventObject;

public interface ControllerListener extends EventListener{
	public void fireEvent(EventObject event);
}
