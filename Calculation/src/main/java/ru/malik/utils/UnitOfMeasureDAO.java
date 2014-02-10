package ru.malik.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureDAO implements InterfaceDAO<UnitOfMeasure> {

	public void add(UnitOfMeasure obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(UnitOfMeasure obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public UnitOfMeasure getById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UnitOfMeasure> getAll() throws SQLException {
		Session session = null;
		List<UnitOfMeasure> resList= new ArrayList<UnitOfMeasure>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			resList = session.createCriteria(UnitOfMeasure.class).list();
		} catch(Exception e){
			
			e.printStackTrace();
		} finally{
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return resList;
	}

	public void delete(UnitOfMeasure obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
