package ru.malik.rss.Calculation.ui.unitOfMeasure;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.Model;

/**
 * @author Малик
 *
 */
public interface UnitOfMeasureModel extends Model<UnitOfMeasureModelListener>{
	/**
	 * Метод сохраняет значение модели
	 */
	public void save();
	
	
	/**
	 * Метод обновляет значение модели беря его заново с хранилища
	 */
	public void refresh();
	
	
	/**
	 * Метод задает значение сущности UnitOfMeasure модели
	 * @param unitOfMeasure
	 */
	public void setUnitOfMesaure(UnitOfMeasure unitOfMeasure);
	
	
	/**Метод возвращает значение сущности UnitOfMeasure
	 * @return UnitOfMeasure
	 */
	public UnitOfMeasure getUnitOfMesaure();
}
