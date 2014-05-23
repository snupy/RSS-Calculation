package ru.malik.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ru.malik.rss.Calculation.entity.UnitOfMeasure;

public class UnitOfMeasureDAO extends AbstractDAO<UnitOfMeasure> {
	
	private static UnitOfMeasureDAO unitOfMeasureDAO;
	
	public static UnitOfMeasureDAO getInstance(){
		if(unitOfMeasureDAO == null){
			unitOfMeasureDAO = new UnitOfMeasureDAO();
		}
		return unitOfMeasureDAO;
	}

	private UnitOfMeasureDAO() {
		super(UnitOfMeasure.class);
	}

}
