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

    private static User user = null;

    private String name;

    private String username;

    private LocalDate dateOfBirth;

    private Gender gender;

    // weight in kg
    private double weight;

    // height in cm
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

    /**
     * Implements singleton design pattern
     * @return User object to be used in the application
     */
    public static synchronized User getUser(String name, String username, LocalDate dateOfBirth, Gender gender, double weight, double height, Goal goal, int progressPace, ActivityLevel activityLevel) {
        if (User.user == null) {
            User.user = new User(name, username, dateOfBirth, gender, weight, height, goal, progressPace, activityLevel);
        }
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
    public int getAge () {
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        int years = (int)ChronoUnit.YEARS.between(this.dateOfBirth, now);

        return years;
    }

    /**
     * @return amount of calories burned at rest
     */
    public double getBasalMetabolicRate() {
        return FitnessFormulas.basalMetabolicRate(this.gender, this.activityLevel, this.weight, this.height, this.getAge());
    }

    /**
     *
     * @return calorie offset(deficit or proficit depending on the goal)
     * based on how many pounds user wants to gain or lose
     */
    public int getCalorieOffset() {
        return FitnessFormulas.calorieOffset(this.progressPace);
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
