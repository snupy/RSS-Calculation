package ru.malik.rss.Calculation.ui.nomenclatureList;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.NomenclatureCategory;
import ru.malik.rss.Calculation.ui.common.AbstractTreeTableModel;
import ru.malik.rss.Calculation.ui.common.TreeTableModel;

public class NomenclatureListTreeTableModel extends AbstractTreeTableModel
		implements TreeTableModel {
	private MutableTreeNode treeNode;

	public NomenclatureListTreeTableModel(Object root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	/*
	 * public NomenclatureListTreeTableModel(List<Nomenclature> nomenclatures){
	 * this(new DefaultMutableTreeNode(new Nomenclature())); for(int i=0;
	 * i<nomenclatures.size(); i++) ((DefaultMutableTreeNode)getRoot()).add(new
	 * DefaultMutableTreeNode(nomenclatures.get(i)));
	 * 
	 * }
	 */

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Наименование";
		case 1:
			return "Ед. изм.";
		default:
			return null;

		}

	}
	
	

	public Object getValueAt(Object node, int column) {
		Object obj = ((DefaultMutableTreeNode) node).getUserObject();
		if (obj instanceof Nomenclature) {
			if (column == 0) {
				return ((Nomenclature) obj).getName();
			} else if (column == 1) {
				return ((Nomenclature) obj).getUnitOfMeasures().getShortName();
			}
		} else if ((obj instanceof NomenclatureCategory) && (column == 0)) {
			return ((NomenclatureCategory) ((DefaultMutableTreeNode) node)
					.getUserObject()).getName();
		}
		return null;

	}

	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return ((TreeNode) parent).getChildAt(index);
	}

	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return ((TreeNode) parent).getChildCount();
	}

	@Override
	public Class getColumnClass(int column) {
		// TODO Auto-generated method stub
		if (column == 0) {
			return TreeTableModel.class;
		} else {
			return super.getColumnClass(column);
		}

	}

}
