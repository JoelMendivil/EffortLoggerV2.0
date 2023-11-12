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
		    loadDataFromFile("deliverableFiles.txt", deliverable);
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
		    	choiceBox.getItems().add(line);
		    }
		} catch (IOException e) {
		        e.printStackTrace();
		  }
	}
	
}
