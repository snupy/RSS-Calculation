/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Работа, которая имеет объем. Например: пропилить 200мм бруса или сварить 1000мм шва.
 * 
 * @author Малик
 */
public class WorkVolume {
	/**
	 * Description of the property volume.
	 */
	public double volume = 0D;

	// Start of user code (user defined attributes for WorkVolume)

	// End of user code

	/**
	 * The constructor.
	 */
	public WorkVolume() {
		// Start of user code constructor for WorkVolume)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for WorkVolume)

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

}
