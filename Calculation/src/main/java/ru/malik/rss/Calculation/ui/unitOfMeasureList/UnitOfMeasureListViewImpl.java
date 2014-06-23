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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ru.malik.rss.Calculation.ui.common.Announcer;
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

	private final Announcer<UnitOfMeasureListViewListener> announcer = new Announcer<UnitOfMeasureListViewListener>(
			UnitOfMeasureListViewListener.class);

	public void addViewListener(UnitOfMeasureListViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(UnitOfMeasureListViewListener listener) {
		announcer.removeListener(listener);
	}

	public void init() {
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);

		setSize(new Dimension(416, 233));
		setMinimumSize(minimumDimension);
	}

	public void sendEditUnitOfMeasure() {
		announcer.announce().editUnitOfMeasure(this);
	}

	public void sendRowSelected(int rowIndex) {
		announcer.announce().selectRow(rowIndex, this);
	}

	public void sendAddUnitOfMeasure() {
		announcer.announce().addUnitOfMeasure(this);
	}

	public void sendRemoveUnitOfMeasure() {
		announcer.announce().removeUnitOfMeasure(this);
	}

	public void sendOkActionUnitOfMeasure() {
		announcer.announce().okActionPerform(this);
	}

	public void sendCancelActionUnitOfMeasure() {
		announcer.announce().cancelActionPerform(this);
	}

	public void initComponents() {
		listPanel = new ListPanel();

		listPanel.addActionListner(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (evt.getActionCommand() == ListPanel.ActionCommands.EDIT_ITEM
						.name()) {
					sendEditUnitOfMeasure();
				} else if (evt.getActionCommand() == ListPanel.ActionCommands.ADD_ITEM
						.name()) {
					sendAddUnitOfMeasure();
				} else if (evt.getActionCommand() == ListPanel.ActionCommands.REMOVE_ITEM
						.name()) {
					sendRemoveUnitOfMeasure();
				}
			}
		});
		getContentPane().add(listPanel);

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

		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		// table.setCellSelectionEnabled(false);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent event) {
						ListSelectionModel lsm = (ListSelectionModel) event
								.getSource();
						int selRowIndx = lsm.getAnchorSelectionIndex();
						sendRowSelected(selRowIndx);

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

	public void setInfoSelectedRow(int index) {
		listPanel.setSelectedCaption(Integer.toString(index));
	}

	public void close() {
		this.dispose();
	}

}
