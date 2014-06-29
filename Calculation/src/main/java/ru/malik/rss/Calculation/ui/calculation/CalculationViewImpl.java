package ru.malik.rss.Calculation.ui.calculation;

import javax.swing.JPanel;

import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.common.Announcer;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import ru.malik.rss.Calculation.ui.common.JRichTextField;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.malik.rss.Calculation.ui.common.ListPanel;

import javax.swing.JTable;

public class CalculationViewImpl extends JPanel implements CalculationView {
	private final Announcer<CalculationViewListener> announcer = new Announcer<CalculationViewListener>(
	CalculationViewListener.class);
	private JTable materialResourceListTable;
	
	private ProductCalculation calculation;

	public CalculationViewImpl() {
		init();
		initComponents();

	}

	public void init() {
		setLayout(new BorderLayout(0, 0));
	}

	public void initComponents() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(0);
		add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Сводная", null, scrollPane, null);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] {0, 1};
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Номенклатура:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JRichTextField richTextField = new JRichTextField();
		GridBagConstraints gbc_richTextField = new GridBagConstraints();
		gbc_richTextField.fill = GridBagConstraints.BOTH;
		gbc_richTextField.gridx = 1;
		gbc_richTextField.gridy = 0;
		panel.add(richTextField, gbc_richTextField);

		ListPanel listPanel = new ListPanel();
		tabbedPane.addTab("Сырье", null, listPanel, null);
		listPanel.addActionListner(new ActionListener() {

			public void actionPerformed(ActionEvent evnt) {
				if (ListPanel.ActionCommands.ADD_ITEM.name().equals(
						evnt.getActionCommand())) {
					// TODO тут добавление в спискок материавльных ресурсов
				} else if (ListPanel.ActionCommands.EDIT_ITEM.name().equals(
						evnt.getActionCommand())) {
					// TODO тут редактирование списка материавльных ресурсов
				} else if (ListPanel.ActionCommands.REMOVE_ITEM.name().equals(
						evnt.getActionCommand())) {
					// TODO тут удаление из спискока материавльных ресурсов
				}
			}
		});

		materialResourceListTable = new JTable();
		listPanel.getContainer().add(materialResourceListTable);
	}

	public void addViewListener(CalculationViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(CalculationViewListener listener) {
		announcer.removeListener(listener);
	}

	public void setMaterialResourceListTableModel(
			MaterialResourceListTableModel tableModel) {
		materialResourceListTable.setModel(tableModel);
	}

	public MaterialResourceListTableModel getMaterialResourceListTableModel() {
		return (MaterialResourceListTableModel) materialResourceListTable
				.getModel();
	}

	public void setCalculation(ProductCalculation calculation) {
		this.calculation = calculation;
	}
}
