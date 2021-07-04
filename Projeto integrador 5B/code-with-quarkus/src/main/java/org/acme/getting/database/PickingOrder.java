package org.acme.getting.database;

import javax.persistence.*;

@Entity
@Table(name = "pickingorder")
public class PickingOrder extends GenericEntity{

    private String number;
    private int prio;
    private int state;
    private String destination;
    private String operator;
    private Order customerOrder;

    @Column(unique = true)
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public int getPrio() {
        return prio;
    }
    public void setPrio(int prio) {
        this.prio = prio;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @ManyToOne
    public Order getCustomerOrder() {
        return customerOrder;
    }
    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }
}
