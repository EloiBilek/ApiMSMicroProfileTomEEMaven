/**
 * 
 */
package com.apimsmicroprofiletomeemaven.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.apimsmicroprofiletomeemaven.common.AbstractService;
import com.apimsmicroprofiletomeemaven.common.IOperations;
import com.apimsmicroprofiletomeemaven.model.entity.Vehicle;
import com.apimsmicroprofiletomeemaven.model.repository.IVehicleRepository;
import com.apimsmicroprofiletomeemaven.service.IVehicleService;

/**
 * Implementation of the Service class.
 * 
 * @author eloi
 */
@Stateless
public class VehicleService extends AbstractService<Vehicle> implements IVehicleService {

	@EJB
	private IVehicleRepository repository;

	@Override
	protected IOperations<Vehicle> getDao() {
		return repository;
	}

}
