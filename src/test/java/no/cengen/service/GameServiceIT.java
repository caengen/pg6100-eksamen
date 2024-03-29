package no.cengen.service;

import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static no.cengen.service.TestConstants.BASE_URL;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class GameServiceIT {

    @Test
    public void getAllGames() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/api/games").request().get();
        assertThat(HttpResponseCodes.SC_OK, is(equalTo(response.getStatus())));

        List<String> games = response.readEntity(new GenericType<List<String>>(){});
        assertThat(games.size(), is(not(0)));
    }
}