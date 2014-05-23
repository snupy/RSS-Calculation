package ru.malik.rss.Calculation.mvc.view;

public interface ModelView<T> {
	public T getModel();
	public boolean setModel(T model);
	public boolean setModel(T model, boolean update);
}
