package ru.malik.rss.Calculation.ui.materialResourceList;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.mvc.model.Model;
import ru.malik.rss.Calculation.mvc.view.View;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class MaterialResourceListControllerImpl extends
		ControllerImpl<MaterialResourceListModel, MaterialResourceListView>
		implements MaterialResourceListController {

	public void propertyChange(PropertyChangeEvent event) {
		if (MaterialResourceListModelListener.PropertyName.MATERIAL_RESOURCE_LIST_TABLE_MODEL
				.name().equals(event.getPropertyName())) {
			MaterialResourceListTableModel model = (MaterialResourceListTableModel) event
					.getNewValue();
			for (MaterialResourceListView view : views) {
				view.setMaterialResourceListTableModel(model);
			}
		}
	}
	

	@Override
	public void setModel(MaterialResourceListModel model) {
		for (MaterialResourceListView view : views) {
			view.setMaterialResourceListTableModel(model.getMaterialResourceListTableModel());
		}
		super.setModel(model);
	}


	@Override
	public void addView(MaterialResourceListView view) {
		view.setMaterialResourceListTableModel(getModel().getMaterialResourceListTableModel());
		super.addView(view);
	}

	
	
}
