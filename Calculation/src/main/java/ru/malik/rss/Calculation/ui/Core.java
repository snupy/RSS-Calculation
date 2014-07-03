package ru.malik.rss.Calculation.ui;

import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.NomenclatureCategory;
import ru.malik.rss.Calculation.entity.ProductCalculation;
import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.ui.calculation.CalculationController;
import ru.malik.rss.Calculation.ui.calculation.CalculationControllerImpl;
import ru.malik.rss.Calculation.ui.calculation.CalculationModel;
import ru.malik.rss.Calculation.ui.calculation.CalculationModelImpl;
import ru.malik.rss.Calculation.ui.calculation.CalculationView;
import ru.malik.rss.Calculation.ui.calculation.CalculationViewImpl;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterController;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterControllerImpl;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterModel;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterModelImpl;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterTableModel;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterView;
import ru.malik.rss.Calculation.ui.calculationRegister.CalculationRegisterViewImpl;
import ru.malik.rss.Calculation.ui.common.JMdiFrame;
import ru.malik.rss.Calculation.ui.common.editPanel.EditPanel;
import ru.malik.rss.Calculation.ui.common.editPanel.EditPanelListener;
import ru.malik.rss.Calculation.ui.main.CategoryTreeModel;
import ru.malik.rss.Calculation.ui.main.MainController;
import ru.malik.rss.Calculation.ui.main.MainControllerImpl;
import ru.malik.rss.Calculation.ui.main.MainModel;
import ru.malik.rss.Calculation.ui.main.MainModelImpl;
import ru.malik.rss.Calculation.ui.main.MainViewImpl;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclatureController;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclatureModel;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclatureModelImpl;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclatureView;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclatureViewImpl;
import ru.malik.rss.Calculation.ui.nomenclature.NomenclauteControllerImpl;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListController;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListControllerImpl;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListModel;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListModelImpl;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListTreeTableModel;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListView;
import ru.malik.rss.Calculation.ui.nomenclatureList.NomenclatureListViewImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureController;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModel;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureView;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureViewImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListController;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListTableModel;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListView;
import ru.malik.rss.Calculation.ui.unitOfMeasureList.UnitOfMeasureListViewImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasureListSelect.unitOfMeasureListSelectViewImpl;
import ru.malik.utils.NomenclatureCategoryDAO;
import ru.malik.utils.NomenclatureDAO;
import ru.malik.utils.ProductCalculcationDAO;
import ru.malik.utils.UnitOfMeasureDAO;

public class Core {
	private static Core core;
	private MainModel mainModel;
	private MainController controller;
	private MainViewImpl mainView;

	private Core() {
		super();
		mainModel = new MainModelImpl();
		controller = new MainControllerImpl(mainModel);
		mainView = new MainViewImpl();
		controller.addView(mainView);

		mainModel.setCategoryTreeModel(new CategoryTreeModel());
		mainView.setVisible(true);
	}

	public static Core getInstance() {
		if (core == null) {
			core = new Core();
		}
		return core;
	}

	public static void main(String[] strings) {
		Core.getInstance();
	}

	public UnitOfMeasure addUnitOfMeasure() {
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();

		UnitOfMeasureModel unitOfMeasureModel = new UnitOfMeasureModelImpl();
		unitOfMeasureModel.setUnitOfMesaure(unitOfMeasure);

		UnitOfMeasureView unitOfMeasureView = new UnitOfMeasureViewImpl();
		mainView.addChildWindows((Component) unitOfMeasureView);
		((Component) unitOfMeasureView).setVisible(true);

		UnitOfMeasureController unitOfMeasureController = new UnitOfMeasureControllerImpl();
		unitOfMeasureController.setModel(unitOfMeasureModel);
		unitOfMeasureController.addView(unitOfMeasureView);

		return unitOfMeasure;
	}

	public void editUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		UnitOfMeasureModel unitOfMeasureModel = new UnitOfMeasureModelImpl();
		unitOfMeasureModel.setUnitOfMesaure(unitOfMeasure);

		UnitOfMeasureView unitOfMeasureView = new UnitOfMeasureViewImpl();
		mainView.addChildWindows((Component) unitOfMeasureView);
		((Component) unitOfMeasureView).setVisible(true);

