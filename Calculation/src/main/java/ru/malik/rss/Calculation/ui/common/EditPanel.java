package ru.malik.rss.Calculation.ui.common;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class EditPanel extends JPanel {
	private JPanel southPanel;
	private JPanel containerPanel;

	public enum ActionCommand {
		OK, CANCEL
	}

	public EditPanel() {
		init();
		initComponents();
	}

	public void init() {
		setLayout(new BorderLayout(5, 5));
	}

	public void initComponents() {
		southPanel = createSouthPanel();
		add(southPanel, BorderLayout.SOUTH);

		containerPanel = new JPanel();
		add(containerPanel, BorderLayout.CENTER);
	}

	public JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton okButton = new JButton("Ok");
		okButton.setActionCommand(ActionCommand.OK.name());
		panel.add(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand(ActionCommand.CANCEL.name());
		panel.add(cancelButton);
		return panel;
	}

	public JPanel getContainerPanel() {
		return containerPanel;
	}
}
