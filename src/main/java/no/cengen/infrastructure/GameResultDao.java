package no.cengen.infrastructure;

import no.cengen.entity.GameResult;
import no.cengen.service.GameService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GameResultDao {
    private EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public GameResult findById(int id) {
        return em.find(GameResult.class, id);
    }

    public List<GameResult> findAll() {
        TypedQuery<GameResult> query = em.createNamedQuery("GameResult.findAll", GameResult.class);
        return query.getResultList();
    }

    public void persist(GameResult result) {
        em.persist(result);
    }
}
