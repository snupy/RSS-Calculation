package ru.malik.rss.Calculation.ui.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface View<L extends ViewListener> {
	public void addViewListner(L listener);

	public void removeViewListner(L listener);
	}
