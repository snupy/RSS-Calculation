package ru.malik.rss.Calculation.ui.nomenclatureList;

import ru.malik.rss.Calculation.ui.common.TreeTableModel;
import ru.malik.rss.Calculation.ui.mvc.View;


public interface NomenclatureListView extends View<NomenclatureListViewListener>{
	public void setNomenclatureListTreeModel(TreeTableModel treeTableModel);
}
