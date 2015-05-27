package no.cengen.infrastructure;


import no.cengen.soap.service.*;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EsportServiceManager {
    private final String CALLER_ID = "1EE3CE17-B958-5287-8E75-091887B470D3";
    private EsportService_Service service;
    private EsportService port;

    public EsportServiceManager() {
        service = new EsportService_Service();
        port = service.getEsportServicePort();
    }

    public List<String> getGames() {
        List<String> games = new ArrayList<>();

        GameResponse response = getGameResponse();
        if (response != null) {
            games.addAll(response.getGames().getGame());
        }

        return games;
    }

    private GameResponse getGameResponse() {
        GameResponse response = null;

        try {
            response = port.getGames(CALLER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();

        getGames().forEach(game -> teams.addAll(getTeamsByGame(game)));

        return teams;
    }

    public List<Team> getTeamsByGame(String game) {
        List<Team> teams = new ArrayList<>();

        TeamResponse response = getTeamResponse(game);
        if (response != null)
            teams.addAll(response.getTeams().getTeam());

        return teams;
    }

    private TeamResponse getTeamResponse(String game) {
        TeamResponse response = null;

        try {
            response = port.getTeams(CALLER_ID, game);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
