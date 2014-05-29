package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class UnitOfMeasureControllerImpl extends
		ControllerImpl<UnitOfMeasureModel, UnitOfMeasureView> implements
		UnitOfMeasureController {

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				UnitOfMeasureModelListener.PN_UNIT_OF_MEASURE)) {
			setUnitOfMeasureToView((UnitOfMeasure) evt.getNewValue());
		}
	}

	public void saveModel() {
		getModel().save();

	}

	public void setUnitOfMeasureToView(UnitOfMeasure unitOfMeasure) {
		for (UnitOfMeasureView unitOfMeasureView : views) {
			unitOfMeasureView.setUnitOfMeasure(unitOfMeasure);
		}
	}

	public void closeView(UnitOfMeasureView unitOfMeasureView) {
		unitOfMeasureView.close();
	}

	public void sendSave(UnitOfMeasureView unitOfMeasureView) {
		saveModel();
		unitOfMeasureView.close();
	}

	public void sendClose(UnitOfMeasureView unitOfMeasureView) {
		closeView(unitOfMeasureView);
	}

	@Override
	public void setModel(UnitOfMeasureModel model) {
		super.setModel(model);
		setUnitOfMeasureToView(model.getUnitOfMesaure());
	}

	@Override
	public void addView(UnitOfMeasureView view) {
		super.addView(view);
		view.setUnitOfMeasure(getModel().getUnitOfMesaure());
	}

}
