package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.exception.NotFoundException;
import com.mxi.maintsuite.model.Aircraft;
import com.mxi.maintsuite.model.Error;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.services.AircraftService;
import com.mxi.maintsuite.services.TaskService;
import io.swagger.annotations.*;

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


    private static final int RESPONSE_CODE_OK = 200;
    private static final int RESPONSE_CODE_CREATED = 201;
    private static final int RESPONSE_CODE_NOCONTENT = 204;
    private static final int RESPONSE_CODE_NOTFOUND = 404;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all aircraft",
            notes = "Returns aircraft as list",
            response = Aircraft.class,
            responseContainer = "List",
            nickname = "Aircraft.findAll")
    public Response get() throws NotFoundException {


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
            @ApiResponse(
                    code = RESPONSE_CODE_OK,
                    message = "Aircraft by Id",
                    response = Aircraft.class
            )}
    )

    public Response get(@ApiParam(value = "Identificator tail", required = true) @PathParam("tail") String tail) throws NotFoundException {

        return Response.status(Response.Status.OK).entity(aircraftService.get(tail)).build();

    }


}

