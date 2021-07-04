package org.acme.getting.business;

import org.acme.getting.database.Position;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class DayAmountBusiness {

    @PersistenceContext
    EntityManager em;

    public Double getDayAmount(){

        String sql = "SELECT SUM(p.amountPicked) FROM " + Position.class.getSimpleName() + " p ";
        Query query = em.createQuery(sql);

        return (Double) query.getSingleResult();

    }
}
