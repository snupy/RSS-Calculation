package ru.malik.rss.Calculation.mvc.view;

import java.awt.Component;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;


public class UnitOfMeasureEditPanel extends DefaultEditPanel<UnitOfMesureViewPanel> {
	
	private UnitOfMeasure unitOfMeasure;
	private UnitOfMesureViewPanel unitOfMesureViewPanel = new UnitOfMesureViewPanel();

	@Override
	public void save() {
		unitOfMesureViewPanel.modelAutoBinding.saveAndNotify();
		super.save();
	}

	@Override
	public void cancel() {
		super.cancel();
		unitOfMesureViewPanel.modelAutoBinding.refreshAndNotify();
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

	@Override
	public Object getModel() {
		return getUnitOfMeasure();
	}
	
	

}
