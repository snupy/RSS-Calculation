package ru.malik.rss.Calculation.mvc.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureListPanel extends JPanel implements
		ModelView<ArrayList<UnitOfMeasure>> {
	private ArrayList<UnitOfMeasure> model;
	private JTable table;
	private UnitOfMeasureTableModel tableModel;

	public ArrayList<UnitOfMeasure> getModel() {
		return this.model;
	}

	public UnitOfMeasureListPanel() {
		super(new BorderLayout());
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void setModel(ArrayList<UnitOfMeasure> model) {
		setModel(model, true);	
	}

	public void setModel(ArrayList<UnitOfMeasure> model, boolean update) {
		this.model = model;
		if (update) {
			table.setModel(tableModel = new UnitOfMeasureTableModel(this.model));
		}

	}

}
