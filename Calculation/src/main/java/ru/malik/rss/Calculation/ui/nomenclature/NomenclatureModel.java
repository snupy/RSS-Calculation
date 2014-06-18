package ru.malik.rss.Calculation.ui.nomenclature;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.mvc.Model;

public interface NomenclatureModel extends Model<NomenclatureModelListener>{
	public void setNomenclature(Nomenclature nomenclature);
	public Nomenclature getNomenclature();
	public void save();
	public void refresh();
}
