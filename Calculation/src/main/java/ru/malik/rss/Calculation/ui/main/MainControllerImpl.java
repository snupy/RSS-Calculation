package ru.malik.rss.Calculation.ui.main;

import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import ru.malik.rss.Calculation.entity.UnitOfMeasureList;
import ru.malik.rss.Calculation.entity.UnitOfMeasuresList;
import ru.malik.rss.Calculation.ui.calculationRegister.CalcultaionRegisterViewImpl;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;
import ru.malik.rss.Calculation.ui.mvc.View;
import ru.malik.rss.Calculation.ui.test.UnitOfMesauresListView;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListController;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListTableModel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListView;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListViewImpl;
import ru.malik.utils.UnitOfMeasureDAO;

public class MainControllerImpl extends ControllerImpl<MainModel, MainView>
		implements MainController {

	public MainControllerImpl(MainModel model) {
		super(model);
	}

	public MainControllerImpl() {
		super();
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				MainModelListener.PN_CATEGORY_TREE_MODEL))
			for (MainView view : views) {
				view.setCategoryTreeModel((CategoryTreeModel) evt.getNewValue());
			}
	}

	public View<?> openCalculationRegister(View<?> view, Container container) {

		// TODO нужно переделать
		JInternalFrame internalFrame = new CalcultaionRegisterViewImpl();
		/*
		 * internalFrame.setIconifiable(true); internalFrame.setResizable(true);
		 * internalFrame.setMaximizable(true); internalFrame.setClosable(true);
		 */
		// internalFrame.setBounds(31, 66, 202, 93);
		int count = container.getComponentCount();
		internalFrame.setLocation(count * 50, count * 50);
		container.add(internalFrame);
		internalFrame.setVisible(true);
		return null;
	}

	public View<?> openUnitOfMeasureList(View<?> view, Container container) {

		// TODO нужно переделать
		UnitOfMeasureListViewImpl unitOfMeasureListView = new UnitOfMeasureListViewImpl();
		int count = container.getComponentCount();
		unitOfMeasureListView.setLocation(count * 50, count * 50);
		container.add(unitOfMeasureListView);
		unitOfMeasureListView.setVisible(true);

		UnitOfMeasureListModel model = new UnitOfMeasureListModelImpl();

		UnitOfMeasureListController controller = new UnitOfMeasureListControllerImpl();
		controller.addView(unitOfMeasureListView);
		controller.setModel(model);

		try {
			model.setUnitOfMeasureListTableModel(new UnitOfMeasureListTableModel(
					UnitOfMeasureDAO.getInstance()
							.getAll()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}
}
