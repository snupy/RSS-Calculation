package ru.malik.rss.Calculation.mvc.controller;

import java.sql.SQLException;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.events.ListEventObject;
import ru.malik.rss.Calculation.mvc.events.listners.AddEventListener;
import ru.malik.utils.UnitOfMeasureDAO;

public class UnitOfMeasuresListController {
	private static UnitOfMeasuresListController unitOfMeasuresListController;
	
	private AddEventListener addEventListener = new AddEventListener() {
		
		public void call(ListEventObject event) {
			addUnitOfMeasure();
		}
		
		public void before(ListEventObject event) {
			// TODO Auto-generated method stub
			
		}
		
		public void after(ListEventObject event) {
			// TODO Auto-generated method stub
			
		}
	};

	public static UnitOfMeasuresListController getInstance() {
		if (unitOfMeasuresListController == null) {
			unitOfMeasuresListController = new UnitOfMeasuresListController();
		}
		return unitOfMeasuresListController;

	}

	private UnitOfMeasuresListController() {
		super();
	}
	
	public UnitOfMeasure addUnitOfMeasure(){
		return UnitOfMeasureController.getInstance().createNewUnitOfMeasure();
	}
	
	public void removeUnitOfMeasure(UnitOfMeasure unitOfMeasure){
		try {
			UnitOfMeasureDAO.getInstance().delete(unitOfMeasure);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
