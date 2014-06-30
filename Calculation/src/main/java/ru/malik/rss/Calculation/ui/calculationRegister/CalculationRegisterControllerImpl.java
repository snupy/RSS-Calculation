package ru.malik.rss.Calculation.ui.calculationRegister;

import java.beans.PropertyChangeEvent;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.Core;
import ru.malik.rss.Calculation.ui.calculation.CalculationView;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;

public class CalculationRegisterControllerImpl extends
		ControllerImpl<CalculationRegisterModel, CalculationRegisterView>
		implements CalculationRegisterController {

	public void propertyChange(PropertyChangeEvent event) {
		if (CalculationRegisterModelListener.PropertyName.CALCULATION_REGISTER_TABLE_MODEL
				.name().equals(event.getPropertyName())) {
			CalculationRegisterTableModel tableModel = (CalculationRegisterTableModel) event
					.getNewValue();
			for (CalculationRegisterView view : views) {
				view.setCalculationRegisterTableModel(tableModel);

			}
		} else if (CalculationRegisterModelListener.PropertyName.SELECTED_CALCULATION
				.name().equals(event.getPropertyName())) {
			// TODO
		}
	}

	public void selectRow(int index, CalculationRegisterView sender) {
		sender.setSelectedRow(index);
		getModel().setSelectedCalculation(
				getModel().getCalculationRegisterTableModel().getCalculationAt(
						index));
	}

	public void addCalculation(CalculationRegisterView sender) {
		Core.getInstance().editCalculation(new ProductCalculation());
	}

	public void removeCalculation(CalculationRegisterView sender) {
		// TODO Auto-generated method stub
		
	}

	public void editCalculation(CalculationRegisterView sender) {
		// TODO Auto-generated method stub
		
	}
	
	
}
