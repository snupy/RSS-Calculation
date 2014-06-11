package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.entity.UnitOfMeasureList;
import ru.malik.rss.Calculation.entity.UnitOfMeasuresList;

public class UnitOfMeasureListTableModel extends AbstractTableModel {
	private	List<UnitOfMeasure> unitOfMeasuresList; 
	
	public int getColumnCount() {
		return 3;
	}

	// TODO Мне не понравилось как это я сделал
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Наименование";
		case 1:
			return "Краткое наименование";	
		case 2:
			return "Код ОКЕИ";
		}
		return null;
	}

	public int getRowCount() {
		return unitOfMeasuresList.size();
	}

	
	// TODO Мне не понравилось как это я сделал
	public Object getValueAt(int row, int column) {
		UnitOfMeasure unitOfMeasure = unitOfMeasuresList.get(row);
		switch (column) {
		case 0:
			return unitOfMeasure.getName();
		case 1:
			return unitOfMeasure.getShortName();	
		case 2:
			return unitOfMeasure.getCodeOKEI();
		}
		return null;
	}

	public UnitOfMeasureListTableModel(List<UnitOfMeasure> unitOfMeasuresList) {
		super();
		this.unitOfMeasuresList = unitOfMeasuresList;
	}
	
	public UnitOfMeasure getUnitOfMeasureAt(int rowIndex){
		return unitOfMeasuresList.get(rowIndex);
	}

	
}
