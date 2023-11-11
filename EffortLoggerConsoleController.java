package application;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class EffortLoggerConsoleController {
	
	@FXML
	private Rectangle ClockLabelRectangle;
	@FXML
	private Label ClockLabel;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ChoiceBox<String> project;

	@FXML
	private ChoiceBox<String> lifecycle;
	@FXML
	private ChoiceBox<String> effortcategory;
	
	private LocalTime startTime;
	private LocalTime stopTime;
	   
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	int i=1;
	
    @FXML
    public void initialize() {
    	project.getItems().addAll("P 1", "P 2", "P 3");
    	lifecycle.getItems().addAll("L 1","L 2","L 3");
    	effortcategory.getItems().addAll("E 1","E 2","E 3");
    }
	
	public void switchtoEffortLogEditor(ActionEvent event) throws IOException {
		// Load the second FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
        Parent secondRoot = loader.load();

        // Get the controller of the second FXML and call the method to load choices
        EffortLogEditorController secondController = loader.getController();
        secondController.loadChoices();

        // Switch to the second scene
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene secondScene = new Scene(secondRoot);
        stage.setScene(secondScene);
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
	@FXML
	void start(ActionEvent event) throws IOException{//done by sriram
		ClockLabelRectangle.setFill(Color.GREEN);//changes the clock is stopped label to green 
		ClockLabel.setText("Clock is Running");//and the text is changed to the clock is running  
					//when the start the activity button is pressed.
		startTime = LocalTime.now();
	}
	@FXML
	void stop(ActionEvent event) throws IOException{
		ClockLabelRectangle.setFill(Color.RED);//changes the clock is stopped label to red 
		ClockLabel.setText("Clock is Stopped");//and the text is changed to the clock is stopped  
		//when the stop the activity button is pressed.
		// Write to file, append mode
		stopTime = LocalTime.now();
		String selected = (i) +". "+LocalDate.now().toString() +" (" + startTime.format(formatter) + "-" + stopTime.format(formatter)+")"+ project.getValue()+";"+lifecycle.getValue()+";"+effortcategory.getValue();
		i= i+1;
        try (PrintWriter out = new PrintWriter(new FileWriter("out.txt", true))) {
            out.println(selected);
        }
		}

}


