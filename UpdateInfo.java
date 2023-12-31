package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateInfo {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button update;
	
	@FXML
	private Button returnTo;
	
	@FXML
	private Label message;
	
	@FXML
	private TextField username;

    @FXML
    private PasswordField password;
	
	
	
	
	public void backToAdmin(ActionEvent event) throws IOException {
		//Kevin
		root = FXMLLoader.load(getClass().getResource("admin_func.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void updateInfo(ActionEvent event) throws IOException {
		//Kevin
		username.clear();
        password.clear();
		
	}
}
