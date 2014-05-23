package ru.malik.rss.Calculation.mvc;

import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

public interface Selectable<T>{
	public void setSelected(T obj);
	public T getSelected();
	public void select();
	public void addSelectListener(SelectEventListener listener);
	public void removeSelectListener(SelectEventListener listener);
}
