package com.mxi.maintsuite;


import com.mxi.maintsuite.model.Task;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/tasks")
@Api(value = "/tasks", description = "Get task information", tags = "task")
public class TaskResource {

    @Inject
    PersistenceHelper helper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task",
            notes = "Returns task as list",
            response = List.class)
    public Response get() {

        final List<Task> taskList = helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).getResultList();
        return Response.status(Response.Status.OK).entity(taskList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task by Id",
            notes = "Returns task as Object",
            response = List.class)
    public Response get(@PathParam("id") int id) {
        final Task task = helper.getEntityManager().createNamedQuery("Task.getById", Task.class).setParameter("id", id).getSingleResult();
        return Response.status(Response.Status.OK).entity(task).build();

    }


    @GET
    @Path("/workpackage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task associated in the workpackage",
            notes = "Returns task as list",
            response = List.class)
    public Response findByWorpackageId(@PathParam("id") int id) {
        final List<Task> taskList = helper.getEntityManager().createNamedQuery("Task.findByWorkpackageId", Task.class).setParameter("id", id).getResultList();
        return Response.status(Response.Status.OK).entity(taskList).build();

    }


}

