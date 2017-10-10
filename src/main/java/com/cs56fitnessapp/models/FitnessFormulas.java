package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/9/17
 * Last Updated: 10/9/17
 */


public class FitnessFormulas {

    public static final int CALORIES_PER_POUND = 3500;
    public  static final int DAYS_IN_A_WEEK = 7;

    public FitnessFormulas() {
    }

    /**
     * Calculating Basal Metabolic Rate based on Harris-Benedict Formula
     * Metric units
     * Women: BMR = 655.09 + (9.56 x weight in kg) + (1.84 x height in cm) - (4.67 x age in years)
     * Men: BMR = 66.47 + (13.75 x weight in kg) + (5 x height in cm) - (6.45 x age in years)
     *
     * Activity level multipliers:
     * Sedentary (little or no exercise): BMR x 1.2
     * Lightly active (light exercise/sports 1-3 days/week) BMR x 1.375
     * Moderately active (moderate exercise/sports 3-5 days/week): BMR x 1.55
     * Very active (hard exercise/sports 6-7 days a week): BMR x 1.725
     *
     * @param gender user's gender
     * @param weight user's weight
     * @param height user's height
     * @param age user's age
     * @return Basal Metabolic Rate - calories spent at rest during the day
     */
    public static double basalMetabolicRate(Gender gender, ActivityLevel activityLevel, double weight, double height, int age) {
        double BMR;

        // calculations for female users
        if (gender.equals(Gender.FEMALE)) {
            BMR = 665.09 + (9.56 * weight) + (1.84 + height) - (4.67 * age);
        } else {
            BMR = 66.47 + (13.75 * weight) + (5.0 * height) - (6.45 * age);
        }

        // adjust calculations based on the activity level
        switch (activityLevel) {
            case SEDENTARY:
                BMR *= 1.2;
                break;
            case SOMEWHAT_ACTIVE:
                BMR *= 1.375;
                break;
            case ACTIVE:
                BMR *= 1.55;
                break;
            case VERY_ACTIVE:
                BMR *= 1.725;
                break;
        }

        return BMR;
    }

    /**
     *
     * @return calorie offset(deficit or proficit depending on the goal)
     * based on how many pounds user wants to gain or lose
     */
    public static int calorieOffset(int progressPace) {
        return Math.round((progressPace * CALORIES_PER_POUND) / DAYS_IN_A_WEEK);
    }

}
