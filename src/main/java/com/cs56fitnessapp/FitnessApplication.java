package com.cs56fitnessapp;
import com.cs56fitnessapp.models.User;
import com.cs56fitnessapp.services.SqLiteConnection;
import com.cs56fitnessapp.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FitnessApplication extends Application {
    User user = null;
    Parent root;
    Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            sqLite.getConnection();

            // Initialize tables
            sqLite.initialize();
            if (UserService.dbHasUser()) {
                // Initialize application user
               this.user = UserService.getUserFromDb();
            }
            sqLite.closeConnection();

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
        resetApplication();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    private void resetApplication () {
        try {
            SqLiteConnection sqLite = new SqLiteConnection();
            sqLite.resetDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
