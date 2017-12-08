package com.cs56fitnessapp;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.SqLiteConnection;
import com.cs56fitnessapp.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class FitnessApplication extends Application {
    private static User user = null;
    // For now constant variable for User id
    private final static long USER_ID = 1;

    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            SqLiteConnection.getConnection();

            // Initialize tables
            SqLiteConnection.initialize();
            if (UserService.dbHasUser()) {
                // Initialize application user
                this.user = UserService.getUserById(USER_ID);
            }
            SqLiteConnection.closeConnection();

            if (user != null) {
                root = FXMLLoader.load(getClass().getResource("views/day.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("views/registerUser.fxml"));
            }

            scene = new Scene(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // This is a final message to the client
            // TODO create this as a pop up
            System.out.println("Something went wrong");
        }

        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Heebo:300,400,500,700,800,900|Righteous");
        scene.getStylesheets().add(getClass().getResource("../../resources/application_styles.css").toExternalForm());

        // show scene
        stage.setScene(scene);
        stage.show();

        // Uncomment to quickly reset db
        // resetApplication();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    private void resetApplication () {
        try {
            SqLiteConnection.getConnection();
            SqLiteConnection.resetDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUser() throws SQLException, ClassNotFoundException {
        if (user == null) {
            SqLiteConnection.getConnection();

            if (UserService.dbHasUser()) {
                // Initialize application user
                user = UserService.getUserById(USER_ID);
            }
            SqLiteConnection.closeConnection();
        }

        return user;
    }
}
