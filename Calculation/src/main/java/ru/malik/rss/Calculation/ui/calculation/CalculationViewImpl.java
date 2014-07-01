package ru.malik.rss.Calculation.ui.calculation;

import javax.swing.JPanel;

import ru.malik.rss.Calculation.entity.Product;
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
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListTableModel;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListView;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListViewImpl;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.PropertyStateEvent;
import org.jdesktop.beansbinding.PropertyStateListener;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import java.sql.Date;

import javax.swing.JFormattedTextField;

public class CalculationViewImpl extends JPanel implements CalculationView {
	private final Announcer<CalculationViewListener> announcer = new Announcer<CalculationViewListener>(
			CalculationViewListener.class);
	private MaterialResourceListViewImpl materialResourceListView;

	private ProductCalculation calculation;
	private JTextField textField;
	private JXDatePicker datePicker;
	private JRichTextField richTextField;

	public CalculationViewImpl() {
		init();
		initComponents();

	}

	public void init() {
		setLayout(new BorderLayout(0, 0));
	}

	public void initComponents() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Сводная", null, scrollPane, null);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 30 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0 };
		panel.setLayout(gbl_panel);

		JLabel label = new JLabel("Номер");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weightx = 1.0;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		datePicker = new JXDatePicker();
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.insets = new Insets(0, 0, 5, 0);
		gbc_datePicker.gridx = 3;
		gbc_datePicker.gridy = 0;
		panel.add(datePicker, gbc_datePicker);

		JLabel lblNewLabel = new JLabel("Номенклатура:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.ipady = 1;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		richTextField = new JRichTextField();
		GridBagConstraints gbc_richTextField = new GridBagConstraints();
		gbc_richTextField.gridwidth = 3;
		gbc_richTextField.insets = new Insets(0, 0, 5, 0);
		gbc_richTextField.ipady = 1;
		gbc_richTextField.fill = GridBagConstraints.BOTH;
		gbc_richTextField.gridx = 1;
		gbc_richTextField.gridy = 1;
		panel.add(richTextField, gbc_richTextField);

		JLabel label_1 = new JLabel("дата");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);

		materialResourceListView = new MaterialResourceListViewImpl();
		tabbedPane.addTab("Сырье", null, materialResourceListView, null);
		materialResourceListView.setVisible(true);

		initBeanProperties();

		initBindingGroup();
		bindingGroup.bind();

	}

	public void addViewListener(CalculationViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(CalculationViewListener listener) {
		announcer.removeListener(listener);
	}

	public void setCalculation(ProductCalculation calculation) {
		if (this.calculation != calculation) {
			this.calculation = calculation;
			initBindingGroup();
			bindingGroup.bind();
		}
	}

	public MaterialResourceListView getMaterialResourceListView() {
		return this.materialResourceListView;
	}

	private BeanProperty<ProductCalculation, String> productCalculationNumberBeanProperty;
	private BeanProperty<ProductCalculation, Product> productCalculationProductBeanProperty;
	private BeanProperty<JTextField, String> jTextFieldBeanProperty;
	private BeanProperty<ProductCalculation, Date> productCalculationDateBeanProperty;
	private BeanProperty<JFormattedTextField, Object> jFormattedTextFieldBeanProperty;
	private BindingGroup bindingGroup;

	protected void initBeanProperties() {
		productCalculationNumberBeanProperty = BeanProperty.create("number");
		jTextFieldBeanProperty = BeanProperty.create("text");
		productCalculationDateBeanProperty = BeanProperty.create("date");
		jFormattedTextFieldBeanProperty = BeanProperty.create("value");
		productCalculationProductBeanProperty = BeanProperty.create("product");
	}

	protected void initBindingGroup() {
		bindingGroup = new BindingGroup();

		AutoBinding<ProductCalculation, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, calculation,
						productCalculationNumberBeanProperty, textField,
						jTextFieldBeanProperty);
		bindingGroup.addBinding(autoBinding);

		AutoBinding<ProductCalculation, Date, JFormattedTextField, Object> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, calculation,
						productCalculationDateBeanProperty,
						datePicker.getEditor(), jFormattedTextFieldBeanProperty);
		bindingGroup.addBinding(autoBinding_1);

		/*
		 * productCalculationProductBeanProperty.addPropertyStateListener(
		 * calculation, new PropertyStateListener() {
		 * 
		 * public void propertyStateChanged(PropertyStateEvent event) {
		 * richTextField.getTextField().setText( ((Product)
		 * event.getNewValue()).getName()); } });
		 * productCalculationProductBeanProperty.
		 */
	}
}
