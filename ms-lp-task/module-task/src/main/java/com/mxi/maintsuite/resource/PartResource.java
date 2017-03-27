package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.to.Part;
import com.mxi.maintsuite.services.PartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/parts")
@Api(value = "/parts", description = "Get parts information", tags = "parts")
public class PartResource {

    @EJB
    private
    PartService partService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all part",
            notes = "Returns  Part as list",
            response = Part.class,
            responseContainer = "List",
            nickname = "Part.findAll")
    public Response get() throws AppException {


        return Response.status(Response.Status.OK).entity(partService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Part By Id",
            notes = "Returns part as Object",
            response = Part.class,
            nickname = "Part.getById"
    )
    public Response get(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(partService.get(id)).build();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Parts By taskId",
            notes = "Returns part as list",
            response = Part.class,
            responseContainer = "List",
            nickname = "Part.findByTaskId")
    public Response findByTaskId(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(partService.findByTask(id)).build();


    }

}
