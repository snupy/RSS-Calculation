package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface UnitOfMeasureListViewListener extends ViewListener {
	public void editUnitOfMeasure(UnitOfMeasure unitOfMeasure, UnitOfMeasureListView sender);
	public void addUnitOfMeasure(UnitOfMeasureListView sender);
	public void removeUnitOfMeasure(UnitOfMeasureListView sender);
}
