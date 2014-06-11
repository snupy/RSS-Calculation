package ru.malik.rss.Calculation.ui.common;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.URL;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.ArrayList;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class ListPanel extends JPanel {

	public enum ActionCommands {ADD_ITEM, REMOVE_ITEM, NEXT_ITEM, PREVIOUS_ITEM, EDIT_ITEM};
	/*public static final String COMMAND_NAME_ADD_ITEM = "ADD_ITEM",
			COMMAND_NAME_REMOVE_ITEM = "REMOVE_ITEM",
			COMMAND_NAME_NEXT_ITEM = "NEXT_ITEM",
			COMMAND_NAME_PREVIOUS_ITEM = "",
			COMMAND_NAME_EDIT_ITEM = "EDIT_ITEM";*/

	private JTextField textFieldRowNumber;
	private JTextField textFieldRowsCount;
	private JPanel centralPanel;
	private JPopupMenu popupMenu;

	private final ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();

	/**
	 * @wbp.nonvisual location=2,329
	 */

	// TODO этот main надо будет убрать потом
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ListPanel());
		frame.setVisible(true);
	}

	public ListPanel() {
		init();
		initComponents();
	}

	public void init() {
		setLayout(new BorderLayout(0, 0));
	}

	public void initComponents() {

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		// TODO тут надо проработать моменты с кнопками

		JButton btnAddItem = makeNavigationButton("/images/24_24/addItem.png",
				ActionCommands.ADD_ITEM.name(), "Добавить запись", "Добавить",
				actionListener);
		toolBar.add(btnAddItem);

		JButton btnRemoveItem = makeNavigationButton(
				"/images/24_24/removeItem.png", ActionCommands.REMOVE_ITEM.name(),
				"Удалить запись", "Удалить", actionListener);
		toolBar.add(btnRemoveItem);

		JButton btnPreviousItem = makeNavigationButton(
				"/images/24_24/previousItem.png", ActionCommands.PREVIOUS_ITEM.name(),
				"Перейти к прдъидущей записи", "предъидущий", actionListener);
		toolBar.add(btnPreviousItem);

		JButton btnNextItem = makeNavigationButton(
				"/images/24_24/nextItem.png", ActionCommands.NEXT_ITEM.name(),
				"Перейти к следующей записи", "следующий", actionListener);
		toolBar.add(btnNextItem);

		JButton btnEditItem = makeNavigationButton(
				"/images/24_24/editItem.png", ActionCommands.EDIT_ITEM.name(),
				"Редактировать запись", "редактировать", actionListener);
		toolBar.add(btnEditItem);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 1, 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0 };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);

		JLabel lblNewLabel = new JLabel("Выбрана строка:");
		panel_1.add(lblNewLabel);

		textFieldRowNumber = new JTextField();
		panel_1.add(textFieldRowNumber);
		textFieldRowNumber.setText("1");
		textFieldRowNumber.setEditable(false);
		textFieldRowNumber.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.weightx = 1.0;
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		panel.add(separator, gbc_separator);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);

		JLabel lblNewLabel_1 = new JLabel("Всего строк");
		panel_2.add(lblNewLabel_1);

		textFieldRowsCount = new JTextField();
		panel_2.add(textFieldRowsCount);
		textFieldRowsCount.setEditable(false);
		textFieldRowsCount.setColumns(10);

		centralPanel = new JPanel();
		add(centralPanel, BorderLayout.CENTER);

		popupMenu = new JPopupMenu();
		
		popupMenu.add(makeNavigationMenuItem("/images/24_24/addItem.png",
				ActionCommands.ADD_ITEM.name(), "Добавить запись", "Добавить",
				actionListener));
		popupMenu.add(makeNavigationMenuItem("/images/24_24/removeItem.png",
				ActionCommands.REMOVE_ITEM.name(), "Удалить запись", "Удалить",
				actionListener));
		popupMenu.add(makeNavigationMenuItem("/images/24_24/previousItem.png",
				ActionCommands.PREVIOUS_ITEM.name(), "Перейти к прдъидущей записи",
				"предъидущий", actionListener));
		popupMenu.add(makeNavigationMenuItem("/images/24_24/nextItem.png",
				ActionCommands.NEXT_ITEM.name(), "Перейти к следующей записи",
				"следующий", actionListener));
		popupMenu.add(makeNavigationMenuItem("/images/24_24/editItem.png",
				ActionCommands.EDIT_ITEM.name(), "Редактировать запись",
				"редактировать", actionListener));

		addPopup(centralPanel, getPopupMenu());
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.X_AXIS));

	}

	
	
	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	public Container getContainer() {
		return centralPanel;
	}

	protected JButton makeNavigationButton(String imageName,
			String actionCommand, String toolTipText, String altText,
			ActionListener actionListener) {

		String imgLocation = imageName;
		URL imageURL = getClass().getResource(imgLocation);

		JButton button = new JButton();
		button.addActionListener(actionListener);
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);

		if (imageURL != null) { // image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} else { // no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}
		return button;
	}

	protected JMenuItem makeNavigationMenuItem(String imageName,
			String actionCommand, String toolTipText, String altText,
			ActionListener actionListener) {

		String imgLocation = imageName;
		URL imageURL = getClass().getResource(imgLocation);

		JMenuItem menuItem = new JMenuItem();
		menuItem.addActionListener(actionListener);
		menuItem.setActionCommand(actionCommand);
		menuItem.setText(altText);
		menuItem.setToolTipText(toolTipText);

		if (imageURL != null) { // image found
			menuItem.setIcon(new ImageIcon(imageURL, altText));
		} else { // no image found
			menuItem.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}
		return menuItem;
	}

	public void setRowsCount(int count) {
		textFieldRowsCount.setText(String.valueOf(count));
	}

	public void setChangedRowIndex(int index) {
		textFieldRowNumber.setText(String.valueOf(index));
	}

	public void addActionListner(ActionListener actionListener) {
		actionListeners.add(actionListener);
	}

	public void removeActionListner(ActionListener actionListener) {
		actionListeners.remove(actionListener);
	}

	private ActionListener actionListener = new ActionListener() {

		public void actionPerformed(ActionEvent evt) {
			for (ActionListener listener : actionListeners) {
				listener.actionPerformed(evt);
			}
		}
	};

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
