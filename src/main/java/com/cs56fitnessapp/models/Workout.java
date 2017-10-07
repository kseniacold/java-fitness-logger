package com.cs56fitnessapp.models;

/**
 * @author Daniel Cervantes
 * Date created: 9/24/17
 * Last updated: 10/6/17
 */

import java.util.Date;

public abstract class Workout implements ActivityFacts {

    private User user;
    private Date localDate;
    private int warmUpTime;
    private int coolDownTime;

    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
        return 0;
    }


}
