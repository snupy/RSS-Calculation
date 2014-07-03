package ru.malik.rss.Calculation.ui.common.editPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ru.malik.rss.Calculation.ui.common.Announcer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel {
	private JPanel southPanel;
	private JPanel containerPanel;
	private JButton okButton, cancelButton;
	final private Announcer<EditPanelListener> announcer = new Announcer<EditPanelListener>(
			EditPanelListener.class);

	public enum ActionCommand {
		OK, CANCEL
	}

	public void addEditPanelListener(EditPanelListener listener) {
		announcer.addListener(listener);
	}

	public void removeEditPanelListener(EditPanelListener listener) {
		announcer.removeListener(listener);
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
				announcer.announce().okActionPerformed(EditPanel.this);
			}
		});

		panel.add(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand(ActionCommand.CANCEL.name());
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				announcer.announce().cancelActionPerformed(EditPanel.this);
			}
		});

		panel.add(cancelButton);
		return panel;
	}

	public JPanel getContainerPanel() {
		return containerPanel;
	}
}
