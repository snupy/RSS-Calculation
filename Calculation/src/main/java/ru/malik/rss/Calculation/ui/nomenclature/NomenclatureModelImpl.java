package ru.malik.rss.Calculation.ui.nomenclature;

import java.sql.SQLException;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.mvc.ModelImpl;
import ru.malik.utils.NomenclatureDAO;

public class NomenclatureModelImpl extends ModelImpl<NomenclatureModelListener>
		implements NomenclatureModel {

	private Nomenclature nomenclature;

	public NomenclatureModelImpl() {
		super(NomenclatureModelListener.class);
	}

	public void setNomenclature(Nomenclature nomenclature) {
		if (this.nomenclature == nomenclature) {
			return;
		}

		getPropertyChangeSupport().firePropertyChange(
				NomenclatureModelListener.PropertyName.NOMENCLATURE.name(),
				this.nomenclature, this.nomenclature = nomenclature);
	}

	public Nomenclature getNomenclature() {

		return nomenclature;
	}

	public void save() {
		try {
			NomenclatureDAO.getInstance().saveOrUpdate(this.nomenclature);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refresh() {
		try {
			NomenclatureDAO.getInstance().refresh(this.nomenclature);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
