package org.acme.getting.model;

import java.util.Date;

public class OperatorPerform {

    private String operatorName;
    private String pickingTime = null;
    private Double amountPicked = 0.0;

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPickingTime() {
        return pickingTime;
    }

    public void setPickingTime(String pickingTime) {
        this.pickingTime = pickingTime;
    }

    public Double getAmountPicked() {
        return amountPicked;
    }

    public void setAmountPicked(Double amountPicked) {
        this.amountPicked = amountPicked;
    }
}
