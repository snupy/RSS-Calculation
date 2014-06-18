package ru.malik.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.entity.NomenclatureCategory;

public class NomenclatureDAO extends AbstractDAO<Nomenclature> {
	private static NomenclatureDAO nomenclatureDAO;

	public static NomenclatureDAO getInstance() {
		if (nomenclatureDAO == null) {
			nomenclatureDAO = new NomenclatureDAO();
		}
		return nomenclatureDAO;
	}

	private NomenclatureDAO() {
		super(Nomenclature.class);
	}
	
	public List<Nomenclature> findByOwner(NomenclatureCategory owner){
		Session session = null;
		List<Nomenclature> result = new ArrayList<Nomenclature>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			if (owner != null) {
				result = session.createCriteria(getTClass())
						.add(Restrictions.eq("nomenclatureCategory", owner)).list();
				
			} else {
				result = session.createCriteria(getTClass())
						.add(Restrictions.isNull("nomenclatureCategory")).list();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}

}
