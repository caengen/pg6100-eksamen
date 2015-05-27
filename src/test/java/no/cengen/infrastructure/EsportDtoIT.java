package no.cengen.infrastructure;

import no.cengen.soap.service.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class EsportDtoIT {
    private EsportServiceBean esportServiceBean;

    @Before
    public void setUp() {
        esportServiceBean = new EsportServiceBean();
    }

    @Test
    public void getGames() {
        List<String> games = esportServiceBean.getGames();
        assertTrue(games.size() > 0);
    }

    @Test
    public void getTeams() {
        String game = esportServiceBean.getGames().get(0);
        List<Team> teams = esportServiceBean.getTeams(game);
        assertTrue(teams.size() > 0);
        teams.forEach(team -> assertThat(team.getId(), is(not(0))));
    }

    @Test
    public void invalidGame_getTeams() {
        List<Team> teams = esportServiceBean.getTeams("Test15325");
        assertThat(teams.size(), is(0));
    }

    @Test
    public void getAllTeams() {
        List<Team> teams = esportServiceBean.getAllTeams();
        assertTrue(teams.size() > 0);
        teams.forEach(team -> assertThat(team.getId(), is(not(0))));
    }
}