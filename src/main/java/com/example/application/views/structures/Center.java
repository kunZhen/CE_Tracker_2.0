package com.example.application.views.structures;

import java.util.Random;

public class Center {

    private String name;

    private boolean distributes;

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
