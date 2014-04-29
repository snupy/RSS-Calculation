package ru.malik.rss.Calculation.mvc.view;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultSelectPanel<T> extends JPanel implements SelectableView<T>, CancelableView {
	private final JPanel contentPanel = new JPanel(new BorderLayout());

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
		
		DefaultDialogButtonsPanel defaultDialogButtonsPanel = DefaultDialogButtonsPanel.createDefaultDialogButtonsOkCancelPanel(aclOk, aclCancel);
		add(defaultDialogButtonsPanel, BorderLayout.SOUTH);

		add(contentPanel, BorderLayout.CENTER);
	}

	public void cancel() {
		setSelected(null);
	}

	public void setSelected(T obj) {
				
	}

	public T getSelected() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void select(){
		
	}
}
