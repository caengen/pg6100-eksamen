package no.cengen.util;

import no.cengen.TeamResultAggregator;
import no.cengen.entity.Result;
import no.cengen.TeamResult;
import no.cengen.soap.service.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TeamResultAggregatorTest {
    TeamResultAggregator aggregator;

    private List<Result> results;
    private List<Team> teams;

    @Before
    public void setUp() {
        aggregator = new TeamResultAggregator();
        results = new ArrayList<>();
        results.add(new Result(1, 2));
        results.add(new Result(1, 2));
        results.add(new Result(2, 1));
        teams = new ArrayList<>();
        Team team1 = new Team();
        team1.setId(1);
        team1.setName("Team 1");
        Team team2 = new Team();
        team2.setId(2);
        team2.setName("Team 2");
        teams.add(team1);
        teams.add(team2);
    }

    @Test
    public void aggregateTeamResults() {
        List<TeamResult> teamResults = aggregator.aggregate(teams, results);
        assertThat(teamResults.size(), is(2));

        Collections.sort(teamResults);
        TeamResult teamResult1 = teamResults.get(0);
        TeamResult teamResult2 = teamResults.get(1);

        assertThat(teamResult1.getId(), is(1));
        assertThat(teamResult1.getWins(), is(2));
        assertThat(teamResult1.getLosses(), is(1));
        assertThat(teamResult1.getMatches(), is(3));
        assertThat(teamResult1.getName(), is(equalTo("Team 1")));

        assertThat(teamResult2.getId(), is(2));
        assertThat(teamResult2.getWins(), is(1));
        assertThat(teamResult2.getLosses(), is(2));
        assertThat(teamResult2.getMatches(), is(3));
        assertThat(teamResult2.getName(), is(equalTo("Team 2")));
    }
}