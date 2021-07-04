package org.acme.getting.database;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pickingpos")
public class Position extends GenericEntity{

    private Double amount;
    private Double amountPicked;
    private String pickFromLocatioNname;
    private String pickingOrderNumber;
    private int state;
    private String itemData;
    private String lot;

    private PickingOrder pickingOrder;


    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountPicked() {
        return amountPicked;
    }
    public void setAmountPicked(Double amountPicked) {
        this.amountPicked = amountPicked;
    }

    public String getPickFromLocatioNname() {
        return pickFromLocatioNname;
    }

    public void setPickFromLocatioNname(String pickFromLocatioNname) {
        this.pickFromLocatioNname = pickFromLocatioNname;
    }
    public String getPickingOrderNumber() {
        return pickingOrderNumber;
    }

    public void setPickingOrderNumber(String pickingOrderNumber) {
        this.pickingOrderNumber = pickingOrderNumber;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }

    public String getItemData() {
        return itemData;
    }
    public void setItemData(String itemData) {
        this.itemData = itemData;
    }

    public String getLot() {
        return lot;
    }
    public void setLot(String lot) {
        this.lot = lot;
    }

    @ManyToOne
    public PickingOrder getPickingOrder() {
        return pickingOrder;
    }
    public void setPickingOrder(PickingOrder pickingOrder) {
        this.pickingOrder = pickingOrder;
    }
}
