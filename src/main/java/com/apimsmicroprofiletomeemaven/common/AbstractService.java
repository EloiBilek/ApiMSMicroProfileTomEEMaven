/**
* 
*/
package com.apimsmicroprofiletomeemaven.common;

import java.io.Serializable;
import java.util.List;

/**
 * Abstract class implementing the CRUD calls from the repository (DAO).
 * 
 * @author eloi eloibilek@gmail.com
 */
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

	protected abstract IOperations<T> getDao();

	@Override
	public T findById(Long id) {
		return getDao().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

}