package ru.malik.rss.Calculation.ui.nomenclatureList;

import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.ui.common.TreeTableModel;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;

public class NomenclatureListModelImpl extends
		ModelImpl<NomenclatureListModelListener> implements
		NomenclatureListModel {
	private TreeTableModel nomenclatureListTreeTableModel;
	private MutableTreeNode selectedNomeclatureTreeNode;

	public void setNomenclatureListTreeModel(TreeTableModel treeTableModel) {
		if (((treeTableModel != null) && (!treeTableModel
				.equals(nomenclatureListTreeTableModel)))
				|| ((treeTableModel == null) && (nomenclatureListTreeTableModel != null))) {
			getPropertyChangeSupport()
					.firePropertyChange(
							NomenclatureListModelListener.PropertyName.NOMENCLATURE_LIST_TREE_TABLE_MODEL
									.name(),
							this.nomenclatureListTreeTableModel,
							this.nomenclatureListTreeTableModel = treeTableModel);
		}
	}

	public TreeTableModel getNomenclatureListTreeModel() {
		return nomenclatureListTreeTableModel;
	}

	public void setSelectedNode(MutableTreeNode treeNode) {
		if ((treeNode != null)
				&& (!treeNode.equals(selectedNomeclatureTreeNode))
				|| ((treeNode == null) && (selectedNomeclatureTreeNode != null))) {
			getPropertyChangeSupport()
					.firePropertyChange(
							NomenclatureListModelListener.PropertyName.SELECTED_NOMENCLATURE
									.name(), this.selectedNomeclatureTreeNode,
							this.selectedNomeclatureTreeNode = treeNode);
		}

	}

	public MutableTreeNode getSelectedNode() {
		return this.selectedNomeclatureTreeNode;
	}

}
