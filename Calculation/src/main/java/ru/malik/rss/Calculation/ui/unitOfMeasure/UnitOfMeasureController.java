package ru.malik.rss.Calculation.ui.unitOfMeasure;

import ru.malik.rss.Calculation.ui.mvc.Controller;

public interface UnitOfMeasureController extends
		Controller<UnitOfMeasureModel, UnitOfMeasureView>, UnitOfMeasureViewListener {
	public void closeView(UnitOfMeasureView unitOfMeasureView);
	public void saveModel();
}
