package no.cengen.controller;

import no.cengen.TeamResult;
import no.cengen.infrastructure.EsportServiceBean;
import no.cengen.infrastructure.ResultDao;
import no.cengen.util.TeamResultUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdminPanelControllerTest {
    @Mock
    private ResultDao resultDao;
    @Mock
    private EsportServiceBean esportServiceBean;
    @Mock
    private TeamResultUtil teamResultUtil;
    @InjectMocks
    private AdminPanelController adminPanelController;

    @Before
    public void setUp() {
        when(adminPanelController.getGames()).thenReturn(new ArrayList<String>());
        when(adminPanelController.getTeamResults(anyString())).thenReturn(new ArrayList<TeamResult>());
    }

    @Test
    public void getGames() {
        adminPanelController.getGames();
        verify(esportServiceBean, times(1)).getGames();
    }

    @Test
    public void getTeamResults() {
        adminPanelController.getTeamResults("test");
        verify(esportServiceBean, times(2)).getTeams(anyString());
        verify(resultDao, times(2)).findAll();
        verify(teamResultUtil).aggregate(anyList(), anyList());
        verifyNoMoreInteractions(esportServiceBean, resultDao, teamResultUtil);
    }
}