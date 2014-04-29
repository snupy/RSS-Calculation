package ru.malik.rss.Calculation.mvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMesureViewPanel extends JPanel implements ModelView<UnitOfMeasure> {

	private BindingGroup m_bindingGroup;
	private ru.malik.economics.model.UnitOfMeasure unitOfMeasure = new ru.malik.economics.model.UnitOfMeasure();
	private JTextField nameJTextField;

	public UnitOfMesureViewPanel(
			ru.malik.economics.model.UnitOfMeasure newUnitOfMeasure) {
		this();
		setModel(newUnitOfMeasure);
	}

	public UnitOfMesureViewPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel nameLabel = new JLabel("Имя:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(nameLabel, labelGbc_0);

		nameJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(nameJTextField, componentGbc_0);

		if (unitOfMeasure != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<ru.malik.economics.model.UnitOfMeasure, java.lang.String> nameProperty = BeanProperty
				.create("name");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty = BeanProperty
				.create("text");
		AutoBinding<ru.malik.economics.model.UnitOfMeasure, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
						unitOfMeasure, nameProperty, nameJTextField,
						textProperty);
		autoBinding.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		//
		return bindingGroup;
	}

	public ru.malik.economics.model.UnitOfMeasure getModel() {
		return unitOfMeasure;
	}

	public void setModel(
			ru.malik.economics.model.UnitOfMeasure newUnitOfMeasure) {
		setModel(newUnitOfMeasure, true);
	}

	public void setModel(
			ru.malik.economics.model.UnitOfMeasure newUnitOfMeasure,
			boolean update) {
		unitOfMeasure = newUnitOfMeasure;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (unitOfMeasure != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
