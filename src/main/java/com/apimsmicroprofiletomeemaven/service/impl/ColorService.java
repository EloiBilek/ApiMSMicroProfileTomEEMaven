/**
 * 
 */
package com.apimsmicroprofiletomeemaven.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.apimsmicroprofiletomeemaven.common.AbstractService;
import com.apimsmicroprofiletomeemaven.common.IOperations;
import com.apimsmicroprofiletomeemaven.model.entity.Color;
import com.apimsmicroprofiletomeemaven.model.repository.IColorRepository;
import com.apimsmicroprofiletomeemaven.service.IColorService;

/**
 * Implementation of the Service class.
 * 
 * @author eloi
 */
@Stateless
public class ColorService extends AbstractService<Color> implements IColorService {

	@EJB
	private IColorRepository repository;

	@Override
	protected IOperations<Color> getDao() {
		return repository;
	}

}
