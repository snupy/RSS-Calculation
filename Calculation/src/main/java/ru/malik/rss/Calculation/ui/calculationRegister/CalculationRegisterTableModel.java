package ru.malik.rss.Calculation.ui.calculationRegister;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.common.treeTable.AbstractTreeTableModel;

public class CalculationRegisterTableModel extends AbstractTableModel {
	private List<ProductCalculation> calculations;

	public int getColumnCount() {

		return 3;
	}

	@Override
	public String getColumnName(int index) {
		// TODO Нужно будет потом переделать
		switch (index) {
		case 0:
			return "Дата";
		case 1:
			return "Номер";
		case 2:
			return "Продукт";
		default:
			return null;
		}
	}

	public int getRowCount() {
		return calculations.size();
	}

	public Object getValueAt(int row, int column) {
		// TODO Нужно будет потом переделать
		ProductCalculation calculation = calculations.get(row);
		switch (column) {
		case 0:
			return calculation.getNumber();
		case 1:
			return calculation.getDate();
		case 2:
			return calculation.getProduct().getName();
		default:
			return null;
		}
	}

	public CalculationRegisterTableModel(List<ProductCalculation> calculations) {
		super();
		this.calculations = calculations;
	}

}
