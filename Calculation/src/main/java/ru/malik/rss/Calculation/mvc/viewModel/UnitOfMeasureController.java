package ru.malik.rss.Calculation.mvc.viewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.AbstractAction;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureWindow;

public class UnitOfMeasureController {
	private UnitOfMeasure model;
	private HashSet<UnitOfMeasureWindow> views;
	
	private class AcUpdate extends AbstractAction {
		public AcUpdate() {
			putValue(NAME, "Ок");
			putValue(SHORT_DESCRIPTION, "Принять");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class AcCancel extends AbstractAction {
		public AcCancel() {
			putValue(NAME, "Отмена");
			putValue(SHORT_DESCRIPTION, "Отмена");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class Ac23 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public UnitOfMeasure getModel() {
		return model;
	}

	public void setModel(UnitOfMeasure model) {
		this.model = model;
	}

	public HashSet<UnitOfMeasureWindow> getViews() {
		return views;
	}

	public UnitOfMeasureController() {
		super();
		views = new HashSet<UnitOfMeasureWindow>();
	}
}
