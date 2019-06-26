/**
 * 
 */
package com.apimsmicroprofiletomeemaven.model.repository.impl;

import javax.ejb.Stateless;

import com.apimsmicroprofiletomeemaven.common.AbstractRepository;
import com.apimsmicroprofiletomeemaven.model.entity.Color;
import com.apimsmicroprofiletomeemaven.model.repository.IColorRepository;

/**
 * Implementation class of the repository call Color.
 * 
 * @author eloi
 */
@Stateless
public class ColorRepository extends AbstractRepository<Color> implements IColorRepository {

	public ColorRepository() {
		setClazz(Color.class);
	}

}
