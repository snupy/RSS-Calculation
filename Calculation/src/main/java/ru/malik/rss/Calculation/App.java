package ru.malik.rss.Calculation;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.malik.economics.model.UnitOfMeasure;
import ru.malik.utils.UnitOfMeasureDAO;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException {
		/*
		 * int i = 0; System.out.println(++i); Configuration con = new
		 * Configuration(); con.configure();
		 * con.setProperty("hibernate.dialect",
		 * "org.hibernate.dialect.HSQLDialect"); System.out.println(++i);
		 * SessionFactory sf = con.buildSessionFactory();
		 * System.out.println(++i); Session session = sf.openSession();
		 * System.out.println(++i); List<UnitOfMeasure> unitOfMeasures = new
		 * ArrayList<UnitOfMeasure>(); System.out.println(++i); unitOfMeasures =
		 * session.createCriteria(UnitOfMeasure.class).list();
		 * 
		 * System.out.println(unitOfMeasures.size()); for (UnitOfMeasure
		 * unitOfMeasure : unitOfMeasures) {
		 * System.out.println(unitOfMeasure.getName()); } session.close();
		 */
		UnitOfMeasureDAO d = new UnitOfMeasureDAO();
		UnitOfMeasure cm = new UnitOfMeasure();
		cm.setName("сантиметр");
		// cm.setId(Long.valueOf(3));
		// d.add(cm);/**/
		List<UnitOfMeasure> unitOfMeasures = d.getAll();
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try {
		 * UnitOfMeasureListWindows window = new UnitOfMeasureListWindows(new
		 * ArrayList<UnitOfMeasure>());
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } } });
		 */

		System.out.println("bye!");
	}
}
