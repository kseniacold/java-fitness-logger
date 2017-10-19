package com.cs56fitnessapp.models;
import java.util.ArrayList;


/**
 * @author Nerissa Hsieh & Jimwell Castillo
 * Date Created: 10/03/17
 * Date Modified: 10/03/17
 */

public class Meal implements DietFacts
    {
        @Override
        public int getCaloriesIn() {
            return 0;
        }

        @Override
        public double getTotalFatIn() {
            return 0;
        }

        @Override
        public double getTotalCarbIn() {
            return 0;
        }

        @Override
        public double getProteinIn() {
            return 0;
        }


        /** Edited Jimwell Castillo
         * 10.18.17
         * */

        public class Meals
            {

                private String mealName;
                private ArrayList <FoodEntry> meal;

                public Meals (String mealName )
                    {
                        this.mealName = mealName;
                        this.meal= new ArrayList<>();
                    }

                /**Checks to see if
                 food entry has been entered
                */

                public boolean addNewMeal(FoodEntry food)
                    {
                        if (findName(food.getFoodName()) >= 0)
                        {
                            System.out.println("Food is already Entered");
                            return false;
                        }

                        meal.add(food);
                        return true;
                    }

                /**Declaration
                to remove Food*/

                public boolean removeFood(FoodEntry food)
                {
                    int foundPosition = findName(food);
                    if(foundPosition <0)
                        {
                            System.out.println(food.getFoodName() +", was not found.");
                            return false;
                        }
                    this.meal.remove(foundPosition);
                    System.out.println(food.getFoodName() + ", was deleted.");
                    return true;
                }

                /**Finds Food
                Entry Food Name
                 */

                private int findName(FoodEntry food)
                    {
                        return this.meal.indexOf(food);
                    }


                private int findName(String FoodName)
                    {
                        for(int i=0; i<this.meal.size(); i++)
                        {
                            FoodEntry food = this.meal.get(i);
                                if(food.getFoodName().equals(FoodName))
                                    {
                                        return i;
                                    }
                        }
                            return -1;
                    }



                /**Once Food Name and Serving Size is inputed,
                Name & Serving size is added to the list.*/

                public void printFoodName()
                    {
                        System.out.println("Meal List");
                        for(int i=0; i<this.meal.size(); i++)
                            {
                                System.out.println((i+1) + "." +
                                        this.meal.get(i).getFoodName() + " -> " +
                                        this.meal.get(i).getServingSize());
                            }

                    }

                //Next goal


                //Manipulate food entries and make MealTitle enumeration


                //


            }
    }





