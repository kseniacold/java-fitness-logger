package com.cs56fitnessapp.models;

/**
 * @author Nerissa Hsieh
 * Date Created: 10/03/17
 * Date Modified: 10/03/17
 */

public class Meal implements DietFacts {
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
}
