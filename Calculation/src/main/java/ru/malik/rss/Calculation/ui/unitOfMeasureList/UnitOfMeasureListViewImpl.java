package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public void addViewListener(UnitOfMeasureListViewListener listener) {
		unitOfMeasureListViewListeners.add(listener);
	}

	public void removeViewListener(UnitOfMeasureListViewListener listener) {
		unitOfMeasureListViewListeners.remove(listener);
	}

	public void init() {
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);

		setSize(new Dimension(416, 233));
		setMinimumSize(minimumDimension);
	}

	public void sendEditUnitOfMeasure(){
		for (UnitOfMeasureListViewListener listener : unitOfMeasureListViewListeners) {
			listener.editUnitOfMeasure(getUnitOfMeasureListTableModel().getUnitOfMeasureAt(table.getSelectedRow()), this);
		}
	}
	
	public void sendAddUnitOfMeasure(){
		for (UnitOfMeasureListViewListener listener : unitOfMeasureListViewListeners) {
			listener.addUnitOfMeasure(this);
		}
	}
	
	public void initComponents() {
		listPanel = new ListPanel();

		listPanel.addActionListner(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (evt.getActionCommand() == ListPanel.ActionCommands.EDIT_ITEM.name()) {
					sendEditUnitOfMeasure();
				} else if(evt.getActionCommand() == ListPanel.ActionCommands.ADD_ITEM.name()){
					sendAddUnitOfMeasure();
				} 
			}
		});

		setContentPane(listPanel);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == e.BUTTON3) {
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
