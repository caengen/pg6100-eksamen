package no.cengen.service;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import no.cengen.infrastructure.EsportDto;
import no.cengen.soap.service.Team;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/teams", description = "Gets teams")
public class TeamService {
    @Inject
    private EsportDto esportDto;

    @GET
    @Path("game/{game}")
    @ApiOperation(value = "Gets the teams in the matching game", response = Team.class, responseContainer = "List")
    public Response getTeamsInGame(@PathParam("game") String game) {
        return Response.ok(esportDto.getTeams(game)).build();
    }

    @GET
    @ApiOperation(value = "Gets all registered teams", response = Team.class, responseContainer = "List")
    public Response getTeams() {
        return Response.ok(esportDto.getAllTeams()).build();
    }
}
