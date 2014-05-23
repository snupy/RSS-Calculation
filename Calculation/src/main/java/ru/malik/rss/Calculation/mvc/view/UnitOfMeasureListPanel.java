package ru.malik.rss.Calculation.mvc.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.entity.UnitOfMeasureList;
import ru.malik.rss.Calculation.mvc.Selectable;
import ru.malik.rss.Calculation.mvc.controller.UnitOfMeasureCallAddListener;
import ru.malik.rss.Calculation.mvc.events.ListEventObject;
import ru.malik.rss.Calculation.mvc.events.listners.AddEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.RemoveEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

public class UnitOfMeasureListPanel extends JPanel implements
		ModelView<UnitOfMeasureList>, Selectable<UnitOfMeasure>, ListView {
	private UnitOfMeasureList model;
	private JTable table;
	private UnitOfMeasureTableModel tableModel;
	private ListEditorToolbar listEditorToolbar;
	private Announcer<SelectEventListener> selectAnnouncer = new Announcer<SelectEventListener>(
			SelectEventListener.class);
	private Announcer<AddEventListener> addAnnouncer = new Announcer<AddEventListener>(
			AddEventListener.class);
	private Announcer<RemoveEventListener> removeAnnouncer = new Announcer<RemoveEventListener>(
			RemoveEventListener.class);

	public UnitOfMeasureList getModel() {
		return this.model;
	}

	public UnitOfMeasureListPanel() {
		super(new BorderLayout());
		table = new JTable();

		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent event) {
						select();
					}
				});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		add(listEditorToolbar = new ListEditorToolbar(), BorderLayout.NORTH);
		listEditorToolbar.getBtnAdd().addActionListener(
				new UnitOfMeasureCallAddListener());
		add(scrollPane, BorderLayout.CENTER);
	}

	public UnitOfMeasureListPanel(UnitOfMeasureList model) {
		this();
		setModel(model);
	}

	public boolean setModel(UnitOfMeasureList model) {
		return setModel(model, true);
	}

	public boolean setModel(UnitOfMeasureList model, boolean update) {
		this.model = model;
		if (update) {
			table.setModel(tableModel = new UnitOfMeasureTableModel(this.model));
		}
		return true;

	}

	public void setSelected(UnitOfMeasure obj) {
		int selectRow;
		if ((selectRow = this.model.indexOf(obj)) >= 0) {
			table.setRowSelectionInterval(selectRow, selectRow);
		}
	}

	public UnitOfMeasure getSelected() {
		return this.model.get(table.getSelectedRow());
	}

	public void select() {
		selectAnnouncer.announce().call(
				new ListEventObject(this, getModel(), getSelected()));
		;
	}

	public void addSelectListener(SelectEventListener listener) {
		selectAnnouncer.addListener(listener);
	}

	public void removeSelectListener(SelectEventListener listener) {
		selectAnnouncer.removeListener(listener);
	}

	public void addAddEventListener(AddEventListener listener) {
		addAnnouncer.addListener(listener);
	}

	public void removeAddEventListener(AddEventListener listener) {
		addAnnouncer.removeListener(listener);
	}

	public void addRemoveEventListener(RemoveEventListener listener) {
		removeAnnouncer.addListener(listener);

	}

	public void removeRemoveEventListener(RemoveEventListener listener) {
		removeAnnouncer.addListener(listener);

	}

}
