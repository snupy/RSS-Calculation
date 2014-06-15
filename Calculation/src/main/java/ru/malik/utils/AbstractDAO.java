package ru.malik.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDAO<T> implements InterfaceDAO<T> {
	private Class<T> tClass;

	public AbstractDAO(Class<T> tClass) {
		super();
		this.tClass = tClass;
	}

	public void add(T obj) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.save(obj);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void update(T obj) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.update(obj);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public T getById(Long id) throws SQLException {
		T res = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			res = (T) session.load(tClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public void refresh(T obj) throws SQLException {
		T res = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.refresh(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() throws SQLException {
		Session session = null;
		List<T> resList = new ArrayList<T>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			resList = session.createCriteria(tClass).list();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resList;
	}

	public void delete(T obj) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.delete(obj);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void saveOrUpdate(T obj) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.saveOrUpdate(obj);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Class<T> getTClass() {
		return tClass;
	}

	
}
