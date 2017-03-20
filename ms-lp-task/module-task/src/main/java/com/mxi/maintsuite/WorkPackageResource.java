package com.mxi.maintsuite;


import com.mxi.maintsuite.model.Tool;
import com.mxi.maintsuite.model.WorkPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/workpackages")
@Api(value = "/workpackages", description = "Get workpackage information", tags = "workpackages")
public class WorkPackageResource {

    @Inject
    PersistenceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all WorkPacakage",
            notes = "Returns tool as list",
            response = WorkPackage.class,
            responseContainer = "List")
    public Response get() {
        final List<WorkPackage> workPackageList = helper.getEntityManager().createNamedQuery("WorkPackage.findAll", WorkPackage.class).getResultList();
        return Response.status(Response.Status.OK).entity(workPackageList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get WorkPackage By Id",
            notes = "Returns WorkPackage as Object",
            response = Tool.class)
    public Response get(@PathParam("id") int id) {
        final WorkPackage workPackage = helper.getEntityManager().createNamedQuery("WorkPackage.getById", WorkPackage.class).setParameter("id", id).getSingleResult();
        return Response.status(Response.Status.OK).entity(workPackage).build();
    }

}
