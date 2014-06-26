package ru.malik.rss.Calculation.ui.nomenclature;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.Core;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModelListener;

public class NomenclauteControllerImpl extends
		ControllerImpl<NomenclatureModel, NomenclatureView> implements
		NomenclatureController {

	public void propertyChange(PropertyChangeEvent evn) {
		if (NomenclatureModelListener.PropertyName.NOMENCLATURE.name().equals(
				evn.getPropertyName())) {
			setNomenclatureToView((Nomenclature) evn.getNewValue());
		}
	}

	public void setNomenclatureToView(Nomenclature nomenclature) {
		for (NomenclatureView view : views) {
			view.setNomenclature(nomenclature);
		}
	}

	public void okActionPerform(NomenclatureView sender) {
		sender.save();
		getModel().save();
	}

	public void cancelActionPerform(NomenclatureView sender) {
		getModel().refresh();
		sender.close();
	}

	public void openUnitOfMeasuresList(final NomenclatureView sender) {
		// TODO Auto-generated method stub

		final UnitOfMeasureListModel listModel = Core.getInstance()
				.showUnitOfMeasureSelectList();
		listModel.addModelListener(new UnitOfMeasureListModelListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

			}

			public void cancelChanges() {
				// TODO Auto-generated method stub

			}

			public void applyChanges() {
				sender.setNomenclatureUnitOfMeasure(listModel
						.getSelectedUnitOfMeasure());

			}
		});
	}

}
