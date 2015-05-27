package no.cengen.infrastructure;


import no.cengen.soap.service.*;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EsportDto {
    private final String CALLER_ID = "1EE3CE17-B958-5287-8E75-091887B470D3";
    private EsportService_Service service;
    private EsportService port;

    public EsportDto() {
        service = new EsportService_Service();
        port = service.getEsportServicePort();
    }

    public List<String> getGames() {
        GameResponse response = new GameResponse();
        try {
            response = port.getGames(CALLER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getGames().getGame();
    }

    public List<Team> getTeams(String game) {
        List<Team> teams = new ArrayList<>();
        try {
            TeamResponse response = port.getTeams(CALLER_ID, game);
            teams.addAll(response.getTeams().getTeam());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams;
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        getGames().forEach(game -> teams.addAll(getTeams(game)));
        return teams;
    }
}
