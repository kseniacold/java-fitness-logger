package com.cs56fitnessapp.models;

/**
 * @author Saori Shigehisa
 * Created: 10/6/17
 * Last Updated: 12/07/17
 */
import com.cs56fitnessapp.models.workout.Workout;

import java.time.LocalDate;
import java.util.ArrayList;

public class Day implements ActivityFacts, DietFacts {

    /** date */
    private LocalDate date;

    /** User */
    private User user;

    /** WorkoutList */
    private ArrayList<Workout> workoutList;

    /** MealList */
    // TODO further additional functionality to sort FoodEntries into Meals
    private ArrayList<Meal> mealList;

    /** FoodEntryList */
    private ArrayList<FoodEntry> foodEntries;

    public Day (LocalDate date, User user){
        this.date = date;
        this.user = user;
        this.workoutList = new ArrayList<Workout>();
        this.mealList = new ArrayList<Meal>();
        this.foodEntries = new ArrayList<FoodEntry>();
    }

    /** Getters and setters start */
    public boolean addWorkout(Workout workout) {
        return this.workoutList.add(workout);
    }

    public ArrayList <Workout> getWorkoutList(){
        return this.workoutList;
    }

    public boolean addWorkout(Meal meal) {
        return this.mealList.add(meal);
    }

    public ArrayList <Meal> getMealList(){
        return this.mealList;
    }

    public boolean isToday() {
        LocalDate now = LocalDate.now();

        return now.getYear() == date.getYear() && now.getMonth() == date.getMonth() && now.getDayOfMonth() == date.getDayOfMonth();
    }

    public void setWorkoutList(ArrayList<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public ArrayList<FoodEntry> getFoodEntries() {
        return foodEntries;
    }

    public void setFoodEntries(ArrayList<FoodEntry> foodEntries) {
        this.foodEntries = foodEntries;
    }

    /** Getters and setters end */

    public double getCaloriesLeft() {
        return this.user.getDailyCalorieGoal() - this.getCaloriesIn() + this.getCaloriesOut();
    }

    /* ActivityFacts Interface */
    @Override
    public int getCaloriesOut() {
        int sum = 0;
        for (int i = 0; i < workoutList.size(); ++i) {
            Workout workout = workoutList.get(i);
            sum += workout.getCaloriesOut();
        }
        return sum;
    }

    @Override
    public int getActiveTimeMins() {
        int sum = 0;
        for (int i = 0; i < workoutList.size(); ++i) {
            Workout workout = workoutList.get(i);
            sum += workout.getActiveTimeMins();
        }
        return sum;
    }

    /* DietFacts Interface */
    @Override
    public int getCaloriesIn() {
        int sum = 0;
        for (int i = 0; i < mealList.size(); ++i) {
            Meal meal = mealList.get(i);
            sum += meal.getCaloriesIn();
        }
        return sum;
    }

    @Override
    public double getTotalFatIn() {
        double sum = 0.0;
        for (int i = 0; i < mealList.size(); ++i) {
            Meal meal = mealList.get(i);
            sum += meal.getTotalFatIn();
        }
        return sum;
    }

    @Override
    public double getTotalCarbIn() {
        double sum = 0.0;
        for (int i = 0; i < mealList.size(); ++i) {
            Meal meal = mealList.get(i);
            sum += meal.getTotalCarbIn();
        }
        return sum;
    }

    @Override
    public double getProteinIn() {
        double sum = 0.0;
        for (int i = 0; i < mealList.size(); ++i) {
            Meal meal = mealList.get(i);
            sum += meal.getProteinIn();
        }
        return sum;
    }
}
