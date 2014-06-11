package ru.malik.rss.Calculation.ui.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewImpl<L extends ViewListener> implements View<L> {
	
	private final ArrayList<L> actionListeners = new ArrayList<L>();

	public void addViewListener(L listener) {
		actionListeners.add(listener);
	}

	public void removeViewListener(L listener) {
		actionListeners.remove(listener);

	}

}
