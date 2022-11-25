package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Package{

    @Id
    @NotEmpty
    private String hexCode;
    @ManyToOne
    @JoinColumn(name = "starting_point_id")
    @NotNull
    private Center startingPoint;
    @ManyToOne
    @JoinColumn(name = "delivery_point_id")
    @NotNull
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


