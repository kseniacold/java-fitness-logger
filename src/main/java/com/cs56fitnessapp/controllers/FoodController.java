package com.cs56fitnessapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Author jimweezy & Ksenia
 * Created: 12/6/17
 * Last changes: 12/6/17 at 9:11 PM
 **/
public class FoodController {


    private Stage window;
    private Parent root;

    @FXML
    private Label title;

    @FXML

    void addFood() throws IOException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();


        /** Redirect to the day scene */
        root = FXMLLoader.load(getClass().getResource("../views/food.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Day scene
        window.setScene(scene);
    }

}
