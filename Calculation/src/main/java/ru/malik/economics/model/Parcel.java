/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Партия товара
 * 
 * @author Малик
 */
public class Parcel {
	/**
	 * Description of the property materialResources.
	 */
	public MaterialResource materialResources = null;

	// Start of user code (user defined attributes for Parcel)

	// End of user code

	/**
	 * The constructor.
	 */
	public Parcel() {
		// Start of user code constructor for Parcel)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Parcel)

	// End of user code
	/**
	 * Returns materialResources.
	 * @return materialResources 
	 */
	public MaterialResource getMaterialResources() {
		return this.materialResources;
	}

	/**
	 * Sets a value to attribute materialResources. 
	 * @param newMaterialResources 
	 */
	public void setMaterialResources(MaterialResource newMaterialResources) {
		this.materialResources = newMaterialResources;
	}

}
