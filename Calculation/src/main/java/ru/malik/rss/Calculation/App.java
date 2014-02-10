package ru.malik.rss.Calculation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.malik.economics.model.UnitOfMeasure;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		int i = 0;
		System.out.println(++i);
		Configuration con = new Configuration();
		con.configure();
		con.setProperty("hibernate.dialect",
				"org.hibernate.dialect.HSQLDialect");
		System.out.println(++i);
		SessionFactory sf = con.buildSessionFactory();
		System.out.println(++i);
		Session session = sf.openSession();
		System.out.println(++i);
		List<UnitOfMeasure> unitOfMeasures = new ArrayList<UnitOfMeasure>();
		System.out.println(++i);
		unitOfMeasures = session.createCriteria(UnitOfMeasure.class).list();
		
		System.out.println(unitOfMeasures.size());
		for (UnitOfMeasure unitOfMeasure : unitOfMeasures) {
			System.out.println(unitOfMeasure.getName());
		}
		session.close();
	}
}
