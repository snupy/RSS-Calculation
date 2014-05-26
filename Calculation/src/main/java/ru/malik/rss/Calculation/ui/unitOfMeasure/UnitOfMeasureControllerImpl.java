package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class UnitOfMeasureControllerImpl implements UnitOfMeasureController {
	private UnitOfMeasureModel unitOfMeasureModel;
	private final ArrayList<UnitOfMeasureView> unitOfMeasureViews = new ArrayList<UnitOfMeasureView>();

	public void save() {

		unitOfMeasureModel.save();
	}

	public void cancel() {
		// TODO Auto-generated method stub

	}

	public UnitOfMeasureControllerImpl(UnitOfMeasureModel unitOfMeasureModel) {
		super();
		this.unitOfMeasureModel = unitOfMeasureModel;
	}

	public void setModel(UnitOfMeasureModel model) {
		unitOfMeasureModel = model;
	}

	public UnitOfMeasureModel getModel() {
		return unitOfMeasureModel;
	}

	public void addView(UnitOfMeasureView measureView) {
		unitOfMeasureViews.add(measureView);
	}

	public void removeView(UnitOfMeasureView measureView) {
		unitOfMeasureViews.remove(measureView);
	}

	public UnitOfMeasureView getView(int index) {
		return unitOfMeasureViews.get(index);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() instanceof UnitOfMeasureView) {
			UnitOfMeasureView view = (UnitOfMeasureView) actionEvent
					.getSource();
			if (actionEvent.getActionCommand().equals("save")) {
				unitOfMeasureModel.setUnitOfMeasureName(view
						.getUnitOfMeasureName());
				unitOfMeasureModel.setUnitOfMeasureOkei(view
						.getUnitOfMeasureOkei());
				unitOfMeasureModel.setUnitOfMeasureShortName(view
						.getUnitOfMeasureShortName());
				if (unitOfMeasureModel.validate()) {
					unitOfMeasureModel.save();
				}
			} else if (actionEvent.getActionCommand().equals("cancel")) {
				unitOfMeasureModel.refresh();
			}
		}
	}

	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		// TODO Auto-generated method stub

	}

}
