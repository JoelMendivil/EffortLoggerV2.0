package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Login App");
        primaryStage.setScene(new Scene(root,600,500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
