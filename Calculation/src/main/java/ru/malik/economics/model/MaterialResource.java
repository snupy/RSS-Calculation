/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

import ru.malik.economics.model.Resource;
// Start of user code (user defined imports)

// End of user code

/**
 * Материапльный ресурс. Т.е. это некий товар в каком-то объеме
 * 
 * @author Малик
 */
public class MaterialResource extends Resource {
	/**
	 * Description of the property volume.
	 */
	public double volume = 0D;

	/**
	 * Description of the property nomenclatures.
	 */
	public Nomenclature nomenclatures = null;

	// Start of user code (user defined attributes for MaterialResource)

	// End of user code

	/**
	 * The constructor.
	 */
	public MaterialResource() {
		// Start of user code constructor for MaterialResource)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MaterialResource)

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
	 * Returns nomenclatures.
	 * @return nomenclatures 
	 */
	public Nomenclature getNomenclatures() {
		return this.nomenclatures;
	}

	/**
	 * Sets a value to attribute nomenclatures. 
	 * @param newNomenclatures 
	 */
	public void setNomenclatures(Nomenclature newNomenclatures) {
		this.nomenclatures = newNomenclatures;
	}

}
