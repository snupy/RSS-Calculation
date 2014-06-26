package ru.malik.rss.Calculation.mvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.reflect.Proxy;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import javax.swing.JTextPane;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class UnitOfMesureViewPanel extends JPanel implements
		ModelView<UnitOfMeasure> {

	private BindingGroup m_bindingGroup;
	private ru.malik.rss.Calculation.entity.UnitOfMeasure unitOfMeasure = new ru.malik.rss.Calculation.entity.UnitOfMeasure();
	private Nomenclature nomenclature;
	private JTextField nameJTextField;
	public AutoBinding<ru.malik.rss.Calculation.entity.UnitOfMeasure, java.lang.String, javax.swing.JTextField, java.lang.String> modelAutoBinding;
	private JTextPane textPane_1;
	private JTextPane textPane;

	public UnitOfMesureViewPanel(
			ru.malik.rss.Calculation.entity.UnitOfMeasure newUnitOfMeasure) {
		this();
		setModel(newUnitOfMeasure);

	}

	public UnitOfMesureViewPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel nameLabel = new JLabel("Имя:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(nameLabel, labelGbc_0);

		nameJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 0);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(nameJTextField, componentGbc_0);
		
		textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 1;
		add(textPane_1, gbc_textPane_1);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 2;
		add(textPane, gbc_textPane);

		if (unitOfMeasure != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	public ru.malik.rss.Calculation.entity.UnitOfMeasure getModel() {
		return unitOfMeasure;
	}

	public boolean setModel(ru.malik.rss.Calculation.entity.UnitOfMeasure newUnitOfMeasure) {
		return setModel(newUnitOfMeasure, true);
	}

	public boolean setModel(
			ru.malik.rss.Calculation.entity.UnitOfMeasure newUnitOfMeasure,
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
		return true;
	}
	protected BindingGroup initDataBindings() {
		BeanProperty<UnitOfMeasure, String> nameProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		modelAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, unitOfMeasure, nameProperty, nameJTextField, textProperty);
		modelAutoBinding.bind();
		//
		BeanProperty<Nomenclature, String> nomenclatureBeanProperty = BeanProperty.create("name");
		BeanProperty<JTextPane, String> jTextPaneBeanProperty = BeanProperty.create("text");
		AutoBinding<Nomenclature, String, JTextPane, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, nomenclature, nomenclatureBeanProperty, textPane_1, jTextPaneBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Nomenclature, String> nomenclatureBeanProperty_1 = BeanProperty.create("unitOfMeasures.name");
		BeanProperty<JTextPane, String> jTextPaneBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Nomenclature, String, JTextPane, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, nomenclature, nomenclatureBeanProperty_1, textPane, jTextPaneBeanProperty_1);
		autoBinding_1.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(modelAutoBinding);
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		return bindingGroup;
	}
}
