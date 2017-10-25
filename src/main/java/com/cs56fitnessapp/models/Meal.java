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

    //    Old Constructor,commented out
    //    public Meal(LocalDate date, String title, ArrayList <FoodEntry> foodEntriesList, MealTitle title1) {
    //        this.date = date;
    //        this.title = title1;
    //        this.foodEntriesList = new ArrayList<>();
    //     }

    /**
     * Edited 10.20.17, Jim
     * **/

    @Override
    public int getCaloriesIn() {
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            FoodEntry food = this.foodEntriesList.get(i);
            if(true){
                return getCaloriesIn();
            }
        }
        return 0;
    }

    @Override
    public double getTotalFatIn() {
        for(int i = 0; i<this.foodEntriesList.size(); i++){
            FoodEntry food = this.foodEntriesList.get(i);
            if(true){
                return food.getCalories();
            }
        }
        return 0;
    }

    @Override
    public double getTotalCarbIn() {

        for(int i = 0; i<this.foodEntriesList.size(); i++){
            FoodEntry food = this.foodEntriesList.get(i);
            if(true){
                return food.getTotalFat();
            }
        }
        return 0;

    }

    @Override
    public double getProteinIn() {

        for(int i = 0; i<this.foodEntriesList.size(); i++){
            FoodEntry food = this.foodEntriesList.get(i);
            if(true){
                return food.getProtein();
            }
        }
        return 0;

    }


    /**
     * Edited 10.25.17, Jim
     * **/


    /**
     *   UML
         * + Meal(date: LocalDate, title: MealTitle)
     * **/

    public Meal (LocalDate date,MealTitle title) {
        this.date = date;
        this.title = title;
    }

    /**
     *   UML
         * + addFoodEntry(foodEntry: FoodEntry): boolean
     * **/

    public boolean addFoodEntry(FoodEntry foodEntry){
        return true;
    }

    //    Not to be implemented yet
    //    public boolean removeFoodEntryByDate(LocalDate date){
    //        return true;
    //    }
    //

    /**
     *   UML
         * + setDate(date: LocalDate)
     * **/
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *   UML
         * + getDate(): LocalDate
     * **/
    public LocalDate getDate(){
        return date;
    }

    /**
     *   UML
         * + setTitle(title: MealTitle)
     * **/
    public void setTitle(MealTitle title) {
        this.title = title;
    }

    /**
     *  UML
         * + getTitle: MealTitle
     * **/
    public MealTitle getTitle(){
        return title;
    }


    /**
     *  UML
         * + getFoodEntriesList(): ArrayList<FoodEntry>
     * **/
    public ArrayList <FoodEntry> getFoodEntriesList() {
        return foodEntriesList;
    }


}





