package com.mxi.maintsuite.rest.resource;


import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Labour;
import com.mxi.maintsuite.services.LabourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/labours")
@Api(value = "/labours", description = "Get labours information", tags = "labours")
@Produces("application/json")
public class LabourResource {

    @EJB
    private
    LabourService labourService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all labour",
            notes = "Returns labour as list",
            response = Labour.class,
            responseContainer = "List",
            nickname = "Labour.findAll")
    public Response get() throws AppException {


        return Response.status(Response.Status.OK).entity(labourService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Labour By Id",
            notes = "Returns labour as Object",
            response = Labour.class,
            nickname = "Labour.getById"
    )
    public Response get(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(labourService.get(id)).build();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Labours By taskId",
            notes = "Returns labour as list",
            response = Labour.class,
            responseContainer = "List",
            nickname = "Labour.findByTaskId")
    public Response findByTaskId(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(labourService.findByTask(id)).build();


    }

}
