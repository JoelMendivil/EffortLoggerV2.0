package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Deliverable {
	
private SimpleStringProperty index, name;
	
	public Deliverable (String index, String name) 
	{
		this.index = new SimpleStringProperty(index);
		this.name = new SimpleStringProperty(name);
	}
	
	public String toString() 
	{
		String s = this.getIndex() + "|" + this.getName() + "\n";
		return s;
	}
	
	public StringProperty indexProperty() 
	{
		return index;
	}
	
	public StringProperty nameProperty() 
	{
		return name;
	}
	
	public String getIndex() 
	{
		return index.get();
	}

	public void setIndex(String index) 
	{
		this.index = new SimpleStringProperty(index);
	}
	
	public String getName() 
	{
		return name.get();
	}

	public void setName(String name) 
	{
		this.name = new SimpleStringProperty(name);
	}

}
