package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.malik.rss.Calculation.ui.common.ListPanel;

public class UnitOfMeasureListViewImpl extends JInternalFrame implements
		UnitOfMeasureListView {
	private ListPanel listPanel;
	private JTable table;

	public final static Dimension minimumDimension = new Dimension(300, 150);

	public UnitOfMeasureListViewImpl() {
		init();
		initComponents();
	}

	private final ArrayList<UnitOfMeasureListViewListener> unitOfMeasureListViewListeners = new ArrayList<UnitOfMeasureListViewListener>();

	public void addViewListner(UnitOfMeasureListViewListener listener) {
		unitOfMeasureListViewListeners.add(listener);
	}

	public void removeViewListner(UnitOfMeasureListViewListener listener) {
		unitOfMeasureListViewListeners.remove(listener);
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

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == e.BUTTON2) {
					listPanel.getPopupMenu().show(e.getComponent(), e.getX(),
							e.getY());
				}
				super.mouseClicked(e);
			}
		});

		listPanel.getContainer().add(scrollPane);

	}

	public void setUnitOfMeasureListTableModel(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel) {
		table.setModel(unitOfMeasureListTableModel);

	}

	public UnitOfMeasureListTableModel getUnitOfMeasureListTableModel() {
		TableModel result = table.getModel();
		return (UnitOfMeasureListTableModel) result;
	}

	public void setItemCount(int count) {
		listPanel.setRowsCount(count);
	}
}
