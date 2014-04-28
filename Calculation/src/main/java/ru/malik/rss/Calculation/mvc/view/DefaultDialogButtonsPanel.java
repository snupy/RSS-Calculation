package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	}
	
	public static DefaultDialogButtonsPanel createDefaultDialogButtonsOkCancelPanel(ActionListener aclOk, ActionListener aclCancel) {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		buttons.add(new DialogButtonsFactory().createJButton(DialogButtonsFactory.DB_OK, aclOk));
		buttons.add(new DialogButtonsFactory().createJButton(DialogButtonsFactory.DB_CANCEL, aclCancel));
		
		return new DefaultDialogButtonsPanel(buttons);
	}
}
