package no.cengen.service;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import no.cengen.entity.Result;
import no.cengen.infrastructure.ResultDao;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/results", description = "Gets and creates game results")
public class ResultService {
    @Context
    private UriInfo uriInfo;
    @Inject
    private ResultDao resultDao;

    @GET
    @ApiOperation(value = "Get all registered results", response = Result.class, responseContainer = "List")
    public Response getAllResults() {
        return Response.ok(resultDao.findAll()).build();
    }

    @GET
    @Path("/id/{id}")
    @ApiOperation(value = "Gets the result with the matching id", response = Result.class)
    public Response getResult(@PathParam("id") int id) {
        return Response.ok(resultDao.findById(id)).build();
    }

    @GET
    @Path("/team/id/{teamId}")
    @ApiOperation(value = "Gets all registered results for the team with the matching id", response = Result.class, responseContainer = "List")
    public Response getResultByTeam(@PathParam("teamId") int teamId) {
        return Response.ok(resultDao.findAllByTeam(teamId)).build();
    }

    @POST
    @ApiOperation(value = "Add a new result")
    public Response createResult(@Valid Result result) {
        resultDao.persist(result);
        URI uri = uriInfo.getAbsolutePathBuilder().path("id/" + result.getId()).build();
        return Response.created(uri).build();
    }
}
