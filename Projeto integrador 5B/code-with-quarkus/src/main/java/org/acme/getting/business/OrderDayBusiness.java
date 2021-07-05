package org.acme.getting.business;

import org.acme.getting.database.Order;
import org.acme.getting.model.DayOrder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class OrderDayBusiness {

    @PersistenceContext
    EntityManager em;

    public DayOrder getDayOrder(){

        DayOrder dayOrder = new DayOrder();
        String sql = "SELECT o FROM " + Order.class.getSimpleName() + " o ";
        Query query = em.createQuery(sql);

        List<Order> orders = query.getResultList();

        for(Order dayOrder1 : orders) {
            if (dayOrder1.getState() != 600)
                dayOrder.setDayOrderOpem(dayOrder.getDayOrderOpem() + 1);
            else
                dayOrder.setDayOrder(dayOrder.getDayOrder() + 1);
        }
        return dayOrder;


    }
}
