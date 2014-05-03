package ru.malik.rss.Calculation.mvc.view;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.economics.model.UnitOfMeasureList;

public class UnitOfMeasureTableModel extends AbstractTableModel {
	private UnitOfMeasureList model;
	
	private UnitOfMeasureTableModel() {
		super();
	}

	public UnitOfMeasureTableModel(UnitOfMeasureList model) {
		this();
		this.model = model;
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

}