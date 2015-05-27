package no.cengen.infrastructure;

import no.cengen.soap.service.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class EsportServiceManagerIT {
    private EsportServiceManager manager;

    @Before
    public void setUp() {
        manager = new EsportServiceManager();
    }

    @Test
    public void getGames() {
        List<String> games = manager.getGames();
        assertTrue(games.size() > 0);
    }

    @Test
    public void getTeams() {
        String game = manager.getGames().get(0);
        List<Team> teams = manager.getTeams(game);
        assertTrue(teams.size() > 0);
        teams.forEach(team -> assertThat(team.getId(), is(not(0))));
    }

    @Test
    public void getAllTeams() {
        List<Team> teams = manager.getAllTeams();
        assertTrue(teams.size() > 0);
        teams.forEach(team -> assertThat(team.getId(), is(not(0))));
    }
}