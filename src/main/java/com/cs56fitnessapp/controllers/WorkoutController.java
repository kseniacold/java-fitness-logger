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
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */


public class WorkoutController implements Initializable {
    // window that this scene belongs to
    private Stage window;
    private Parent root;

    @FXML
    private Label title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void addEndurance() throws IOException{
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();


        /** Redirect to the Endurance scene */
        root = FXMLLoader.load(getClass().getResource("../views/endurance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Endurance scene
        window.setScene(scene);
    }

    @FXML void addStrength() throws IOException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();


        /** Redirect to the Strength scene */
        root = FXMLLoader.load(getClass().getResource("../views/strength.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Strength scene
        window.setScene(scene);
    }
}
