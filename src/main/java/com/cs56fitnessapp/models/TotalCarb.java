package com.cs56fitnessapp.models;

/**
 * @author Ksenia Koldaeva
 * Created: 10/1/17
 * Last Updated: 10/11/17
 */

public class TotalCarb {
    private double totalCarb;
    private double sugars;
    private double dietaryFiber;

    /**
     * Constructs totalCarb object with provided total carbohydrate value
     * @param totalCarb total carbohydrate value
     */
    public TotalCarb(double totalCarb) {
        this.totalCarb = totalCarb;
    }

    // Start getters and setters

    public double getTotalCarb() {
        return totalCarb;
    }

    public void setTotalCarb(double totalCarb) {
        this.totalCarb = totalCarb;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    // End getters and setters



}
