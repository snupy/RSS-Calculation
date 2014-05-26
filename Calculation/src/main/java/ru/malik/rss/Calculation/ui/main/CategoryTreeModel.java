package ru.malik.rss.Calculation.ui.main;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class CategoryTreeModel extends DefaultTreeModel {
	public static DefaultMutableTreeNode nodeRoot;
	public static DefaultMutableTreeNode nodeCalculationRegister;
	public static DefaultMutableTreeNode nodeUnitOfMeasureList;

	public CategoryTreeModel() {
		super(nodeRoot);
	}

	static {
		DefaultMutableTreeNode node;
		
		nodeRoot = new DefaultMutableTreeNode("Категории");
		
		
		node = new DefaultMutableTreeNode("Документы");
		nodeRoot.add(node);
		node.add(nodeCalculationRegister = new DefaultMutableTreeNode("Журнал калькуляций"));
		
		
		node = new DefaultMutableTreeNode("Справочники");
		nodeRoot.add(node);
		node.add(nodeUnitOfMeasureList = new DefaultMutableTreeNode("Единицы измерения"));
	}
}
