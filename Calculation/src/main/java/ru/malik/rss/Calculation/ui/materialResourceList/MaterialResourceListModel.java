package ru.malik.rss.Calculation.ui.materialResourceList;

import ru.malik.rss.Calculation.ui.mvc.Model;

public interface MaterialResourceListModel extends Model<MaterialResourceListModelListener> {
	public MaterialResourceListTableModel getMaterialResourceListTableModel();
	public void setMaterialResourceListTableModel(MaterialResourceListTableModel materialResourceListTableModel);
}
