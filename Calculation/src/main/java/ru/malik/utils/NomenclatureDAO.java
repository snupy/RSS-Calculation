package ru.malik.utils;

import ru.malik.rss.Calculation.entity.Nomenclature;

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

}
