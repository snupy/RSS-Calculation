package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import ru.malik.rss.Calculation.ui.mvc.View;

public interface UnitOfMeasureListView extends View<UnitOfMeasureListViewListener> {
	public void setUnitOfMeasureListTableModel(UnitOfMeasureListTableModel unitOfMeasureListTableModel);
	public UnitOfMeasureListTableModel getUnitOfMeasureListTableModel();
	public void setItemCount(int count);
}
