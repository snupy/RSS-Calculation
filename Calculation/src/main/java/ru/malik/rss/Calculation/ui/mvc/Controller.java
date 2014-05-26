package ru.malik.rss.Calculation.ui.mvc;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public interface Controller<M extends Model,V extends View> extends ModelListener, ViewListener{
	public void setModel(M model);
	public M getModel();

	public void addView(V view);
	public void removeView(V view);
	public V getView(int index);
}
