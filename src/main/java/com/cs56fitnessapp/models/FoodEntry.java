package com.cs56fitnessapp.models;

public class FoodEntry {
    private double servingSize;
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
    public FoodEntry(double servingSize, int calories, TotalFat totalFat, double cholesterol, double sodium, TotalCarb totalCarbs, double protein, double vitaminA, double vitaminC, double calcium, double iron){
        this.servingSize = servingSize;
        this.calories = calories;
        this.totalFat = totalFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.totalCarbs = totalCarbs;
        this.protein = protein;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.calcium = calcium;
        this.iron = iron;
    }
    public double getServingSize(){
        return servingSize;
    }
    public void setServingSize(double a){
        servingSize = a;
    }
    public int getCalories(){
        return calories;
    }
    public void setCalories(int b){
        calories  = b;
    }
    public TotalFat getTotalFat(){
        return totalFat;
    }
    public void setTotalFat(TotalFat c){
        totalFat = c;
    }
    public double getCholesterol(){
        return cholesterol;
    }
    public void setCholesterol(double d){
        cholesterol = d;
    }
    public double getSodium(){
        return sodium;
    }
    public void setSodium(double e){
        sodium = e;
    }
    public TotalCarb getTotalCarbs(){
        return totalCarbs;
    }
    public void setTotalCarbs(TotalCarb f){
        totalCarbs = f;
    }
    public double getProtein(){
        return protein;
    }
    public void  setProtein(double g){
        protein = g;
    }
    public double getVitaminA(){
        return vitaminA;
    }
    public void setVitaminA(double h){
        vitaminA = h;
    }
    public double getVitaminC(){
        return vitaminC;
    }
    public void setVitaminC(double i){
        vitaminC = i;
    }
    public double getCalcium(){
        return calcium;
    }
    public void setCalcium(double j){
        calcium = j;
    }
    public double getIron(){
        return iron;
    }
    public void setIron(double k){
        iron = k;
    }
}
