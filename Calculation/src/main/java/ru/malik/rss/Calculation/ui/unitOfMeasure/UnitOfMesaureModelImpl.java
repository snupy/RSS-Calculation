package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.utils.UnitOfMeasureDAO;

public class UnitOfMesaureModelImpl implements UnitOfMeasureModel {
	private UnitOfMeasure unitOfMeasure;
	private UnitOfMeasureDAO unitOfMeasureDAO; 
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public void setUnitOfMeasureName(String value) {
		// TODO Auto-generated method stub

	}

	public void setUnitOfMeasureShortName(String value) {
		// TODO Auto-generated method stub

	}

	public void setUnitOfMeasureOkei(String value) {
		// TODO Auto-generated method stub

	}

	public String getUnitOfMeasureName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUnitOfMeasureShortName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUnitOfMeasureOkei() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validate() {
		return !(getUnitOfMeasureName().equals("")||getUnitOfMeasureOkei().equals("")||getUnitOfMeasureShortName().equals(""));
	}

	public void save() {
		try {
			unitOfMeasureDAO.saveOrUpdate(unitOfMeasure);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void refresh() {
		try {
			setUnitOfMeasure(unitOfMeasureDAO.getById(unitOfMeasure.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public UnitOfMeasureDAO getUnitOfMeasureDAO() {
		return unitOfMeasureDAO;
	}

	public void setUnitOfMeasureDAO(UnitOfMeasureDAO unitOfMeasureDAO) {
		this.unitOfMeasureDAO = unitOfMeasureDAO;
	}

	public void addPropertyChangeListener(
			PropertyChangeListener propertyChangeListener) {
		this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public void removePropertyChangeListener(
			PropertyChangeListener propertyChangeListener) {
		this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
		
	}
	
	

}
