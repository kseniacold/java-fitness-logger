package com.cs56fitnessapp.models;
import java.util.ArrayList;
import java.time.LocalDate;


/**
 * @author Nerissa Hsieh & Jimwell Castillo
 * Date Created: 10/03/17
 * Date Modified: 10/20/17
 */

public class Meal implements DietFacts{
    private LocalDate date;
    private MealTitle title;
    private ArrayList <FoodEntry> foodEntriesList;

    /**
     * Constructs new Meal object with provided parameters
     * @param date - date of meal consumption
     * @param title - meal title, e.g. "Breakfast", "Lunch", "Dinner" or "Snack"
     */
    public Meal (LocalDate date, MealTitle title) {
        this.date = date; 
        this.title = title;
        this.foodEntriesList = new ArrayList<>();
    }

    /**
     * Edited 10.27.17, Jim
     * **/

    // Start getters and setters

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setTitle(MealTitle title) {
        this.title = title;
    }

    public MealTitle getTitle(){
        return title;
    }

    public ArrayList <FoodEntry> getFoodEntriesList() {
        return foodEntriesList;
    }

    public boolean addFoodEntry(FoodEntry foodEntry) {
        return this.foodEntriesList.add(foodEntry);
    }

    // End getters and setters

    @Override
    public int getCaloriesIn() {
        int totalCalories = 0;
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            totalCalories += this.foodEntriesList.get(i).getCaloriesIn();
            }
        return totalCalories;
    }

    @Override
    public double getTotalFatIn() {
        double totalFat = 0;
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            totalFat += this.foodEntriesList.get(i).getTotalFatIn();
            }
        return totalFat;
    }

    @Override
    public double getTotalCarbIn() {
        double totalCarb = 0;
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            totalCarb += this.foodEntriesList.get(i).getTotalCarbIn();
            }
        return totalCarb;
    }

    @Override
    public double getProteinIn() {
        double totalProtein = 0;
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            totalProtein += this.foodEntriesList.get(i).getProteinIn();

        }
        return totalProtein;
    }


    /**
     * Edited 10.27.17, Jim
     * **/


//    private FoodEntry findFoodEntry(String title){
//        for(FoodEntry checkFoodEntry: this.foodEntriesList)
//        {
//            if(checkFoodEntry.getFoodName().equals(title))
//            {
//                return checkFoodEntry;
//            }
//
//        }
//        return null;
//    }

    //    Not to be implemented yet
    //    public boolean removeFoodEntryByDate(LocalDate date){return true;}


}





