package ru.malik.rss.Calculation.mvc.view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public abstract class AbstractDialogPanel extends JPanel {
	public AbstractDialogPanel() {
	}

	private Component contentComponent;
	private Component controlComponent;
	private Object contentPanelLayoutCon = BorderLayout.CENTER;
	private Object controlPanelLayoutCon = BorderLayout.SOUTH;

	public Component getContentComponent() {

		return contentComponent;
	}

	public void setContentComponent(Component contentPanel) {
		if (this.contentComponent == contentPanel) {
			return;
		}
		if (this.contentComponent != null) {
			remove(this.contentComponent);
		}
		this.contentComponent = contentPanel;
		add(this.contentComponent, contentPanelLayoutCon);
		revalidate();
	}

	public Component getControlComponent() {
		return controlComponent;
	}

	public void setControlComponent(Component controlPanel) {
		if (this.controlComponent == controlPanel) {
			return;
		}
		if (this.controlComponent != null) {
			remove(this.controlComponent);
		}
		this.controlComponent = controlPanel;
		add(this.controlComponent, controlPanelLayoutCon);
	}

}
