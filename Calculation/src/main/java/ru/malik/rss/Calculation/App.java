package ru.malik.rss.Calculation;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.rss.Calculation.mvc.view.DefaultEditPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMeasureEditPanel;
import ru.malik.rss.Calculation.mvc.view.UnitOfMesureViewPanel;
import ru.malik.utils.HibernateUtil;
import ru.malik.utils.UnitOfMeasureDAO;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException, CloneNotSupportedException {
		UnitOfMeasureDAO dao = new UnitOfMeasureDAO();
		UnitOfMeasure t3, unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setName("шт");
		t3 = (UnitOfMeasure)unitOfMeasure.clone();
		JFrame frame = new JFrame();
		DefaultEditPanel editPanel = new UnitOfMeasureEditPanel(unitOfMeasure);
		//frame.add(new UnitOfMesureViewPanel(unitOfMeasure));
		frame.add(editPanel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dao.add(unitOfMeasure);/**/
	}
}
