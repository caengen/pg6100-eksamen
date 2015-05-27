package no.cengen.infrastructure;

import no.cengen.entity.Result;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ResultDao {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Result findById(int id) {
        return em.find(Result.class, id);
    }

    public List<Result> findAll() {
        TypedQuery<Result> query = em.createNamedQuery("Result.findAll", Result.class);

        return query.getResultList();
    }

    public List<Result> findAllByTeam(int id) {
        TypedQuery<Result> query = em.createNamedQuery("Result.findAllByTeam", Result.class)
                .setParameter("teamId", id);

        return query.getResultList();
    }

    public void persist(Result result) {
        em.persist(result);
    }
}
