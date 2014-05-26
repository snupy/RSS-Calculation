package ru.malik.rss.Calculation.ui.unitFoMeasureList;

import ru.malik.rss.Calculation.ui.mvc.Model;

public interface UnitOfMeasureListModel extends
		Model<UnitOfMeasureListModelListener> {

	public void setUnitOfMeasureListTableModel(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel);

	public UnitOfMeasureListTableModel getUnitOfMeasureListTableModel();

}
