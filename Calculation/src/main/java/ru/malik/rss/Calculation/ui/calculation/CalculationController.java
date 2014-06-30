package ru.malik.rss.Calculation.ui.calculation;

import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListController;
import ru.malik.rss.Calculation.ui.mvc.Controller;

public interface CalculationController extends Controller<CalculationModel, CalculationView>, CalculationModelListener, CalculationViewListener{

	public MaterialResourceListController getMaterialResourceListController();

}
