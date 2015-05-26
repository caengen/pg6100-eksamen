package no.cengen.infrastructure;

import no.cengen.soap.service.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class EsportDtoTest {
    private EsportDto esportDto;

    @Before
    public void setUp() throws Exception {
        esportDto = new EsportDto();
    }

    @Test
    public void testGetGames() throws Exception {
        List<String> games = esportDto.getGames();
        assertTrue(games.size() > 0);
    }

    @Test
    public void testGetTeams() throws Exception {
        String game = esportDto.getGames().get(0);
        List<Team> teams = esportDto.getTeams(game);
        assertTrue(teams.size() > 0);
        for (Team team : teams) {
            assertThat(team.getId(), is(not(0)));
        }
    }
}