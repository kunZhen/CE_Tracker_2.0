package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Entity
public class Center extends AbstractEntity{

    @NotEmpty
    private String name = "";

    @NotNull
    private boolean distributes;

    public Center() {
    }

    public Center(String name){
        Random random = new Random();
        this.distributes = random.nextBoolean();

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDistributes() {
        return true;
    }
}
