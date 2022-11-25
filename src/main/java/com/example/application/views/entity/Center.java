package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Random;

/**
 * The Center Class is a JPA entity that represents a center
 */
@Entity
public class Center extends AbstractEntity{

    @NotEmpty
    private String name = "";

    @NotNull
    private boolean distributes;

    /**
     * It's a constructor whithout parameters
     */
    public Center() {
    }

    /**
     * It's a constructor that receives a name
     * @param name name of the center
     */
    public Center(String name){
        Random random = new Random();
        this.distributes = random.nextBoolean();

        this.name = name;
    }

    /**
     * Returns the name of the center
     * @return name of the center
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a true if the center distributes, otherwise returns false
     * @return true or false
     */
    public boolean isDistributes() {
        return distributes;
    }
}
