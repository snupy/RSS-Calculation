package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public interface UnitOfMeasureController extends ActionListener, PropertyChangeListener{
	public void save();
	public void cancel();
	
	public void setModel(UnitOfMeasureModel model);
	public UnitOfMeasureModel getModel();

	public void addView(UnitOfMeasureView measureView);
	public void removeView(UnitOfMeasureView measureView);
	public UnitOfMeasureView getView(int index);
}
