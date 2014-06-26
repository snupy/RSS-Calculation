package ru.malik.rss.Calculation.ui.nomenclature;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.View;

public interface NomenclatureView extends View<NomenclatureViewListener>{
	public void setNomenclature(Nomenclature nomenclature);
	public Nomenclature getNomenclature();
	public void setNomenclatureName(String name);
	public void setNomenclatureUnitOfMeasure(UnitOfMeasure unitOfMeasure);
	public void save();
	public void close();
}
