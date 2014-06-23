package ru.malik.rss.Calculation.ui.mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import ru.malik.rss.Calculation.ui.common.Announcer;

public class ModelImpl<L extends ModelListener> implements Model<L> {
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	protected final Announcer<L> announcer;
	
	public ModelImpl(Class<L> modelListenerClass) {
		super();
		announcer = new Announcer<L>(modelListenerClass);
	}
	

	public void addModelListener(
			L listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
		announcer.addListener(listener);

	}

	public void removeModelListener(
			L listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
		announcer.removeListener(listener);
	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

}
