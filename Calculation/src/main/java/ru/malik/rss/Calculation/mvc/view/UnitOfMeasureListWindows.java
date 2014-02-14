package ru.malik.rss.Calculation.mvc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import ru.malik.economics.model.UnitOfMeasure;

import javax.swing.table.DefaultTableModel;

public class UnitOfMeasureListWindows {

	private JFrame frame;
	private JTable table;

	private ArrayList<UnitOfMeasure> unitOfMeasures;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitOfMeasureListWindows window = new UnitOfMeasureListWindows(
							new ArrayList<UnitOfMeasure>());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnitOfMeasureListWindows(ArrayList<UnitOfMeasure> unitOfMeasures) {
		this.unitOfMeasures = unitOfMeasures;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(new UnitOfMeasureListTableModel());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					(new UnitOfMeasureWindow((UnitOfMeasure) table.getValueAt(
							table.rowAtPoint(mouseEvent.getPoint()), 0)))
							.getFrame().setVisible(true);
				}
			}
		});

		table.setDefaultRenderer(UnitOfMeasure.class,
				new DefaultTableCellRenderer() {

					@Override
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// TODO Auto-generated method stub
						return super.getTableCellRendererComponent(table,
								((UnitOfMeasure) value).getName(), isSelected,
								hasFocus, row, column);
					}
				});

		frame.getContentPane().add(table, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private class UnitOfMeasureListTableModel extends AbstractTableModel {

		public UnitOfMeasureListTableModel() {
			super();

		}

		public int getColumnCount() {
			return 1;
		}

		public int getRowCount() {
			// TODO Auto-generated method stub
			return unitOfMeasures.size();
		}

		public Object getValueAt(int r, int c) {
			return unitOfMeasures.get(r);
		}

		@Override
		public String getColumnName(int column) {
			return "Наименование";
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}

		// оставляем как есть, потом вернемся
		@Override
		public void setValueAt(Object aValue, int row, int column) {
		}

		@Override
		public Class getColumnClass(int c) {
			return (UnitOfMeasure.class);
		}

	}
}
