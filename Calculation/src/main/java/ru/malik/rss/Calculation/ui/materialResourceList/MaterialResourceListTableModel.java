package ru.malik.rss.Calculation.ui.materialResourceList;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ru.malik.rss.Calculation.entity.MaterialResource;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;

public class MaterialResourceListTableModel extends AbstractTableModel {

	private List<MaterialResource> materialResources;

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return materialResources.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		MaterialResource materialResource = materialResources.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return materialResource.getNomenclatures().getName();
		case 1:
			return materialResource.getNomenclatures().getUnitOfMeasures()
					.getShortName();
		case 2:
			return materialResource.getVolume();
		}

		return null;
	}

	
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Номенклатура";
		case 1:
			return "Ед. изм.";
		case 2:
			return "Количество";
		}

		return null;
	}

	public MaterialResource getMaterialResource(int rowIndex) {
		return materialResources.get(rowIndex);
	}

	public MaterialResourceListTableModel(
			List<MaterialResource> materialResources) {
		super();
		this.materialResources = materialResources;
	}
}
