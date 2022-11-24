package com.example.application.views.entity;

import javax.validation.constraints.NotEmpty;

public class Package {
    @NotEmpty
    private String hexCode;
    @NotEmpty
    private String startingPoint;
    @NotEmpty
    private String deliveryPoint;
    @NotEmpty
    private Integer waitingTime;

    public Package(String hexCode, String startingPoint, String deliveryPoint) {
        this.hexCode = hexCode;
        this.startingPoint = startingPoint;
        this.deliveryPoint = deliveryPoint;
        this.waitingTime = null;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }
}


