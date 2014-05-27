package ru.malik.rss.Calculation.ui.common;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel {
	private JPanel southPanel;
	private JPanel containerPanel;
	private JButton okButton, cancelButton;

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

		okButton = new JButton("Ok");
		okButton.setActionCommand(ActionCommand.OK.name());
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendOk();
			}
		});

		panel.add(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand(ActionCommand.CANCEL.name());
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendCancel();
			}
		});

		panel.add(cancelButton);
		return panel;
	}

	public JPanel getContainerPanel() {
		return containerPanel;
	}

	public void sendOk() {

	}

	public void sendCancel() {

	}
}
