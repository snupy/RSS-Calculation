package ru.malik.rss.Calculation.ui.nomenclature;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.mvc.View;

public interface NomenclatureView extends View<NomenclatureViewListener>{
	public void setNomenclature(Nomenclature nomenclature);
	public Nomenclature getNomenclature();
}
