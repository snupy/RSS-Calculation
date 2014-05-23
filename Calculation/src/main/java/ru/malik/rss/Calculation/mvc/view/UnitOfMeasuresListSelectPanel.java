package ru.malik.rss.Calculation.mvc.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.entity.UnitOfMeasureList;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

public class UnitOfMeasuresListSelectPanel extends
		DefaultSelectPanel<UnitOfMeasureListPanel, UnitOfMeasure> {
	private UnitOfMeasuresListSelectPanel() {
		super();
	};

	public UnitOfMeasuresListSelectPanel(UnitOfMeasureList model) {
		this();
		setModelView(new UnitOfMeasureListPanel(model));

	}

	public void setSelected(UnitOfMeasure obj) {
		getModelView().setSelected(obj);
	}
	
	

	public UnitOfMeasure getSelected() {
		return getModelView().getSelected();
	}

}
