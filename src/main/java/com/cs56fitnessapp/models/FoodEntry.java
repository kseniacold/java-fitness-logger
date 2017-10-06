package com.cs56fitnessapp.models;

public class FoodEntry {
    private double servingSize;
    private String foodName;
    private int calories;
    private TotalFat totalFat;
    private double cholesterol;
    private double sodium;
    private TotalCarb totalCarbs;
    private double protein;
    private double vitaminA;
    private double vitaminC;
    private double calcium;
    private double iron;

    /**
     * Constructs FoodEntry object with sevingSize and calories
     *
     * @param servingSize
     * @param calories
     */
    public FoodEntry(String foodName, double servingSize, int calories) {
        this.servingSize = servingSize;
        this.foodName = foodName;
        this.calories = calories;
    }

    // Getters and Setters begin
    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public TotalFat getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(TotalFat totalFat) {
        this.totalFat = totalFat;
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

    public TotalCarb getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(TotalCarb totalCarbs) {
        this.totalCarbs = totalCarbs;
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



