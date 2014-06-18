package ru.malik.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import ru.malik.rss.Calculation.entity.NomenclatureCategory;

public class NomenclatureCategoryDAO extends AbstractDAO<NomenclatureCategory> {
	private static NomenclatureCategoryDAO nomenclatureCategoryDAO;

	public static NomenclatureCategoryDAO getInstance() {
		if (nomenclatureCategoryDAO == null) {
			nomenclatureCategoryDAO = new NomenclatureCategoryDAO();
		}
		return nomenclatureCategoryDAO;
	}

	private NomenclatureCategoryDAO() {
		super(NomenclatureCategory.class);
	}

	public List<NomenclatureCategory> findAll(NomenclatureCategory owner) {

		Session session = null;
		List<NomenclatureCategory> result = new ArrayList<NomenclatureCategory>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			if (owner != null) {
				result = session.createCriteria(getTClass())
						.add(Restrictions.eq("owner", owner)).list();
				
			} else {
				result = session.createCriteria(getTClass())
						.add(Restrictions.isNull("owner")).list();
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
