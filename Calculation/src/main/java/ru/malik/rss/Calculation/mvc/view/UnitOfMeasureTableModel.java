package ru.malik.rss.Calculation.mvc.view;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureTableModel implements TableModel {
	private ArrayList<UnitOfMeasure> model;

	private UnitOfMeasureTableModel() {
		super();
	}

	public UnitOfMeasureTableModel(ArrayList<UnitOfMeasure> model) {
		this();
		this.model = model;
	}

	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 1;
	}

	public String getColumnName(int columnIndex) {
		return "Имя";
	}

	public int getRowCount() {
		return model.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return model.get(rowIndex).getName();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}