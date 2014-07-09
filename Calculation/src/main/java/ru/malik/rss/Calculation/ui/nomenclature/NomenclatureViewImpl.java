package ru.malik.rss.Calculation.ui.nomenclature;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.common.Announcer;
import ru.malik.rss.Calculation.ui.common.JMdiFrame;
import ru.malik.rss.Calculation.ui.common.JRichTextField;
import ru.malik.rss.Calculation.ui.common.editPanel.EditPanel;
import ru.malik.rss.Calculation.ui.common.editPanel.EditPanelListener;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;
import org.jdesktop.beansbinding.PropertyStateEvent;
import org.jdesktop.beansbinding.PropertyStateListener;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import javax.swing.JScrollPane;

public class NomenclatureViewImpl extends JMdiFrame implements NomenclatureView {

	private Nomenclature nomenclature;

	private BindingGroup bindingGroup;

	private final Announcer<NomenclatureViewListener> announcer = new Announcer<NomenclatureViewListener>(
			NomenclatureViewListener.class);

	private EditPanel editPanel;
	private JTextField textFieldName;
	private JRichTextField<UnitOfMeasure> richTextFieldUnitOfMeasure;

	public void addViewListener(NomenclatureViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(NomenclatureViewListener listener) {
		announcer.removeListener(listener);
	}

	public NomenclatureViewImpl() {
		init();
		initComponents();
	}

	public void init() {

	}

	public void initComponents() {
		editPanel = new EditPanel();
		editPanel.addEditPanelListener(new EditPanelListener() {
			
			public void okActionPerformed(Object sender) {
				announcer.announce().okActionPerform(NomenclatureViewImpl.this);
			}
			
			public void cancelActionPerformed(Object sender) {
				announcer.announce().cancelActionPerform(
						NomenclatureViewImpl.this);
			}
		});
		getContentPane().add(editPanel);
		editPanel.getContainerPanel().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		editPanel.getContainerPanel().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Основное", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Наименование");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textFieldName = new JTextField();
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.weightx = 1.0;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 0;
		panel.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Ед. изм.");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		richTextFieldUnitOfMeasure = new JRichTextField<UnitOfMeasure>(){

			@Override
			public String getValueStringView(UnitOfMeasure value) {
				return value.getName();
			}
		};
		richTextFieldUnitOfMeasure.getButton().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						announcer.announce().openUnitOfMeasuresList(
								NomenclatureViewImpl.this);
					}
				});

		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.weightx = 1.0;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(richTextFieldUnitOfMeasure, gbc_textField_1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ед. изм.", null, panel_1, null);

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		bindingGroup = createDataBindings();

		pack();
	}

	private UnitOfMeasure unitOfMeasure;

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	private AutoBinding<Nomenclature, UnitOfMeasure, JRichTextField<UnitOfMeasure>, UnitOfMeasure> unitOfMeasureAutoBinding;
	private AutoBinding<Nomenclature, String, JTextField, String> nameAutoBinding;

	private BeanProperty<Nomenclature, String> nomenclatureNameBeanProperty;

	private BeanProperty<Nomenclature, UnitOfMeasure> nomenclatureUnitOfMeasureBeanProperty;

	protected BindingGroup createDataBindings() {

		BindingGroup resultBindingGroup = new BindingGroup();
		if (nomenclature == null) {
			return resultBindingGroup;
		}
		;
		nomenclatureNameBeanProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		nameAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ,
				nomenclature, nomenclatureNameBeanProperty, textFieldName,
				jTextFieldBeanProperty);
		resultBindingGroup.addBinding(nameAutoBinding);

		nomenclatureUnitOfMeasureBeanProperty = BeanProperty
				.create("unitOfMeasures");
		BeanProperty<JRichTextField<UnitOfMeasure>, UnitOfMeasure> jRichTextValueFieldBeanProperty = BeanProperty
				.create("value");

		unitOfMeasureAutoBinding = Bindings.createAutoBinding(
				UpdateStrategy.READ_ONCE, nomenclature,
				nomenclatureUnitOfMeasureBeanProperty, richTextFieldUnitOfMeasure,
				jRichTextValueFieldBeanProperty);
		resultBindingGroup.addBinding(unitOfMeasureAutoBinding);
		return resultBindingGroup;
	}

	public void setNomenclature(Nomenclature nomenclature) {
		// проверяем производится ли действительно изменение
		if (this.nomenclature == nomenclature) {
			return;
		}

		// зануляем наш текущий bind
		if (bindingGroup != null) {
			bindingGroup.unbind();
			bindingGroup = null;
		}

		// обновлеяем нашу сущность
		this.nomenclature = nomenclature;
		if (this.nomenclature != null) {
			bindingGroup = createDataBindings();
			bindingGroup.bind();
		}

	}

	public Nomenclature getNomenclature() {
		return this.nomenclature;
	}

	public void close() {
		this.dispose();
	}

	public void setNomenclatureName(String name) {
		nameAutoBinding.getTargetProperty().setValue(
				nameAutoBinding.getTargetObject(), name);
	}

	public void setNomenclatureUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		richTextFieldUnitOfMeasure.setValue(unitOfMeasure);
	}

	public void save() {
		for (Binding binding : bindingGroup.getBindings()) {
			binding.save();
		}
	}
}
