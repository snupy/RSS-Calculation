package ru.malik.rss.Calculation.mvc.view;

public interface ModelView<T> {
	public T getModel();
	public void setModel(T model);
	public void setModel(T model, boolean update);
}
