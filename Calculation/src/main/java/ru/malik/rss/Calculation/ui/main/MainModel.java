package ru.malik.rss.Calculation.ui.main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import ru.malik.rss.Calculation.ui.mvc.Model;

public interface MainModel extends Model<MainModelListener>{
	public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel);
	public CategoryTreeModel getCategoryTreeModel();
}
