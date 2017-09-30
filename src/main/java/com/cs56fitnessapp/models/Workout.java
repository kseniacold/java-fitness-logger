/*
* @author Daniel Cervantes
* Date created: 9/24/17
* Last updated: 9/27/17
 */


package com.cs56fitnessapp.models;

import java.util.ArrayList;

public abstract class Workout implements BurningCalories {

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
