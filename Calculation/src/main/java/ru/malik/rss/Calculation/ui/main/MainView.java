package ru.malik.rss.Calculation.ui.main;

import java.awt.Component;

import ru.malik.rss.Calculation.ui.mvc.View;

public interface MainView extends View<MainViewListener>{
	public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel);
	public CategoryTreeModel getCategoryTreeModel();
	public void addChildWindows(Component child);
}
