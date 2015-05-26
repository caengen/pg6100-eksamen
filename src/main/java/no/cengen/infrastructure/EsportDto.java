package no.cengen.infrastructure;

import no.cengen.external.service.*;

import java.util.List;

public class EsportDto {
    private EsportService_Service service;
    private EsportService port;

    public EsportDto() {
        service = new EsportService_Service();
        port = service.getEsportServicePort();
    }

    public List<String> getGames() throws SOAPException_Exception {
        GameResponse response = port.getGames(AppConfig.CALLER_ID);
        return response.getGames().getGame();
    }

    public List<Team> getTeams(String game) throws SOAPException_Exception {
        TeamResponse response = port.getTeams(AppConfig.CALLER_ID, game);
        return response.getTeams().getTeam();
    }

    //TODO: test throws exception with invalid CALLER_ID - BOTH CASES
    //TODO: test NO TEAMS with invalid GAME - getTeams CASE
}
