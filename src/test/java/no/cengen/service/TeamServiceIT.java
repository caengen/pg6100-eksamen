package no.cengen.service;

import no.cengen.soap.service.Team;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static no.cengen.service.TestConstants.BASE_URL;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TeamServiceIT {

    @Test
    public void getTeam() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/api/teams/game/Hearthstone").request().get();
        assertEquals(HttpResponseCodes.SC_OK, response.getStatus());

        List<Team> teams = response.readEntity(new GenericType<List<Team>>() {
        });
        assertTrue(teams.size() > 0);
    }

    public void getTeam_NoTeams() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/api/teams/game/asihflfa").request().get();
        assertEquals(HttpResponseCodes.SC_OK, response.getStatus());

        List<Team> teams = response.readEntity(new GenericType<List<Team>>() {
        });
        assertThat(teams.size(), is(0));
    }

    @Test
    public void getAllTeams() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/api/teams").request().get();
        assertEquals(HttpResponseCodes.SC_OK, response.getStatus());

        List<Team> teams = response.readEntity(new GenericType<List<Team>>() {
        });
        assertTrue(teams.size() > 0);
    }
}