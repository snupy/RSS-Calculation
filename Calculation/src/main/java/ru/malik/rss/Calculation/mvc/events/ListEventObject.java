package ru.malik.rss.Calculation.mvc.events;

import java.util.EventObject;

public class ListEventObject extends EventObject {
	private Object listModel, selected;

	public ListEventObject(Object arg0, Object listModel, Object selected) {
		super(arg0);
		this.listModel = listModel;
		this.selected = selected;
	}

	private ListEventObject(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public Object getListModel() {
		return listModel;
	}

	public void setListModel(Object listModel) {
		this.listModel = listModel;
	}

	public Object getSelected() {
		return selected;
	}

	public void setSelected(Object selected) {
		this.selected = selected;
	}
	
	
	
}
