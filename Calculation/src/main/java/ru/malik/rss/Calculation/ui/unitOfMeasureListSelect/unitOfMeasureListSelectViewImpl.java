package ru.malik.rss.Calculation.ui.unitOfMeasureListSelect;

import ru.malik.rss.Calculation.ui.common.EditPanel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListViewImpl;

public class unitOfMeasureListSelectViewImpl extends UnitOfMeasureListViewImpl{
	public unitOfMeasureListSelectViewImpl() {
	}
	private EditPanel editPanel;
	@Override
	public void initComponents() {
		editPanel = new EditPanel();
		setContentPane(editPanel);
		super.initComponents();
	}
	

}
