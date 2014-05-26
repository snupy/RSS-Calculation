package ru.malik.rss.Calculation.ui.common;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class EditPanel extends JPanel {
	private JPanel southPanel;

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
	}
	
	public JPanel createSouthPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton okButton = new JButton("Ok");
		panel.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		return panel;
	}
}
