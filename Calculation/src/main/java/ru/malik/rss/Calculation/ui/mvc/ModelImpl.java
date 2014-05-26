package ru.malik.rss.Calculation.ui.mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelImpl<L extends ModelListener> implements Model<L> {
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(
			L propertyChangeListener) {
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);

	}

	public void removePropertyChangeListener(
			L propertyChangeListener) {
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

}
