package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.beans.PropertyChangeListener;

public interface UnitOfMeasureModel {
	public void setUnitOfMeasureName(String value);
	public void setUnitOfMeasureShortName(String value);
	public void setUnitOfMeasureOkei(String value);
	public String getUnitOfMeasureName();
	public String getUnitOfMeasureShortName();
	public String getUnitOfMeasureOkei();
	public void save();
	public void refresh();
	public boolean validate();
	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);
	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener);
}
