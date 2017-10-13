package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 9/17/17
 * Last Updated: 10/1/17
 */

public class Day implements ActivityFacts, DietFacts {


    /* ActivityFacts Interface */
    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTimeMins() {
        return 0;
    }

    /* DietFacts Interface */
    @Override
    public int getCaloriesIn() {
        return 0;
    }

    @Override
    public TotalFat getTotalFatIn() {
        return null;
    }

    @Override
    public TotalCarb getTotalCarbIn() {
        return null;
    }

    @Override
    public double getProteinIn() {
        return 0;
    }

    public static void main(String [] args) {
        System.out.println("Hello");
    }
}
