package ru.malik.rss.Calculation.mvc.view;

import ru.malik.rss.Calculation.mvc.events.listners.AddEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.RemoveEventListener;

public interface ListView {
	public void addAddEventListener(AddEventListener listener);
	public void removeAddEventListener(AddEventListener listener);
	public void addRemoveEventListener(RemoveEventListener listener);
	public void removeRemoveEventListener(RemoveEventListener listener);
	
}
