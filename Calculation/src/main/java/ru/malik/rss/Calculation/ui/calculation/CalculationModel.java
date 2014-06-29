package ru.malik.rss.Calculation.ui.calculation;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.mvc.Model;

public interface CalculationModel extends Model<CalculationModelListener> {
	public void setCalculation(ProductCalculation calculation);

	public ProductCalculation getCalculation();
}
