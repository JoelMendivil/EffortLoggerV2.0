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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class PlanningPokerConsole {

	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML //Joel
	private ChoiceBox<String> project;

	@FXML
	private ChoiceBox<String> lifecycle;
	@FXML
	private ChoiceBox<String> effortcategory;
	@FXML
	private ChoiceBox<String> deliverable;
	
	//Added by Joel
	@FXML
    public void initialize() {
        // Load data from file and populate the ChoiceBox
        loadDataFromFile("projectFiles.txt", project);
        loadDataFromFile("LifeCycleFiles.txt", lifecycle);
        loadDataFromFile("effortCategoryFiles.txt", effortcategory);
        //loadDataFromFile("deliverableFiles.txt", deliverable);

        // Add a listener to the Effort Category choice box
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
	
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
		
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
