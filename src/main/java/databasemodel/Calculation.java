package databasemodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    private int number1;
	    private int number2;
	    private String operation;

	    public int getid() {
	        return id;
	    }
	    public void setid(int id) {
	        this.id = id;
	    }
	    public int getnumber1() {
	        return number1;
	    }
	    public void setnumber1(int number1) {
	        this.number1 = number1;
	    }
	    public int getnumber2() {
	        return number2;
	    }
	    public void setnumber2(int number2) {
	        this.number2 = number2;
	    }
	    public String getOperation() {
	        return operation;
	    }
	    public void setOperation(String operation) {
	        this.operation = operation;
	    }

}
