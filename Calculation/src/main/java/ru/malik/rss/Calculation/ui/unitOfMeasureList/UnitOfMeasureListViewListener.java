package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

public interface UnitOfMeasureListViewListener extends ViewListener {
	
	/**
	 * Редактирование UnitOfMeasure
	 * @param sender вид сгенерировавший событие
	 */
	public void editUnitOfMeasure(UnitOfMeasureListView sender);
	
	/**
	 * Добавление UnitOfMeasure
	 * @param sender Вид сгенерировавший событие
	 */
	public void addUnitOfMeasure(UnitOfMeasureListView sender);
	
	/**
	 * Удаление UnitOfMeasure
	 * @param sender Вид сгенерировавший событие
	 */
	public void removeUnitOfMeasure(UnitOfMeasureListView sender);
	
	
	/**
	 * Выбор строки
	 * @param index выбранная строка
	 */
	public void selectRow(int index, UnitOfMeasureListView sender);
	
	public void okActionPerform(UnitOfMeasureListView sender);
	public void cancelActionPerform(UnitOfMeasureListView sender);
}
