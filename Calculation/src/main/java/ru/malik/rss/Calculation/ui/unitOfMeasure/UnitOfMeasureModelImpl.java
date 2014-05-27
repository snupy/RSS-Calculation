package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.sql.SQLException;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.utils.UnitOfMeasureDAO;

public class UnitOfMeasureModelImpl extends
		ModelImpl<UnitOfMeasureModelListener> implements UnitOfMeasureModel {

	private UnitOfMeasure unitOfMeasure;

	// TODO пока и так пойдет но потом нужно будет переделать, ибо не гибко
	public void save() {
		try {
			UnitOfMeasureDAO.getInstance().saveOrUpdate(getUnitOfMesaure());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO пока и так пойдет но потом нужно будет переделать, ибо не гибко
	public void refresh() {
		if (unitOfMeasure != null) {
			try {
				setUnitOfMesaure(UnitOfMeasureDAO.getInstance().getById(
						unitOfMeasure.getId()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setUnitOfMesaure(UnitOfMeasure unitOfMeasure) {
		if (this.unitOfMeasure != unitOfMeasure) {
			getPropertyChangeSupport().firePropertyChange(
					UnitOfMeasureModelListener.PN_UNIT_OF_MEASURE,
					this.unitOfMeasure, unitOfMeasure);
			this.unitOfMeasure = unitOfMeasure;
		}
	}

	public UnitOfMeasure getUnitOfMesaure() {
		// TODO Auto-generated method stub
		return unitOfMeasure;
	}

}