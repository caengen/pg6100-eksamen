package no.cengen.service;

import no.cengen.infrastructure.EsportDto;
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
public class GameService {

    @Inject
    private EsportDto esportDto;

    @GET
    public Response getAllGames() throws SOAPException_Exception {
        return Response.ok(esportDto.getGames()).build();
    }
}
