package ru.malik.rss.Calculation;

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
import ru.malik.utils.UnitOfMeasureDAO;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException {
		new JFrame() {
			{
				setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				add(new DefaultEditPanel() {

					@Override
					public void save() {
						// TODO Auto-generated method stub

					}

					@Override
					public void cancel() {
						// TODO Auto-generated method stub

					}
				});
			}
		};
		System.out.println("bye!");
	}
}
