package ru.malik.rss.Calculation.ui.calculationRegister;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;

public class CalculationRegisterModelImpl extends
		ModelImpl<CalculationRegisterModelListener> implements
		CalculationRegisterModel {
	private CalculationRegisterTableModel calculationRegisterTableModel;
	private ProductCalculation selectedCalculation;

	public CalculationRegisterModelImpl(
			) {
		super(CalculationRegisterModelListener.class);
		// TODO Auto-generated constructor stub
	}

	public void setCalculationRegisterTableModel(
			CalculationRegisterTableModel tableModel) {
		if (calculationRegisterTableModel != tableModel) {

			getPropertyChangeSupport()
					.firePropertyChange(
							CalculationRegisterModelListener.PropertyName.CALCULATION_REGISTER_TABLE_MODEL
									.name(), calculationRegisterTableModel,
							calculationRegisterTableModel = tableModel);
		}
	}

	public CalculationRegisterTableModel getCalculationRegisterTableModel() {
		return calculationRegisterTableModel;
	}

	public void setSelectedCalculation(ProductCalculation productCalculation) {
		if (selectedCalculation != productCalculation) {
			getPropertyChangeSupport()
					.firePropertyChange(
							CalculationRegisterModelListener.PropertyName.SELECTED_CALCULATION
									.name(), selectedCalculation,
							selectedCalculation = productCalculation);
		}
	}

	public ProductCalculation getSelectedCalculation() {
		return selectedCalculation;
	}

	public void editProductCalculation(ProductCalculation productCalculation) {
		// TODO Auto-generated method stub

	}

	public void addProductCalculation(ProductCalculation productCalculation) {
		// TODO Auto-generated method stub

	}

	public void removeProductCalculation(ProductCalculation productCalculation) {
		// TODO Auto-generated method stub

	}
}
