package com.cs56fitnessapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM dd");
        String formattedString = localDate.format(formatter);

        title.setText(formattedString);
    }

    @FXML
    private void addFood() {

    }

    @FXML void addWorkout() throws IOException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();


        /** Redirect to the day scene */
        root = FXMLLoader.load(getClass().getResource("../views/workout.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Day scene
        window.setScene(scene);
    }
}
