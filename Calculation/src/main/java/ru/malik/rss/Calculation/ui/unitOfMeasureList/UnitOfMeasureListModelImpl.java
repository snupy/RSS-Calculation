package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureController;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModel;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureView;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureViewImpl;

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

	public void editUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		UnitOfMeasureModel unitOfMeasureModel = new UnitOfMeasureModelImpl();
		unitOfMeasureModel.setUnitOfMesaure(unitOfMeasure);
		
		UnitOfMeasureView unitOfMeasureView = new UnitOfMeasureViewImpl();
		
		UnitOfMeasureController unitOfMeasureController = new UnitOfMeasureControllerImpl();
		
		unitOfMeasureController.setModel(unitOfMeasureModel);
		unitOfMeasureController.addView(unitOfMeasureView);
	}
	
	public void addUnitOfMeasure(){
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		editUnitOfMeasure(unitOfMeasure);
	}
	
}
