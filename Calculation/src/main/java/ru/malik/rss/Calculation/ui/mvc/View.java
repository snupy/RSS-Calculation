package ru.malik.rss.Calculation.ui.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface View<L extends ViewListener> {
	
	
	/**
	 * Добавляет слушателя View
	 * 
	 * @param listener добавляемый слушатель
	 */
	public void addViewListener(L listener);

	/**
	 * Удаляет слушателя VIew
	 * @param listener удаляемый слушатель
	 */
	public void removeViewListener(L listener);
	}
