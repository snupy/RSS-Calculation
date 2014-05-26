package ru.malik.rss.Calculation.ui.unitOfMeasure;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import ru.malik.rss.Calculation.mvc.view.DefaultDialogButtonsPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMesureViewPanel;

public class UnitOfMeasureEditViewPanel extends JPanel {
	private UnitOfMeasureViewPanel unitOfMeasureViewPanel;
	private DefaultDialogButtonsPanel dialogButtonsPanel;

	public UnitOfMeasureEditViewPanel() {
		init();
		initComponents();
	}

	public void init() {
		setLayout(new BorderLayout());
		// aclOk.get(0).actionPerformed(new ActionEvent(this, id, command));
	}

	public void initComponents() {
		unitOfMeasureViewPanel = new UnitOfMeasureViewPanel();
		add(unitOfMeasureViewPanel, BorderLayout.CENTER);

		dialogButtonsPanel = DefaultDialogButtonsPanel
				.createDefaultDialogButtonsOkCancelPanel(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						save();
					}
				}, new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						cancel();

					}
				});
		add(dialogButtonsPanel, BorderLayout.SOUTH);
	}

	public void save() {
		unitOfMeasureViewPanel.fireAction(new ActionEvent(
				unitOfMeasureViewPanel, ActionEvent.ACTION_PERFORMED, "save"));

	}

	public void cancel() {

		unitOfMeasureViewPanel
				.fireAction(new ActionEvent(unitOfMeasureViewPanel,
						ActionEvent.ACTION_PERFORMED, "cancel"));

	}

}
