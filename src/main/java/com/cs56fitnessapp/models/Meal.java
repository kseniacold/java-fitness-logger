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
    private MealTitle title;
    //foodList
    private ArrayList <FoodEntry> foodList;

    public Meal(LocalDate date, String title, ArrayList <FoodEntry> foodList, MealTitle title1) {
        this.date = date;
        this.title = title1;
        this.foodList = new ArrayList<>();
     }

    /**E
     * dited 10.20.17, Jim
     * **/

    @Override
    public int getCaloriesIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(true){
                    return getCaloriesIn();
                }
            }
            return 0;

        }

        @Override
        public double getTotalFatIn() {
            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(true){
                    return food.getCalories();
                }
            }
            return 0;
        }

        @Override
        public double getTotalCarbIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(true){
                    return food.getTotalFat();
                }
            }
            return 0;

        }

        @Override
        public double getProteinIn() {

            for(int i = 0; i<this.foodList.size(); i++){
                FoodEntry food = this.foodList.get(i);
                if(true){
                    return food.getProtein();
                }
            }
            return 0;

        }

    public MealTitle getTitle() {
        return title;
    }
}





