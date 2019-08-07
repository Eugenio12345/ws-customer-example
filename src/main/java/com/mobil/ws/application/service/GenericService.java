package com.mobil.ws.application.service;

import java.sql.SQLException;
import java.util.List;

public interface GenericService<T> {

	/**
	 * Method to save or update
	 * @param t
	 */
	void saveOrUpdate(T t)throws SQLException;
	
	/**
	 * Method for get all Records
	 * @return
	 */
	List<T>getAll();
	
	/**
	 * find one record By Id 
	 */
	
	T findId(Integer id);
}
