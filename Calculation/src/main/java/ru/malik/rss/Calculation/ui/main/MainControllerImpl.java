package ru.malik.rss.Calculation.ui.main;

import java.awt.Container;
import java.beans.PropertyChangeEvent;

import javax.swing.JInternalFrame;

import ru.malik.rss.Calculation.ui.calculationRegister.CalcultaionRegisterViewImpl;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;
import ru.malik.rss.Calculation.ui.mvc.View;

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

}
