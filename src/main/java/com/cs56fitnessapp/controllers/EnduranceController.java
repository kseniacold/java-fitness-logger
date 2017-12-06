package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.models.workout.CyclingType;
import com.cs56fitnessapp.models.workout.EnduranceType;
import com.cs56fitnessapp.models.workout.SwimmingStroke;
import com.cs56fitnessapp.utils.CyclingTypeConverter;
import com.cs56fitnessapp.utils.EnduranceTypeConverter;
import com.cs56fitnessapp.utils.SwimmingStrokeConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
    private TextField endDuration;

    @FXML
    private TextField endDistance;

    @FXML
    private HBox swimmingOptions;

    @FXML
    private HBox cyclingOptions;

    @FXML
    private ChoiceBox<CyclingType> cyclingType;

    @FXML
    private ChoiceBox<SwimmingStroke> stroke;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /** Set converters from String to enum and back */
        endType.setConverter(new EnduranceTypeConverter());
        cyclingType.setConverter(new CyclingTypeConverter());
        stroke.setConverter(new SwimmingStrokeConverter());

        endDuration.setPromptText("minutes");
        endDistance.setPromptText("miles");
        
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
                        cyclingOptions.setVisible(false);
                        cyclingType.setValue(null);

                        swimmingOptions.setVisible(true);
                        break;
                    case CYCLING:
                        swimmingOptions.setVisible(false);
                        stroke.setValue(null);

                        cyclingOptions.setVisible(true);
                        break;
                    case RUNNING:
                        swimmingOptions.setVisible(false);
                        cyclingOptions.setVisible(false);

                        stroke.setValue(null);
                        cyclingType.setValue(null);
                        break;
                }
            }
        });
    }
}
