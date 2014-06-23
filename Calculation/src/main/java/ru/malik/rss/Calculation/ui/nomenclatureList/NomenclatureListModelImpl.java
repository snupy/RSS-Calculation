package ru.malik.rss.Calculation.ui.nomenclatureList;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.NomenclatureCategory;
import ru.malik.rss.Calculation.ui.common.treeTable.TreeTableModel;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.utils.NomenclatureCategoryDAO;
import ru.malik.utils.NomenclatureDAO;

public class NomenclatureListModelImpl extends
		ModelImpl<NomenclatureListModelListener> implements
		NomenclatureListModel {
	private TreeTableModel nomenclatureListTreeTableModel;
	private MutableTreeNode selectedNomeclatureTreeNode;
	
	
	

	public NomenclatureListModelImpl() {
		super(NomenclatureListModelListener.class);
	}

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
		// проверка на действительность изменения
		if (this.selectedNomeclatureTreeNode == treeNode) {
			return;
		}
		
		getPropertyChangeSupport()
				.firePropertyChange(
						NomenclatureListModelListener.PropertyName.SELECTED_NOMENCLATURE
								.name(), this.selectedNomeclatureTreeNode,
						this.selectedNomeclatureTreeNode = treeNode);

	}

	public MutableTreeNode getSelectedNode() {
		return this.selectedNomeclatureTreeNode;
	}

	public static class NomenclaturesCollector {

		static public DefaultMutableTreeNode buld(NomenclatureCategory obj) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(obj) {

				@Override
				public String toString() {
					if (getUserObject() != null) {
						return ((NomenclatureCategory) getUserObject())
								.getName();
					} else {
						return "";
					}
				}
			};

			List<NomenclatureCategory> childs = NomenclatureCategoryDAO
					.getInstance().findAll(obj);
			for (int i = 0; i < childs.size(); i++) {
				System.out.println(childs.get(i).getName());
				node.add(buld(childs.get(i)));

			}

			List<Nomenclature> childNomenclatures = NomenclatureDAO
					.getInstance().findByOwner(obj);
			for (int i = 0; i < childNomenclatures.size(); i++) {
				node.add(new DefaultMutableTreeNode(childNomenclatures.get(i)) {

					@Override
					public String toString() {
						return ((Nomenclature) getUserObject()).getName();
					}
				});
			}

			return node;
		}
	}
}
