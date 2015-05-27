package no.cengen.entity;

import no.cengen.TeamResult;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TeamResultTest {

    private TeamResult teamResult;

    @Before
    public void setUp() {
        teamResult = new TeamResult(15, 4, 3, "D1n3r5 C1uB");
    }

    @Test
    public void getName() {
        assertThat(teamResult.getName(), is(equalTo("D1n3r5 C1uB")));
    }

    @Test
    public void setName() {
        teamResult.setName("new test name");
        assertThat(teamResult.getName(), is(equalTo("new test name")));
    }

    @Test
    public void getMatches() {
        assertThat(teamResult.getMatches(), is(equalTo(teamResult.getWins() + teamResult.getLosses())));
    }

    @Test
    public void getWins() {
        assertThat(teamResult.getWins(), is(4));
    }

    @Test
    public void setWins() {
        teamResult.setWins(0);
        assertThat(teamResult.getWins(), is(0));
    }

    @Test
    public void getLosses() {
        assertThat(teamResult.getLosses(), is(3));
    }

    @Test
    public void setLosses() {
        teamResult.setLosses(0);
        assertThat(teamResult.getLosses(), is(0));
    }

    @Test
    public void getId() {
        assertThat(teamResult.getId(), is(15));
    }

    @Test
    public void setId() {
        teamResult.setId(1);
        assertThat(teamResult.getId(), is(1));
    }

    @Test
    public void compareTo() {
        TeamResult other = new TeamResult(16, 2, 7, "Ownrimmar");
        int comparison = teamResult.compareTo(other);
        assertTrue(comparison < 0);
    }
}