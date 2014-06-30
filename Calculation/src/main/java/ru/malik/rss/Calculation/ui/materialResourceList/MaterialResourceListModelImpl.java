package ru.malik.rss.Calculation.ui.materialResourceList;

import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;

public class MaterialResourceListModelImpl extends
		ModelImpl<MaterialResourceListModelListener> implements
		MaterialResourceListModel {

	private MaterialResourceListTableModel materialResourceListTableModel;

	public MaterialResourceListModelImpl() {
		super(MaterialResourceListModelListener.class);
	}

	public MaterialResourceListTableModel getMaterialResourceListTableModel() {
		return materialResourceListTableModel;
	}

	public void setMaterialResourceListTableModel(
			MaterialResourceListTableModel materialResourceListTableModel) {
		if (this.materialResourceListTableModel != materialResourceListTableModel) {
			getPropertyChangeSupport()
					.firePropertyChange(
							MaterialResourceListModelListener.PropertyName.MATERIAL_RESOURCE_LIST_TABLE_MODEL
									.name(),
							this.materialResourceListTableModel,
							this.materialResourceListTableModel = materialResourceListTableModel);
		}
	}
}
