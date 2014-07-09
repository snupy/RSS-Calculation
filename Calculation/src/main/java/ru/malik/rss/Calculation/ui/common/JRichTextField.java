package ru.malik.rss.Calculation.ui.common;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JRichTextField<T> extends JPanel {
	private JButton button;
	private JTextField textField;
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		textField.setText(getValueStringView(value));
		firePropertyChange("value", this.value,
				this.value = value);

	}

	public String getValueStringView(T value) {
		return (value != null) ? value.toString() : "";
	}

	public JRichTextField() {
		super();
		init();
		initComponents();
	}

	public void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		setLayout(gridBagLayout);
	}

	public void initComponents() {

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.weightx = 1.0;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		button = new JButton("...");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		add(button, gbc_button);
	}

	public JButton getButton() {
		return button;
	}

	public JTextField getTextField() {
		return textField;
	}

}
