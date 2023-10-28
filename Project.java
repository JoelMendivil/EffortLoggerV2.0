package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {
	
	private SimpleStringProperty number, name, step1, step2, step3, step4, step5, step6, step7,
								 step8, step9, step10, step11, step12, step13, step14, step15, step16;

	
	public Project(String number, String name, String step1, String step2, String step3, String step4, String step5,
			       String step6,String step7, String step8, String step9, String step10, String step11, String step12,
			       String step13, String step14, String step15, String step16) {
		this.name = new SimpleStringProperty(name);
		this.number = new SimpleStringProperty(number);
		this.step1 = new SimpleStringProperty(step1);
		this.step2 = new SimpleStringProperty(step2);
		this.step3 = new SimpleStringProperty(step3);
		this.step4 = new SimpleStringProperty(step4);
		this.step5 = new SimpleStringProperty(step5);
		this.step6 = new SimpleStringProperty(step6);
		this.step7 = new SimpleStringProperty(step7);
		this.step8 = new SimpleStringProperty(step8);
		this.step9 = new SimpleStringProperty(step9);
		this.step10 = new SimpleStringProperty(step10);
		this.step11 = new SimpleStringProperty(step11);
		this.step12 = new SimpleStringProperty(step12);
		this.step13 = new SimpleStringProperty(step13);
		this.step14 = new SimpleStringProperty(step14);
		this.step15 = new SimpleStringProperty(step15);
		this.step16 = new SimpleStringProperty(step16);
		
	}
	
	public String toString() {
		String s = this.getNumber() + "|" + this.getName() + "|" + this.getStep1() + "|" + this.getStep2() 
		           + "|" + this.getStep3() + "|" + this.getStep4() + "|" + this.getStep5() + "|" + this.getStep6() + "|" +
		           this.getStep7() + "|" + this.getStep8() + "|" + this.getStep9() + "|" + this.getStep10() + "|" +
		           this.getStep11() + "|" + this.getStep12() + "|" + this.getStep13() + "|" + this.getStep14() + "|" +
		           this.getStep15() + "|" + this.getStep16() + "\n";
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

	public StringProperty step4Property() {
		return step4;
	}
	
	public StringProperty step5Property() {
		return step5;
	}
	
	public StringProperty step6Property() {
		return step6;
	}
	
	public StringProperty step7Property() {
		return step7;
	}
	
	public StringProperty step8Property() {
		return step8;
	}
	
	public StringProperty step9Property() {
		return step9;
	}
	
	public StringProperty step10Property() {
		return step10;
	}
	
	public StringProperty step11Property() {
		return step11;
	}
	
	public StringProperty step12Property() {
		return step12;
	}
	
	public StringProperty step13Property() {
		return step13;
	}
	
	public StringProperty step14Property() {
		return step14;
	}
	
	public StringProperty step15Property() {
		return step15;
	}
	
	public StringProperty step16Property() {
		return step16;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

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
	
	public String getStep4() {
		return step4.get();
	}

	public void setStep4(String step4) {
		this.step4 = new SimpleStringProperty(step4);
	}
	
	public String getStep5() {
		return step5.get();
	}

	public void setStep5(String step5) {
		this.step5 = new SimpleStringProperty(step5);
	}
	
	public String getStep6() {
		return step6.get();
	}

	public void setStep6(String step6) {
		this.step6 = new SimpleStringProperty(step6);
	}
	
	public String getStep7() {
		return step7.get();
	}

	public void setStep7(String step7) {
		this.step7 = new SimpleStringProperty(step7);
	}
	
	public String getStep8() {
		return step8.get();
	}

	public void setStep8(String step8) {
		this.step8 = new SimpleStringProperty(step8);
	}
	
	public String getStep9() {
		return step9.get();
	}

	public void setStep9(String step9) {
		this.step9 = new SimpleStringProperty(step9);
	}
	
	public String getStep10() {
		return step10.get();
	}

	public void setStep10(String step10) {
		this.step10 = new SimpleStringProperty(step10);
	}
	
	public String getStep11() {
		return step11.get();
	}

	public void setStep11(String step11) {
		this.step11 = new SimpleStringProperty(step11);
	}
	
	public String getStep12() {
		return step12.get();
	}

	public void setStep12(String step12) {
		this.step12 = new SimpleStringProperty(step12);
	}
	
	public String getStep13() {
		return step13.get();
	}

	public void setStep13(String step13) {
		this.step13 = new SimpleStringProperty(step13);
	}
	
	public String getStep14() {
		return step14.get();
	}

	public void setStep14(String step14) {
		this.step14 = new SimpleStringProperty(step14);
	}
	
	public String getStep15() {
		return step15.get();
	}

	public void setStep15(String step15) {
		this.step15 = new SimpleStringProperty(step15);
	}
	
	public String getStep16() {
		return step16.get();
	}

	public void setStep16(String step16) {
		this.step16 = new SimpleStringProperty(step16);
	}

}
