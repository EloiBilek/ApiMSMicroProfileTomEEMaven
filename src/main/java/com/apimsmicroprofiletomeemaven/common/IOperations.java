package com.apimsmicroprofiletomeemaven.common;

import java.util.List;

/**
 * Interface with standard CRUD methods.
 * 
 * @author eloi eloibilek@gmail.com
 */
public interface IOperations<T> {

	T findById(final Long id);

	List<T> findAll();

	T create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	// void deleteById(final String entityId);

}
