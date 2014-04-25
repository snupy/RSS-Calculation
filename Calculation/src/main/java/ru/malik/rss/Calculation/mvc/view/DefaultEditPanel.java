package ru.malik.rss.Calculation.mvc.view;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public abstract class DefaultEditPanel extends JPanel {

	public final AbstractAction acSave = new AbstractAction() {
		{
			putValue(NAME, DialogButtonsFactory.DB_YES);
		}

		public void actionPerformed(ActionEvent e) {

			save();
		}
	};

	public final AbstractAction acCancel = new AbstractAction() {
		{
			putValue(NAME, DialogButtonsFactory.DB_CANCEL);
		}

		public void actionPerformed(ActionEvent e) {

			cancel();
		}
	};

	/**
	 * Create the panel.
	 */
	public DefaultEditPanel() {
		setLayout(new BorderLayout(0, 0));
		ArrayList<JButton> dialogButtons = new ArrayList<JButton>();

		dialogButtons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_YES, acSave));

		dialogButtons.add(DialogButtonsFactory.createJButton(
				DialogButtonsFactory.DB_CANCEL, acCancel));
		

		int ss = dialogButtons
				.size()+1;
		DefaultDialogButtonsPanel defaultDialogButtonsPanel = new DefaultDialogButtonsPanel(
				dialogButtons);
		defaultDialogButtonsPanel.add(new JLabel(Integer.toString(ss)));
		add(defaultDialogButtonsPanel, BorderLayout.CENTER);

	}

	public abstract void save();

	public abstract void cancel();

}
