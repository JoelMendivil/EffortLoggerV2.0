package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
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
	@FXML
	private ChoiceBox<String> deliverable;
	
	private LocalTime startTime;
	private LocalTime stopTime;
	   
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	
    @FXML
    public void initialize() {
        // Load data from file and populate the ChoiceBox
        loadDataFromFile("projectFiles.txt", project);
        loadDataFromFile("LifeCycleFiles.txt", lifecycle);
        loadDataFromFile("effortCategoryFiles.txt", effortcategory);
        //loadDataFromFile("deliverableFiles.txt", deliverable);

        // Add a listener to the effortcategory choice box
        effortcategory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the deliverable choice box
            deliverable.getItems().clear();

            // Check the selected value and populate the deliverable choice box based on it
            if ("Plans".equals(newValue)) {
                // Load data from a specific file or add specific items
                // For demonstration, just adding a single item
            	loadDataFromFile("planFiles.txt", deliverable);
            } else if ("Deliverables".equals(newValue)) {
                // Add different items or load from a different file
            	loadDataFromFile("deliverableFiles.txt", deliverable);
            } else if("Interruptions".equals(newValue)) {
            	loadDataFromFile("interruptionFiles.txt", deliverable);
            } else if("Defects".equals(newValue)) {
            	loadDataFromFile("defectCategoryFiles.txt", deliverable);
            }
            
        });
    }
	
	public void switchtoEffortLogEditor(ActionEvent event) throws IOException {
		// Load the second FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
        Parent secondRoot = loader.load();

        // Get the controller of the second FXML and call the method to load choices
        EffortLogEditorController secondController = loader.getController();
        secondController.loadChoices();
        secondController.loadChoices2();

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortandDefectLogs.fxml"));
        Parent secondRoot = loader.load();

        // Get the controller of the second FXML and call the method to load choices
        effectdefectlogs secondController2 = loader.getController();
        secondController2.newchoices();

        // Switch to the second scene
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene secondScene = new Scene(secondRoot);
        stage.setScene(secondScene);
        stage.show();
	}
	public void switchtoPlanningPoker(ActionEvent event) throws IOException { //Added by Joel
		root = FXMLLoader.load(getClass().getResource("PlanningPoker.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	 //Done by Sri Ram Reddy
	public void switchtoLogout(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("logout.fxml"));
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
		stopTime = LocalTime.now(); //clock cycle
		String selected = LocalDate.now().toString() +" (" + startTime.format(formatter) + "-" + stopTime.format(formatter)+")"+ project.getValue()+";"+lifecycle.getValue()+";"+effortcategory.getValue();
        try (PrintWriter out = new PrintWriter(new FileWriter("out.txt", true))) {
            out.println(selected);
        }
		}

	//Joel
	private void loadDataFromFile(String fileName, ChoiceBox<String> choiceBox) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split("\\|");
	            if (parts.length > 1) { // Check if there are at least two '|' characters
	                String dataToDisplay = parts[1].trim(); // Extract the data between the first and second '|'
	                choiceBox.getItems().add(dataToDisplay);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}


