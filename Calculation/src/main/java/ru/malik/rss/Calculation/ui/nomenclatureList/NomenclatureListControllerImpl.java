package ru.malik.rss.Calculation.ui.nomenclatureList;

import java.beans.PropertyChangeEvent;

import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.ui.common.TreeTableModel;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class NomenclatureListControllerImpl extends
		ControllerImpl<NomenclatureListModel, NomenclatureListView> implements
		NomenclatureListController {

	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String propertyName = evt.getPropertyName();
		if (propertyName.equals(PropertyName.NOMENCLATURE_LIST_TREE_TABLE_MODEL
				.name())) {
			for(NomenclatureListView view: views){
				view.setNomenclatureListTreeModel((TreeTableModel)evt.getNewValue());
			}
		} else if (propertyName.equals(PropertyName.SELECTED_NOMENCLATURE
				.name())) {
			// TODO нужно тут что то сделать
		}
	}

	public void addNomenclature(NomenclatureListView sender) {
		// TODO Auto-generated method stub

	}

	public void editNomenclature(NomenclatureListView sender) {
		// TODO Auto-generated method stub

	}

	public void removeNomenclature(NomenclatureListView sender) {
		// TODO Auto-generated method stub

	}

	public void selectRow(MutableTreeNode selectedNode,
			NomenclatureListView sender) {
		getModel().setSelectedNode(selectedNode);		
	}
}
