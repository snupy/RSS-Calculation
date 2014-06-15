package ru.malik.rss.Calculation.ui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ru.malik.rss.Calculation.ui.common.Announcer;
import ru.malik.rss.Calculation.ui.mvc.View;
import ru.malik.rss.Calculation.ui.mvc.ViewListener;

import java.awt.CardLayout;
import java.awt.FlowLayout;

public class MainViewImpl extends JFrame implements MainView {

	private JPanel contentPane;
	private JTextField textFieldCategoryFilter;
	private JDesktopPane desktopPane;
	private JTree tree;
	private Point newChildPostion = new Point(0, 0);

	// private final ArrayList<MainViewListener> viewListeners = new
	// ArrayList<MainViewListener>();
	private final Announcer<MainViewListener> announcer = new Announcer<MainViewListener>(
			MainViewListener.class);
	private JMenu mnNewMenu_2;

	public void addViewListener(MainViewListener listener) {
		announcer.addListener(listener);
	}

	public void removeViewListener(MainViewListener listener) {
		announcer.removeListener(listener);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainModel mainModel = new MainModelImpl();
					MainController controller = new MainControllerImpl(
							mainModel);
					MainViewImpl frame = new MainViewImpl();
					controller.addView(frame);

					mainModel.setCategoryTreeModel(new CategoryTreeModel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainViewImpl() {
		init();
		initComponents();
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void initComponents() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Файл");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Документы");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Журнал калькуляций");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCalculationRegister();

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		mnNewMenu_2 = new JMenu("Справочники");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem = new JMenuItem("Единицы измерения");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openUnitOfMeasureList();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Номенклатура");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openNomenclatureList();

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);

		desktopPane = new JDesktopPane();
		splitPane.setRightComponent(desktopPane);
		desktopPane.setLayout(null);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		textFieldCategoryFilter = new JTextField();
		panel.add(textFieldCategoryFilter, BorderLayout.NORTH);

		textFieldCategoryFilter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				tree.repaint();
				super.keyPressed(e);
			}

		});

		tree = new JTree();

		// добавляем реакцию на нажатие по узнам дерева категорий
		// TODO мне не нравиться как я это сделал
		tree.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					TreePath treePath = tree.getPathForLocation(e.getX(),
							e.getY());
					if ((treePath != null)
							&& treePath.getLastPathComponent().equals(
									CategoryTreeModel.nodeCalculationRegister)) {
						openCalculationRegister();
					}
				}
				super.mouseClicked(e);
			}
		});

		// включаем фильтр дерева
		tree.setCellRenderer(new DefaultTreeCellRenderer() {
			private JLabel lblNull = new JLabel();

			@Override
			public Component getTreeCellRendererComponent(JTree tree,
					Object value, boolean sel, boolean expanded, boolean leaf,
					int row, boolean hasFocus) {
				Component c = super.getTreeCellRendererComponent(tree, value,
						sel, expanded, leaf, row, hasFocus);

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				if (categoryNameFilter(node.toString())) {

					c.setFont(new Font(c.getFont().getName(), Font.BOLD, c
							.getFont().getSize()));
					return c;
				} else if (containsMatchingChild(node)) {
					c.setFont(new Font(c.getFont().getName(), 0, c.getFont()
							.getSize()));
					return c;
				} else {
					return lblNull;

				}
			}

			private boolean containsMatchingChild(DefaultMutableTreeNode node) {
				Enumeration<DefaultMutableTreeNode> e = node
						.breadthFirstEnumeration();
				while (e.hasMoreElements()) {
					if (categoryNameFilter(e.nextElement().toString())) {
						return true;
					}
				}

				return false;
			}

		});

		scrollPane.setViewportView(tree);

		textFieldCategoryFilter.setColumns(10);
	}

	public void openCalculationRegister() {

		announcer.announce().openCalculationRegister(this, desktopPane);

	}

	public void openUnitOfMeasureList() {
		announcer.announce().openUnitOfMeasureList(this, desktopPane);

	}

	public void openNomenclatureList() {
		announcer.announce().openNomenclatureList(this, desktopPane);
	}

	public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel) {
		tree.setModel(categoryTreeModel);
	}

	public CategoryTreeModel getCategoryTreeModel() {
		return (CategoryTreeModel) tree.getModel();
	}

	public boolean categoryNameFilter(String name) {
		return (textFieldCategoryFilter.getText() == null) || (name != null)
				&& name.contains(textFieldCategoryFilter.getText());
	}

	public void addChildWindows(Component child) {
		desktopPane.add(child);
		child.setLocation(newChildPostion);
		newChildPostion.setLocation(newChildPostion.x + 20,
				newChildPostion.y + 20);
	}
}
