package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.Model;

public interface UnitOfMeasureListModel extends
		Model<UnitOfMeasureListModelListener> {

	public void setUnitOfMeasureListTableModel(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel);

	public UnitOfMeasureListTableModel getUnitOfMeasureListTableModel();
	
	public void editUnitOfMeasure(UnitOfMeasure unitOfMeasure);

}
