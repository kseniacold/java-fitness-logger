package com.cs56fitnessapp.models;

import java.time.LocalDate;

/**
 * @author Ksenia Koldaeva
 * Created: 10/23/17
 * Last Updated: 10/23/17
 */

public class FoodEntry implements DietFacts {
    private LocalDate date;
    private Food food;
    private double amountOfServings;

    /**
     * Constructs new FoodEntry object with provided parameters
     * @param date - date of the food consumed
     * @param food - food consumed
     * @param amountOfServings - amount of servings consumed
     */
    public FoodEntry(LocalDate date, Food food, double amountOfServings) {
        this.date = date;
        this.food = food;
        this.amountOfServings = amountOfServings;
    }

    // Start getters and setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getAmountOfServings() {
        return amountOfServings;
    }

    public void setAmountOfServings(double amountOfServings) {
        this.amountOfServings = amountOfServings;
    }

    // End getters and setters

    /**
     * @return amount of calories in a given food consumption entry
     */
    @Override
    public int getCaloriesIn() {
        return (int)(this.food.getCalories() * this.amountOfServings);
    }

    /**
     * @return amount of total fat in a given food consumption entry
     */
    @Override
    public double getTotalFatIn() {
        return this.food.getTotalFat() * this.amountOfServings;
    }

    /**
     * @return amount of total carb in a given food consumption entry
     */
    @Override
    public double getTotalCarbIn() {
        return this.food.getTotalCarb() * this.amountOfServings;
    }

    /**
     * @return amount of protein in a given food consumption entry
     */
    @Override
    public double getProteinIn() {
        return this.food.getProtein() * this.amountOfServings;
    }
}
