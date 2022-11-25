package com.example.application.views.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Center{

    @Id
    private String name;

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
        return distributes;
    }
}
