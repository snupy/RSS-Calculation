package ru.malik.rss.Calculation.ui.calculation;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;

public class CalculcationModelImpl extends ModelImpl<CalculationModelListener>
		implements CalculationModel {
	private ProductCalculation ProductCalculation;

	public CalculcationModelImpl() {
		super(CalculationModelListener.class);
	}

	public void setCalculation(ProductCalculation calculation) {
		if (this.ProductCalculation != calculation) {
			getPropertyChangeSupport()
					.firePropertyChange(
							CalculationModelListener.PropertyName.PRODUCT_CALCULATION
									.name(), this.ProductCalculation,
							this.ProductCalculation = calculation);
		}
	}

	public ProductCalculation getCalculation() {
		return this.ProductCalculation;
	}

}
