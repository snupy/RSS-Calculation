package ru.malik.rss.Calculation.ui.main;

import ru.malik.rss.Calculation.ui.mvc.Model;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;
import ru.malik.rss.Calculation.ui.mvc.ViewImpl;

public class MainModelImpl extends ModelImpl<MainModelListener> implements MainModel{
	private CategoryTreeModel categoryTreeModel;
	public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel) {
		if((this.categoryTreeModel==null)||(!this.categoryTreeModel.equals(categoryTreeModel))){
			getPropertyChangeSupport().firePropertyChange(MainModelListener.PN_CATEGORY_TREE_MODEL, this.categoryTreeModel, categoryTreeModel);
			this.categoryTreeModel = categoryTreeModel;
		}
	}

	public CategoryTreeModel getCategoryTreeModel() {
		return this.categoryTreeModel;
	}
	
}
