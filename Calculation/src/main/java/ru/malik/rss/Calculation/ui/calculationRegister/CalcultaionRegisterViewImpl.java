package ru.malik.rss.Calculation.ui.calculationRegister;

import java.util.ArrayList;

import javax.swing.JInternalFrame;

import ru.malik.rss.Calculation.ui.common.ListPanel;
import ru.malik.rss.Calculation.ui.mvc.View;
import ru.malik.rss.Calculation.ui.test.JTreeTable;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;

public class CalcultaionRegisterViewImpl extends JInternalFrame implements
		CalcultaionRegisterView {
	public final static Dimension minimumDimension = new Dimension(300,150);

	private ListPanel listPanel;

	public CalcultaionRegisterViewImpl() {
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
		
		table = new JTable(new CalculationRegisterTableModel());
		
		jScrollPane.setViewportView(table);
	}

	private final ArrayList<CalculationRegisterViewListener> calculationViewListeners = new ArrayList<CalculationRegisterViewListener>();
	private JTable table;

	public void addViewListener(CalculationRegisterViewListener listener) {
		calculationViewListeners.add(listener);
	}

	public void removeViewListener(CalculationRegisterViewListener listener) {
		calculationViewListeners.remove(listener);
	}

}
