package com.cs56fitnessapp.models;

/**
 * @author Nerissa Hsieh
 */

public class Food {
    private long id;
    private String servingSize;
    private String name;
    private int calories;
    private double cholesterol;
    private double sodium;
    private double totalFat;
    private double saturatedFat;
    private double transFat;
    private double totalCarb;
    private double sugars;
    private double dietaryFiber;
    private double protein;
    private double vitaminA;
    private double vitaminC;
    private double calcium;
    private double iron;

    /**
     * Constructs Food object with sevingSize and calories
     *
     * @param servingSize
     * @param calories
     */
    public Food(long id, String name, String servingSize, int calories) {
        this.id = id;
        this.servingSize = servingSize;
        this.name = name;
        this.calories = calories;
    }

    public Food(long id, String servingSize, String name, int calories, double totalFat, double totalCarb, double protein) {
        this.id = id;
        this.servingSize = servingSize;
        this.name = name;
        this.calories = calories;
        this.totalFat = totalFat;
        this.totalCarb = totalCarb;
        this.protein = protein;
    }

    // Getters and Setters begin
    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

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

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }
    // Getters and Setters end
}



