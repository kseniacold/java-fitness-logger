package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 9/17/17
 * Last Updated: 10/1/17
 */

public interface DietFacts {

    // Calories consumed over an interval
    int getCaloriesIn();

    // Total fat consumed over an interval
    double getTotalFatIn();

    // Total carbohydrate consumed over an interval
    double getTotalCarbIn();

    // Total carbohydrate consumed over an interval
    double getProteinIn();

}
