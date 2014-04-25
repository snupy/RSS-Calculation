package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;

public class DefaultDialogButtonsPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public DefaultDialogButtonsPanel(ArrayList<JButton> buttons) {
		super();
		for (int i = 0; i < buttons.size(); i++) {
			add(buttons.get(i));
		}

		add(new JLabel(Integer.toString(buttons.size())));

	}
}
