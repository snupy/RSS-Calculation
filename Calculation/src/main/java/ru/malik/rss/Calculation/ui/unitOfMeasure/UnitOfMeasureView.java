package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface UnitOfMeasureView {
	public void setUnitOfMeasureName(String value);

	public void setUnitOfMeasureShortName(String value);

	public void setUnitOfMeasureOkei(String value);

	public String getUnitOfMeasureName();

	public String getUnitOfMeasureShortName();

	public String getUnitOfMeasureOkei();

	public void addActionListner(ActionListener listener);

	public void removeActionListner(ActionListener listener);
	
	public void fireAction(ActionEvent actionEvent);

}
