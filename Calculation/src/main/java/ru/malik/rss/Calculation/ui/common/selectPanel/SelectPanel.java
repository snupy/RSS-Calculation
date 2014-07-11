package ru.malik.rss.Calculation.ui.common.selectPanel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import ru.malik.rss.Calculation.ui.common.Announcer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPanel extends JPanel {
	private JPanel southPanel;
	private Component container;
	private JButton selectButton, cancelButton;

	final private Announcer<SelectPanelListener> announcer = new Announcer<SelectPanelListener>(
			SelectPanelListener.class);

	public void addSelectPanelListener(SelectPanelListener listener) {
		announcer.addListener(listener);
	}

	public void removeSelectPanelListener(SelectPanelListener listener) {
		announcer.removeListener(listener);
	}

	public void init() {
		setLayout(new BorderLayout(0, 0));
	}

	public void initComponents() {
		createSouthPanel();
		add(southPanel, BorderLayout.SOUTH);

		setContainer(new JPanel());
	}

	public SelectPanel() {
		init();
		initComponents();
	}

	public void createSouthPanel() {
		southPanel = new JPanel();

		selectButton = new JButton("Выбрать");
		selectButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				announcer.announce().selectActionPerformed(SelectPanel.this);
			}
		});
		southPanel.add(selectButton);

		cancelButton = new JButton("Отмена");
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				announcer.announce().cancelActionPerformed(SelectPanel.this);
			}
		});

		southPanel.add(cancelButton);
	}

	public Component getContainer() {
		return container;
	}

	public void setContainer(Component component) {
		if (container != null) {
			this.remove(container);
		}

		container = component;
		add(container, BorderLayout.CENTER);
	}
}
