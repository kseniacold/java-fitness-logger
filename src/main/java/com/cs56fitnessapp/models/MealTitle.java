package com.cs56fitnessapp.models;

/**
 * @Author jimweezy
 * Created: 10/24/17
 * Last changes: 10/24/17 at 5:37 AM
 **/
public enum MealTitle {
    QUICK_MEAL("Quick Meal"), BREAKFAST("Breakfast"), LUNCH("Backstroke"), DINNER("Dinner"), DESSERT("Dessert");

    // String representation
    private String stringValue;
   MealTitle(String stringValue) {
        this.stringValue = stringValue;
    }
    public String getStringValue() {
        return stringValue;
    }

}
