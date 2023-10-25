package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {
	
	private SimpleStringProperty number, name, step1, step2, step3;
	
	public Project(String number, String name, String step1, String step2, String step3) {
		this.name = new SimpleStringProperty(name);
		this.number = new SimpleStringProperty(number);
		this.step1 = new SimpleStringProperty(step1);
		this.step2 = new SimpleStringProperty(step2);
		this.step3 = new SimpleStringProperty(step3);
		
	}
	
	public String toString() {
		String s = this.getNumber() + "|" + this.getName() + "|" + this.getStep1()
				   + "|" + this.getStep2() + "|" + this.getStep3() + "\n";
		return s;
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public StringProperty numberProperty() {
		return number;
	}
	
	public StringProperty step1Property() {
		return step1;
	}
	
	public StringProperty step2Property() {
		return step2;
	}
	
	public StringProperty step3Property() {
		return step3;
	}

	public String getName() {
		return name.get();
	}

	/////Change all set methods to be like this
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	//////////////////////////////////////////////

	public String getNumber() {
		return number.get();
	}

	public void setNumber(SimpleStringProperty number) {
		this.number = number;
	}

	public String getStep1() {
		return step1.get();
	}

	public void setStep1(String step1) {
		this.step1 = new SimpleStringProperty(step1);
	}

	public String getStep2() {
		return step2.get();
	}

	public void setStep2(String step2) {
		this.step2 = new SimpleStringProperty(step2);
	}

	public String getStep3() {
		return step3.get();
	}

	public void setStep3(String step3) {
		this.step3 = new SimpleStringProperty(step3);
	}

	
	

}
