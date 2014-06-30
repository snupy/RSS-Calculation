/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/
package ru.malik.rss.Calculation.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductCalculation {
	/* public List<WorkVolume> workVolumes = new ArrayList<WorkVolume>(); */
	private List<MaterialResource> materialResource = new ArrayList<MaterialResource>();
	private String number;
	private Date date;
	private Long id;
	private Product product;

	
	
	public List<MaterialResource> getMaterialResource() {
		return materialResource;
	}
	public void setMaterialResource(List<MaterialResource> materialResource) {
		this.materialResource = materialResource;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
