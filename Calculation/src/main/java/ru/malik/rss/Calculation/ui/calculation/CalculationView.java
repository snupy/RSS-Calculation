package ru.malik.rss.Calculation.ui.calculation;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListView;
import ru.malik.rss.Calculation.ui.mvc.View;

public interface CalculationView extends View<CalculationViewListener>{
	public void setCalculation(ProductCalculation calculation);
	public MaterialResourceListView getMaterialResourceListView();
	public void save();
}
