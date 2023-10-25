package application;

import java.io.IOException;
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


		
		projectTable.setItems(getProjects());
		projectTable.setEditable(true); //Table is now editable
		
		//Opens up a text field for the project column when double-clicked on
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		step1Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step2Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step3Column.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	//Creates a list of projects with values to be initialized to a table
	public ObservableList<Project> getProjects(){
		ObservableList<Project> projects = FXCollections.observableArrayList();
		projects.add(new Project("1", "Business Project", "10", "9", "8"));
		projects.add(new Project("2", "Development Project", "2", "4", "6"));
		projects.add(new Project("3", "Project3", "1", "3", "5"));
		
		return projects;
	}
	
	//For editing the name column on the project table
	public void changeProjectNameCellEvent(CellEditEvent editedCell) {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setName(editedCell.getNewValue().toString());
	}
	
	//For editing the step1 column on the project table
	public void changeProjectStep1CellEvent(CellEditEvent editedCell) {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep1(editedCell.getNewValue().toString());
	}
	
	//For editing the step1 column on the project table
	public void changeProjectStep2CellEvent(CellEditEvent editedCell) {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep2(editedCell.getNewValue().toString());
	}
	
	//For editing the step1 column on the project table
	public void changeProjectStep3CellEvent(CellEditEvent editedCell) {
		Project projectSelected = projectTable.getSelectionModel().getSelectedItem();
		
		//Captures the new value typed in the column cell
		projectSelected.setStep3(editedCell.getNewValue().toString());
	}
	
	//Switches scenes to the EffortLogger Console main page
		public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
