/**
 * 
 */
package br.mahl.javafx.main;

import br.mahl.javafx.main.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author MatheusMahl
 *
 */
public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	/*
	 * @FXML private Label postalCodeLabel;
	 * 
	 * @FXML private Label cityLabel;
	 * 
	 * @FXML private Label birthdayLabel;
	 */

	// Reference to the main application.
	private Main mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PersonOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastName());

		showPersonDetails(null);

		personTable.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}

	public void showPersonDetails(Person pessoa) {
		if (pessoa == null) {
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
		} else {
			firstNameLabel.setText(pessoa.getFirstName().get());
			lastNameLabel.setText(pessoa.getLastName().get());
			streetLabel.setText(pessoa.getStreet().get());
		}
	}
	
	@FXML
	private void handleDeletePerson(){
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
	        personTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}
	
}
