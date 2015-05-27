package no.cengen.controller;

import no.cengen.TeamResult;
import no.cengen.infrastructure.EsportServiceManager;
import no.cengen.infrastructure.ResultDao;
import no.cengen.TeamResultAggregator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultsControllerTest {
    @Mock
    private ResultDao resultDao;
    @Mock
    private EsportServiceManager manager;
    @Mock
    private TeamResultAggregator teamResultAggregator;
    @InjectMocks
    private ResultsController resultsController;

    @Before
    public void setUp() {
        when(resultsController.getGames()).thenReturn(Arrays.asList("Hearthstone", "League of Legends"));

        List<TeamResult> teamResults = new ArrayList<>();
        teamResults.add(new TeamResult(1, 3, 1, "WinnerTeam"));
        teamResults.add(new TeamResult(2, 1, 3, "LoserTeam"));
        when(resultsController.getTeamResults(anyString())).thenReturn(teamResults);
    }

    @Test
    public void getGames() {
        List<String> games = resultsController.getGames();
        verify(manager, times(1)).getGames();
        assertThat(games.size(), is(2));
    }

    @Test
    public void getTeamResults() {
        List<TeamResult> teamResults = resultsController.getTeamResults("test");
        verify(manager, times(2)).getTeamsByGame(anyString());
        verify(resultDao, times(2)).findAll();
        verify(teamResultAggregator).aggregate(anyList(), anyList());
        verifyNoMoreInteractions(manager, resultDao, teamResultAggregator);
        assertThat(teamResults.size(), is(2));
    }
}