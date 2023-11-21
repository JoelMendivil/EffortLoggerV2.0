package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EffortLogEditorController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private ChoiceBox<String> choice_editor;
	
	@FXML
    private ChoiceBox<String> delete_log;
	
	@FXML
	private ChoiceBox<String> project ;

	@FXML
	private ChoiceBox<String> lifecycle;
	@FXML
	private ChoiceBox<String> effortcategory;
	@FXML
	private ChoiceBox<String> deliverable;
	
	@FXML 
	private Label finished;
	
	@FXML
	private Button delete;
	
	@FXML
	private TextField date;
	
	@FXML
	private TextField startTime;
	
	@FXML
	private TextField stopTime;
	
	@FXML
	private String newEntry;
	
	@FXML
	private LocalTime stopTime2;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public String midNight = "00:00:00";
	
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
        try (BufferedReader br = new BufferedReader(new FileReader("src/application/projectFiles.txt"))) {
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
    public void removeSelectedItem(ActionEvent event) {
        String selectedItem = delete_log.getValue().toString();
       
        if (selectedItem != null) {
            choice_editor.getItems().remove(selectedItem); 
        	choice_editor.setStyle(" ");
        }
        
    }
	@FXML
	public void updateTime(ActionEvent event)throws IOException {
		String del = choice_editor.getValue().toString();
		//Kevin
				String selected = LocalDate.now().toString() +" (" + (startTime.getText().toString()) + "-" + (stopTime.getText().toString())+")"+ "null" +";"+ "null" +";"+ "null";
		        try (PrintWriter out = new PrintWriter(new FileWriter("out.txt", true))) {
		            out.println(selected);
			}
		    finished.setText("These attributes have been saved.");
		    removePrev("out.txt", del);
		    System.out.println(del);
	}
	
	@FXML
	public void splitLog(ActionEvent event)throws IOException {
		String del = choice_editor.getValue().toString();
		String ss = date.getText().toString();
		stopTime2 = LocalTime.now();
		//Kevin
		String selected =  ss +" (" + (startTime.getText().toString()) + "-" + (midNight)+")"+ "null" +";"+ "null" +";"+ "null";
	    try (PrintWriter out = new PrintWriter(new FileWriter("out.txt", true))) {
        	out.println(selected);
	   }
	    
	    String selected_ =  ss +" (" + (midNight) + "-" + stopTime2.format(formatter)+")"+ "null" +";"+ "null" +";"+ "null";
	    try (PrintWriter out = new PrintWriter(new FileWriter("out.txt", true))) {
        	out.println(selected_);
	   }
	    finished.setText("These. attributes have been saved.");
	    removePrev("out.txt", del);
	    System.out.println(del);
	}
	
	
	
	//written by kevin cabrera to update time stamps on entries and help split logs
	public void removePrev(String fileName, String delV ){
		String tempFile = "temp.txt";
		File oldFile = new File(fileName);
		File newFile = new File(tempFile);
		
		String currentLine;
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null) {
				if(!((currentLine.toString()).equals(delV))) {
					pw.println(currentLine);
					// searches for the desired entry to delete
					// writes everything but that line
				}
			}
			
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.deleteOnExit();
			File dump = new File("effort_Logger_V2/out.txt");
			newFile.renameTo(dump);
			//rename temp to out
		}
		catch(Exception e) {
			System.out.println(e);
			//exception handle
		}
	}
}