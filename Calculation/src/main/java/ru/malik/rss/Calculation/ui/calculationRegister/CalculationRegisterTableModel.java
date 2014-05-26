package ru.malik.rss.Calculation.ui.calculationRegister;

import javax.swing.table.DefaultTableModel;

// TODO переаботать класс CalculationRegisterTableModel
public class CalculationRegisterTableModel extends DefaultTableModel {
	
	@Override
	public int getColumnCount() {
		
		return 10;
	}

	@Override
	public String getColumnName(int arg0) {
		
		return super.getColumnName(arg0);
	}

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return new Integer(row*column);
	}

}
