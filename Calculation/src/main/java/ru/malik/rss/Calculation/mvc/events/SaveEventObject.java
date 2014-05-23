package ru.malik.rss.Calculation.mvc.events;

import java.util.EventObject;

public class SaveEventObject extends EventObject {

	private SaveEventObject(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	private Object saveObj;
	public SaveEventObject(Object source, Object saveObj) {
		super(source);
		this.saveObj = saveObj;
	}
	public Object getSaveObj() {
		return saveObj;
	}
	public void setSaveObj(Object saveObj) {
		this.saveObj = saveObj;
	}

	
}
