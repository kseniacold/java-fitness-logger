package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.models.workout.EnduranceType;
import com.cs56fitnessapp.utils.EnduranceTypeConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 12/6/17
 * Last Updated: 12/6/17
 */
public class EnduranceController implements Initializable {
    // window that this scene belongs to
    private Stage window;
    private Parent root;

    @FXML
    private ChoiceBox<EnduranceType> endType;

    @FXML
    private HBox swimmingOptions;

    @FXML
    private HBox cyclingOptions;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /** Set converter from String to enum and back */
        endType.setConverter(new EnduranceTypeConverter());
        
        handleEnduranceSelection();
    }

    private void handleEnduranceSelection() {
        swimmingOptions.setVisible(false);
        cyclingOptions.setVisible(false);

        endType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EnduranceType>() {
            @Override
            public void changed(ObservableValue<? extends EnduranceType> observable, EnduranceType oldValue, EnduranceType newValue) {
                switch (newValue) {
                    case SWIMMING:

                        break;
                }
            }
        });
    }
}
