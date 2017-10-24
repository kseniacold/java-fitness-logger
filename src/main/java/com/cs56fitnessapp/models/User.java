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

    private String name;

    private String username;
    // email is optional in this implementation, username can be provided instead
    private String email;

    private String password;

    private LocalDate dateOfBirth;

    private Gender gender;

    // weight in kg
    private double bodyMassKg;

    // heightCm in cm
    private double heightCm;

    private Goal goal;

    private double goalWeight;

    // progress pace in kilograms / week
    private int weeklyGoalKg;

    private ActivityLevel activityLevel;

    /**
     * Constructs new user with provided parameters
     * @param name user's name
     * @param username username
     * @param dateOfBirth user's date of birth
     * @param gender gender
     * @param bodyMassKg body mass in kilograms
     * @param heightCm height in centimeters
     * @param goal goal - to lose, maintain or gain weight
     * @param weeklyGoalKg how many kilograms per week to lose or gain
     * @param activityLevel user's activity level
     */
    public User(String name, String username, String password, LocalDate dateOfBirth, Gender gender, double bodyMassKg, double heightCm, Goal goal, int weeklyGoalKg, ActivityLevel activityLevel) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bodyMassKg = bodyMassKg;
        this.heightCm = heightCm;
        this.goal = goal;
        this.weeklyGoalKg = weeklyGoalKg;
        this.activityLevel = activityLevel;
    }

    // Start getters and setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public double getBodyMassKg() {
        return bodyMassKg;
    }

    public void setBodyMassKg(double bodyMassKg) {
        this.bodyMassKg = bodyMassKg;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
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

    public int getWeeklyGoalKg() {
        return weeklyGoalKg;
    }

    public void setWeeklyGoalKg(int weeklyGoalKg) {
        this.weeklyGoalKg = weeklyGoalKg;
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
        return (int)ChronoUnit.YEARS.between(this.dateOfBirth, now);
    }

    /**
     * @return amount of calories burned at rest
     */
    public double getBasalMetabolicRate() {
        return FitnessFormulas.basalMetabolicRate(this.gender, this.activityLevel, this.bodyMassKg, this.heightCm, this.getAge());
    }

    /**
     *
     * @return calorie offset(deficit or proficit depending on the goal)
     * based on how many pounds user wants to gain or lose
     */
    public int getCalorieOffset() {
        return FitnessFormulas.calorieOffset(this.weeklyGoalKg);
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
