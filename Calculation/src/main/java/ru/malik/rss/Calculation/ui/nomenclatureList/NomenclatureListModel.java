package ru.malik.rss.Calculation.ui.nomenclatureList;

import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.ui.common.treeTable.TreeTableModel;
import ru.malik.rss.Calculation.ui.mvc.Model;

/**
 * Интефейс модели списка номенклатур
 * @author Малик
 *
 */
public interface NomenclatureListModel extends Model<NomenclatureListModelListener>{
	
	/**
	 * Задает TreeTableModel для модели NomenclatureListModel
	 * @param treeTableModel
	 */
	public void setNomenclatureListTreeModel(TreeTableModel treeTableModel);
	
	/**
	 * Возвращает значение TreeTableModel модели
	 * @return
	 */
	public TreeTableModel getNomenclatureListTreeModel();
	
	
	/**
	 * Задает выбранный узел модели
	 * @param treeNode
	 */
	public void setSelectedNode(MutableTreeNode treeNode);
	/**
	 * Возвращает выбранныей узел модели
	 * @return
	 */
	public MutableTreeNode getSelectedNode();
}
