package ru.malik.rss.Calculation.ui.unitOfMeasureListSelect;

import ru.malik.rss.Calculation.ui.common.editPanel.EditPanel;
import ru.malik.rss.Calculation.ui.common.editPanel.EditPanelListener;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListViewImpl;

public class unitOfMeasureListSelectViewImpl extends UnitOfMeasureListViewImpl {
	public unitOfMeasureListSelectViewImpl() {
	}

	private EditPanel editPanel;

	@Override
	public void initComponents() {
		editPanel =  new EditPanel();
		editPanel.addEditPanelListener(new EditPanelListener() {
			
			public void okActionPerformed(Object sender) {
				sendOkActionUnitOfMeasure();				
			}
			
			public void cancelActionPerformed(Object sender) {
				sendCancelActionUnitOfMeasure();
			}
		});
		setContentPane(editPanel);
		super.initComponents();
	}

}
