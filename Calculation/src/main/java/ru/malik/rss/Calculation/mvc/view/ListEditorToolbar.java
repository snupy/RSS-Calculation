package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ListEditorToolbar extends JToolBar {
	private JButton btnAdd, btnRemove, btnEdit;

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}
	public ListEditorToolbar(){
		super();
		add(btnAdd = new JButton("ADD"));
		add(btnRemove = new JButton("REMOVE"));
		add(btnEdit = new JButton("EDIT"));
	}
}
