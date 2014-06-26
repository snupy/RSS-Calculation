/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import ru.malik.rss.Calculation.entity.Nomenclature;


public class Product extends Nomenclature {
	private List<ProductCalculation> productCalculations = new ArrayList<ProductCalculation>();

	public List<ProductCalculation> getProductCalculations() {
		return productCalculations;
	}

	public void setProductCalculations(List<ProductCalculation> productCalculations) {
		this.productCalculations = productCalculations;
	}

}
