package com.cs56fitnessapp.models;

import com.cs56fitnessapp.models.ActivityLevel;
import com.cs56fitnessapp.models.Gender;

/**
 * @author Ksenia Koldaeva
 * Created: 10/9/17
 * Last Updated: 10/11/17
 */


public class FitnessFormulas {

    public static final int CALORIES_PER_POUND = 3500;
    public static  final int CALORIES_PER_KG = 7700;
    public  static final int DAYS_IN_A_WEEK = 7;
    public  static final int MINS_IN_AN_HOUR = 60;

    /**
     * respiratoryExchangeRatio is 5.0 for blood sugars, but drops to 4.86 for freeing energy from fat,
     * will be using 4.86 assuming that running is more than few minutes
     */
    public static final double RESPIRATORY_EXCHANGE_RATIO_RUNNING_CALS_FROM_FAT = 4.86;

    /** MET (Metabolic Equivalent of Task) values for endurance sports */

    /** RUNNING */
    // average estimate for training based on MET for running at (9 min/mile)
    public static final double MET_RUNNING_TRAINING = 10.5;
    public static final double MET_RUNNING_GENERAL = 7.0;

    /** CYCLING */
    // based on bicycling, mountain, uphill, vigorous effort
    public static final double MET_CYCLING_MOUNTAIN = 14.0;

    // based on bicycling, 10-11.9 mph, leisure, slow, light effort
    public static final double MET_CYCLING_LEISURE = 6.8;

    // based on bicycling, 16-19 mph, racing/not drafting or > 19 mph drafting, very fast, racing general
    public static final double MET_CYCLING_RACING = 12.0;

    /** SWIMMING */
    public static final double MET_SWIMMING_CRAWL_FAST = 10.0;
    public static final double MET_SWIMMING_CRAWL_MEDIUM = 8.3;

    // value MET_SWIMMING_CRAWL_TRAINING is the average of MET_SWIMMING_CRAWL_FAST and MET_SWIMMING_CRAWL_MEDIUM
    public static final double MET_SWIMMING_CRAWL_TRAINING = 8.3;

    // based on swimming laps, freestyle, front crawl, slow, light or moderate effort
    public static final double MET_SWIMMING_CRAWL_RECREATIONAL = 5.8;

    public static final double MET_SWIMMING_BREASTSTROKE_TRAINING = 10.3;
    public static final double MET_SWIMMING_BREASTSTROKE_RECREATIONAL = 6.3;

    public static final double MET_SWIMMING_BACKSTROKE_TRAINING = 9.5;
    public static final double MET_SWIMMING_BACKSTROKE_RECREATIONAL = 6.3;

    public static final double MET_SWIMMING_BUTTERFLY_GENERAL = 13.8;

    // MET_SWIMMING_MIXED_TRAINING is an average of strokes training values
    public static final double MET_SWIMMING_MIXED_TRAINING = 10.5;
    public static final double MET_SWIMMING_MIXED_RECREATIONAL = 6.0;



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
            BMR = 655.09 + (9.56 * weight) + (1.84 * height) - (4.67 * age);
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
     * @return calorie offset(deficit or proficit depending on the goal)
     * based on how many kilograms user wants to gain or lose
     */
    public static int calorieOffset(double weeklyGoalKg) {
        return (int)Math.round((weeklyGoalKg * CALORIES_PER_KG) / DAYS_IN_A_WEEK);
    }

    /**
     * Using MET (Metabolic Equivalent of Task) constant and the formula
     * Kcal ~= METS * bodyMassKg * timePerformingHours
     * to calculate caloric value of activity
     * @param MET_value Metabolic Equivalent of Task
     * @param bodyMassKg user's weight
     * @param timePerformingHours time of the workout in hrs
     * @return caloric value of activity using MET constant
     */
    public static int caloriesOutByMET(double MET_value, double bodyMassKg, double timePerformingHours) {
        return (int)Math.round(MET_value * bodyMassKg * timePerformingHours);
    }


    /**
     * Using the following equation to calculate Kcal/Min
     * Kcal/Min ~= respiratoryExchangeRatio * massKg * VO2 / 1000
     * Using the Léger equation to calculate VO2
     * V̇O2 = 2.209 + 3.1633 * kph
     * @param bodyMassKg user's weight
     * @param distanceKm distance of the workout in km
     * @param timePerformingHours time of the workout in hrs
     * @return calories out from running workout
     */
    public static int caloriesOutRunnigLegerFormula(double bodyMassKg, double distanceKm, double timePerformingHours) {
        // in kilometers per hour
        double speed = distanceKm / timePerformingHours;

        // Using The Léger equation V̇O2 = 2.209 + 3.1633 * kph
        double VO2 = 2.209 + 3.1633 * speed;

        double kcalPerMin = RESPIRATORY_EXCHANGE_RATIO_RUNNING_CALS_FROM_FAT + bodyMassKg * VO2 / 1000;

        return (int)Math.round(kcalPerMin * (timePerformingHours * MINS_IN_AN_HOUR));
    }

}
