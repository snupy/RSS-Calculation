package ru.malik.rss.Calculation.ui.unitOfMeasureList;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;

import javax.swing.JInternalFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.model.Model;
import ru.malik.rss.Calculation.mvc.view.View;
import ru.malik.rss.Calculation.ui.Core;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureController;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureControllerImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModel;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureModelImpl;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureView;
import ru.malik.rss.Calculation.ui.unitOfMeasure.UnitOfMeasureViewImpl;

public class UnitOfMeasureListControllerImpl extends
		ControllerImpl<UnitOfMeasureListModel, UnitOfMeasureListView> implements
		UnitOfMeasureListController {

	public void propertyChange(PropertyChangeEvent evt) {
		if (UnitOfMeasureListModelListener.PropertyName.UNIT_OF_MEASURE_LIST_TABLE_MODEL
				.name().equals(evt.getPropertyName())) {
			setTableModelToViews((UnitOfMeasureListTableModel) evt
					.getNewValue());
		} else if (UnitOfMeasureListModelListener.PropertyName.SELECTED_UNIT_OF_MEASURE
				.name().equals(evt.getPropertyName())) {
			// TODO тут необходмо обработывать сообщение модели об изменении выбранной строки
			//int rowIndex = getModel().getUnitOfMeasureListTableModel().g
			for (UnitOfMeasureListView unitOfMeasureListView : views) {
				//unitOfMeasureListView.setSelectedRowIndex((Integer));
			}
		}

	}

	private TableModelListener listener = new TableModelListener() {

		public void tableChanged(TableModelEvent env) {
			if (env.getType() == TableModelEvent.DELETE
					|| env.getType() == TableModelEvent.INSERT) {
				setItemCountToViews();
			}
		}
	};

	public void setTableModelToViews(
			UnitOfMeasureListTableModel unitOfMeasureListTableModel) {
		for (UnitOfMeasureListView unitOfMeasureListView : views) {
			unitOfMeasureListTableModel.addTableModelListener(listener);
			unitOfMeasureListView
					.setUnitOfMeasureListTableModel(unitOfMeasureListTableModel);
		}
		setItemCountToViews(unitOfMeasureListTableModel.getRowCount());
	}

	public void setItemCountToViews() {
		setItemCountToViews(getModel().getUnitOfMeasureListTableModel()
				.getRowCount());
	}

	public void setItemCountToViews(int count) {
		for (UnitOfMeasureListView unitOfMeasureListView : views) {
			unitOfMeasureListView.setItemCount(count);
		}
	}

	public void editUnitOfMeasure(UnitOfMeasureListView sender) {
		/*UnitOfMeasureModel unitOfMeasureModel = new UnitOfMeasureModelImpl();

		unitOfMeasureModel.setUnitOfMesaure(getModel().getSelectedUnitOfMeasure());

		UnitOfMeasureView unitOfMeasureView = new UnitOfMeasureViewImpl();

		UnitOfMeasureController unitOfMeasureController = new UnitOfMeasureControllerImpl();
		unitOfMeasureController.setModel(unitOfMeasureModel);
		unitOfMeasureController.addView(unitOfMeasureView);

		((JInternalFrame) sender).getDesktopPane().add(
				(UnitOfMeasureViewImpl) unitOfMeasureView);

		((UnitOfMeasureViewImpl) unitOfMeasureView).setBounds(new Rectangle(
				100, 100, 400, 400));
		((UnitOfMeasureViewImpl) unitOfMeasureView).setVisible(true);
		((UnitOfMeasureViewImpl) unitOfMeasureView).requestFocus();*/
		
		Core.getInstance().editUnitOfMeasure(getModel().getSelectedUnitOfMeasure());
	}

	public void addUnitOfMeasure(UnitOfMeasureListView sender) {
		
		// TODO нужно переделать
		//Core.getInstance().addUnitOfMeasure();
		Core.getInstance().editUnitOfMeasure(new UnitOfMeasure());
	}

	public void removeUnitOfMeasure(UnitOfMeasureListView sender) {
		// TODO Необходим запрос перед удалением
		getModel().removeUnitOfMeasure(getModel().getSelectedUnitOfMeasure());
	}

	public void selectRow(int index, UnitOfMeasureListView sender) {
		getModel().setSelectedUnitOfMeasure(
				getModel().getUnitOfMeasureListTableModel().getUnitOfMeasureAt(
						index));
		
		sender.setInfoSelectedRow(index+1);
	}

	public void okActionPerform(UnitOfMeasureListView sender) {
		// TODO
	}

	public void cancelActionPerform(UnitOfMeasureListView sender) {
		// TODO Auto-generated method stub
		
	}
	
	
}

