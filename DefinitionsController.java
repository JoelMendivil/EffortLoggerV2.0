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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class DefinitionsController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Project[] projectArray = new Project[10];
	private LifeCycle[] lifeCycleArray = new LifeCycle[30];
	private EffortCategory[] effortCategoryArray = new EffortCategory[5];
	private Plan[] planArray = new Plan[10];
	private Deliverable[] deliverableArray = new Deliverable[10];
	private Interruption[] interruptionArray = new Interruption[10];
	private DefectCategory[] defectCategoryArray = new DefectCategory[15];
	
	//Buffered Reader and Writer for reading/writing files
	BufferedReader br;
	BufferedWriter bw;
	
	//Create all the tables
	@FXML private TableView<Project> projectTable;
	@FXML private TableView<LifeCycle> lifeCycleTable;
	@FXML private TableView<EffortCategory> effortCategoryTable;
	@FXML private TableView<Plan> planTable;
	@FXML private TableView<Deliverable> deliverableTable;
	@FXML private TableView<Interruption> interruptionTable;
	@FXML private TableView<DefectCategory> defectCategoryTable;
	
	
	//Creates all the columns in the Project Table
	@FXML private TableColumn<Project, String> numberColumn = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> nameColumn = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step1Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step2Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step3Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step4Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step5Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step6Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step7Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step8Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step9Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step10Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step11Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step12Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step13Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step14Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step15Column = new TableColumn<Project, String>("");
	@FXML private TableColumn<Project, String> step16Column = new TableColumn<Project, String>("");
	
	//Creates all the columns in the Life Cycle Table
	@FXML private TableColumn<LifeCycle, String> indexColumn = new TableColumn<LifeCycle, String>("");
	@FXML private TableColumn<LifeCycle, String> lifeCycleNameColumn = new TableColumn<LifeCycle, String>("");
	@FXML private TableColumn<LifeCycle, String> effortCategoryColumn = new TableColumn<LifeCycle, String>("");
	@FXML private TableColumn<LifeCycle, String> deliverableColumn = new TableColumn<LifeCycle, String>("");
	
	//Creates all the columns in the Effort Category Table
	@FXML private TableColumn<EffortCategory, String> ECIndexColumn = new TableColumn<EffortCategory, String>("");
	@FXML private TableColumn<EffortCategory, String> effortCategoryNameColumn = new TableColumn<EffortCategory, String>("");
	
	//Creates all the columns in the Plan Table
	@FXML private TableColumn<Plan, String> planIndexColumn = new TableColumn<Plan, String>("");
	@FXML private TableColumn<Plan, String> planNameColumn = new TableColumn<Plan, String>("");
	
	//Creates all the columns in the Deliverable Table
	@FXML private TableColumn<Deliverable, String> deliverableIndexColumn = new TableColumn<Deliverable, String>("");
	@FXML private TableColumn<Deliverable, String> deliverableNameColumn = new TableColumn<Deliverable, String>("");
	
	//Creates all the columns in the Interruption Table
	@FXML private TableColumn<Interruption, String> interruptionIndexColumn = new TableColumn<Interruption, String>("");
	@FXML private TableColumn<Interruption, String> interruptionNameColumn = new TableColumn<Interruption, String>("");
	
	//Creates all the columns in the Defect Category Table
	@FXML private TableColumn<DefectCategory, String> defectCategoryIndexColumn = new TableColumn<DefectCategory, String>("");
	@FXML private TableColumn<DefectCategory, String> defectCategoryNameColumn = new TableColumn<DefectCategory, String>("");
	
	//Initialize all the values within the tables on launch 
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//All columns for the project table
		numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		step1Column.setCellValueFactory(cellData -> cellData.getValue().step1Property());
		step2Column.setCellValueFactory(cellData -> cellData.getValue().step2Property());
		step3Column.setCellValueFactory(cellData -> cellData.getValue().step3Property());
		step4Column.setCellValueFactory(cellData -> cellData.getValue().step4Property());
		step5Column.setCellValueFactory(cellData -> cellData.getValue().step5Property());
		step6Column.setCellValueFactory(cellData -> cellData.getValue().step6Property());
		step7Column.setCellValueFactory(cellData -> cellData.getValue().step7Property());
		step8Column.setCellValueFactory(cellData -> cellData.getValue().step8Property());
		step9Column.setCellValueFactory(cellData -> cellData.getValue().step9Property());
		step10Column.setCellValueFactory(cellData -> cellData.getValue().step10Property());
		step11Column.setCellValueFactory(cellData -> cellData.getValue().step11Property());
		step12Column.setCellValueFactory(cellData -> cellData.getValue().step12Property());
		step13Column.setCellValueFactory(cellData -> cellData.getValue().step13Property());
		step14Column.setCellValueFactory(cellData -> cellData.getValue().step14Property());
		step15Column.setCellValueFactory(cellData -> cellData.getValue().step15Property());
		step16Column.setCellValueFactory(cellData -> cellData.getValue().step16Property());
		
		//All columns for the Life Cycle Table
		indexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		lifeCycleNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		effortCategoryColumn.setCellValueFactory(cellData -> cellData.getValue().effortCategoryProperty());
		deliverableColumn.setCellValueFactory(cellData -> cellData.getValue().deliverableProperty());
		
		//All columns for the Effort Category Table
		ECIndexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		effortCategoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		//All columns for the Plan Table
		planIndexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		planNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		//All columns for the Deliverable Table
		deliverableIndexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		deliverableNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		//All columns for the Interruption Table
		interruptionIndexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		interruptionNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		//All columns for the Defect Category Table
		defectCategoryIndexColumn.setCellValueFactory(cellData -> cellData.getValue().indexProperty());
		defectCategoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

		
		//Load table information from text files
		try {
			projectTable.setItems(loadProjects());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lifeCycleTable.setItems(loadLifeCycles());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			effortCategoryTable.setItems(loadEffortCategories());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			planTable.setItems(loadPlans());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			deliverableTable.setItems(loadDeliverables());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			interruptionTable.setItems(loadInterruptions());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			defectCategoryTable.setItems(loadDefectCategories());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Make all tables editable
		projectTable.setEditable(true); //Table is now editable
		lifeCycleTable.setEditable(true);
		effortCategoryTable.setEditable(true);
	    planTable.setEditable(true);
	    deliverableTable.setEditable(true);
	    interruptionTable.setEditable(true);
	    defectCategoryTable.setEditable(true);
		
		//Opens up a text field for the project table columns when double-clicked on
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		step1Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step2Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step3Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step4Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step5Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step6Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step7Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step8Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step9Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step10Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step11Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step12Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step13Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step14Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step15Column.setCellFactory(TextFieldTableCell.forTableColumn());
		step16Column.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for Life Cycle columns
		lifeCycleNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		effortCategoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		deliverableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for the Effort Category columns
		effortCategoryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for the Plan columns
		planNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for the Deliverable columns
		deliverableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for the Interruption columns
		interruptionNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Text field functionality for the Defect Category columns
		defectCategoryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	//Creates a list of project objects with values to be initialized to a table
	public ObservableList<Project> loadProjects() throws IOException{
		
		//List of Projects
		ObservableList<Project> projects = FXCollections.observableArrayList();
		
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("projectFiles.txt"));
		
		String line;
		int i = 0;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			
			String[] newParams = new String[18];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			
			projectArray[i] = new Project(newParams[0], newParams[1], newParams[2], newParams[3], newParams[4], newParams[5], newParams[6],
					                      newParams[7], newParams[8], newParams[9], newParams[10], newParams[11], newParams[12], newParams[13],
					                      newParams[14], newParams[15], newParams[16], newParams[17]);
			projects.add(projectArray[i]);
			i++;
		}
		
		br.close();
				
		return projects;
	}
	
	//Creates a list of LifeCycle Objects with values to be initialized to a table
	public ObservableList<LifeCycle> loadLifeCycles() throws IOException{
		
		//List of life cycles
		ObservableList<LifeCycle> lifeCycles = FXCollections.observableArrayList();
		
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("LifeCycleFiles.txt"));
		
		String line;
		int i = 0;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[4];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			lifeCycleArray[i] = new LifeCycle(newParams[0], newParams[1], newParams[2], newParams[3]);
			lifeCycles.add(lifeCycleArray[i]);
			i++;
		}
		
		br.close();
				
		return lifeCycles;
	}
	
	//Creates a list of Effort Category Objects with values to be initialized to a table
	public ObservableList<EffortCategory> loadEffortCategories() throws IOException{
			
		//List of life cycles
		ObservableList<EffortCategory> effortCategories = FXCollections.observableArrayList();
			
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("effortCategoryFiles.txt"));
			
		String line;
		int i = 0;
			
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[2];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			effortCategoryArray[i] = new EffortCategory(newParams[0], newParams[1]);
			effortCategories.add(effortCategoryArray[i]);
			i++;
		}
			
		br.close();
					
		return effortCategories;
	}
	
	//Creates a list of Plan Objects with values to be initialized to a table
	public ObservableList<Plan> loadPlans() throws IOException{
				
		//List of life cycles
		ObservableList<Plan> plans = FXCollections.observableArrayList();
				
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("planFiles.txt"));
				
		String line;
		int i = 0;
				
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[2];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			planArray[i] = new Plan(newParams[0], newParams[1]);
			plans.add(planArray[i]);
			i++;
		}
				
		br.close();
						
		return plans;
	}
	
	//Creates a list of Deliverable Objects with values to be initialized to a table
	public ObservableList<Deliverable> loadDeliverables() throws IOException{
					
		//List of life cycles
		ObservableList<Deliverable> deliverables = FXCollections.observableArrayList();
					
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("deliverableFiles.txt"));
					
		String line;
		int i = 0;
					
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[2];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			deliverableArray[i] = new Deliverable(newParams[0], newParams[1]);
			deliverables.add(deliverableArray[i]);
			i++;
		}
					
		br.close();
							
		return deliverables;
	}
	
	//Creates a list of Interruption Objects with values to be initialized to a table
	public ObservableList<Interruption> loadInterruptions() throws IOException{
						
		//List of life cycles
		ObservableList<Interruption> interruptions = FXCollections.observableArrayList();
						
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("interruptionFiles.txt"));
						
		String line;
		int i = 0;
						
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[2];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			interruptionArray[i] = new Interruption(newParams[0], newParams[1]);
			interruptions.add(interruptionArray[i]);
			i++;
		}
						
		br.close();
								
		return interruptions;
	}
	
	//Creates a list of Defect Category Objects with values to be initialized to a table
	public ObservableList<DefectCategory> loadDefectCategories() throws IOException{
							
		//List of life cycles
		ObservableList<DefectCategory> defectCategories = FXCollections.observableArrayList();
							
		//Read from projectFiles.txt
		br = new BufferedReader(new FileReader("defectCategoryFiles.txt"));
							
		String line;
		int i = 0;
							
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\|");
			String[] newParams = new String[2];
			
			for (int j = 0; j < params.length; j++) {
				newParams[j] = params[j];
			}
			for (int j = params.length; j < newParams.length; j++) {
				newParams[j] = " ";
			}
			defectCategoryArray[i] = new DefectCategory(newParams[0], newParams[1]);
			defectCategories.add(defectCategoryArray[i]);
			i++;
		}
							
		br.close();
									
		return defectCategories;
	}
	
	//Switches scenes to the EffortLogger Console main page
		public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			//saveProjects();
		}
		
		//Saves the changes to the projects table to projectFiles.txt
		public void saveChanges(ActionEvent event) throws IOException {
			//Save project table changes
			bw = new BufferedWriter(new FileWriter("projectFiles.txt"));
			
			for (int i = 0; i < projectArray.length; i++) {
				
				bw.write(projectArray[i].toString());
			}
			
			bw.close();
					
			//Save life cycle table changes
			bw = new BufferedWriter(new FileWriter("LifeCycleFiles.txt"));
			
			for (int i = 0; i < lifeCycleArray.length; i++) {
				bw.write(lifeCycleArray[i].toString());
			}
			
			bw.close();
			
			//save effort category table changes
			bw = new BufferedWriter(new FileWriter("effortCategoryFiles.txt"));
			
			for (int i = 0; i < effortCategoryArray.length; i++) {
				bw.write(effortCategoryArray[i].toString());
			}
			
			bw.close();
			
			//save plan table changes
			bw = new BufferedWriter(new FileWriter("planFiles.txt"));
			
			for (int i = 0; i < planArray.length; i++) {
				bw.write(planArray[i].toString());
			}
			
			bw.close();
			
			//save deliverable table changes
			bw = new BufferedWriter(new FileWriter("deliverableFiles.txt"));
			
			for (int i = 0; i < deliverableArray.length; i++) {
				bw.write(deliverableArray[i].toString());
			}
			
			bw.close();
			
			//save interruption table changes
			bw = new BufferedWriter(new FileWriter("interruptionFiles.txt"));
			
			for (int i = 0; i < interruptionArray.length; i++) {
				bw.write(interruptionArray[i].toString());
			}
			
			bw.close();
			
			//save defect category table changes
			bw = new BufferedWriter(new FileWriter("defectCategoryFiles.txt"));
			
			for (int i = 0; i < defectCategoryArray.length; i++) {
				bw.write(defectCategoryArray[i].toString());
			}
			
			bw.close();
			
			root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
		}
		
}
