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

import ru.malik.rss.Calculation.entity.UnitOfMeasure;
import ru.malik.rss.Calculation.entity.UnitOfMeasureList;
import ru.malik.rss.Calculation.mvc.events.ListEventObject;
import ru.malik.rss.Calculation.mvc.events.SaveEventObject;
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
		UnitOfMeasureDAO dao =UnitOfMeasureDAO.getInstance();
		UnitOfMeasure t3, unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setName("шт");
		t3 = (UnitOfMeasure) unitOfMeasure.clone();
		{
			JFrame frame = new JFrame();
			DefaultEditPanel editPanel = new UnitOfMeasureEditPanel(
					unitOfMeasure);
			// frame.add(new UnitOfMesureViewPanel(unitOfMeasure));
			editPanel.addSaveListener(new SaveEventListener() {

				public void after(SaveEventObject event){
					try {
						UnitOfMeasureDAO.getInstance().add((UnitOfMeasure)event.getSaveObj());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}

				public void before(SaveEventObject event) {
					// TODO Auto-generated method stub
					
				}

				public void call(SaveEventObject event) {
					// TODO Auto-generated method stub
					
				}
			});
			frame.add(editPanel);
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		/*	unitOfMeasure.setName("ssddd");
			((UnitOfMesureViewPanel)editPanel.getModelView()).modelAutoBinding.getSourceObject().setName("sssSd");
			((UnitOfMesureViewPanel)editPanel.getModelView()).modelAutoBinding.unbind();
			((UnitOfMesureViewPanel)editPanel.getModelView()).modelAutoBinding.bind();
			System.out.println(((UnitOfMesureViewPanel)editPanel.getModelView()).modelAutoBinding.getSourceObject().getName());*/
		}
		
		
		UnitOfMeasureList list = new UnitOfMeasureList(dao.getAll());
		{
			JFrame frame = new JFrame();
			UnitOfMeasuresListSelectPanel listPanel = new UnitOfMeasuresListSelectPanel(list);
			listPanel.addSelectListener(new SelectEventListener() {
				
				public void after(EventObject event) {
					System.out.println("SELECT");
					
				}

				public void before(ListEventObject event) {
					// TODO Auto-generated method stub
					
				}

				public void after(ListEventObject event) {
					// TODO Auto-generated method stub
					
				}

				public void call(ListEventObject event) {
					// TODO Auto-generated method stub
					
				}
			});
			frame.add(listPanel);
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
