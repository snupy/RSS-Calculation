package ru.malik.rss.Calculation.ui.unitOfMeasure;

import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface UnitOfMeasureViewListener extends ViewListener{
	public void sendSave(UnitOfMeasureView unitOfMeasureView);
	public void sendClose(UnitOfMeasureView unitOfMeasureView);
}
