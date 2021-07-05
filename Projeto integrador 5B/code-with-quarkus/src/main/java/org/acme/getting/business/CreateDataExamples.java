package org.acme.getting.business;

import org.acme.getting.database.Order;
import org.acme.getting.database.PickingOrder;
import org.acme.getting.database.Position;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Transactional
@ApplicationScoped
public class CreateDataExamples {

    @PersistenceContext
    EntityManager em;

    public void create(){

        Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());

        Order o1 = new Order();
        o1.setCustomerName("Leo");
        o1.setDeliveryDate(new Date());
        o1.setExternalNumber("000000000001");
        o1.setNumber("ORDER000001");
        o1.setPrio(10);
        o1.setExternalId("0328947982754");
        o1.setState(600);
        o1.setLock(0);
        em.persist(o1);

        PickingOrder pickingOrder1 = new PickingOrder();
        pickingOrder1.setNumber("PICK000001");
        pickingOrder1.setPrio(100);
        pickingOrder1.setLock(0);
        pickingOrder1.setCustomerOrder(o1);
        pickingOrder1.setDestination("DS01");
        pickingOrder1.setOperator("op02");
        em.persist(pickingOrder1);

        Position positionPick01 = new Position();
        positionPick01.setLock(0);
        positionPick01.setState(600);
        positionPick01.setAmount(10.0);
        positionPick01.setItemData("WO120");
        positionPick01.setAmountPicked(10.0);
        positionPick01.setPickFromLocatioNname("A01-01-01-09");
        positionPick01.setPickingOrderNumber(pickingOrder1.getNumber());
        positionPick01.setPickingOrder(pickingOrder1);
        positionPick01.setFinished(new Date(c.getTimeInMillis()+45500));
        em.persist(positionPick01);


        Order o2 = new Order();
        o2.setCustomerName("Charles");
        o2.setDeliveryDate(new Date());
        o2.setExternalNumber("000000000002");
        o2.setNumber("ORDER000002");
        o2.setPrio(9);
        o2.setExternalId("0437564");
        o2.setState(600);
        o2.setLock(0);
        em.persist(o2);

        PickingOrder pickingOrder2 = new PickingOrder();
        pickingOrder2.setNumber("PICK000002");
        pickingOrder2.setPrio(100);
        pickingOrder2.setLock(0);
        pickingOrder2.setCustomerOrder(o2);
        pickingOrder2.setDestination("DS02");
        pickingOrder2.setOperator("op01");
        em.persist(pickingOrder2);

        Position positionPick02 = new Position();
        positionPick02.setLock(0);
        positionPick02.setState(600);
        positionPick02.setAmount(55.0);
        positionPick02.setItemData("AKX1040");
        positionPick02.setAmountPicked(55.0);
        positionPick02.setPickFromLocatioNname("A02-01-01-01");
        positionPick02.setPickingOrderNumber(pickingOrder2.getNumber());
        positionPick02.setPickingOrder(pickingOrder2);
        positionPick02.setFinished(new Date(c.getTimeInMillis()+100000));
        em.persist(positionPick02);


        Order o3 = new Order();
        o3.setCustomerName("Lucca");
        o3.setDeliveryDate(new Date());
        o3.setExternalNumber("000000000003");
        o3.setNumber("ORDER000003");
        o3.setPrio(10);
        o3.setExternalId("4576375476");
        o3.setState(600);
        o3.setLock(0);
        em.persist(o3);

        PickingOrder pickingOrder3 = new PickingOrder();
        pickingOrder3.setNumber("PICK000003");
        pickingOrder3.setPrio(100);
        pickingOrder3.setLock(0);
        pickingOrder3.setCustomerOrder(o3);
        pickingOrder3.setDestination("DS01");
        pickingOrder3.setOperator("op05");
        em.persist(pickingOrder3);

        Position positionPick03 = new Position();
        positionPick03.setLock(0);
        positionPick03.setState(600);
        positionPick03.setAmount(550.0);
        positionPick03.setItemData("WP130");
        positionPick03.setAmountPicked(550.0);
        positionPick03.setPickFromLocatioNname("A08-01-02-01");
        positionPick03.setPickingOrderNumber(pickingOrder3.getNumber());
        positionPick03.setPickingOrder(pickingOrder3);
        positionPick03.setFinished(new Date(c.getTimeInMillis()+22000));
        em.persist(positionPick03);



        Order o4 = new Order();
        o4.setCustomerName("Larissa");
        o4.setDeliveryDate(new Date());
        o4.setExternalNumber("000000000004");
        o4.setNumber("ORDER000004");
        o4.setPrio(10);
        o4.setExternalId("565438747");
        o4.setState(0);
        o4.setLock(0);
        em.persist(o4);

        PickingOrder pickingOrder4 = new PickingOrder();
        pickingOrder4.setNumber("PICK000004");
        pickingOrder4.setPrio(100);
        pickingOrder4.setLock(0);
        pickingOrder4.setCustomerOrder(o4);
        pickingOrder4.setDestination("DS03");
        pickingOrder4.setOperator("op04");
        em.persist(pickingOrder4);

        Position positionPick04 = new Position();
        positionPick04.setLock(0);
        positionPick04.setState(600);
        positionPick04.setAmount(100.0);
        positionPick04.setItemData("000004");
        positionPick04.setAmountPicked(100.0);
        positionPick04.setPickFromLocatioNname("A03-02-02-01");
        positionPick04.setPickingOrderNumber(pickingOrder4.getNumber());
        positionPick04.setPickingOrder(pickingOrder4);
        positionPick04.setFinished(new Date(c.getTimeInMillis() + 36000));
        em.persist(positionPick04);


    }
}
