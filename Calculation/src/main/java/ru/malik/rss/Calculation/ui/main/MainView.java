package ru.malik.rss.Calculation.ui.main;

import ru.malik.rss.Calculation.ui.mvc.View;

public interface MainView extends View<MainViewListener>{
	public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel);
	public CategoryTreeModel getCategoryTreeModel();
}
