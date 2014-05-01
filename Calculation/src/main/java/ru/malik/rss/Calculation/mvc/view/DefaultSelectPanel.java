package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JPanel;

import ru.malik.rss.Calculation.mvc.Cancelable;
import ru.malik.rss.Calculation.mvc.Selectable;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;

import java.util.ArrayList;
import java.util.EventObject;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class DefaultSelectPanel<T extends Component, F> extends
		AbstractDialogPanel implements Selectable<F>, Cancelable,
		HasModelView<T> {
	private ListEditorToolbar listEditorToolbar;
	private Announcer<SelectEventListener> selectAnnouncer = new Announcer<SelectEventListener>(
			SelectEventListener.class);
	private Announcer<CancelEventListener> cancelAnnouncer = new Announcer<CancelEventListener>(
			CancelEventListener.class);

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

	public DefaultSelectPanel() {
		setLayout(new BorderLayout(0, 0));

		DefaultDialogButtonsPanel defaultDialogButtonsPanel = DefaultDialogButtonsPanel
				.createDefaultDialogButtonsOkCancelPanel(aclOk, aclCancel);
		setControlComponent(defaultDialogButtonsPanel);

		listEditorToolbar = new ListEditorToolbar();
		add(listEditorToolbar, BorderLayout.NORTH);

	}

	public T getModelView() {
		return (T) getContentComponent();
	}

	public boolean setModelView(T modelView) {
		setContentComponent(modelView);
		return true;
	}

	public ListEditorToolbar getListEditorToolbar() {
		return listEditorToolbar;
	}

	public void cancel() {
		cancelAnnouncer.announce().cancel(new EventObject(this));

	}

	public void select() {
		selectAnnouncer.announce().select(new EventObject(this));
	
	}

	public void addCancelListener(CancelEventListener listener) {
		cancelAnnouncer.addListener(listener);
	}

	public void addSelectListener(SelectEventListener listener) {
		selectAnnouncer.addListener(listener);
	
	}

	public void removeCancelListener(CancelEventListener listener) {
		cancelAnnouncer.removeListener(listener);		
	}

	public void removeSelectListener(SelectEventListener listener) {
		selectAnnouncer.removeListener(listener);
	}
	
	

}
