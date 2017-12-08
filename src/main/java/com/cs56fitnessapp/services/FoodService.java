package com.cs56fitnessapp.services;

import com.cs56fitnessapp.models.Food;
import com.cs56fitnessapp.models.FoodEntry;
import com.cs56fitnessapp.utils.DateFormatter;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksenia Koldaeva
 * Created: 12/7/17
 * Last Updated: 12/7/17
 */
public class FoodService {
    /**
     * Inserts Food into database and returns it's id
     * @param food
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static long addFoodToDb(Food food) throws SQLException, ClassNotFoundException {
        long foodId;
        // open sqlite connection
        Connection connection = SqLiteConnection.getConnectionObj();

        String sqlQuery = "INSERT INTO food(name, serving_size, calories, total_fat, total_carb, protein) VALUES(" +
                "'" + food.getName() + "'," +
                "'" + food.getServingSize() + "'," +
                "'" + food.getCalories() + "'," +
                "'" + food.getTotalFat() + "'," +
                "'" + food.getTotalCarb() + "'," +
                "'" + food.getProtein() + "')";

        PreparedStatement statement = connection.prepareStatement(sqlQuery ,
                Statement.RETURN_GENERATED_KEYS);

        statement.executeUpdate(sqlQuery);
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                foodId = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        SqLiteConnection.closeConnection();
        return foodId;
    }

    /**
     * Adds FoodEntry to database
     * @param dateTime
     * @param amountOfServings
     * @param foodId
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addFoodEntryToDb(LocalDateTime dateTime, int amountOfServings, long foodId) throws SQLException, ClassNotFoundException {
        // open sqlite connection
        Connection connection = SqLiteConnection.getConnectionObj();
        Statement statement = connection.createStatement();

        String sqlQuery = "INSERT INTO food_entry(date, amount_of_servings, food_id) VALUES(" +
                "'" + dateTime + "'," +
                "'" + amountOfServings + "'," +
                "'" + foodId + "')";

        statement.executeUpdate(sqlQuery);
        SqLiteConnection.closeConnection();
    }

    /**
     * Returns list of food entries by provided date
     * @param date
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<FoodEntry> getFoodEntryListByDate(LocalDate date) throws SQLException, ClassNotFoundException {
        List<FoodEntry> foodEntryList = new ArrayList<>();

        /************************************************************************/
        // open sqlite connection
        Connection connection = SqLiteConnection.getConnectionObj();
        Statement statement = connection.createStatement();

        String formattedDate = DateFormatter.dateToString(date);

        String sqlQueryFoodEntry = "SELECT * FROM food_entry WHERE date LIKE '%" + formattedDate + "%'";
        ResultSet rsFoodEntry = statement.executeQuery(sqlQueryFoodEntry);

        while(rsFoodEntry.next()) {
            FoodEntry foodEntry;
            Food food = null;
            long foodId = rsFoodEntry.getLong("food_id");
            int amountOfServings = rsFoodEntry.getInt("amount_of_servings");
            LocalDateTime dateTime = DateFormatter.stingToDateTime(rsFoodEntry.getString("date"));

            String sqlQueryFood =  "SELECT * FROM food WHERE id = '" + foodId + "'";
            ResultSet rsFood = statement.executeQuery(sqlQueryFood);

            while (rsFood.next()) {
                String name = rsFood.getString("name");
                String servingSize = rsFood.getString("serving_size");
                int calories = rsFood.getInt("calories");
                double totalFat = rsFood.getDouble("total_fat");
                double totalCarb = rsFood.getDouble("total_carb");
                double protein = rsFood.getDouble("protein");

                food = new Food(foodId, servingSize, name, calories, totalFat, totalCarb, protein);
            }

            foodEntry = new FoodEntry(dateTime, food, amountOfServings);
            foodEntryList.add(foodEntry);
        }

        SqLiteConnection.closeConnection();
        return foodEntryList;
    }

}
