package ru.malik.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ru.malik.economics.model.UnitOfMeasure;

public class UnitOfMeasureDAO extends AbstractDAO<UnitOfMeasure> {

	public UnitOfMeasureDAO() {
		super(UnitOfMeasure.class);
	}

}
