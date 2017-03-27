package com.mxi.maintsuite.rest.resource;


import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Tool;
import com.mxi.maintsuite.services.ToolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/tools")
@Api(value = "/tools", description = "Get tools information", tags = "tools")
public class ToolResource {

    @EJB
    private
    ToolService toolService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all tool",
            notes = "Returns tool as list",
            response = Tool.class,
            responseContainer = "List",
            nickname = "Tool.findAll")
    public Response get() throws AppException {


        return Response.status(Response.Status.OK).entity(toolService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Tool By Id",
            notes = "Returns tool as Object",
            response = Tool.class,
            nickname = "Tool.getById"
    )
    public Response get(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(toolService.get(id)).build();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tools By taskId",
            notes = "Returns tool as list",
            response = Tool.class,
            responseContainer = "List",
            nickname = "Tool.findByTaskId")
    public Response findByTaskId(@PathParam("id") Long id) throws AppException {
        return Response.status(Response.Status.OK).entity(toolService.findByTask(id)).build();


    }

}
