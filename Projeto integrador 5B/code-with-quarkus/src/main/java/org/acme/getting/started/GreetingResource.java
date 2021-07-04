package org.acme.getting.started;

import org.acme.getting.business.CreateDataExamples;
import org.acme.getting.business.DayAmountBusiness;
import org.acme.getting.business.OrderDayBusiness;
import org.acme.getting.database.Order;
import org.acme.getting.model.DayAmount;
import org.acme.getting.model.DayOrder;
import org.acme.getting.model.GenericComunication;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/project_5b")
public class GreetingResource extends GenericComunication {

    @Inject
    CreateDataExamples orders;
    @Inject
    DayAmountBusiness dayAmountBusiness;
    @Inject
    OrderDayBusiness orderDayBusiness;

    @GET
    @Path("dayAmount")
    @Produces(MediaType.APPLICATION_JSON)
    public String dayAmount() {
        return gson.toJson(new DayAmount(dayAmountBusiness.getDayAmount()));
    }

    @GET
    @Path("dayOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public String dayOrder() {
        return gson.toJson(new DayOrder(orderDayBusiness.getDayOrder().intValue()));
    }


    @GET
    @Path("operatorPerform")
    @Produces(MediaType.APPLICATION_JSON)
    public String operatorPerform() {
        return gson.toJson("operatorPerform");
    }

    @GET
    @Path("createDatas")
    @Produces(MediaType.APPLICATION_JSON)
    public String createDatas() {
        orders.create();
        return gson.toJson("createDatas");
    }

}