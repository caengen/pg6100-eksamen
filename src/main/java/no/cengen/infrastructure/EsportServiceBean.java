package no.cengen.infrastructure;


import no.cengen.soap.service.*;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EsportServiceBean {
    private final String CALLER_ID = "1EE3CE17-B958-5287-8E75-091887B470D3";
    private EsportService_Service service;
    private EsportService port;

    public EsportServiceBean() {
        service = new EsportService_Service();
        port = service.getEsportServicePort();
    }

    public List<String> getGames() {
        GameResponse response = getGameResponse();

        return response.getGames().getGame();
    }

    private GameResponse getGameResponse() {
        GameResponse response = new GameResponse();

        try {
            response = port.getGames(CALLER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        getGames().forEach(game -> teams.addAll(getTeams(game)));

        return teams;
    }

    public List<Team> getTeams(String game) {
        return getTeamResponse(game).getTeams().getTeam();
    }

    private TeamResponse getTeamResponse(String game) {
        TeamResponse response = new TeamResponse();

        try {
            response = port.getTeams(CALLER_ID, game);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
