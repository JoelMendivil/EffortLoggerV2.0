package application;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class effectdefectlogs {
	@FXML
	private TextFlow lags;
	public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
		Object root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene((Parent) root);
		stage.setScene(scene);
		stage.show();
	}
	public void newchoices(){
        try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Text node = new Text(line + "\n"); // Create a new Text node for each line
                lags.getChildren().add(node); // Add the new node to the TextFlow
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}