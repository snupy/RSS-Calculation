package ru.malik.rss.Calculation.ui.main;

import java.awt.Container;

import ru.malik.rss.Calculation.ui.mvc.View;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface MainViewListener extends ViewListener {
	public View<?> openCalculationRegister(View<?> view, Container container);
}
