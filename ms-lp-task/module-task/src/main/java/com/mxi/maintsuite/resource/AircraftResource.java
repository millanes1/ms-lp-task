package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.model.Aircraft;
import com.mxi.maintsuite.services.AircraftService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/aircrafts")
@Api(value = "/aircrafts", description = "Get aircrafts information")
@Produces({"application/json", "application/xml"})
public class AircraftResource {


    @EJB
    private
    AircraftService aircraftService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all aircraft",
            notes = "Returns aircraft as list",
            response = Aircraft.class,
            responseContainer = "List",
            nickname = "Aircraft.findAll")
    public Response get() throws AppException {


        return Response.status(Response.Status.OK).entity(aircraftService.findAll()).build();
    }

    @GET
    @Path("/{tail}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task By Id",
            notes = "Returns task as Object",
            response = Aircraft.class,
            nickname = "Aircraft.getById")


    public Response get(@ApiParam(value = "Identificator tail", required = true) @PathParam("tail") String tail) throws AppException {

        return Response.status(Response.Status.OK).entity(aircraftService.get(tail)).build();

    }


}

