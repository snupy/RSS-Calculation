package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.sql.SQLException;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureController;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModel;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureView;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureViewImpl;
import ru.malik.utils.UnitOfMeasureDAO;

public class UnitOfMeasureListModelImpl extends
		ModelImpl<UnitOfMeasureListModelListener> implements
		UnitOfMeasureListModel {
	private UnitOfMeasureListTableModel unitOfMeasureListTableModel;
	private UnitOfMeasure selectedUnitOfMeasure;
	private UnitOfMeasure applyedSelectedUnitOfMeasure;

	public void setUnitOfMeasureListTableModel(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel) {
		if ((getUnitOfMeasureListTableModel() == null)
				|| !getUnitOfMeasureListTableModel().equals(
						unitOfMeasureListTableModel)) {
			getPropertyChangeSupport()
					.firePropertyChange(
							UnitOfMeasureListModelListener.PropertyName.UNIT_OF_MEASURE_LIST_TABLE_MODEL
									.name(),
							getUnitOfMeasureListTableModel(),
							this.unitOfMeasureListTableModel = unitOfMeasureListTableModel);

			setSelectedUnitOfMeasure(this.unitOfMeasureListTableModel
					.getUnitOfMeasureAt(0));
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

	public void addUnitOfMeasure() {
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		editUnitOfMeasure(unitOfMeasure);
	}

	public UnitOfMeasure getSelectedUnitOfMeasure() {
		return this.selectedUnitOfMeasure;
	}

	public void setSelectedUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		getPropertyChangeSupport()
				.firePropertyChange(
						UnitOfMeasureListModelListener.PropertyName.SELECTED_UNIT_OF_MEASURE
								.name(), this.selectedUnitOfMeasure,
						this.selectedUnitOfMeasure = unitOfMeasure);
	}

	public void removeUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		try {
			UnitOfMeasureDAO.getInstance().delete(unitOfMeasure);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
