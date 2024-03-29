package no.cengen.service;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import no.cengen.infrastructure.EsportServiceManager;
import no.cengen.soap.service.SOAPException_Exception;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/games", description = "Gets games")
public class GameService {
    @Inject
    private EsportServiceManager manager;

    @GET
    @ApiOperation(value = "Get all registered games", response = String.class, responseContainer = "List")
    public Response getGames() throws SOAPException_Exception {
        return Response.ok(manager.getGames()).build();
    }
}
