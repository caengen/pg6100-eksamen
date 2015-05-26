package no.cengen.service;

import no.cengen.soap.service.Team;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeamServiceIT {

    @Test
    public void testGetAllTeams() throws Exception {
        Response response = ClientBuilder.newClient().target(TestConstants.BASE_URL + "/teams").request().get();
        assertEquals(HttpResponseCodes.SC_OK, response.getStatus());

        List<Team> teams = response.readEntity(new GenericType<List<Team>>() {});
        assertTrue(teams.size() > 0);
    }
}