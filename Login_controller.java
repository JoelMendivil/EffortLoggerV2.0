package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_controller {
	@FXML 
	private Stage stage;
	private Scene scene;
	private Parent root;
	int ad, em;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	RadioButton admin;
	@FXML
	RadioButton emp;
	@FXML
	Label invalid_log;
	
	
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		
		if (username.getText().toString().equals("admin99") && password.getText().toString().equals("pw123") && ad == 1) {
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		
		if (username.getText().toString().equals("newEMP") && password.getText().toString().equals("pw123")  && em == 1) {
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		
	}
	
	
	public void ad_log(ActionEvent event) throws IOException {
		ad = 1;
	}
	
	public void em_log(ActionEvent event) throws IOException {
		 em = 1;
	}
	
}