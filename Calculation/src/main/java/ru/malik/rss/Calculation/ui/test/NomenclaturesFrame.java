package ru.malik.rss.Calculation.ui.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;

public class NomenclaturesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action acAdd = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomenclaturesFrame frame = new NomenclaturesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NomenclaturesFrame() {
		init();
		initComponents();
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane = new JPanel(new BorderLayout()));
	}

	public void initComponents() {
		JPanel panelFilter = new JPanel();
		contentPane.add(panelFilter, BorderLayout.NORTH);
		panelFilter.setLayout(new BoxLayout(panelFilter, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Фильтр");
		panelFilter.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent e) {
				((JTextField)e.getSource()).getText();
				
			}
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panelFilter.add(textField);
		textField.setColumns(10);

		JPanel panelManageButtons = new JPanel();
		contentPane.add(panelManageButtons, BorderLayout.SOUTH);

		JButton btnOk = new JButton("Ok");
		btnOk.setAction(action);
		panelManageButtons.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action_1);
		panelManageButtons.add(btnCancel);

		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setName("кг");

		Nomenclature nomenclature;

		DefaultMutableTreeNode rootNode, lkm, emal, sortoment;
		rootNode = new DefaultMutableTreeNode("Номенклатура");
		rootNode.add(lkm = new DefaultMutableTreeNode("ЛКМ"));
		lkm.add(emal = new DefaultMutableTreeNode("Эмаль"));
		rootNode.add(sortoment = new DefaultMutableTreeNode("Сортомент"));

		nomenclature = new Nomenclature();
		nomenclature.setName("ПФ 115 белый");
		nomenclature.setUnitOfMeasures(unitOfMeasure);
		emal.add(new DefaultMutableTreeNode(nomenclature));

		nomenclature = new Nomenclature();
		nomenclature.setName("ПФ 115 черный");
		nomenclature.setUnitOfMeasures(unitOfMeasure);
		emal.add(new DefaultMutableTreeNode(nomenclature));
		

		nomenclature = new Nomenclature();
		nomenclature.setName("Труба 32x3.2");
		nomenclature.setUnitOfMeasures(unitOfMeasure);
		sortoment.add(new DefaultMutableTreeNode(nomenclature){

			@Override
			public String toString() {
				return ((Nomenclature)getUserObject()).getName();
			}});

		JTreeTable treeTable = new JTreeTable(new AbstractTreeTableModel(
				rootNode) {

			String filte = "c";
			
			
			
			public int getChildCount(Object parent) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;
				System.out.println(parent + ":" + node.getChildCount());
				return node.getChildCount();
			}

			public Object getChild(Object parent, int index) {
				
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;
				System.out.println("xx" + node.getChildAt(index));
				return node.getChildAt(index);
			}

			
			
			@Override
			public boolean isLeaf(Object node) {
				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
				System.out.println(treeNode.isLeaf());
				return treeNode.isLeaf();
			}

			public Object getValueAt(Object node, int column) {
				Object value = "";

				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
				if (treeNode.getUserObject() instanceof Nomenclature) {
					switch (column) {
					case 0:
						value = ((Nomenclature) treeNode.getUserObject())
								.getName();
						break;
					case 1:
						value = ((Nomenclature) treeNode.getUserObject())
								.getUnitOfMeasures().getName();
						break;
					}
				} else if (treeNode.getUserObject() instanceof String) {
					if (column == 0) {
						value = treeNode.getUserObject();
					}
				}

				return value;

			}

			@Override
			public int getIndexOfChild(Object parent, Object child) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;

				return node.getIndex((DefaultMutableTreeNode) child);
			}

			public String getColumnName(int column) {
				String columnName = "";
				switch (column) {
				case 0:
					columnName = "Наименование";
					break;
				case 1:
					columnName = "Ед. изм";
					break;
				default:
					columnName = "";
					break;
				}
				return columnName;
			}

			
			
			@Override
			public Class getColumnClass(int column) {
				if(column == 0){
					return TreeTableModel.class;
				}
				return String.class;
			}

			public int getColumnCount() {
				return 2;
			}
			
			//class Name
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(treeTable);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(treeTable, popupMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Добавить");
		mntmNewMenuItem.setAction(acAdd);
		popupMenu.add(mntmNewMenuItem);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

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

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Добавить");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			NomenclatureView nomenclatureView = new NomenclatureView();
			nomenclatureView.setVisible(true);
		}
	}
}
