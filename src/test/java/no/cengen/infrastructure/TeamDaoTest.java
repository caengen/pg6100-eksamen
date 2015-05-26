package no.cengen.infrastructure;

import no.cengen.entity.Team;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class TeamDaoTest {
    @Rule
    public H2Setup h2Setup = new H2Setup();
    private TeamDao teamDao;

    @Before
    public void setUp() {
        teamDao = new TeamDao();
        teamDao.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void persist() {
        Team team = new Team();
        team.setId(1);
        teamDao.persist(team);
        assertNotNull(teamDao.findById(1));
    }
}