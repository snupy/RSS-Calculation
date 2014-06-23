package ru.malik.rss.Calculation.ui.mvc;

import java.beans.PropertyChangeListener;

public interface Model<L extends ModelListener> {
	public void addModelListener(L listener);
	public void removeModelListener(L listener);
}
