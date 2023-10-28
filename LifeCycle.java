package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LifeCycle {
	
	private SimpleStringProperty index, name, effortCategory, deliverable;
	
	public LifeCycle (String index, String name, String effortCategory, String deliverable) 
	{
		this.index = new SimpleStringProperty(index);
		this.name = new SimpleStringProperty(name);
		this.effortCategory = new SimpleStringProperty(effortCategory);
		this.deliverable = new SimpleStringProperty(deliverable);
	}
	
	public String toString() 
	{
		String s = this.getIndex() + "|" + this.getName() + "|" + this.getEffortCategory() 
			       + "|" + this.getDeliverable() + "\n";
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
	
	public StringProperty effortCategoryProperty() 
	{
		return effortCategory;
	}
	
	public StringProperty deliverableProperty() 
	{
		return deliverable;
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
	
	public String getEffortCategory() 
	{
		return effortCategory.get();
	}

	public void setEffortCategory(String effortCategory) 
	{
		this.effortCategory = new SimpleStringProperty(effortCategory);
	}
	
	public String getDeliverable() 
	{
		return deliverable.get();
	}

	public void setDeliverable(String deliverable) 
	{
		this.deliverable = new SimpleStringProperty(deliverable);
	}
	
	
	
	
}
