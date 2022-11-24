package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Package extends AbstractEntity{
    @NotEmpty
    private String hexCode;
    @NotEmpty
    private Center startingPoint;
    @NotEmpty
    private Center deliveryPoint;
    @NotEmpty
    private Integer waitingTime;

    /*public Package(String hexCode, String startingPoint, String deliveryPoint) {
        this.hexCode = hexCode;
        this.startingPoint = startingPoint;
        this.deliveryPoint = deliveryPoint;
        this.waitingTime = null;
    }*/

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public Center getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Center startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Center getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(Center deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }
}


