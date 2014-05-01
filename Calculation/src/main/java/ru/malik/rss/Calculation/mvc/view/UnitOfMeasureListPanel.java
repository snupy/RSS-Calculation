package ru.malik.rss.Calculation.mvc.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.Selectable;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

public class UnitOfMeasureListPanel extends JPanel implements
		ModelView<ArrayList<UnitOfMeasure>>, Selectable<UnitOfMeasure> {
	private ArrayList<UnitOfMeasure> model;
	private JTable table;
	private UnitOfMeasureTableModel tableModel;
	private Announcer<SelectEventListener> selectAnnouncer = new Announcer<SelectEventListener>(
			SelectEventListener.class);

	public ArrayList<UnitOfMeasure> getModel() {
		return this.model;
	}

	public UnitOfMeasureListPanel() {
		super(new BorderLayout());
		table = new JTable();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent event) {
				select();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public UnitOfMeasureListPanel(ArrayList<UnitOfMeasure> model) {
		this();
		setModel(model);
	}

	public void setModel(ArrayList<UnitOfMeasure> model) {
		setModel(model, true);
	}

	public void setModel(ArrayList<UnitOfMeasure> model, boolean update) {
		this.model = model;
		if (update) {
			table.setModel(tableModel = new UnitOfMeasureTableModel(this.model));
		}

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

	public void cancel() {
		// TODO Auto-generated method stub

	}

	public void addCancelListener(CancelEventListener listner) {
		// TODO Auto-generated method stub

	}

	public void select() {
		selectAnnouncer.announce().select(new EventObject(this));
	}

	public void addSelectListener(SelectEventListener listener) {
		selectAnnouncer.addListener(listener);
	}

	public void removeCancelListener(CancelEventListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeSelectListener(SelectEventListener listener) {
		selectAnnouncer.removeListener(listener);
	}

}
