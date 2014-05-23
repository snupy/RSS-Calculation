package ru.malik.rss.Calculation.mvc.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.view.FrameFacory;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureEditPanel;

public class UnitOfMeasureCallAddListener extends AbstractAction {
	{
		putValue(NAME, "Добавить");
	}

	public void actionPerformed(ActionEvent arg0) {
		JFrame frame= FrameFacory.getInstance().getNewFrame();
		frame.add(new UnitOfMeasureEditPanel(new UnitOfMeasure()));
		frame.pack();
		frame.setVisible(true);
	}

}
