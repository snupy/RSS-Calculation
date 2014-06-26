package ru.malik.utils;

import ru.malik.rss.Calculation.entity.ProductCalculation;

public class ProductCalculcationDAO extends AbstractDAO<ProductCalculation> {

	public ProductCalculcationDAO() {
		super(ProductCalculation.class);
	}

private static ProductCalculcationDAO productCalculcationDAO;
	
	public static ProductCalculcationDAO getInstance(){
		if(productCalculcationDAO == null){
			productCalculcationDAO = new ProductCalculcationDAO();
		}
		return productCalculcationDAO;
	}
}
