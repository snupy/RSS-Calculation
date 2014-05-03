package ru.malik.rss.Calculation.mvc.view;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.mvc.events.listners.ControllerListener;

public interface View {
	 public void modelPropertyChange(final PropertyChangeEvent evt);
	 public void addControllerListener(ControllerListener listener);
	 public void removeControllerListener(ControllerListener listener);
}
