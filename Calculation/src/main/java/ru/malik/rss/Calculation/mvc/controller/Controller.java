package ru.malik.rss.Calculation.mvc.controller;

import java.beans.PropertyChangeEvent;

import ru.malik.rss.Calculation.mvc.model.Model;
import ru.malik.rss.Calculation.mvc.view.View;

public interface Controller {

	public abstract void addModel(Model model);

	public abstract void removeModel(Model model);

	public abstract void addView(View view);

	public abstract void removeView(View view);

	public abstract void propertyChange(PropertyChangeEvent evt);

	public abstract void setModelProperty(String propertyName, Object newValue);

}