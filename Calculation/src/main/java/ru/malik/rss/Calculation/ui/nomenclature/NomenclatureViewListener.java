package ru.malik.rss.Calculation.ui.nomenclature;

import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface NomenclatureViewListener extends ViewListener {
	public void okActionPerform(NomenclatureView sender);

	public void cancelActionPerform(NomenclatureView sender);
	
	public void openUnitOfMeasuresList(NomenclatureView sender);
}
