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

	private BindingGroup bindingGroup;
	private BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
			.create("text");
	private BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
			.create("text");
	private BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
			.create("text");

	public UnitOfMeasureViewImpl() {
		init();
		initComponents();
		pack();
	}

	private final ArrayList<UnitOfMeasureViewListener> viewListeners = new ArrayList<UnitOfMeasureViewListener>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public void addViewListener(UnitOfMeasureViewListener listener) {
		viewListeners.add(listener);
	}

	public void removeViewListener(UnitOfMeasureViewListener listener) {
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
			viewListener.save(this);
		}
	}

	public void sendClose() {

		for (UnitOfMeasureViewListener viewListener : viewListeners) {
			viewListener.close(this);
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

		JLabel lblNewLabel_1 = new JLabel("Краткое наименование");
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
		
		
		bindingGroup = createDataBindings();
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		if (this.unitOfMeasure != unitOfMeasure) {
			this.unitOfMeasure = unitOfMeasure;
			if (bindingGroup != null) {
				bindingGroup.unbind();
				bindingGroup = null;
			}
			if (this.unitOfMeasure != null) {
				bindingGroup = createDataBindings();
				
				bindingGroup.bind();

			}
		}
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return this.unitOfMeasure;
	}

	protected BindingGroup createDataBindings() {
		BindingGroup resultBindingGroup = new BindingGroup();
		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty = BeanProperty
				.create("name");

		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, unitOfMeasure,
						unitOfMeasureBeanProperty, textField,
						jTextFieldBeanProperty, "unitOfMeasureNameBind");
		resultBindingGroup.addBinding(autoBinding);

		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty_1 = BeanProperty
				.create("shortName");

		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, unitOfMeasure,
						unitOfMeasureBeanProperty_1, textField_1,
						jTextFieldBeanProperty_1);
		resultBindingGroup.addBinding(autoBinding_1);

		BeanProperty<UnitOfMeasure, String> unitOfMeasureBeanProperty_2 = BeanProperty
				.create("codeOKEI");

		AutoBinding<UnitOfMeasure, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ_WRITE, unitOfMeasure,
						unitOfMeasureBeanProperty_2, textField_2,
						jTextFieldBeanProperty_2);
		resultBindingGroup.addBinding(autoBinding_2);

		return resultBindingGroup;
	}

	public void close() {
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {

			e.printStackTrace();
		}
	}
}
