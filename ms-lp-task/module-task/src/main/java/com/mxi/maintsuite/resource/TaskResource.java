package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.WorkPackage;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.persistence.TaskDAO;
import com.mxi.maintsuite.persistence.WorkPackageDAO;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/tasks")
@Api(value = "/tasks", description = "Get tasks information")
@Produces({"application/json", "application/xml"})
public class TaskResource {

    @Inject
    PersistenceHelper helper;

    @Inject
    TaskDAO taskDAO;

    @Inject
    WorkPackageDAO workPackageDAO;

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
            responseContainer = "List")
    public Response get() {

        final List<Task> taskList = taskDAO.findAll();
        for (Task item : taskList) {
            item.setWorkPackage(this.find(item.getWorkPackageId()));
        }
        return Response.status(Response.Status.OK).entity(taskList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Task By Id",
            notes = "Returns task as Object",
            response = Task.class)
    @ApiResponses(
            @ApiResponse(
                    code = RESPONSE_CODE_OK,
                    message = "Task by Id",
                    response = Task.class))

    public Response get(@ApiParam(value = "Identificator Task", required = true) @PathParam("id") int id) {
        final Task task = helper.getEntityManager().createNamedQuery("Task.getById", Task.class).setParameter("id", id).getSingleResult();

        task.setWorkPackage(this.find(task.getWorkPackageId()));

        return Response.status(Response.Status.OK).entity(task).build();

    }


    @GET
    @Path("/workpackage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Find Tasks By WorkPacakage Id",
            notes = "Returns task as list",
            response = Task.class,
            responseContainer = "List"
    )
    public Response findByWorkPackageId(@ApiParam(value = "Identificator WorkPackage", required = true) @PathParam("id") int id) {
        final List<Task> taskList = taskDAO.findByWorkPackage(id);
        for (Task item : taskList) {
            item.setWorkPackage(this.find(item.getWorkPackageId()));
        }

        return Response.status(Response.Status.OK).entity(taskList).build();

    }


    private WorkPackage find(Integer workPackageId) {
        return (workPackageDAO.get(workPackageId));

    }

}

