package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class UnitOfMeasureControllerImpl extends ControllerImpl<UnitOfMeasureModel, UnitOfMeasureView> implements
		UnitOfMeasureController {

	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	
	public void saveModel() {
		getModel().save();
		
	}


	public void closeView(UnitOfMeasureView unitOfMeasureView) {
		unitOfMeasureView.close();
	}


	public void sendSave(UnitOfMeasureView unitOfMeasureView) {
		unitOfMeasureView.
		saveModel();
		unitOfMeasureView.close();
	}


	public void sendClose(UnitOfMeasureView unitOfMeasureView) {
		closeView(unitOfMeasureView);		
	}
	
}
