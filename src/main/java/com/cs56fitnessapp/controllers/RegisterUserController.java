package com.cs56fitnessapp.controllers;

import com.cs56fitnessapp.models.ActivityLevel;
import com.cs56fitnessapp.models.Gender;
import com.cs56fitnessapp.models.Goal;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.UserService;
import com.cs56fitnessapp.utils.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * @author Ksenia Koldaeva
 * Created: 11/29/17
 * Last Updated: 11/29/17
 */

public class RegisterUserController implements Initializable {
    // window that this scene belongs to
    private Stage window;
    private Parent root;

    @FXML
    private ChoiceBox<Goal> goal;

    @FXML
    private ChoiceBox<ActivityLevel> activityLevel;

    @FXML
    private ChoiceBox<Gender> gender;

    @FXML
    private DatePicker date;

    @FXML
    private TextField heightFt;

    @FXML
    private TextField heightIns;

    @FXML
    private TextField weight;

    @FXML
    private TextField goalWeight;

    // Weekly goal interactive elements start
    @FXML
    private Text selectGoalFirst;

    @FXML
    private Text maintainWeight;

    @FXML
    private VBox loseWeightContainer;

    @FXML
    private VBox gainWeightContainer;

    @FXML
    private TextField loseWeight;

    @FXML
    private TextField gainWeight;
    // Weekly goal interactive elements end
    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    /**
     * No argument constructor
     */
    public RegisterUserController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /** Set converter from String to enum and back */
        goal.setConverter(new GoalConverter());

        /** Set converter from String to enum and back */
        activityLevel.setConverter(new ActivityLevelConverter());
        activityLevel.setValue(ActivityLevel.SEDENTARY);

        /** Set converter from String to enum and back */
        gender.setConverter(new GenderConverter());
        gender.setValue(Gender.MALE);

        heightFt.setTextFormatter(FormatterUtils.getIntFormatter());
        heightIns.setTextFormatter(FormatterUtils.getIntFormatter());

        weight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        loseWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        gainWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());

        goalWeight.setTextFormatter(FormatterUtils.getDoubleFormatter());
        //TODO Validate email address

        name.setPromptText("Name");
        username.setPromptText("Username");
        email.setPromptText("Email");
        password.setPromptText("Password");

        handleWeeklyGoal();
    }

    @FXML
    private void registerUser() throws IOException {
        /** Initialize window obj */
        window = (Stage)goal.getScene().getWindow();

        String nameValue = name.getText();
        String usernameValue = username.getText();
        String emailValue = email.getText();
        String passwordValue = password.getText();
        LocalDate dateValue = date.getValue();
        Gender genderValue = gender.getValue();
        double bodyMassKg = UnitsConverter.poundsToKg(Double.parseDouble(weight.getText()));
        double heightCm = UnitsConverter.feetInchesToCm(Integer.parseInt(heightFt.getText()), Integer.parseInt(heightIns.getText()));
        Goal goalValue = goal.getValue();
        double weeklyGoalKg;


        if (loseWeight.getText().trim().isEmpty() && !gainWeight.getText().isEmpty()) {
            weeklyGoalKg = Double.parseDouble(gainWeight.getText());
        } else if (!loseWeight.getText().trim().isEmpty() && gainWeight.getText().isEmpty()) {
            weeklyGoalKg = Double.parseDouble(loseWeight.getText());
        } else {
            weeklyGoalKg = 0.0;
        }

        ActivityLevel activityLevelValue = activityLevel.getValue();
        User user = new User(nameValue, usernameValue, emailValue, passwordValue, dateValue, genderValue, bodyMassKg, heightCm, goalValue, weeklyGoalKg, activityLevelValue);
        UserService userService = new UserService();
        userService.addUserToDb(user);

        System.out.println(user.getWeeklyGoalKg());

        /** Redirect to the day scene */
        root = FXMLLoader.load(getClass().getResource("../views/day.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../../../resources/application_styles.css").toExternalForm());

        // show Day scene
        window.setScene(scene);
    }
    
    /**
     * Helper method
     * Handle Weekly Goal Interactive Pane
     */
    private void handleWeeklyGoal() {
        maintainWeight.setVisible(false);
        loseWeightContainer.setVisible(false);
        gainWeightContainer.setVisible(false);

        goal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Goal>() {
            @Override
            public void changed(ObservableValue<? extends Goal> observable, Goal oldValue, Goal newValue) {
                selectGoalFirst.setVisible(false);

                switch (newValue) {
                    case LOSE:
                        maintainWeight.setVisible(false);
                        gainWeightContainer.setVisible(false);
                        gainWeight.setText("");

                        loseWeight.setText("0.5");
                        loseWeightContainer.setVisible(true);
                        break;
                    case MAINTAIN:
                        loseWeightContainer.setVisible(false);
                        gainWeightContainer.setVisible(false);
                        maintainWeight.setVisible(true);
                        break;
                    case GAIN:
                        maintainWeight.setVisible(false);
                        loseWeightContainer.setVisible(false);
                        loseWeight.setText("");

                        gainWeight.setText("0.5");
                        gainWeightContainer.setVisible(true);
                        break;
                }
            }
        });
    }

}
