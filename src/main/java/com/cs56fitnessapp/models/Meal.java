package com.cs56fitnessapp.models;
import java.util.ArrayList;
// import java.util.Date;
import java.time.LocalDate;


/**
 * @author Nerissa Hsieh & Jimwell Castillo
 * Date Created: 10/03/17
 * Date Modified: 10/20/17
 */

public class Meal implements DietFacts{

      //date
    private LocalDate date;
    private String title;
    //foodList
    private ArrayList <FoodEntry> foodList;
    private String MealTitle;
    private int MealCalories;

    public Meal (LocalDate date, String MealTitle, ArrayList < FoodEntry > foodList) {
        this.date = date;
        this.title = MealTitle;
        this.foodList = new ArrayList<>();
     }

    /**Edited 10.20.17, Jim
     * **/

    @Override
    public int getCaloriesIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(food.getCalories() == MealCalories){
                    return i;
                }
            }
            return 0;

        }

        @Override
        public double getTotalFatIn() {
            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(food.getTotalFat() == MealCalories){
                    return i;
                }
            }
            return 0;
        }

        @Override
        public double getTotalCarbIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(food.getTotalCarb() == MealCalories){
                    return i;
                }
            }
            return 0;

        }

        @Override
        public double getProteinIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(food.getTotalFat() == MealCalories){
                    return i;
                }
            }
            return 0;

        }

}





