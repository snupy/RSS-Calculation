package ru.malik.rss.Calculation.mvc.events.listners;

import java.util.EventListener;
import java.util.EventObject;

public interface CancelEventListener extends EventListener {
	public void cancel (EventObject event);
}
