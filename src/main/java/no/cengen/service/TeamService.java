package no.cengen.service;

import no.cengen.infrastructure.EsportDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamService {
    @Inject
    private EsportDto esportDto;

    @GET
    @Path("game/{game}")
    public Response getTeams(@PathParam("game") String game) {
        return Response.ok(esportDto.getTeams(game)).build();
    }
    //TODO: fix exception handlingen
    @GET
    public Response getAllTeams() {
        return Response.ok(esportDto.getAllTeams()).build();
    }
}
