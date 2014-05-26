package ru.malik.rss.Calculation.ui.mvc;

import java.beans.PropertyChangeListener;

public interface Model<L extends ModelListener> {
	public void addPropertyChangeListener(L propertyChangeListener);
	public void removePropertyChangeListener(L propertyChangeListener);
}
