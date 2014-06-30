package ru.malik.rss.Calculation.ui.materialResourceList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;

import ru.malik.rss.Calculation.ui.common.Announcer;
import ru.malik.rss.Calculation.ui.common.ListPanel;

public class MaterialResourceListViewImpl extends JPanel implements
		MaterialResourceListView {

	private ListPanel listPanel;
	private JTable jTable;

	public MaterialResourceListViewImpl() {
		super();
		init();
		initComponents();
	}

	public void init() {
	}

	public void initComponents() {
		listPanel = new ListPanel();
		listPanel.addActionListner(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				if(ListPanel.ActionCommands.ADD_ITEM.name().equals(event.getActionCommand())){
					 // TODO
				}
			}
		});
		
		jTable = new JTable();
		listPanel.getContainer().add(jTable);
	}

	private final Announcer<MaterialResourceListViewListener> announcer = new Announcer<MaterialResourceListViewListener>(
			MaterialResourceListViewListener.class);

	public void addViewListener(MaterialResourceListViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(MaterialResourceListViewListener listener) {
		announcer.removeListener(listener);
	}

	public void setMaterialResourceListTableModel(
			MaterialResourceListTableModel materialResourceListTableModel) {
		jTable.setModel(materialResourceListTableModel);		
	}

	
}
