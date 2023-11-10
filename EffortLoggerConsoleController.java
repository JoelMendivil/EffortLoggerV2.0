package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class EffortLoggerConsoleController {
	
	@FXML
	private Rectangle ClockLabelRectangle;//sriram 
	@FXML
	private Label ClockLabel;//sriram
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private ChoiceBox<String> projectChoiceBox;
	
	public void switchtoEffortLogEditor(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortLogEditor.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoDefectLogConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefectLogConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoDefinitions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Definitions.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoEffortandDefectLogs(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortandDefectLogs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoPlanningPoker(ActionEvent event) throws IOException { //Added by Joel
		root = FXMLLoader.load(getClass().getResource("PlanningPoker.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	void start(ActionEvent event) throws IOException{//written by sriram
		ClockLabelRectangle.setFill(Color.GREEN);//changes the clock is stopped label to green 
		ClockLabel.setText("Clock is Running");//and the text is changed to the clock is running  
					//when the start the activity button is pressed.
	}
	@FXML
	void stop(ActionEvent event) throws IOException{
		ClockLabelRectangle.setFill(Color.RED);//changes the clock is stopped label to red 
		ClockLabel.setText("Clock is Stopped");//and the text is changed to the clock is stopped  
		//when the stop the activity button is pressed.
	}
}
