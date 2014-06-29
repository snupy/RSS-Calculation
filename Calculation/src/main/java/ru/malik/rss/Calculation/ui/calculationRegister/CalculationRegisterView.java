package ru.malik.rss.Calculation.ui.calculationRegister;

import ru.malik.rss.Calculation.ui.mvc.View;

public interface CalculationRegisterView extends View<CalculationRegisterViewListener> {
	public void setCalculationRegisterTableModel(CalculationRegisterTableModel tableModel);
	public void setSelectedRow(int index);
	public void setRowCount(int count);
}
