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


public class EffortLogEditorController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private ChoiceBox<String> choice_editor;
	
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void loadChoices() {
		choice_editor.getItems().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	choice_editor.getItems().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
