/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.economics.model;

import java.util.HashSet;

import ru.malik.economics.model.Nomenclature;
// Start of user code (user defined imports)

// End of user code

/**
 * ????? ????????? ? ??????? ???????????? ???????????
 * 
 * @author ?????
 */
public class Product extends Nomenclature {
	/**
	 * Description of the property productCalculations.
	 */
	public HashSet<ProductCalculation> productCalculations = new HashSet<ProductCalculation>();

	// Start of user code (user defined attributes for Product)

	// End of user code

	/**
	 * The constructor.
	 */
	public Product() {
		// Start of user code constructor for Product)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Product)

	// End of user code
	/**
	 * Returns productCalculations.
	 * @return productCalculations 
	 */
	public HashSet<ProductCalculation> getProductCalculations() {
		return this.productCalculations;
	}

}
