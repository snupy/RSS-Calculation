package ru.malik.rss.Calculation.ui.unitFoMeasureList;

import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;

public class UnitOfMeasureListModelImpl extends
		ModelImpl<UnitOfMeasureListModelListener> implements
		UnitOfMeasureListModel {
	private UnitOfMeasureListTableModel unitOfMeasureListTableModel;

	public void setUnitOfMeasureListTableModel(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel) {
		if ((getUnitOfMeasureListTableModel() == null)
				|| !getUnitOfMeasureListTableModel().equals(
						unitOfMeasureListTableModel)) {
			getPropertyChangeSupport()
					.firePropertyChange(
							UnitOfMeasureListModelListener.PN_UNIT_OF_MEASURE_LIST_TABLE_MODEL,
							getUnitOfMeasureListTableModel(),
							unitOfMeasureListTableModel);
		}
	}

	public UnitOfMeasureListTableModel getUnitOfMeasureListTableModel() {
		return this.unitOfMeasureListTableModel;
	}

}
