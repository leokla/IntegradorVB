package org.acme.getting.business;

import org.acme.getting.database.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class OrderDayBusiness {

    @PersistenceContext
    EntityManager em;

    public Long getDayOrder(){

        String sql = "SELECT COUNT(o.id) FROM " + Order.class.getSimpleName() + " o ";
        Query query = em.createQuery(sql);

        return (Long) query.getSingleResult();
    }
}
