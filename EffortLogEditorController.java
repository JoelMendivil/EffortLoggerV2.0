package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class EffortLogEditorController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private ChoiceBox<String> choice_editor;
	
	@FXML
    private ChoiceBox<String> delete_log;
	
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void loadChoices() {
	
		choice_editor.getItems().clear();
		//delete_log.getItems().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	choice_editor.getItems().add(line);
            	//delete_log.getItems().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void loadChoices2() {
		
		delete_log.getItems().clear();
		//delete_log.getItems().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	delete_log.getItems().add(line);
            	//delete_log.getItems().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@FXML
    private void removeSelectedItem(ActionEvent event) {
       
		 String selectedItem = delete_log.getSelectionModel().getSelectedItem();
		    if (selectedItem != null) {
		        // Read the current choices from the file, remove the selected item, and write back
		        updateFileContents("out.txt", selectedItem);
		    }
		    String selectedItem1 = delete_log.getValue();
       
        if (selectedItem1 != null) {
            choice_editor.getItems().remove(selectedItem1);
        	delete_log.getItems().remove(selectedItem1);
        	delete_log.setStyle(" ");
        	choice_editor.setStyle(" ");
        }
    }
	private void updateFileContents(String fileName, String itemToRemove) {
	    try {
	        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
	        lines.removeIf(line -> line.contains(itemToRemove)); // Remove the selected item
	        Files.write(Paths.get(fileName), lines); // Write the updated list back to the file
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
