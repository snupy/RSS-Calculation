package ru.malik.rss.Calculation.ui.NomenclatureList;

import ru.malik.rss.Calculation.ui.common.JMdiFrame;
import ru.malik.rss.Calculation.ui.common.ListPanel;

public class NomenclatureListViewImpl extends JMdiFrame implements
		NomenclatureListView {

	private ListPanel listPanel;
	
	public void addViewListener(NomenclatureListViewListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeViewListener(NomenclatureListViewListener listener) {
		// TODO Auto-generated method stub

	}

	public NomenclatureListViewImpl() {
		super();
		init();
		initComponents();
	}

	public void init() {
	}

	public void initComponents() {
		listPanel = new ListPanel();
		this.setContentPane(listPanel);
	}
}
