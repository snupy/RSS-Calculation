package ru.malik.rss.Calculation.ui.calculationRegister;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import ru.malik.rss.Calculation.ui.common.Announcer;
import ru.malik.rss.Calculation.ui.common.ListPanel;
import ru.malik.rss.Calculation.ui.mvc.View;
import ru.malik.rss.Calculation.ui.test.JTreeTable;
import ru.malik.utils.HibernateUtil;
import ru.malik.utils.ProductCalculcationDAO;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CalculationRegisterViewImpl extends JInternalFrame implements
		CalculationRegisterView {
	public final static Dimension minimumDimension = new Dimension(300, 150);

	private final Announcer<CalculationRegisterViewListener> announcer = new Announcer<CalculationRegisterViewListener>(
			CalculationRegisterViewListener.class);

	private JTable table;

	private ListPanel listPanel;

	public CalculationRegisterViewImpl() {
		init();
		initComponents();
		updateUI();
	}

	public void init() {
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);

		setSize(minimumDimension);
		setMinimumSize(minimumDimension);
	}

	public void initComponents() {
		listPanel = new ListPanel();
		setContentPane(listPanel);

		JScrollPane jScrollPane = new JScrollPane();
		listPanel.getContainer().add(jScrollPane);
		listPanel.addActionListner(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				if(ListPanel.ActionCommands.ADD_ITEM.name().equals(event.getActionCommand())){
					announcer.announce().addCalculation(CalculationRegisterViewImpl.this);
				}
			}
		});
		

		table = new JTable();
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent event) {
						ListSelectionModel lsm = (ListSelectionModel) event
								.getSource();
						int selRowIndx = lsm.getAnchorSelectionIndex();
						announcer.announce().selectRow(selRowIndx,
								CalculationRegisterViewImpl.this);
					}
				});
		jScrollPane.setViewportView(table);
	}

	public void addViewListener(CalculationRegisterViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(CalculationRegisterViewListener listener) {
		announcer.removeListener(listener);
	}

	public void setCalculationRegisterTableModel(
			CalculationRegisterTableModel tableModel) {
		table.setModel(tableModel);
	}

	public void setSelectedRow(int index) {
		table.getSelectionModel().setSelectionInterval(index, index);
		listPanel.setSelectedCaption(String.valueOf(index));
	}

	public void setRowCount(int count) {
		listPanel.setRowsCount(count);
	}

}
