package ru.malik.rss.Calculation.mvc.view;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import org.apache.commons.collections.set.CompositeSet.SetMutator;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureWindow extends DefaultEditWindow {

	private UnitOfMeasure model;

	private JTextField textField;

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitOfMeasureWindow window = new UnitOfMeasureWindow(
							new UnitOfMeasure());
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public UnitOfMeasureWindow(UnitOfMeasure model) {
		super();
		setModel(model);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void initialize() {
		super.initialize();
		/*
		 * frame = new JFrame(); frame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.getContentPane().setLayout(new BorderLayout(0, 0));
		 * 
		 * JPanel panel = new JPanel(); frame.getContentPane().add(panel,
		 * BorderLayout.CENTER);
		 */
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0 };
		getPanContent().setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Наименование");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getPanContent().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weighty = 1.0;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getPanContent().add(textField, gbc_textField);
		textField.setColumns(10);
		getFrame().pack();
	}

	public UnitOfMeasure getModel() {
		return model;
	}

	public void setModel(UnitOfMeasure model) {
		this.model = model;
		if (this.model != null) {
			textField.setText(this.model.getName());
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void okPerformed() {
		if (this.model != null) {
			model.setName(textField.getText());
		}
		getFrame().dispose();
		super.okPerformed();
	}

}
