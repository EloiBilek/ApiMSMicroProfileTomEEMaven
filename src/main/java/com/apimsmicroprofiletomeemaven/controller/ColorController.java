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

import com.apimsmicroprofiletomeemaven.model.entity.Color;
import com.apimsmicroprofiletomeemaven.service.IColorService;

/**
 * Control class, which provides Rest calls connections, to {@link Color} CRUD.
 * 
 * @author eloi
 *
 */

@Path("/colors")
@ApplicationScoped
public class ColorController {

	private static Logger LOGGER = Logger.getLogger(ColorController.class.getName());

	/*
	 * Injecting the class of service (in charge of the server) linked to the color,
	 * through interface
	 */
	@EJB
	private IColorService colorService;

	/*
	 * Search all colors
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		try {
			return Response.status(200).entity(colorService.findAll()).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Search for a certain color by its id
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response findById(@PathParam("id") final Long id) {
		try {
			return Response.status(200).entity(colorService.findById(id)).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Creates a color
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(Color resource) {
		try {
			resource = colorService.create(resource);
			return Response.status(201).entity(resource).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Update a color
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Color resource) {
		try {
			resource = colorService.update(resource);
			return Response.status(200).entity(resource).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

	/*
	 * Delete a color
	 */
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response delete(@PathParam("id") final Long id) {
		try {
			colorService.delete(colorService.findById(id));
			return Response.status(200).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new WebApplicationException(e, 500);
		}
	}

}
