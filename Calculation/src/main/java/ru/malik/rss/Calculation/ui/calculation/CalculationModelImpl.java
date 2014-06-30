package ru.malik.rss.Calculation.ui.calculation;

import java.util.List;

import ru.malik.rss.Calculation.entity.MaterialResource;
import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListModel;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListModelImpl;
import ru.malik.rss.Calculation.ui.materialResourceList.MaterialResourceListTableModel;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.rss.Calculation.ui.mvc.ModelListener;

public class CalculationModelImpl extends ModelImpl<CalculationModelListener>
		implements CalculationModel {
	private ProductCalculation ProductCalculation;
	private MaterialResourceListModel materialResourceListModel =new MaterialResourceListModelImpl();

	public CalculationModelImpl() {
		super(CalculationModelListener.class);
	}

	public void setCalculation(ProductCalculation calculation) {
		if (this.ProductCalculation != calculation) {

			this.materialResourceListModel
					.setMaterialResourceListTableModel(new MaterialResourceListTableModel(
							calculation.getMaterialResource()));

			getPropertyChangeSupport()
					.firePropertyChange(
							CalculationModelListener.PropertyName.PRODUCT_CALCULATION
									.name(), this.ProductCalculation,
							this.ProductCalculation = calculation);
		}
	}

	public ProductCalculation getCalculation() {
		return this.ProductCalculation;
	}

	public MaterialResourceListModel getMaterialResourceListModel() {
		return this.materialResourceListModel;
	}

}
