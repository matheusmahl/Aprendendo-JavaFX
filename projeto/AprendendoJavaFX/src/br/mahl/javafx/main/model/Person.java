/**
 * 
 */
package br.mahl.javafx.main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author MatheusMahl
 *
 */
public class Person {
	
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    
    public Person() {
		this(null,null);
	}
    
    public Person(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
    }
    
	public StringProperty getFirstName() {
		return firstName;
	}
	public StringProperty getLastName() {
		return lastName;
	}
	public StringProperty getStreet() {
		return street;
	}

}
