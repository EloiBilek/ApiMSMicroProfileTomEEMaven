/**
 * 
 */
package com.apimsmicroprofiletomeemaven.model.repository.impl;

import javax.ejb.Stateless;

import com.apimsmicroprofiletomeemaven.common.AbstractRepository;
import com.apimsmicroprofiletomeemaven.model.entity.Vehicle;
import com.apimsmicroprofiletomeemaven.model.repository.IVehicleRepository;

/**
 * Implementation class of the vehicle repository call.
 * 
 * @author eloi
 */
@Stateless
public class VehicleRepository extends AbstractRepository<Vehicle> implements IVehicleRepository {

	public VehicleRepository() {
		setClazz(Vehicle.class);
	}

}
