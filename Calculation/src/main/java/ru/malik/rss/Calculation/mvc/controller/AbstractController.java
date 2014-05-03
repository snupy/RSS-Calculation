package ru.malik.rss.Calculation.mvc.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EventListener;

import ru.malik.rss.Calculation.mvc.events.listners.ControllerListener;
import ru.malik.rss.Calculation.mvc.model.Model;
import ru.malik.rss.Calculation.mvc.view.ModelView;
import ru.malik.rss.Calculation.mvc.view.View;

public abstract class AbstractController implements PropertyChangeListener, Controller, ControllerListener{
	/*private static Controller controller;
	public static Controller getInstace(){
		if(controller == null){
			controller = new AbstractController(); 
		}
		return controller;
	}
	*/
	private ArrayList<View> registeredViews;
    private ArrayList<Model> registeredModels;

    public AbstractController() {
        registeredViews = new ArrayList<View>();
        registeredModels = new ArrayList<Model>();
    }


    /* (non-Javadoc)
	 * @see ru.malik.rss.Calculation.mvc.controller.Controller#addModel(ru.malik.rss.Calculation.mvc.model.Model)
	 */
    public void addModel(Model model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    /* (non-Javadoc)
	 * @see ru.malik.rss.Calculation.mvc.controller.Controller#removeModel(ru.malik.rss.Calculation.mvc.model.Model)
	 */
    public void removeModel(Model model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    /* (non-Javadoc)
	 * @see ru.malik.rss.Calculation.mvc.controller.Controller#addView(ru.malik.rss.Calculation.mvc.view.View)
	 */
    public void addView(View view) {
    	registeredViews.add(view);
    	view.addControllerListener(this);
    }

    /* (non-Javadoc)
	 * @see ru.malik.rss.Calculation.mvc.controller.Controller#removeView(ru.malik.rss.Calculation.mvc.view.View)
	 */
    public void removeView(View view) {
        registeredViews.remove(view);
        view.removeControllerListener(this);
    }

    /* (non-Javadoc)
	 * @see ru.malik.rss.Calculation.mvc.controller.Controller#propertyChange(java.beans.PropertyChangeEvent)
	 */
    public void propertyChange(PropertyChangeEvent evt) {

        for (View view: registeredViews) {
            view.modelPropertyChange(evt);
        }
    }
    
    
    public void setModelProperty(String propertyName, Object newValue) {

        for (Model model: registeredModels) {
            try {

                Method method = model.getClass().
                    getMethod("set"+propertyName, new Class[] {
                                                      newValue.getClass()
                                                  }


                             );
                method.invoke(model, newValue);

            } catch (Exception ex) {
                //  Handle exception.
            }
        }
    }
	
}

