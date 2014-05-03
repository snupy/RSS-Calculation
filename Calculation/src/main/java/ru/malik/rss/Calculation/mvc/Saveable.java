package ru.malik.rss.Calculation.mvc;

import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;

public interface Saveable {
	public void save();
	public void addSaveListener(SaveEventListener listener);
	public void removeSaveListener(SaveEventListener listener);
}
