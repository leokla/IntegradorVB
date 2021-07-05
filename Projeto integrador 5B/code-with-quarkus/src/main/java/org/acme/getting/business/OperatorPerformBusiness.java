package org.acme.getting.business;

import org.acme.getting.database.Position;
import org.acme.getting.model.OperatorPerform;
import org.acme.getting.response.OperatorPerformResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@ApplicationScoped
public class OperatorPerformBusiness {

    @PersistenceContext
    EntityManager em;

    public List<OperatorPerform> getPerform(){

        Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        //OperatorPerformResponse response = new OperatorPerformResponse();
        List<OperatorPerform> operatorPerformList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

        String sql = "SELECT pos FROM " + Position.class.getSimpleName() + " pos ";
        Query query = em.createQuery(sql);

        List<Position> list = query.getResultList();

        Map<String, OperatorPerform> stringOperatorPerformMap = new HashMap<>();
        list.forEach(pos -> {
            OperatorPerform operatorPerform = null;
            operatorPerform = stringOperatorPerformMap.get(pos.getPickingOrder().getOperator());
            if(operatorPerform == null){
                operatorPerform = new OperatorPerform();
                operatorPerform.setOperatorName(pos.getPickingOrder().getOperator());
            }
            if(operatorPerform.getPickingTime() == null) {
                operatorPerform.setPickingTime(simpleDateFormat.format(new Date(pos.getFinished().getTime() - pos.getCreated().getTime())));
            }

            operatorPerform.setAmountPicked(operatorPerform.getAmountPicked() + pos.getAmountPicked());
            stringOperatorPerformMap.put(pos.getPickingOrder().getOperator(), operatorPerform);

        });

        operatorPerformList.addAll(stringOperatorPerformMap.values());
        return operatorPerformList;
    }

}
