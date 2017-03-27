package com.mxi.maintsuite.rest.resource;


import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.services.AircraftService;
import com.mxi.maintsuite.to.Aircraft;
import io.swagger.annotations.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.mxi.maintsuite.rest.filter.AppConstants.*;


@Path("/aircrafts")
@Api(value = "/aircrafts", description = "Get aircrafts information")
@Produces("application/json")
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MESSAGE_200, response = Aircraft.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = MESSAGE_400, response = AppException.class),
            @ApiResponse(code = 401, message = MESSAGE_401, response = AppException.class),
            @ApiResponse(code = 403, message = MESSAGE_403, response = AppException.class),
            @ApiResponse(code = 404, message = MESSAGE_404, response = AppException.class),
            @ApiResponse(code = 429, message = MESSAGE_429, response = AppException.class),
            @ApiResponse(code = 500, message = MESSAGE_500, response = AppException.class),
            @ApiResponse(code = 503, message = MESSAGE_503, response = AppException.class)})
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MESSAGE_200, response = Aircraft.class),
            @ApiResponse(code = 400, message = MESSAGE_400, response = AppException.class),
            @ApiResponse(code = 401, message = MESSAGE_401, response = AppException.class),
            @ApiResponse(code = 403, message = MESSAGE_403, response = AppException.class),
            @ApiResponse(code = 404, message = MESSAGE_404, response = AppException.class),
            @ApiResponse(code = 429, message = MESSAGE_429, response = AppException.class),
            @ApiResponse(code = 500, message = MESSAGE_500, response = AppException.class),
            @ApiResponse(code = 503, message = MESSAGE_503, response = AppException.class)})

    public Response get(@ApiParam(value = "Identificator tail", required = true) @PathParam("tail") String tail) throws AppException {

        return Response.status(Response.Status.OK).entity(aircraftService.get(tail)).build();

    }


}

