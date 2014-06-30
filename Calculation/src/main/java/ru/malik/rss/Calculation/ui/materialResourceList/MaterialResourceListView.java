package ru.malik.rss.Calculation.ui.materialResourceList;

import ru.malik.rss.Calculation.ui.mvc.View;

public interface MaterialResourceListView extends View<MaterialResourceListViewListener> {
	public void setMaterialResourceListTableModel(MaterialResourceListTableModel materialResourceListTableModel); 
}
