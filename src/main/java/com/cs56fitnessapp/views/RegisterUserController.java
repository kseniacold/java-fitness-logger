package com.cs56fitnessapp.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 11/29/17
 * Last Updated: 11/29/17
 */
public class RegisterUserController implements Initializable {
    @FXML
    private ChoiceBox genderChoiceBox;

    /**
     * No argument constructor
     */
    public RegisterUserController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void printOutput() {
        System.out.println(genderChoiceBox.getValue());
    }
}
