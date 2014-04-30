package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class DefaultSelectPanel<T extends Component> extends
		AbstractDialogPanel implements SelectableView<T>, CancelableView,
		HasModelView<T> {
	public final ActionListener aclOk = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			select();
		}
	};

	public final ActionListener aclCancel = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			cancel();
		}
	};

	/**
	 * Create the panel.
	 */
	public DefaultSelectPanel() {
		setLayout(new BorderLayout(0, 0));

		DefaultDialogButtonsPanel defaultDialogButtonsPanel = DefaultDialogButtonsPanel
				.createDefaultDialogButtonsOkCancelPanel(aclOk, aclCancel);
		setControlComponent(defaultDialogButtonsPanel);

	}

	public abstract void select();
	
	public T getModelView() {
		return (T) getContentComponent();
	}

	public boolean setModelView(T modelView) {
		setContentComponent(modelView);
		return true;
	}
}
