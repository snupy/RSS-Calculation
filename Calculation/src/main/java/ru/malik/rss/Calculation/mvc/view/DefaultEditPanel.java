package ru.malik.rss.Calculation.mvc.view;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public abstract class DefaultEditPanel<T extends Component> extends
		AbstractDialogPanel implements EditableView, CancelableView,
		HasModelView<T> {

	private T modelView;

	public final ActionListener aclSave = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			save();
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
	public DefaultEditPanel() {
		setLayout(new BorderLayout(0, 0));

		DefaultDialogButtonsPanel defaultDialogButtonsPanel = DefaultDialogButtonsPanel
				.createDefaultDialogButtonsOkCancelPanel(aclSave, aclCancel);

		setControlComponent(defaultDialogButtonsPanel);

		// contentPanel.add(contentComponent = createContentComponent());

		revalidate();

	}
	
	

	
	public T getModelView() {
		return (T) getContentComponent();
	}


	public boolean setModelView(T modelView){
		setContentComponent(modelView);
		return true;
	}

	public abstract void save();

	public abstract void cancel();
}
