package ru.malik.rss.Calculation;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.events.listners.SaveEventListener;
import ru.malik.rss.Calculation.mvc.events.listners.SelectEventListener;
import ru.malik.rss.Calculation.mvc.view.DefaultEditPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureEditPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureListPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasuresListSelectPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMesureViewPanel;
import ru.malik.utils.HibernateUtil;
import ru.malik.utils.UnitOfMeasureDAO;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException,
			CloneNotSupportedException {
		UnitOfMeasureDAO dao = new UnitOfMeasureDAO();
		UnitOfMeasure t3, unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setName("шт");
		t3 = (UnitOfMeasure) unitOfMeasure.clone();
		{
			JFrame frame = new JFrame();
			DefaultEditPanel editPanel = new UnitOfMeasureEditPanel(
					unitOfMeasure);
			// frame.add(new UnitOfMesureViewPanel(unitOfMeasure));
			editPanel.addSaveListener(new SaveEventListener() {
				
				public void save(EventObject event) {
					System.out.println("SAVE!");					
				}
			});
			frame.add(editPanel);
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		ArrayList<UnitOfMeasure> list = (ArrayList<UnitOfMeasure>)dao.getAll();
		{
			JFrame frame = new JFrame();
			UnitOfMeasuresListSelectPanel listPanel = new UnitOfMeasuresListSelectPanel(list);
			listPanel.addSelectListener(new SelectEventListener() {
				
				public void select(EventObject event) {
					System.out.println("SELECT");
					
				}
			});
			frame.add(listPanel);
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		// dao.add(unitOfMeasure);/**/
	}
}
