package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.beans.PropertyChangeEvent;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import ru.malik.rss.Calculation.mvc.model.Model;
import ru.malik.rss.Calculation.mvc.view.View;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class UnitOfMeasureListControllerImpl extends
		ControllerImpl<UnitOfMeasureListModel, UnitOfMeasureListView> implements
		UnitOfMeasureListController {

	public void propertyChange(PropertyChangeEvent evt) {
		if (PN_UNIT_OF_MEASURE_LIST_TABLE_MODEL.equals(evt.getPropertyName())) {
			setTableModelToViews((UnitOfMeasureListTableModel) evt
					.getNewValue());
		}
	}

	private TableModelListener listener = new TableModelListener() {

		public void tableChanged(TableModelEvent env) {
			if (env.getType() == TableModelEvent.DELETE
					|| env.getType() == TableModelEvent.INSERT) {
				setItemCountToViews();
			}
		}
	};

	public void setTableModelToViews(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel) {
		for (UnitOfMeasureListView unitOfMeasureListView : views) {
			unitOfMeasureListTableModel.addTableModelListener(listener);
			unitOfMeasureListView
					.setUnitOfMeasureListTableModel(unitOfMeasureListTableModel);
		}
		setItemCountToViews(unitOfMeasureListTableModel.getRowCount());
	}

	public void setItemCountToViews() {
		setItemCountToViews(getModel().getUnitOfMeasureListTableModel()
				.getRowCount());
	}

	public void setItemCountToViews(int count) {
		for (UnitOfMeasureListView unitOfMeasureListView : views) {
			unitOfMeasureListView.setItemCount(count);
		}
	}

}
