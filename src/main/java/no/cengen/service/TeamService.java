package no.cengen.service;

import no.cengen.infrastructure.EsportDto;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamService {
    @Inject
    private EsportDto esportDto;

    @GET
    public Response getAllTeams() {
        return Response.ok(esportDto.getAllTeams()).build();
    }
}
