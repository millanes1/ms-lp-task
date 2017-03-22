package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.model.Error;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.services.TaskService;
import com.mxi.maintsuite.exception.NotFoundException;
import io.swagger.annotations.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/tasks")
@Api(value = "/tasks", description = "Get tasks information")
@Produces({"application/json", "application/xml"})
public class TaskResource {


    @EJB
    private
    TaskService taskService;


    private static final int RESPONSE_CODE_OK = 200;
    private static final int RESPONSE_CODE_CREATED = 201;
    private static final int RESPONSE_CODE_NOCONTENT = 204;
    private static final int RESPONSE_CODE_NOTFOUND = 404;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "findTaskAll")
    public Response get() throws NotFoundException {


        return Response.status(Response.Status.OK).entity(taskService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task By Id",
            notes = "Returns task as Object",
            response = Task.class,
            nickname = "getTaskById")
    @ApiResponses(value = {
            @ApiResponse(
                    code = RESPONSE_CODE_OK,
                    message = "Task by Id",
                    response = Task.class
                    , responseContainer = "List"
            ),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)}
    )

    public Response get(@ApiParam(value = "Identificator Task", required = true) @PathParam("id") int id) throws NotFoundException {

        return Response.status(Response.Status.OK).entity(taskService.get(id)).build();

    }


    @GET
    @Path("/workpackage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tasks By WorkPacakage Id",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "getTaskByWorkPackageId"
    )
    public Response findByWorkPackageId(@ApiParam(value = "Identificator WorkPackage", required = true) @PathParam("id") int id) throws NotFoundException {


        return Response.status(Response.Status.OK).entity(taskService.findByWorkPackage(id)).build();

    }

}

