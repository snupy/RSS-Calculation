package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JButton;
import javax.swing.Action;

public final class DialogButtonsFactory {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source text "New button"
	 * @wbp.factory.parameter.source action action
	 */
	public static JButton createJButton(String text, Action action) {
		JButton button = new JButton(text);
		button.setAction(action);
		return button;
	}

	final static public String DB_YES = "Да", DB_NO = "Нет",
			DB_CANCEL = "Отмена", DB_OK = "Хорошо";

}