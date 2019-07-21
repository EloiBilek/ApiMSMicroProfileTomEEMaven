package com.apimsmicroprofiletomeemaven.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apimsmicroprofiletomeemaven.model.entity.Vehicle;
import com.apimsmicroprofiletomeemaven.service.IVehicleService;

/**
 * Control class, which provides the connections of the Rest calls, to the CRUD
 * of {@link Vehicle}.
 * 
 * @author eloi
 *
 */

@Path("/vehicles")
@ApplicationScoped
public class VehicleController {

	private static Logger LOGGER = Logger.getLogger(VehicleController.class.getName());

	/*
	 * Injecting the class of service (in charge of the server) linked to vehicle,
	 * through interface.
	 */
	@EJB
	private IVehicleService vehicleService;

	/*
	 * Search all vehicles
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		try {
			return Response.status(200).entity(vehicleService.findAll()).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Search a particular vehicle for your id
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response findById(@PathParam("id") final Long id) {
		try {
			return Response.status(200).entity(vehicleService.findById(id)).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Creates a vehicle
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(Vehicle resource) {
		try {
			resource = vehicleService.create(resource);
			return Response.status(201).entity(resource).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Refresh a vehicle
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Vehicle resource) {
		try {
			resource = vehicleService.update(resource);
			return Response.status(200).entity(resource).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Delete a vehicle
	 */
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response delete(@PathParam("id") final Long id) {
		try {
			vehicleService.delete(vehicleService.findById(id));
			return Response.status(200).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}
}
