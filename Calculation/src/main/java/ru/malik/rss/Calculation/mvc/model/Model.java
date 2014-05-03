package ru.malik.rss.Calculation.mvc.model;

import java.beans.PropertyChangeListener;

public interface Model {

	public  void firePropertyChange(String propertyName, Object oldValue,
			Object newValue);

	public void removePropertyChangeListener(PropertyChangeListener listener);

	public void addPropertyChangeListener(PropertyChangeListener listener);

}
