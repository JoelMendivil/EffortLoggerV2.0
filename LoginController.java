package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;
   

    public void loginButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidCredentials(username, password)) {
        	messageLabel.setLayoutX(245);
        	messageLabel.setLayoutY(150);
        	messageLabel.setText("Login Successful");
        		Object root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
        		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        		Scene scene = new Scene((Parent) root);
        		stage.setScene(scene);
        		stage.show();
        } else {
        	messageLabel.setLayoutX(245);
        	messageLabel.setLayoutY(150);
        	messageLabel.setText("Invalid Credentials");
            usernameField.clear();
            passwordField.clear();
        }
    }

    public void registerButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("credentials.txt", true))) {
                writer.println(username + ":" + password);
                writer.flush();
                messageLabel.setLayoutX(230);
            	messageLabel.setLayoutY(150);
                messageLabel.setText("Registration Successful");
                usernameField.clear();
                passwordField.clear();
            } catch (IOException e) {
                e.printStackTrace();
                messageLabel.setText("Error registering credentials");
            }
        } else {
        	messageLabel.setLayoutX(200);
        	messageLabel.setLayoutY(150);
        	messageLabel.setText("Please enter a username and password");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("credentials.txt"));
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
