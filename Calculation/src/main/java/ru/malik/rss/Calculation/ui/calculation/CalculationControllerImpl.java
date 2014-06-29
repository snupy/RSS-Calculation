package ru.malik.rss.Calculation.ui.calculation;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class CalculationControllerImpl extends
		ControllerImpl<CalculationModel, CalculationView> implements
		CalculationController {

	public void propertyChange(PropertyChangeEvent event) {
		if (CalculationModelListener.PropertyName.PRODUCT_CALCULATION.name()
				.equals(event.getPropertyName())) {
			ProductCalculation calculation = (ProductCalculation) event
					.getNewValue();
			for (CalculationView view : views) {
				view.setCalculation(calculation);
			}
		}
	}
}
