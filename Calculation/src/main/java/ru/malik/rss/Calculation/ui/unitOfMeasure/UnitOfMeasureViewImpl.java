package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.util.ArrayList;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.common.EditPanel;
import ru.malik.rss.Calculation.ui.common.JMdiFrame;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.beans.PropertyVetoException;

import javax.swing.JTextField;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class UnitOfMeasureViewImpl extends JMdiFrame implements
		UnitOfMeasureView {
	private UnitOfMeasure unitOfMeasure;
	private EditPanel editPanel;
	private BindingGroup bindingGroup = new BindingGroup();

	public UnitOfMeasureViewImpl() {
		init();
		initComponents();
	}

	private final ArrayList<UnitOfMeasureViewListener> viewListeners = new ArrayList<UnitOfMeasureViewListener>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public void addViewListner(UnitOfMeasureViewListener listener) {
		viewListeners.add(listener);
	}

	public void removeViewListner(UnitOfMeasureViewListener listener) {
		viewListeners.remove(listener);
	}

	public void init() {
		editPanel = new EditPanel() {

			@Override
			public void sendOk() {
				sendSave();
				super.sendOk();
			}

			@Override
			public void sendCancel() {
				sendClose();
				super.sendCancel();
			}
		};
		setContentPane(editPanel);
	}

	public void sendSave() {
		for (UnitOfMeasureViewListener viewListener : viewListeners) {
			viewListener.sendSave(this);
		}
	}

	public void sendClose() {
		for (UnitOfMeasureViewListener viewListener : viewListeners) {
			viewListener.sendClose(this);
		}
	}

	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		editPanel.getContainerPanel().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Наименование");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		editPanel.getContainerPanel().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		editPanel.getContainerPanel().add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Короткое наименование");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		editPanel.getContainerPanel().add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		editPanel.getContainerPanel().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Код ОКЕИ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		editPanel.getContainerPanel().add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		editPanel.getContainerPanel().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		initDataBindings();
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		if (this.unitOfMeasure != unitOfMeasure) {
			this.unitOfMeasure = unitOfMeasure;
			if (this.unitOfMeasure != null) {
				bindingGroup.bind();
			}
		}
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return this.unitOfMeasure;
	}

	protected void initDataBindings() {
		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty = BeanProperty
				.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, unitOfMeasure,
						unitOfMeasureBeanProperty, textField,
						jTextFieldBeanProperty, "unitOfMeasureNameBind");
		bindingGroup.addBinding(autoBinding);
		autoBinding.bind();
		//
		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty_1 = BeanProperty
				.create("shortName");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, unitOfMeasure,
						unitOfMeasureBeanProperty_1, textField_1,
						jTextFieldBeanProperty_1);
		bindingGroup.addBinding(autoBinding_1);
		autoBinding_1.bind();
		//
		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty_2 = BeanProperty
				.create("codeOKEI");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ, unitOfMeasure,
						unitOfMeasureBeanProperty_2, textField_2,
						jTextFieldBeanProperty_2);
		bindingGroup.addBinding(autoBinding_2);
		autoBinding_2.bind();
	}

	public void close() {
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}