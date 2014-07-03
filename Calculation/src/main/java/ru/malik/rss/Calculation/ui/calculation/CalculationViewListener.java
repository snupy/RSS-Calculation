package ru.malik.rss.Calculation.ui.calculation;

import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface CalculationViewListener extends ViewListener{
	public void applyChanges(CalculationView sender);
	public void cancel(CalculationView sender);
}
