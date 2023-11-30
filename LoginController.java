package application;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginController {
		
		int em =0, adm =0;

	    @FXML
	    private TextField usernameField;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private Label messageLabel;
	    
	    @FXML
	    private RadioButton admin;
	    
	    @FXML
	    private RadioButton employee;
	    
	    @FXML
		private PasswordField logout_password;
	    
	    @FXML
	    private Label message_logout;
	    //Done by Sri Ram Reddy
	    public void loginButtonAction(ActionEvent event) throws IOException {
	    	
	    	 if (em == 1 && adm == 0) {
	        String username = usernameField.getText();
	        String password = passwordField.getText();
	        if (username.isEmpty()&&password.isEmpty()) {
	        	messageLabel.setText("Both fields are empty");
	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;"); // Set the background color (optional)
	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        }
	        else if(username.isEmpty())
	        {
	        	messageLabel.setText("username field is empty");
	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        }      
	        else if(password.isEmpty()) {
	        	messageLabel.setText("password field is empty");
	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        }
	        else {
	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;"); 
	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        if(username.length()<17&&password.length()<10) {
	        if (isValidCredentials(username, password)) {
	        	messageLabel.setText("Login Successful");
	        		Object root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
	        		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		Scene scene = new Scene((Parent) root);
	        		stage.setScene(scene);
	        		stage.show();
	        } else {
	        	messageLabel.setText("Invalid Credentials");
	            usernameField.clear();
	            passwordField.clear();
	        }}else {
	        	usernameField.clear();
	            passwordField.clear();
	        	messageLabel.setText("Please make sure your credentials follow the guidelines");
	        } }
	        
	    	 }
	    	 else if(adm == 1 && em ==0) {
	    		 String username = usernameField.getText();
	 	        String password = passwordField.getText();
	 	        if (username.isEmpty()&&password.isEmpty()) {
	 	        	messageLabel.setText("Both fields are empty");
	 	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;"); // Set the background color (optional)
	 	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	 	        }
	 	        else if(username.isEmpty())
	 	        {
	 	        	messageLabel.setText("username field is empty");
	 	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	 	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	 	        }      
	 	        else if(password.isEmpty()) {
	 	        	messageLabel.setText("password field is empty");
	 	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	 	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	 	        }
	 	        else {
	 	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;"); 
	 	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	 	        if(username.length()<17&&password.length()<10) {
	 	        if (isValidCredentials(username, password)) {
	 	        	messageLabel.setText("Login Successful");
	 	        		Object root = FXMLLoader.load(getClass().getResource("Admin_func.fxml"));
	 	        		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 	        		Scene scene = new Scene((Parent) root);
	 	        		stage.setScene(scene);
	 	        		stage.show();
	 	        } else {
	 	        	messageLabel.setText("Invalid Credentials");
	 	            usernameField.clear();
	 	            passwordField.clear();
	 	        }}else {
	 	        	usernameField.clear();
	 	            passwordField.clear();
	 	        	messageLabel.setText("Please make sure your credentials follow the guidelines");
	 	        } }
	    	 }
	    }
	    //Done by Sri Ram Reddy
	    public void registerButtonAction() {
	        String username = usernameField.getText();
	        String password = passwordField.getText();
	        if (username.isEmpty()&&password.isEmpty()) {
	        	messageLabel.setText("Both fields are empty");
	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;"); // Set the background color (optional)
	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        }
	        else if(username.isEmpty())
	        {
	        	messageLabel.setText("username field is empty");
	        	usernameField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        }      
	        else if(password.isEmpty()) {
	        	messageLabel.setText("password field is empty");
	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        	passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        }else {
	        	usernameField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        	passwordField.setStyle("-fx-border-color: white; -fx-border-width: 0px;");
	        if(username.length()<17 || password.length()<10) {
	        if (!username.isEmpty() && !password.isEmpty()) {
	            try (PrintWriter writer = new PrintWriter(new FileWriter("credentials.txt", true))) {
	                writer.println(username + ":" + password);
	                writer.flush();
	                messageLabel.setText("Registration Successful");
	                usernameField.clear();
	                passwordField.clear();
	            } catch (IOException e) {
	                e.printStackTrace();
	                messageLabel.setText("Error registering credentials");
	            }
	        } else {
	        	messageLabel.setText("Please enter a username and password");
	        }}else {
	        	messageLabel.setText("Please make sure your credentials follow the guidelines");
	        }}
	    }
	    //Done by Sri Ram Reddy
	    private boolean isValidCredentials(String username, String password) {//takes username and password as an arguement.(true of false function)
	        try {
	            List<String> lines = Files.readAllLines(Paths.get("credentials.txt"));//makes an array of credentials from credentials.txt
	            for (String line : lines) {
	                String[] parts = line.split(":");//splits the username and password into 2 parts
	                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {//checks if the entered password matches with the password in the
	                	// credentials.txt and checks the obtained text from credentials.txt is 2 parts or not
	                    return true; //returns true if it satiesfies the above requirements in the if statement
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false; //returns false if it does not satisfy the above requirements in the if statement
	    }
	    
	  //Done by Sri Ram Reddy
	    private boolean isValidCredentials2(String password) {//takes password as an arguement.(true of false function)
	        try {
	            List<String> lines = Files.readAllLines(Paths.get("credentials.txt"));//makes an array of credentials from credentials.txt
	            for (String line : lines) {
	                String[] parts = line.split(":"); //splits the username and password into 2 parts
	                if (parts.length == 2 && parts[1].equals(password)) {//checks if the entered password matches with the password in the
	                	// credentials.txt and checks the obtained text from credentials.txt is 2 parts or not
	                    return true; //returns true if it satiesfies the above requirements in the if statement
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false; //returns false if it does not satisfy the above requirements in the if statement
	    }
		  //Done by Sri Ram Reddy
	    public void logout(ActionEvent event) throws IOException{ //logout function
	    	String password2 = logout_password.getText(); //initiated a string and assigned with the password we entered in the password field
	    	if (isValidCredentials2(password2)) { //this checks if the entered password in the logout page is valid or not.
	        	//messageLabel.setText("Login Successful");
	        		Object root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));//this loads the loginscreen if thevalid password is entered in the logout password field
	        		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		Scene scene = new Scene((Parent) root);
	        		stage.setScene(scene);
	        		stage.show();
	        }
	    	else if(password2.isEmpty()) {
	        	message_logout.setText("Password field is empty");
	        	message_logout.setTextFill(Color.RED);
	        	logout_password.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
	        }
	    	else {
	    		message_logout.setText("Please enter correct Password!");
	    		message_logout.setTextFill(Color.RED);
	    	}
	    }
	    //Done by Sri Ram Reddy
	    public void switchtoEffortLoggerConsolePage(ActionEvent event) throws IOException {
			Object root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene((Parent) root);
			stage.setScene(scene);
			stage.show();
	    }
	   
	    public void admin(ActionEvent event) throws IOException{
			adm = 1;
			em = 0;// made by kevin
			//help with improper privilege management
		}
		public void employee(ActionEvent event) throws IOException{
			em = 1;
			adm =0;// made by kevin
			//help with improper privilege management
		}
}