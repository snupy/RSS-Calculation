package ru.malik.rss.Calculation.ui.unitOfMeasure;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.View;

public interface UnitOfMeasureView extends View<UnitOfMeasureViewListener> {
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure);

	public UnitOfMeasure getUnitOfMeasure();

	public void close();
}
