package com.cs56fitnessapp.views;

import com.cs56fitnessapp.models.Gender;
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
    private ChoiceBox gender;

    /**
     * No argument constructor
     */
    public RegisterUserController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gender.setValue(Gender.MALE);
    }

    @FXML
    private void printOutput() {
        Gender genderOutput = null;

        if (gender.getValue() instanceof Gender) {
            genderOutput = (Gender)gender.getValue();
        } else {
            System.out.println("Incompatible types");
        }


        if (genderOutput != null) {
            switch (genderOutput) {
                case FEMALE:
                    System.out.println("female");
                    break;
                case MALE:
                    System.out.println("male");
                    break;
            }
        }

    }
}
