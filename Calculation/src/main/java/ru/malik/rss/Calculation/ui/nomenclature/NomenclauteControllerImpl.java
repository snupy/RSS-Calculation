package ru.malik.rss.Calculation.ui.nomenclature;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.entity.Nomenclature;
import ru.malik.rss.Calculation.ui.mvc.ControllerImpl;

public class NomenclauteControllerImpl extends ControllerImpl<NomenclatureModel, NomenclatureView> implements NomenclatureController{

	public void propertyChange(PropertyChangeEvent evn) {
		if(NomenclatureModelListener.PropertyName.NOMENCLATURE.name().equals(evn.getPropertyName())){
			setNomenclatureToView((Nomenclature)evn.getNewValue());
		}		
	}
	
	public void setNomenclatureToView(Nomenclature nomenclature){
		for(NomenclatureView view: views){
			view.setNomenclature(nomenclature);
		}
	}

	public void okActionPerform() {
		getModel().save();
	}

	public void cancelActionPerform() {
		getModel().refresh();
		
	}

}