		UnitOfMeasureController unitOfMeasureController = new UnitOfMeasureControllerImpl();
		unitOfMeasureController.setModel(unitOfMeasureModel);
		unitOfMeasureController.addView(unitOfMeasureView);

	}

	public void editCalculation(ProductCalculation productCalculation) {
		final CalculationModel model = new CalculationModelImpl();
		model.setCalculation(productCalculation);

		final CalculationView  view= new CalculationViewImpl();
		
		final CalculationController controller = new CalculationControllerImpl();
		 controller.setModel(model);
		controller.addView(view);
		
		final JMdiFrame frame = new JMdiFrame();
		EditPanel editPanel= new EditPanel();
		
		editPanel.addEditPanelListener(new EditPanelListener() {
			
			public void okActionPerformed(Object sender) {
				controller.applyChanges(view);
				try {
					ProductCalculcationDAO.getInstance().saveOrUpdate(model.getCalculation());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void cancelActionPerformed(Object sender) {
				controller.cancel(view);
				frame.dispose();
			}
		});
		
		editPanel.getContainerPanel().add((Container)view);
		
		
		
		frame.setContentPane(editPanel);
		
		mainView.addChildWindows(frame);
		frame.setVisible(true);
		frame.pack();
		
		

	}

	public void editNomenclature(Nomenclature nomenclature) {
		NomenclatureModel model = new NomenclatureModelImpl();
		NomenclatureView view = new NomenclatureViewImpl();
		NomenclatureController controller = new NomenclauteControllerImpl();

		controller.setModel(model);
		controller.addView(view);

		model.setNomenclature(nomenclature);

		mainView.addChildWindows((Component) view);
		((Component) view).setVisible(true);
	}

	public void showUnitOfMeasureList() {
		UnitOfMeasureListView unitOfMeasureListView = new UnitOfMeasureListViewImpl();
		mainView.addChildWindows((UnitOfMeasureListViewImpl) unitOfMeasureListView);
		((UnitOfMeasureListViewImpl) unitOfMeasureListView).setVisible(true);

		UnitOfMeasureListModel model = new UnitOfMeasureListModelImpl();

		UnitOfMeasureListController controller = new UnitOfMeasureListControllerImpl();
		controller.addView(unitOfMeasureListView);
		controller.setModel(model);

		try {
			model.setUnitOfMeasureListTableModel(new UnitOfMeasureListTableModel(
					UnitOfMeasureDAO.getInstance().getAll()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showCalculationRegister() {
		CalculationRegisterView view = new CalculationRegisterViewImpl();
		mainView.addChildWindows((CalculationRegisterViewImpl) view);
		((CalculationRegisterViewImpl) view).setVisible(true);

		CalculationRegisterModel model = new CalculationRegisterModelImpl();

		CalculationRegisterController controller = new CalculationRegisterControllerImpl();
		controller.addView(view);
		controller.setModel(model);

		try {
			model.setCalculationRegisterTableModel(new CalculationRegisterTableModel(
					ProductCalculcationDAO.getInstance().getAll()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UnitOfMeasureListModel showUnitOfMeasureSelectList() {
		UnitOfMeasureListView unitOfMeasureListView = new unitOfMeasureListSelectViewImpl();
		mainView.addChildWindows((UnitOfMeasureListViewImpl) unitOfMeasureListView);
		((unitOfMeasureListSelectViewImpl) unitOfMeasureListView)
				.setVisible(true);

		UnitOfMeasureListModel model = new UnitOfMeasureListModelImpl();

		UnitOfMeasureListController controller = new UnitOfMeasureListControllerImpl();
		controller.addView(unitOfMeasureListView);
		controller.setModel(model);

		try {
			model.setUnitOfMeasureListTableModel(new UnitOfMeasureListTableModel(
					UnitOfMeasureDAO.getInstance().getAll()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

	public void showNomenclatureList() {
		NomenclatureListView nomenclatureListView = new NomenclatureListViewImpl();
		mainView.addChildWindows((NomenclatureListViewImpl) nomenclatureListView);
		((NomenclatureListViewImpl) nomenclatureListView).setVisible(true);

		NomenclatureListModel nomenclatureListModel = new NomenclatureListModelImpl();

		NomenclatureListController nomenclatureListController = new NomenclatureListControllerImpl();
		nomenclatureListController.setModel(nomenclatureListModel);
		nomenclatureListController.addView(nomenclatureListView);

		nomenclatureListModel
				.setNomenclatureListTreeModel(new NomenclatureListTreeTableModel(
						NomenclatureListModelImpl.NomenclaturesCollector
								.buld(null)));
		;
		/*
		 * List<Nomenclature> nomenclatures;
		 * 
		 * List<NomenclatureCategory> tt = NomenclatureCategoryDAO.getInstance()
		 * .findAll(null); System.out.println(tt.get(0).getName());
		 */

	}
}
