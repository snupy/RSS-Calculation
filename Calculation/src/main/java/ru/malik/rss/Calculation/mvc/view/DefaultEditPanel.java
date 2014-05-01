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
import java.util.EventObject;

import javax.swing.JToolBar;

import ru.malik.rss.Calculation.mvc.Cancelable;
import ru.malik.rss.Calculation.mvc.Editable;
import ru.malik.rss.Calculation.mvc.events.listners.CancelEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;

public class DefaultEditPanel<T extends Component> extends
		AbstractDialogPanel implements Editable, Cancelable,
		HasModelView<T> {

	private T modelView;
	private Announcer<SaveEventListener> saveAnnouncer = new Announcer<SaveEventListener>(SaveEventListener.class);
	private Announcer<CancelEventListener> cancelAnnouncer = new Announcer<CancelEventListener>(CancelEventListener.class);
	
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
	
	
	
	
	public void addSaveListener(SaveEventListener listner) {
		saveAnnouncer.addListener(listner);
	}




	public void addCancelListener(CancelEventListener listner) {
		// TODO Auto-generated method stub
		
	}




	public T getModelView() {
		return (T) getContentComponent();
	}


	public boolean setModelView(T modelView){
		setContentComponent(modelView);
		return true;
	}
	
	

	public void save(){
		saveAnnouncer.announce().save(new EventObject(this));
	}

	public void cancel(){
		cancelAnnouncer.announce().cancel(new EventObject(this));
	}




	public void removeCancelListener(CancelEventListener listener) {
		cancelAnnouncer.removeListener(listener);
	}




	public void removeSaveListener(SaveEventListener listener) {
		saveAnnouncer.removeListener(listener);
	}
}
