package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admin_controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		//Kevin
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void returnToLogin(ActionEvent event) throws IOException {
		//Kevin
		root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void editUser(ActionEvent event) throws IOException{
		//Kevin
		root = FXMLLoader.load(getClass().getResource("new_info.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
