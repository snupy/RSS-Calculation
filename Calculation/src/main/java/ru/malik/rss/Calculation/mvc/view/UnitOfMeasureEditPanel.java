package ru.malik.rss.Calculation.mvc.view;

import java.awt.Component;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureEditPanel extends DefaultEditPanel<UnitOfMesureViewPanel> {
	
	private UnitOfMeasure unitOfMeasure;
	private UnitOfMesureViewPanel unitOfMesureViewPanel = new UnitOfMesureViewPanel();

	@Override
	public void save() {
		super.save();
		try {
			unitOfMeasure = (UnitOfMeasure)unitOfMesureViewPanel.getModel().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cancel() {
		super.cancel();
		try {
			unitOfMesureViewPanel.setModel((UnitOfMeasure)unitOfMeasure.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		setModelView(unitOfMesureViewPanel);
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		try {
			//unitOfMesureViewPanel.setModel((UnitOfMeasure)this.unitOfMeasure.clone());
			unitOfMesureViewPanel.setModel((UnitOfMeasure)this.unitOfMeasure);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
