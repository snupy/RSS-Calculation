package ru.malik.rss.Calculation.mvc.view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ru.malik.economics.model.Nomenclature;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ListSelectionModel;

public class NomenclatureListPanel extends JPanel {
	private JTable table;
	private NomenclautesDataModel nomenclautesDataModel;

	private ArrayList<Nomenclature> nomenclatures;
	private Nomenclature selectNomenclature;

	/**
	 * Create the panel.
	 */
	public NomenclatureListPanel() {
		super();
		createPanel();
	}

	public NomenclatureListPanel(ArrayList<Nomenclature> nomenclatures) {
		this();
		setNomenclatures(nomenclatures);
	}

	public void createPanel() {
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(table, BorderLayout.CENTER);
		nomenclautesDataModel = new NomenclautesDataModel(null);
		table.setModel(nomenclautesDataModel);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent e) {
						setSelectNomenclature(((NomenclautesDataModel) table
								.getModel()).getList().get(e.getFirstIndex()));
					}
				});

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

				if (mouseEvent.getClickCount() >= 2) {
					(new NomenclatureEditFrame(getSelectNomenclature()))
							.setVisible(true);
				}
			}
		});
	}

	private class NomenclautesDataModel extends DefaultTableModel {

		private ArrayList<Nomenclature> list;
		private String[] columnsName = { "Наименование", "Единица измерения" };

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			if (list == null) {
				return 0;
			} else {
				return this.list.size();
			}
		}

		public NomenclautesDataModel(ArrayList<Nomenclature> list) {

			this.list = (list != null) ? list : (new ArrayList<Nomenclature>());

		}

		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return columnsName[column];
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			switch (column) {
			case 1:
				return list.get(row).getName();

			case 2:
				return list.get(row).getUnitOfMeasures().getName();

			default:
				return null;

			}
		}

		public ArrayList<Nomenclature> getList() {
			return list;
		}

		public void setList(ArrayList<Nomenclature> list) {
			this.list = list;
		}

		@Override
		public void setValueAt(Object arg0, int arg1, int arg2) {

		}

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

	}

	public ArrayList<Nomenclature> getNomenclatures() {
		return nomenclatures;
	}

	public void setNomenclatures(ArrayList<Nomenclature> nomenclatures) {
		this.nomenclatures = nomenclatures;
		this.nomenclautesDataModel.setList(this.nomenclatures);
	}

	public Nomenclature getSelectNomenclature() {

		return selectNomenclature;
	}

	public void setSelectNomenclature(Nomenclature selectNomenclature) {
		this.selectNomenclature = selectNomenclature;
	}

}
