package ru.malik.utils;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
	public void add(T obj) throws SQLException;
	public void update(T obj) throws SQLException;
	public T getById(Long id) throws SQLException;
	public List<T> getAll() throws SQLException;
	public void delete(T obj)throws SQLException;
}
