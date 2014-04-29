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

public abstract class DefaultEditPanel extends JPanel {

	private Component contentComponent;
	private final JPanel contentPanel = new JPanel(new BorderLayout());
	
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

		add(defaultDialogButtonsPanel, BorderLayout.SOUTH);
		
		contentPanel.add(contentComponent = createContentComponent());
		
		add(contentPanel, BorderLayout.CENTER);
		revalidate();
	}
	
	

	public Component getContentComponent() {
		return contentComponent;
	}

	public void setContentComponent(Component contentComponent) {
		this.contentComponent = contentComponent;
		contentPanel.removeAll();
		contentPanel.add(this.contentComponent);
		revalidate();		
	}
	

	public abstract void save();

	public abstract void cancel();

	public Component createContentComponent(){
		return new JPanel();
	}
}
