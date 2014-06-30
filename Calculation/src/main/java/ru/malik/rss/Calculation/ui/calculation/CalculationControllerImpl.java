package ru.malik.rss.Calculation.ui.calculation;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListController;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListControllerImpl;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class CalculationControllerImpl extends
		ControllerImpl<CalculationModel, CalculationView> implements
		CalculationController {
	private MaterialResourceListController materialResourceListController = new MaterialResourceListControllerImpl();

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

	public MaterialResourceListController getMaterialResourceListController() {
		return materialResourceListController;
	}

	@Override
	public void setModel(CalculationModel model) {
		materialResourceListController.setModel(model.getMaterialResourceListModel());
		super.setModel(model);
	}

	@Override
	public void addView(CalculationView view) {
		materialResourceListController.addView(view.getMaterialResourceListView());
		super.addView(view);
	}

	@Override
	public void removeView(CalculationView view) {
		materialResourceListController.removeView(view.getMaterialResourceListView());
		super.removeView(view);
	}
	
	
}
