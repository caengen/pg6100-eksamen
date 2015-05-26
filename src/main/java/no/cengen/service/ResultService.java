package no.cengen.service;

import no.cengen.entity.Result;
import no.cengen.infrastructure.ResultDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResultService {
    @Context
    private UriInfo uriInfo;
    @Inject
    private ResultDao resultDao;

    @GET
    public Response getAllResults() {
        return Response.ok(resultDao.findAll()).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getResult(@PathParam("id") int id) {
        return Response.ok(resultDao.findById(id)).build();
    }

    @GET
    @Path("/team/{teamId}")
    public Response getResultByTeam(@PathParam("teamId") int teamId) {
        return Response.ok(resultDao.findAllByTeam(teamId)).build();
    }

    @POST
    public Response createResult(Result result) {
        resultDao.persist(result);
        URI uri = uriInfo.getAbsolutePathBuilder().path("id/" + result.getId()).build();
        return Response.created(uri).build();
    }
}
