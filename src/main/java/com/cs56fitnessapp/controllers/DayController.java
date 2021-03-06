package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.Day;
import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.DayService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 12/4/17
 * Last Updated: 12/4/17
 */

public class DayController implements Initializable {
    // window that this scene belongs to
    private Stage window;
    private Parent root;

    @FXML
    private Label title;

    @FXML
    private Label caloriesLeft;

    @FXML
    private Label net;

    @FXML
    private Label activeCalories;

    @FXML
    private Label consumedCalories;

    @FXML
    private Label caloriesGoal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM dd");
        String formattedString = localDate.format(formatter);

        title.setText(formattedString);

        try {
            User user = FitnessApplication.getUser();
            Day day = DayService.getDay(LocalDate.now());

            long dailyCalorieGoal = Math.round(user.getDailyCalorieGoal());
            long caloriesLeftVaule = Math.round(day.getCaloriesLeft());
            int netValue = day.getCaloriesIn() - day.getCaloriesOut();

            caloriesGoal.setText("/ " + Long.toString(dailyCalorieGoal));
            caloriesLeft.setText(Long.toString(caloriesLeftVaule));
            net.setText(Integer.toString(netValue));
            activeCalories.setText(Integer.toString(day.getCaloriesOut()));
            consumedCalories.setText(Integer.toString(day.getCaloriesIn()));

        } catch(Exception ex) {
            // This is a final message to the client
            // TODO create this as a pop up
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void addFood() throws IOException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();

        /** Redirect to the workout scene */
        root = FXMLLoader.load(getClass().getResource("../views/food.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Food scene
        window.setScene(scene);
    }

    @FXML void addWorkout() throws IOException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();

        /** Redirect to the workout scene */
        root = FXMLLoader.load(getClass().getResource("../views/workout.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Workout scene
        window.setScene(scene);
    }
}
