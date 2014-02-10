/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Класс работника
 * 
 * @author Малик
 */
public class Worker {
	/**
	 * Description of the property professions.
	 */
	public Profession professions = null;

	// Start of user code (user defined attributes for Worker)

	// End of user code

	/**
	 * The constructor.
	 */
	public Worker() {
		// Start of user code constructor for Worker)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Worker)

	// End of user code
	/**
	 * Returns professions.
	 * @return professions 
	 */
	public Profession getProfessions() {
		return this.professions;
	}

	/**
	 * Sets a value to attribute professions. 
	 * @param newProfessions 
	 */
	public void setProfessions(Profession newProfessions) {
		this.professions = newProfessions;
	}

}
