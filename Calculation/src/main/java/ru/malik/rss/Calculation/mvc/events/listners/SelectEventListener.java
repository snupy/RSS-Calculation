package ru.malik.rss.Calculation.mvc.events.listners;

import java.util.EventListener;
import java.util.EventObject;

import org.hibernate.event.EventListeners;

import ru.malik.rss.Calculation.mvc.events.ListEventObject;

public interface SelectEventListener extends MyEventListener<ListEventObject> {

}
