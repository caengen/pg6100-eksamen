package no.cengen.controller;

import no.cengen.entity.Result;
import no.cengen.infrastructure.EsportDto;
import no.cengen.infrastructure.ResultDao;
import no.cengen.soap.service.Team;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@Model
public class AdminPanelController {

    @Inject
    private ResultDao resultDao;
    @Inject
    private EsportDto esportDto;

    public List<Team> getTeams() {
        return esportDto.getAllTeams();
    }

    public List<Result> getResults() {
        return resultDao.findAll();
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml";
    }
}
