package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.exception.Message;
import com.mxi.maintsuite.exception.NotFoundException;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.services.TaskService;
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

    private static final String MESSAGE_200 = "Success";
    private static final String MESSAGE_400 = "The request was invalid or cannot be otherwise served.";
    private static final String MESSAGE_401 = "Authentication credentials were missing or incorrect.";
    private static final String MESSAGE_403 = "The request is understood, but it has been refused or access is not allowed.";
    private static final String MESSAGE_404 = "The URI requested is invalid or the resource requested does not exists.";
    private static final String MESSAGE_429 = "The request cannot be served due to the application’s rate limit having been exhausted for the resource.";
    private static final String MESSAGE_503 = "The server is up, but overloaded with requests. Try again later.";
    private static final String MESSAGE_500 = "Something is broken";


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "Task.findAll")
    public Response get() throws AppException {


        return Response.status(Response.Status.OK).entity(taskService.findAll()).build();
    }

    @GET
    @Path("/users/{userMail}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all task By User",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "Task.findByUser")
    public Response get(@ApiParam(value = "User Mail", required = true) @PathParam("userMail") String userMail, @ApiParam(value = "Offset starting item", defaultValue = "1") @DefaultValue("1") @QueryParam("offset") Integer offset, @ApiParam(value = "Limits the number of returned items", defaultValue = "10") @DefaultValue("10") @QueryParam("limit") Integer limit) throws AppException {


        return Response.status(Response.Status.OK).entity(taskService.findByUser(userMail, offset, limit)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task By Id",
            notes = "Returns task as Object",
            response = Task.class,
            nickname = "Task.getById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MESSAGE_200, response = Task.class),
            @ApiResponse(code = 400, message = MESSAGE_400, response = Message.class),
            @ApiResponse(code = 401, message = MESSAGE_401, response = Message.class),
            @ApiResponse(code = 403, message = MESSAGE_403, response = Message.class),
            @ApiResponse(code = 404, message = MESSAGE_404, response = Message.class),
            @ApiResponse(code = 429, message = MESSAGE_429, response = Message.class),
            @ApiResponse(code = 500, message = MESSAGE_500, response = Message.class),
            @ApiResponse(code = 503, message = MESSAGE_503, response = Message.class)})


    public Response get(@ApiParam(value = "Serial Identifier Task in the product Line Planning", required = true) @PathParam("id") Long id) throws AppException {

        return Response.status(Response.Status.OK).entity(taskService.get(id)).build();

    }

    @GET
    @Path("/barcodes/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task By Barcode",
            notes = "Returns task as Object",
            response = Task.class,
            nickname = "Task.getByBarcode")
    @ApiResponses(value = {
            @ApiResponse(
                    code = RESPONSE_CODE_OK,
                    message = "Task by Id",
                    response = Task.class
                    , responseContainer = "List"
            ),
            @ApiResponse(code = 200, message = "Unexpected error", response = Task.class)}
    )

    public Response get(@ApiParam(value = "Visual identifier of a task in the product Line Planning", required = true) @PathParam("barcode") String barcode) throws AppException {

        return Response.status(Response.Status.OK).entity(taskService.get(barcode
        )).build();

    }


    @GET
    @Path("/workpackages/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tasks By Barcode WorkPackage",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "Task.findByWorkPackage"

    )
    public Response findByWorkPackage(@ApiParam(value = "Visual identifier of a WorkPackage in the product Line Planning", required = true) @PathParam("barcode") String barcode) throws AppException {


        return Response.status(Response.Status.OK).entity(taskService.findByWorkPackage(barcode)).build();

    }

    @GET
    @Path("/aircrafts/{tail}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tasks By aircraft",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List",
            nickname = "Task.findByAircraft"
    )
    public Response findByAircraft(@ApiParam(value = "Identifier for Tail", required = true) @PathParam("tail") String tail) throws AppException {


        return Response.status(Response.Status.OK).entity(taskService.findByAircraft(
                tail)).build();

    }


}

