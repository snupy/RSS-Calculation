package ru.malik.rss.Calculation.mvc.view;

public interface HasModelView<T> {
	public T getModelView();
	public boolean setModelView(T modelView);
}
