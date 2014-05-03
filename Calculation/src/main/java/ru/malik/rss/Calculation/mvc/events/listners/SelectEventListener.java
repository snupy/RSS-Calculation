package ru.malik.rss.Calculation.mvc.events.listners;

import java.util.EventListener;
import java.util.EventObject;

import org.hibernate.event.EventListeners;

public interface SelectEventListener extends EventListener {
	public void select(EventObject event);
}
