package ru.malik.rss.Calculation.mvc;

import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

public interface Cancelable {
	public void cancel();
	public void addCancelListener(CancelEventListener listener);
	public void removeCancelListener(CancelEventListener listener);
}
