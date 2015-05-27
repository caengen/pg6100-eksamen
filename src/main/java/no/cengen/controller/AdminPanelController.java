package no.cengen.controller;

import no.cengen.entity.Result;
import no.cengen.TeamResult;
import no.cengen.infrastructure.EsportDto;
import no.cengen.infrastructure.ResultDao;
import no.cengen.soap.service.Team;
import no.cengen.util.TeamResultUtil;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model
public class AdminPanelController {

    @Inject
    private ResultDao resultDao;
    @Inject
    private EsportDto esportDto;
    @Inject
    private TeamResultUtil teamResultUtil;

    public List<String> getGames() {
        return esportDto.getGames();
    }

    public List<TeamResult> getTeams(String game) {
        List<Team> teams = esportDto.getTeams(game);
        List<Result> results = resultDao.findAll();
        List<TeamResult> teamResults = teamResultUtil.aggregate(teams, results);

        Collections.sort(teamResults);
        return teamResults;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml";
    }
}
