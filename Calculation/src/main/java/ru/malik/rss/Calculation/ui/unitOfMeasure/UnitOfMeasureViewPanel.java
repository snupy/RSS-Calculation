package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnitOfMeasureViewPanel extends JPanel implements UnitOfMeasureView {
	private JTextField tfName;
	private JTextField tfShortName;
	private JTextField tfOkei;

	private final ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();

	public void addActionListner(ActionListener listener) {
		actionListeners.add(listener);
	}

	public void removeActionListner(ActionListener listener) {
		actionListeners.remove(listener);
	}

	public UnitOfMeasureViewPanel() {
		init();
		initComponents();
	}

	public void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		setLayout(gridBagLayout);
	}

	public void initComponents() {
		JLabel lblName = new JLabel("Наименование");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);

		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.insets = new Insets(0, 0, 5, 0);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 0;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);

		JLabel lblShortName = new JLabel("Краткое наименование");
		GridBagConstraints gbc_lblShortName = new GridBagConstraints();
		gbc_lblShortName.anchor = GridBagConstraints.EAST;
		gbc_lblShortName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortName.gridx = 0;
		gbc_lblShortName.gridy = 1;
		add(lblShortName, gbc_lblShortName);

		tfShortName = new JTextField();
		GridBagConstraints gbc_tfShortName = new GridBagConstraints();
		gbc_tfShortName.insets = new Insets(0, 0, 5, 0);
		gbc_tfShortName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfShortName.gridx = 1;
		gbc_tfShortName.gridy = 1;
		add(tfShortName, gbc_tfShortName);
		tfShortName.setColumns(10);

		JLabel lblOkei = new JLabel("Код по ОКЕИ");
		GridBagConstraints gbc_lblOkei = new GridBagConstraints();
		gbc_lblOkei.anchor = GridBagConstraints.EAST;
		gbc_lblOkei.insets = new Insets(0, 0, 0, 5);
		gbc_lblOkei.gridx = 0;
		gbc_lblOkei.gridy = 2;
		add(lblOkei, gbc_lblOkei);

		tfOkei = new JTextField();
		GridBagConstraints gbc_tfOkei = new GridBagConstraints();
		gbc_tfOkei.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfOkei.gridx = 1;
		gbc_tfOkei.gridy = 2;
		add(tfOkei, gbc_tfOkei);
		tfOkei.setColumns(10);
	}

	public void setUnitOfMeasureName(String value) {
		tfName.setText(value);
	}

	public void setUnitOfMeasureShortName(String value) {
		tfShortName.setText(value);
	}

	public void setUnitOfMeasureOkei(String value) {
		tfOkei.setText(value);
	}

	public String getUnitOfMeasureName() {
		return tfName.getText();
	}

	public String getUnitOfMeasureShortName() {
		return tfShortName.getText();
	}

	public String getUnitOfMeasureOkei() {
		return tfOkei.getText();
	}
	
	public void fireAction(ActionEvent actionEvent) {
		for(ActionListener actionListener: actionListeners){
			actionListener.actionPerformed(actionEvent);
		}
	}
}
