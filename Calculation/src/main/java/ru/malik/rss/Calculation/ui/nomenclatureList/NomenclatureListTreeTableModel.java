package ru.malik.rss.Calculation.ui.nomenclatureList;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.common.AbstractTreeTableModel;

public class NomenclatureListTreeTableModel extends AbstractTreeTableModel{
	private MutableTreeNode treeNode;

	private NomenclatureListTreeTableModel(Object root) {
		super(root);
		// TODO Auto-generated constructor stub
	}
	
	public NomenclatureListTreeTableModel(List<Nomenclature> nomenclatures){
		this(new DefaultMutableTreeNode(new Nomenclature()));
		for(int i=0; i<nomenclatures.size(); i++)
		((DefaultMutableTreeNode)getRoot()).add(new DefaultMutableTreeNode(nomenclatures.get(i)));
		
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return "Наименование";
	}

	public Object getValueAt(Object node, int column) {
		((Nomenclature)((DefaultMutableTreeNode)node).getUserObject()).getName();
		return ((Nomenclature)((DefaultMutableTreeNode)node).getUserObject()).getName();
	}

	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return ((TreeNode)parent).getChildAt(index);
	}

	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return ((TreeNode)parent).getChildCount();
	}

}
