package ru.malik.rss.Calculation.ui.calculationRegister;

import ru.malik.rss.Calculation.ui.calculation.CalculationView;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface CalculationRegisterViewListener extends ViewListener {
	public void selectRow(int index, CalculationRegisterView sender);
	public void addCalculation(CalculationRegisterView sender);
	public void removeCalculation(CalculationRegisterView sender);
	public void editCalculation(CalculationRegisterView sender);
}
