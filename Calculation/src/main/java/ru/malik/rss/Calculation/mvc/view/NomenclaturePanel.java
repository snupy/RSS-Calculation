package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class NomenclaturePanel extends JPanel {
	private JTextField textName;
	private JTextField textUnitOfMeasure;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public NomenclaturePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Наименование");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.gridwidth = 2;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 0;
		add(textName, gbc_textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Единица измерения:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textUnitOfMeasure = new JTextField();
		textUnitOfMeasure.setEditable(false);
		GridBagConstraints gbc_textUnitOfMeasure = new GridBagConstraints();
		gbc_textUnitOfMeasure.insets = new Insets(0, 0, 0, 5);
		gbc_textUnitOfMeasure.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUnitOfMeasure.gridx = 1;
		gbc_textUnitOfMeasure.gridy = 1;
		add(textUnitOfMeasure, gbc_textUnitOfMeasure);
		textUnitOfMeasure.setColumns(10);
		
		btnNewButton = new JButton("...");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

	}

}
