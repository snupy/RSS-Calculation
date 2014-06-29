package ru.malik.rss.Calculation.ui.calculationRegister;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.mvc.Model;

public interface CalculationRegisterModel extends
		Model<CalculationRegisterModelListener> {
	public void setCalculationRegisterTableModel(
			CalculationRegisterTableModel tableModel);

	public CalculationRegisterTableModel getCalculationRegisterTableModel();

	public void setSelectedCalculation(ProductCalculation productCalculation);

	public ProductCalculation getSelectedCalculation();

	public void editProductCalculation(ProductCalculation productCalculation);

	public void addProductCalculation(ProductCalculation productCalculation);

	public void removeProductCalculation(ProductCalculation productCalculation);
}
