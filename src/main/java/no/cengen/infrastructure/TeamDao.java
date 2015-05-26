package no.cengen.infrastructure;

import no.cengen.entity.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamDao {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Team findById(int id) {
        return em.find(Team.class, id);
    }

    public void persist(Team team) {
        em.persist(team);
    }
}
