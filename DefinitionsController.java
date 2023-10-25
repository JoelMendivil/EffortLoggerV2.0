package application;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class DefinitionsController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Project[] projectArray = new Project[10];
	
	//Buffered Reader and Writer for reading/writing files
	BufferedReader br;
	BufferedWriter bw;
	
	//Create all the tables
	@FXML private TableView<Project> projectTable;
	
	//Creates all the columns in the Project Table
	@FXML private TableColumn<Project, String> numberColumn;
	@FXML private TableColumn<Project, String> nameColumn;
	@FXML private TableColumn<Project, String> step1Column;
	@FXML private TableColumn<Project, String> step2Column;
	@FXML private TableColumn<Project, String> step3Column;
	
	//Initialize all the values within the tables on launch 
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//All columns for the project table
		numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		step1Column.setCellValueFactory(cellData -> cellData.getValue().step1Property());
		step2Column.setCellValueFactory(cellData -> cellData.getValue().step2Property());
		step3Column.setCellValueFactory(cellData -> cellData.getValue().step3Property());


		
		try {
			projectTable.setItems(loadProjects());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		projectTable.setEditable(true); //Table is now editable
		
		//Opens up a text field for the project column when double-clicked on
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		step1Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step2Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step3Column.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	//Creates a list of projects with values to be initialized to a table
	public ObservableList<Project> loadProjects() throws IOException{
		
		//List of Projects
		ObservableList<Project> projects = FXCollections.observableArrayList();
		
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("projectFiles.txt"));
		
		String line;
		int i = 0;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			projectArray[i] = new Project(params[0], params[1], params[2], params[3], params[4]);
			projects.add(projectArray[i]);
			i++;
		}
		
		br.close();
				
		return projects;
	}
	
	//For editing the name column on the project table
	public void changeProjectNameCellEvent(CellEditEvent editedCell) throws IOException {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setName(editedCell.getNewValue().toString());
		
		//Changes the real project object value for later
		for (int i = 0; i < projectArray.length; i++) {
			if (projectArray[i].getName().equals(projectSelected.getName())) {
				projectArray[i].setName(editedCell.getNewValue().toString());
			}
		}
		saveProjects();
		
	}
	
	//For editing the step1 column on the project table
	public void changeProjectStep1CellEvent(CellEditEvent editedCell) throws IOException {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep1(editedCell.getNewValue().toString());
		
		for (int i = 0; i < projectArray.length; i++) {
			if (projectArray[i].getStep1().equals(projectSelected.getName())) {
				projectArray[i].setStep1(editedCell.getNewValue().toString());
			}
		}
		saveProjects();
	}
	
	//For editing the step2 column on the project table
	public void changeProjectStep2CellEvent(CellEditEvent editedCell) throws IOException {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep2(editedCell.getNewValue().toString());
		
		for (int i = 0; i < projectArray.length; i++) {
			if (projectArray[i].getStep2().equals(projectSelected.getName())) {
				projectArray[i].setStep2(editedCell.getNewValue().toString());
			}
		}
		saveProjects();
	}
	
	//For editing the step3 column on the project table
	public void changeProjectStep3CellEvent(CellEditEvent editedCell) throws IOException {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep3(editedCell.getNewValue().toString());
		
		for (int i = 0; i < projectArray.length; i++) {
			if (projectArray[i].getStep3().equals(projectSelected.getName())) {
				projectArray[i].setStep3(editedCell.getNewValue().toString());
			}
		}
		saveProjects();
	}
	
	//Switches scenes to the EffortLogger Console main page
		public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			saveProjects();
		}
		
		//Saves the changes to the projects table to projectFiles.txt
		public void saveProjects() throws IOException {
			bw = new BufferedWriter(new FileWriter("projectFiles.txt"));
			
					for (int i = 0; i < projectArray.length; i++) {
						bw.write(projectArray[i].toString());
					}
			
					bw.close();
		}
		
}
