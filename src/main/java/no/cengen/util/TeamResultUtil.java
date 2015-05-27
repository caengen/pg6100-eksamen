package no.cengen.util;

import no.cengen.entity.Result;
import no.cengen.TeamResult;
import no.cengen.soap.service.Team;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TeamResultUtil {
    public List<TeamResult> aggregate(List<Team> teams, List<Result> results) {
        List<TeamResult> teamResults = new ArrayList<>();
        for (Team t : teams) {
            int wins = countWins(results, t);
            int losses = countLosses(results, t);
            TeamResult teamResult = new TeamResult(t.getId(), wins, losses, t.getName());
            teamResults.add(teamResult);
        }

        return teamResults;
    }

    private int countLosses(List<Result> results, Team t) {
        return (int) results.stream().filter(r -> r.getLoser() == t.getId()).count();
    }

    private int countWins(List<Result> results, Team t) {
        return (int) results.stream().filter(r -> r.getWinner() == t.getId()).count();
    }
}
