package org.acme.getting.model;

public class DayAmount{

    private Double dayAmount = 0.0;

    public DayAmount(Double dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Double getDayAmount() { return dayAmount; }
    public void setDayAmount(Double dayAmount) { this.dayAmount = dayAmount; }
}

