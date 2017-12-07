package com.cs56fitnessapp.models;

/**
 * @author Saori Shigehisa
 * Created: 10/6/17
 * Last Updated: 11/03/17
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
    private ArrayList < Workout > workoutList;

    /** MealList */
    private ArrayList < Meal > mealList;

    public Day (LocalDate date, User user){
        this.date = date;
        this.user = user;
        this.workoutList = new ArrayList <Workout>();
        this.mealList = new ArrayList <Meal>();
    }

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
