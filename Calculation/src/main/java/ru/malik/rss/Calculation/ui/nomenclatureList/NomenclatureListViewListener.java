package ru.malik.rss.Calculation.ui.nomenclatureList;

import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface NomenclatureListViewListener extends ViewListener{
	public void addNomenclature(NomenclatureListView sender);
	public void editNomenclature(NomenclatureListView sender);
	public void removeNomenclature(NomenclatureListView sender);
	public void selectRow(MutableTreeNode selectedNode, NomenclatureListView sender);
}
