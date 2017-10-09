package com.cs56fitnessapp.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @author Zeed Alsuwayyigh
 * @author Ksenia Koldaeva
 * Created 9/26/17
 * Last updated 10/09/17
 */

public class User {
    public static final int CALORIES_PER_POUND = 3500;
    public  static final int DAYS_IN_A_WEEK = 7;

    private static User user;

    private String name;

    private String username;

    private LocalDate dateOfBirth;

    private Gender gender;

    private double weight;

    // will be stored in metric values
    private double height;

    private Goal goal;

    private double goalWeight;

    // progress pace in pounds / week
    private int progressPace;

    private ActivityLevel activityLevel;

    /**
     * User implements singleton design pattern
     * Private constructor creates a new user with provided parameters
     * @param name
     * @param username
     * @param dateOfBirth
     * @param gender
     * @param weight
     * @param height
     * @param goal
     * @param progressPace
     * @param activityLevel
     */
    private User(String name, String username, LocalDate dateOfBirth, Gender gender, double weight, double height, Goal goal, int progressPace, ActivityLevel activityLevel) {
        this.name = name;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.goal = goal;
        this.progressPace = progressPace;
        this.activityLevel = activityLevel;
    }

    // Start getters and setters

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getProgressPace() {
        return progressPace;
    }

    public void setProgressPace(int progressPace) {
        this.progressPace = progressPace;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    // End getters and setters


    /**
     * @return user's age
     */
    public long getAge () {
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        long years = ChronoUnit.YEARS.between(this.dateOfBirth, now);

        return years;
    }

    /**
     * @return amount of calories burned at rest
     */
    public double getBasalMetabolicRate() {
        double BMR;
        // calculations for female users
        if (this.gender.equals(Gender.FEMALE)) {
            BMR = 66.47 + (13.75 * this.weight) + (5.0 * this.height) - (6.45 * this.getAge());
        } else {
            // TODO: check the formula
            BMR = 66.509 + (9.56 * this.weight) + (1.84 + this.height) - (4.67 * this.getAge());
        }
        return BMR;
    }

    // TODO refactor - remove formulas into a separate class
    /**
     *
     * @return calorie offset(deficit or proficit depending on the goal)
     * based on how many pounds user wants to gain or loose
     */
    public int getCalorieOffset() {
        return Math.round((this.progressPace * CALORIES_PER_POUND) / DAYS_IN_A_WEEK);
    }

    /**
     * @return daily calorie goal depending on the user's goal
     */
    public double getDailyCalorieGoal () {
        double dailyCalorieGoal = 0;

        switch (goal) {
            case LOSE:
                dailyCalorieGoal = getBasalMetabolicRate() - this.getCalorieOffset();
                break;
            case MAINTAIN:
                dailyCalorieGoal = getBasalMetabolicRate();
                break;
            case GAIN:
                dailyCalorieGoal = getBasalMetabolicRate() + this.getCalorieOffset();

        }

        return dailyCalorieGoal;
    }

}
