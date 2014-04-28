package ru.malik.rss.Calculation.mvc.view;

import java.awt.Component;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureEditPanel extends DefaultEditPanel {
	
	private UnitOfMeasure unitOfMeasure;
	private UnitOfMesureViewPanel unitOfMesureViewPanel;

	@Override
	public void save() {
		try {
			unitOfMeasure = (UnitOfMeasure)unitOfMesureViewPanel.getUnitOfMeasure().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cancel() {
		try {
			unitOfMesureViewPanel.setUnitOfMeasure((UnitOfMeasure)unitOfMeasure.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Component createContentComponent() {
		
		return unitOfMesureViewPanel = new UnitOfMesureViewPanel();
	}
	
	
	/**
	 * Закрываем конструктор от внешнего вызова
	 */
	private UnitOfMeasureEditPanel(){
		super();
	}

	public UnitOfMeasureEditPanel(UnitOfMeasure unitOfMeasure) {
		this();
		setUnitOfMeasure(unitOfMeasure);
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		try {
			unitOfMesureViewPanel.setUnitOfMeasure((UnitOfMeasure)this.unitOfMeasure.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	

}
