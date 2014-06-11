package ru.malik.rss.Calculation.ui.mvc;

import java.util.ArrayList;

public abstract class ControllerImpl<M extends Model, V extends View>
		implements Controller<M, V> {
	protected M model;
	protected final ArrayList<V> views = new ArrayList<V>();

	public void setModel(M model) {
		if ((this.model == null) || !this.model.equals(model)) {
			if (this.model != null) {
				this.model.removePropertyChangeListener(this);
			}
			this.model = model;
			this.model.addPropertyChangeListener(this);
		}
	}

	public M getModel() {
		return this.model;
	}

	public void addView(V view) {
		views.add(view);
		view.addViewListener(this);
	}

	public void removeView(V view) {
		views.remove(view);
		view.removeViewListener(this);
	}

	public V getView(int index) {
		return views.get(index);
	}

	public ControllerImpl(M model) {
		super();
		setModel(model);
	}

	public ControllerImpl() {
		super();
	}
}
