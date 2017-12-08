package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.Food;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.FoodService;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * @Author jimweezy & Ksenia
 * Created: 12/6/17
 * Last changes: 12/6/17 at 9:11 PM
 **/
public class FoodController implements Initializable {


    private Stage window;
    private Parent root;

    @FXML
    private Label title;

    @FXML
    private TextField servingSize;

    @FXML
    private TextField name;

    @FXML
    private TextField calories;

    @FXML
    private TextField totalFat;

    @FXML
    private TextField totalCarbs;

    @FXML
    private TextField protein;

    @FXML
    private TextField amtOfServings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void addFood() throws IOException, SQLException, ClassNotFoundException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();

        Food food = null;
        long centinelId = 0;
        LocalDateTime dateTime = LocalDateTime.now();

        String servingSizeValue = servingSize.getText();
        String nameValue = name.getText();
        int caloriesValue = Integer.parseInt(calories.getText());
        double totalFatValue = Double.parseDouble(totalFat.getText());
        double totalCarbValue = Double.parseDouble(totalCarbs.getText());
        double proteinValue = Double.parseDouble(protein.getText());
        int amtOfServingsValue = Integer.parseInt(amtOfServings.getText());

        /************************************************************************/

       food = new Food(centinelId, servingSizeValue, nameValue, caloriesValue, totalFatValue, totalCarbValue, proteinValue);
       long foodId = FoodService.addFoodToDb(food);
       FoodService.addFoodEntryToDb(dateTime, amtOfServingsValue, foodId);

        /** Redirect to the day scene */
        root = FXMLLoader.load(getClass().getResource("../views/day.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Day scene
        window.setScene(scene);
    }

}
