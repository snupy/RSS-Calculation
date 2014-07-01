/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

public class Resource {
	private Long id;
	private Double volume;
	private ProductCalculation productCalculation;
	
	
	
	public ProductCalculation getProductCalculation() {
		return productCalculation;
	}
	public void setProductCalculation(ProductCalculation productCalculation) {
		this.productCalculation = productCalculation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	
}
