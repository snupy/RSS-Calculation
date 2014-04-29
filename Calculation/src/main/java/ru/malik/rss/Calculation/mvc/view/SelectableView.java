package ru.malik.rss.Calculation.mvc.view;

public interface SelectableView<T> {
	public void setSelected(T obj);
	public T getSelected();
}
