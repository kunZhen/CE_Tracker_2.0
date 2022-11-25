package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * The Package class represents each of the packages that are send by the user
 */
public class Package extends AbstractEntity{
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

    /**
     * It's a constructor for the package
     * @param hexCode hexadecimal code of the package
     * @param startingPoint center starting Point
     * @param deliveryPoint center delivery Point
     */
    public Package(String hexCode, Center startingPoint, Center deliveryPoint) {
        this.hexCode = hexCode;
        this.startingPoint = startingPoint;
        this.deliveryPoint = deliveryPoint;
        this.waitingTime = null;
    }

    /**
     * Gets the hexadecimal code of the package
     * @return hexadecimal code
     */


    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    /**
     * Gets startingPoint of the package
     * @return startingPoint
     */
    public Center getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Center startingPoint) {
        this.startingPoint = startingPoint;
    }

    /**
     * Gets DeliveryPoint of the package
     * @return DeliveryPoint
     * */
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


