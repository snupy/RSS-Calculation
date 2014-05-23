package ru.malik.rss.Calculation.mvc.view;

public interface HasModelView<T extends ModelView> {
	public T getModelView();
	public boolean setModelView(T modelView);
}
