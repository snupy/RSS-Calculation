package ru.malik.rss.Calculation.ui.nomenclatureList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.MutableTreeNode;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.common.Announcer;
import ru.malik.rss.Calculation.ui.common.JMdiFrame;
import ru.malik.rss.Calculation.ui.common.ListPanel;
import ru.malik.rss.Calculation.ui.common.treeTable.JTreeTable;
import ru.malik.rss.Calculation.ui.common.treeTable.TreeTableModel;

public class NomenclatureListViewImpl extends JMdiFrame implements
		NomenclatureListView {

	private ListPanel listPanel;
	private JTreeTable treeTable;

	private final Announcer<NomenclatureListViewListener> announcer = new Announcer<NomenclatureListViewListener>(
			NomenclatureListViewListener.class);

	public void addViewListener(NomenclatureListViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(NomenclatureListViewListener listener) {
		announcer.removeListener(listener);
	}

	public NomenclatureListViewImpl() {
		super();
		init();
		initComponents();
		pack();
	}

	public void init() {
	}

	public void initComponents() {
		listPanel = new ListPanel();
		listPanel.addActionListner(new ActionListener() {

			public void actionPerformed(ActionEvent evnt) {
				if (evnt.getActionCommand().equals(
						ListPanel.ActionCommands.ADD_ITEM.name())) {
					announcer.announce().addNomenclature(
							NomenclatureListViewImpl.this);

				} else if (evnt.getActionCommand().equals(
						ListPanel.ActionCommands.EDIT_ITEM.name())) {
					announcer.announce().editNomenclature(
							NomenclatureListViewImpl.this);

				} else if (evnt.getActionCommand().equals(
						ListPanel.ActionCommands.REMOVE_ITEM.name())) {
					announcer.announce().removeNomenclature(
							NomenclatureListViewImpl.this);
				}
			}
		});

		JScrollPane scrollPane;
		listPanel.getContainer().add(
				scrollPane = new JScrollPane(treeTable = new JTreeTable()));
		treeTable.setCellSelectionEnabled(true);
		treeTable.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		
		treeTable.getTreeSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {

					public void valueChanged(TreeSelectionEvent event) {
						MutableTreeNode selected = (MutableTreeNode) (event
								.getPath().getLastPathComponent());
						announcer.announce().selectRow(selected,
								NomenclatureListViewImpl.this);
					}
				});

		this.setContentPane(listPanel);
	}

	public void setNomenclatureListTreeModel(TreeTableModel treeTableModel) {
		treeTable.setTreeTableModel(treeTableModel);
	}

	public void setNomenclatureListSelected(String selectedName) {
		listPanel.setSelectedCaption(selectedName);
	}
	
}
