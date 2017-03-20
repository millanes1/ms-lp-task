package com.mxi.maintsuite;


import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.model.Tool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/tools")
@Api(value = "/tools", description = "Get tools information", tags = "tools")
public class ToolResource {

    @Inject
    PersistenceHelper helper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all tool",
            notes = "Returns tool as list",
            response = Tool.class,
            responseContainer = "List")
    public Response get() {

        final List<Tool> toolList = helper.getEntityManager().createNamedQuery("Tool.findAll", Tool.class).getResultList();
        return Response.status(Response.Status.OK).entity(toolList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Tool By Id",
            notes = "Returns tool as Object",
            response = Tool.class)
    public Response get(@PathParam("id") int id) {
        final Tool tool = helper.getEntityManager().createNamedQuery("Tool.getById", Tool.class).setParameter("id", id).getSingleResult();
        return Response.status(Response.Status.OK).entity(tool).build();
    }


    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tasks By WorkPacakage Id",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List")
    public Response findByTaskId(@PathParam("id") int id) {
        final List<Tool> toolList = helper.getEntityManager().createNamedQuery("Tool.findByTaskId", Tool.class).getResultList();
        return Response.status(Response.Status.OK).entity(toolList).build();


    }

}
