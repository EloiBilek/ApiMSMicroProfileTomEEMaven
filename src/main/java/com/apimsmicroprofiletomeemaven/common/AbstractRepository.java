/**
 * 
 */
package com.apimsmicroprofiletomeemaven.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract class of the repository, with CRUD implementations of EntityManager.
 * 
 * @author eloi eloibilek@gmail.com
 */
public abstract class AbstractRepository<T extends Serializable> implements IOperations<T> {

	@PersistenceContext(unitName = "restapi_PU")
	private EntityManager em;

	protected Class<T> clazz;

	public AbstractRepository() {
	}

	public List<T> findAll() {
		return em.createNamedQuery(clazz.getSimpleName() + "_findAll", clazz).getResultList();
	}

	public T findById(final Long id) {
		return em.find(clazz, id);
	}

	public T create(final T entity) {
		em.persist(entity);
		return entity;
	}

	public T update(final T entity) {
		em.merge(entity);
		return entity;
	}

	public void delete(T entity) {
		if (!em.contains(entity)) {
			entity = em.merge(entity);
		}
		em.remove(entity);
	}

	/**
	 * Method to register the Entity to be used in the persistence layer.
	 * 
	 * @param clazzToSet
	 */
	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}
}
