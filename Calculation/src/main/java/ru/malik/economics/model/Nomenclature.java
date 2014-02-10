/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Номенклатура — базовый класс всех вещей.
 * 
 * @author Малик
 */
public class Nomenclature {
	/**
	 * Description of the property unitOfMeasures.
	 */
	public UnitOfMeasure unitOfMeasures = null;

	/**
	 * Description of the property Name.
	 */
	private String Name = "";

	// Start of user code (user defined attributes for Nomenclature)

	// End of user code

	/**
	 * The constructor.
	 */
	public Nomenclature() {
		// Start of user code constructor for Nomenclature)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Nomenclature)

	// End of user code
	/**
	 * Returns unitOfMeasures.
	 * @return unitOfMeasures 
	 */
	public UnitOfMeasure getUnitOfMeasures() {
		return this.unitOfMeasures;
	}

	/**
	 * Sets a value to attribute unitOfMeasures. 
	 * @param newUnitOfMeasures 
	 */
	public void setUnitOfMeasures(UnitOfMeasure newUnitOfMeasures) {
		this.unitOfMeasures = newUnitOfMeasures;
	}

	/**
	 * Returns Name.
	 * @return Name 
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Sets a value to attribute Name. 
	 * @param newName 
	 */
	public void setName(String newName) {
		this.Name = newName;
	}

}
