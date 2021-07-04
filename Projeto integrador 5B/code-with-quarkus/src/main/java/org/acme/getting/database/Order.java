package org.acme.getting.database;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customerorder")
public class Order extends GenericEntity {

    private String customerName;
    private Date deliveryDate;
    private String externalId;
    private String externalNumber;
    private String number;
    private int prio;
    private int state;

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalNumber() {
        return externalNumber;
    }
    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    @Column(unique=true)
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
}
