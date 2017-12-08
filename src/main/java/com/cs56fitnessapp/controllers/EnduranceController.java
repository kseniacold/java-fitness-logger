package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.FitnessApplication;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.models.workout.*;
import com.cs56fitnessapp.services.UserService;
import com.cs56fitnessapp.services.WorkoutService;
import com.cs56fitnessapp.utils.CyclingTypeConverter;
import com.cs56fitnessapp.utils.EnduranceTypeConverter;
import com.cs56fitnessapp.utils.SwimmingStrokeConverter;
import com.cs56fitnessapp.utils.UnitsConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Label title;

    @FXML
    private ChoiceBox<EnduranceType> endType;

    @FXML
    private TextField endDuration;

    @FXML
    private TextField endDistance;

    @FXML
    private VBox swimmingOptions;

    @FXML
    private HBox cyclingOptions;

    @FXML
    private ChoiceBox<CyclingType> cyclingType;

    @FXML
    private ChoiceBox<SwimmingStroke> stroke;

    @FXML
    private CheckBox swimmingTraining;

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

    @FXML
    private void addEndurance() throws SQLException, ClassNotFoundException {
        /** Initialize window obj */
        window = (Stage)title.getScene().getWindow();
        User user = FitnessApplication.getUser();
        Endurance endurance = null;
        long centinelId = 0;

        LocalDateTime date = LocalDateTime.now();
        double timePerformingHrs = UnitsConverter.minsToHrs(Double.parseDouble(endDuration.getText()));
        EnduranceType enduranceTypeValue = endType.getValue();
        double distanceKm = UnitsConverter.milesToKm(Double.parseDouble(endDistance.getText()));
        boolean swimmingTrainingValue = swimmingTraining.isSelected();
        SwimmingStroke swimmingStroke = stroke.getValue();
        CyclingType cyclingTypeValue = cyclingType.getValue();

        /************************************************************************/

        // Create endurance instance from data fetched
        if (enduranceTypeValue == EnduranceType.RUNNING) {
            endurance = new Running(centinelId, user, date, distanceKm, timePerformingHrs);
        }

        if (enduranceTypeValue == EnduranceType.SWIMMING) {
            endurance = new Swimming(centinelId, user, date, distanceKm, timePerformingHrs, swimmingStroke);
            ((Swimming)endurance).setTraining(swimmingTrainingValue);
        }

        if (enduranceTypeValue == EnduranceType.CYCLING) {
            endurance = new Cycling(centinelId, user, date, distanceKm, timePerformingHrs, cyclingTypeValue);
        }

        /************************************************************************/
        WorkoutService workoutService = new WorkoutService();
        workoutService.addEnduranceToDb(endurance);

        LocalDate today = LocalDate.now();
        workoutService.getEnduranceListByDate(today);
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
