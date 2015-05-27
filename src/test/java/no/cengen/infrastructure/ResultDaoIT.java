package no.cengen.infrastructure;

import no.cengen.entity.Result;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ResultDaoIT {

    @Rule
    public H2Setup h2Setup = new H2Setup();
    private ResultDao resultDao;

    @Before
    public void setUp() throws Exception {
        resultDao = new ResultDao();
        resultDao.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void findById() throws Exception {
        Result result = resultDao.findById(1);
        assertThat(result.getWinner(), is(equalTo(9)));
        assertThat(result.getLoser(), is(equalTo(10)));
    }

    @Test
    public void findAll() throws Exception {
        List<Result> results = resultDao.findAll();
        assertTrue(results.size() >= 11);
    }

    @Test
    public void findAllByTeam() {
        List<Result> results = resultDao.findAllByTeam(9);
        assertTrue(results.size() >= 2);
    }

    @Test
    public void persist() throws Exception {
        Result result = new Result();
        result.setWinner(1);
        result.setLoser(2);
        resultDao.persist(result);
        assertTrue(result.getId() >= 100);
    }
}