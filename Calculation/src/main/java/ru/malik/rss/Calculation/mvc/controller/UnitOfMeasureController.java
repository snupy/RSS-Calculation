package ru.malik.rss.Calculation.mvc.controller;

import java.sql.SQLException;

import javax.swing.JFrame;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.events.SaveEventObject;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;
import ru.malik.rss.Calculation.mvc.view.FrameFacory;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureEditPanel;
import ru.malik.utils.UnitOfMeasureDAO;

public class UnitOfMeasureController {
	private static UnitOfMeasureController unitOfMeasureController;

	public static UnitOfMeasureController getInstance() {
		if (unitOfMeasureController == null) {
			unitOfMeasureController = new UnitOfMeasureController();
		}

		return unitOfMeasureController;
	}

	private SaveEventListener saveEventListener = new SaveEventListener() {
		public void after(SaveEventObject event) {
			
			//TODO тут еще надо подумать как правильнее сделать
			try {
				UnitOfMeasureDAO.getInstance().saveOrUpdate(
						(UnitOfMeasure) event.getSaveObj());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void before(SaveEventObject event) {
			
		}

		public void call(SaveEventObject event) {
				
		}
	};

	public SaveEventListener getSaveEventListener() {
		return saveEventListener;
	}

	public UnitOfMeasure createNewUnitOfMeasure() {
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		JFrame frame = FrameFacory.getInstance().getNewFrame();
		frame.add(new UnitOfMeasureEditPanel(unitOfMeasure));
		frame.pack();
		frame.setVisible(true);
		
		return unitOfMeasure;
	}
}
