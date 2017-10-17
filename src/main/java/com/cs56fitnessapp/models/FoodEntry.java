package com.cs56fitnessapp.models;

public class FoodEntry {
    private double servingSize;
    private String foodName;
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

    // TODO >>>>>>> Insert getters and setters for fats

    // TODO >>>>>>> Insert getters and setters for carb

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



