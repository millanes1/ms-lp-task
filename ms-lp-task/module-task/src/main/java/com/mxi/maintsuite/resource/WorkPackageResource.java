package com.mxi.maintsuite.resource;


import com.mxi.maintsuite.model.Tool;
import com.mxi.maintsuite.model.WorkPackage;
import com.mxi.maintsuite.services.WorkPackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/workpackages")
@Api(value = "/workpackages", description = "Get workpackage information", tags = "workpackages")
public class WorkPackageResource {


    @EJB
    private
    WorkPackageService workPackageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get the all WorkPacakage",
            notes = "Returns tool as list",
            response = WorkPackage.class,
            responseContainer = "List")
    public Response get() {
        return Response.status(Response.Status.OK).entity(workPackageService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get WorkPackage By Id",
            notes = "Returns WorkPackage as Object",
            response = Tool.class)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(workPackageService.get(id)).build();
    }

}
