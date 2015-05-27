package no.cengen.controller;

import no.cengen.TeamResult;
import no.cengen.entity.Result;
import no.cengen.infrastructure.EsportServiceManager;
import no.cengen.infrastructure.ResultDao;
import no.cengen.soap.service.Team;
import no.cengen.TeamResultAggregator;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model
public class ResultsController {
    @Inject
    private ResultDao resultDao;
    @Inject
    private EsportServiceManager manager;
    @Inject
    private TeamResultAggregator aggregator;

    public List<String> getGames() {
        return manager.getGames();
    }

    public List<TeamResult> getTeamResults(String game) {
        List<Team> teams = manager.getTeamsByGame(game);
        List<Result> results = resultDao.findAll();
        List<TeamResult> teamResults = aggregator.aggregate(teams, results);
        Collections.sort(teamResults);

        return teamResults;
    }
}
