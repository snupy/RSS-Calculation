/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

import ru.malik.economics.model.Resource;
// Start of user code (user defined imports)

// End of user code

/**
 * Человеский ресурс, который состоит из работника и объема человеко*часов
 * 
 * @author Малик
 */
public class PeopleResource extends Resource {
	/**
	 * Description of the property volume.
	 */
	public double volume = 0D;

	/**
	 * Description of the property workers.
	 */
	public Worker workers = null;

	// Start of user code (user defined attributes for PeopleResource)

	// End of user code

	/**
	 * The constructor.
	 */
	public PeopleResource() {
		// Start of user code constructor for PeopleResource)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for PeopleResource)

	// End of user code
	/**
	 * Returns volume.
	 * @return volume 
	 */
	public double getVolume() {
		return this.volume;
	}

	/**
	 * Sets a value to attribute volume. 
	 * @param newVolume 
	 */
	public void setVolume(double newVolume) {
		this.volume = newVolume;
	}

	/**
	 * Returns workers.
	 * @return workers 
	 */
	public Worker getWorkers() {
		return this.workers;
	}

	/**
	 * Sets a value to attribute workers. 
	 * @param newWorkers 
	 */
	public void setWorkers(Worker newWorkers) {
		this.workers = newWorkers;
	}

}
