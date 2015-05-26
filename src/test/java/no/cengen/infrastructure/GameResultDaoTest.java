package no.cengen.infrastructure;

import no.cengen.entity.GameResult;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameResultDaoTest {

    @Rule
    public H2Setup h2Setup = new H2Setup();
    private GameResultDao gameResultDao;

    @Before
    public void setUp() throws Exception {
        gameResultDao = new GameResultDao();
        gameResultDao.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void testFindById() throws Exception {
        GameResult result = gameResultDao.findById(1);
        assertThat(result.getWinner(), is(equalTo(1)));
        assertThat(result.getLoser(), is(equalTo(2)));
    }

    @Test
    public void testFindAll() throws Exception {
        List<GameResult> results = gameResultDao.findAll();
        assertTrue(results.size() >= 7);
    }

    @Test
    public void testPersist() throws Exception {
        GameResult gameResult = new GameResult();
        gameResult.setWinner(1);
        gameResult.setLoser(2);
        gameResultDao.persist(gameResult);
        assertTrue(gameResult.getId() >= 100);
    }
}