package com.cs56fitnessapp.models;

/**
 * @author Daniel Cervantes
 * Date created: 9/24/17
 * Last updated: 9/24/17
 */


import java.util.ArrayList;

public abstract class Workout implements ActivityFacts {
    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
        return 0;
    }

    ArrayList<String> exerciseList = new ArrayList<String>(){{

        add("\nBench Press\n");
        add("Bicep Curls\n");
        add("Shoulder Press\n");
        add("Lateral Raises\n");
        add("Tricep Extensions\n");
        add("Bent Over Rows\n");
        add("Sit Ups\n");
        add("Back Squats\n");
        add("Front Squats\n");
        add("Deadlift\n");
        add("Leg Press\n");
        add("Lunges\n");
        add("Kettle Bell Swings\n");
        add("Leg Lifts\n");

    }};

}
