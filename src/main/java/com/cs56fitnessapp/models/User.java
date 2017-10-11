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
    private double bodyMassKg;

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
     * @param name user's name
     * @param username username
     * @param dateOfBirth user's date of birth
     * @param gender gender
     * @param bodyMassKg body mass in kilograms
     * @param height
     * @param goal goal - to lose, maintain or gain weight
     * @param progressPace how many puonds per week to lose
     * @param activityLevel user's activity level
     */
    private User(String name, String username, LocalDate dateOfBirth, Gender gender, double bodyMassKg, double height, Goal goal, int progressPace, ActivityLevel activityLevel) {
        this.name = name;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bodyMassKg = bodyMassKg;
        this.height = height;
        this.goal = goal;
        this.progressPace = progressPace;
        this.activityLevel = activityLevel;
    }

    /**
     * Implements singleton design pattern
     * This method accepts arguments and designed to use by the client if User.isSet() returns false
     * @return User object to be used in the application
     */
    public static synchronized User getUser(String name, String username, LocalDate dateOfBirth, Gender gender, double bodyMassKg, double height, Goal goal, int progressPace, ActivityLevel activityLevel) {
        if (User.user == null) {
            User.user = new User(name, username, dateOfBirth, gender, bodyMassKg, height, goal, progressPace, activityLevel);
        }
        return user;
    }

    /**
     * Implements singleton design pattern
     * This method does not accept args and designed to use by the client if User.isSet() returns true
     * Otherwise use getUser(String name, String username, LocalDate dateOfBirth, Gender gender, double bodyMassKg, double height, Goal goal, int progressPace, ActivityLevel activityLevel)
     * @return User object to be used in the application
     * @throws NullPointerException if User object has not been instantiated and there is nothing to return
     */
    public static synchronized User getUser() throws NullPointerException {
        if (User.user == null) {
            throw new NullPointerException("User object is not set.");
        } else {
            return user;
        }
    }

    /**
     * Designed to performed a check before using getUser() method
     * @return true is User is set and ready to use for other classes
     */
    public static boolean isSet() {
        return User.user != null;
    }

    // Start getters and setters

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

    public double getbodyMassKg() {
        return bodyMassKg;
    }

    public void setbodyMassKg(double bodyMassKg) {
        this.bodyMassKg = bodyMassKg;
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
        return FitnessFormulas.basalMetabolicRate(this.gender, this.activityLevel, this.bodyMassKg, this.height, this.getAge());
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
