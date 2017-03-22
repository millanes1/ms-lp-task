package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.model.Tool;
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
            nickname = "findToolAll")
    public Response get() {


        return Response.status(Response.Status.OK).entity(toolService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Tool By Id",
            notes = "Returns tool as Object",
            response = Tool.class,
            nickname = "getToolById"
    )
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(toolService.get(id)).build();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tools By taskId",
            notes = "Returns task as list",
            response = Tool.class,
            responseContainer = "List",
            nickname = "findToolByTaskId")
    public Response findByTaskId(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(toolService.findByTask(id)).build();


    }

}
