package ru.malik.rss.Calculation.ui.common.selectPanel;

import java.util.EventListener;

public interface SelectPanelListener extends EventListener{
	public void selectActionPerformed(Object sender);
	public void cancelActionPerformed(Object sender);
}
