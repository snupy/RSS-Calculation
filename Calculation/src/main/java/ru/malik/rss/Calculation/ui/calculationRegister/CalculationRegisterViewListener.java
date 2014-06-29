package ru.malik.rss.Calculation.ui.calculationRegister;

import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface CalculationRegisterViewListener extends ViewListener {
	public void selectRow(int index, CalculationRegisterView sender);
}
