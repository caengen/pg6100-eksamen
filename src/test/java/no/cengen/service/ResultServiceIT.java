package no.cengen.service;

import no.cengen.entity.Result;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static no.cengen.service.TestConstants.BASE_URL;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ResultServiceIT {

    @Test
    public void getAllResults() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/results").request().get();
        assertThat(HttpResponseCodes.SC_OK, is(equalTo(response.getStatus())));

        List<Result> results = response.readEntity(new GenericType<List<Result>>(){});
        assertTrue(results.size() >= 7);
    }

    @Test
    public void getResult() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/results/id/1").request().get();
        assertThat(HttpResponseCodes.SC_OK, is(equalTo(response.getStatus())));

        Result result = response.readEntity(Result.class);
        assertThat(result.getWinner(), is(1));
        assertThat(result.getLoser(), is(2));
    }

    @Test
    public void getResultByTeam() throws Exception {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/results/team/2").request().get();
        assertThat(HttpResponseCodes.SC_OK, is(equalTo(response.getStatus())));

        List<Result> results = response.readEntity(new GenericType<List<Result>>(){});
        assertTrue(results.size() >= 4);
    }

    @Test
    public void createResult() throws Exception {
        Result result = new Result();
        result.setLoser(5);
        result.setWinner(3);
        Response response = ClientBuilder.newClient().target(BASE_URL + "/results").request()
                .post(Entity.entity(result, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(HttpResponseCodes.SC_CREATED, response.getStatus());
    }
}