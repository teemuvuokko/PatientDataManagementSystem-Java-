package patientmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;

public class TableController implements Initializable {
	
	@FXML
	private TableView<PatientData> table;
	@FXML
	private TableColumn<PatientData, String> col_id;
	@FXML
	private TableColumn<PatientData, String> col_name;
	@FXML
	private TableColumn <PatientData,String> col_address;
	@FXML
	private TableColumn <PatientData,String> col_doa;
	@FXML
	private TableColumn <PatientData,String> col_injury;
	@FXML
	private TableColumn <PatientData,String> col_doctor;
	@FXML
	private TableColumn <PatientData,String> col_medicalprocedures;
	
	
	@FXML
	private TextField textfieldId;
	@FXML
	private TextField textfieldName;
	@FXML
	private TextField textfieldAddress;
	@FXML
	private TextField textfieldInjury;
	@FXML
	private DatePicker textfieldDoa;
	@FXML
	private TextField textfieldDoctor;
	@FXML
	private TextField textfieldMedicalprocedures;
	
	private DatabaseConnector dc;
	
	//SQL command to view all data 
	private String sql ="SELECT * FROM data";
		
	ObservableList<PatientData> oblist;
	
	public void initialize(URL url, ResourceBundle resources) {
		this.dc = new DatabaseConnector();
	}
	
	// Loads patients data from mySQLdatabase 
	@FXML
	private void loadPatientData(ActionEvent event) throws SQLException{
		try {
			Connection conn = DatabaseConnector.getConnection();
			this.oblist = FXCollections.observableArrayList();
			
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				this.oblist.add(new PatientData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
	} catch (SQLException e) {
		System.err.println("Error " + e);
	}	
		/*Populates populates cell within table columns and sets them to FXCollection observableArraylist.
		 * After that it populates the table with values of property items.
		 */
		this.col_id.setCellValueFactory(new PropertyValueFactory <>("id"));
		this.col_name.setCellValueFactory(new PropertyValueFactory <>("name"));
		this.col_address.setCellValueFactory(new PropertyValueFactory <>("address"));
		this.col_doa.setCellValueFactory(new PropertyValueFactory <>("doa"));
		this.col_injury.setCellValueFactory(new PropertyValueFactory <>("injury"));
		this.col_doctor.setCellValueFactory(new PropertyValueFactory <>("doctor"));
		this.col_medicalprocedures.setCellValueFactory(new PropertyValueFactory <>("medicalprocedures"));
		
		this.table.setItems(this.oblist);
	
		
			}
	//Adds a new patient to the database
	@FXML
	private void addPatient(ActionEvent event) {
		String sqlInsert = "INSERT INTO data (id,name,address,doa,injury,doctor,medicalprocedures) VALUES (?,?,?,?,?,?,?)";
		try {
			Connection conn = DatabaseConnector.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlInsert);
			
			statement.setString(1, this.textfieldId.getText());
			statement.setString(2, this.textfieldName.getText());
			statement.setString(3, this.textfieldAddress.getText());
			statement.setString(4, this.textfieldDoa.getEditor().getText());
			statement.setString(5, this.textfieldInjury.getText());
			statement.setString(6, this.textfieldDoctor.getText());
			statement.setString(7, this.textfieldMedicalprocedures.getText());
			
			statement.execute();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// Resets the text fields by setting their value to empty string
	@FXML
	private void clearFields(ActionEvent event) {
		this.textfieldId.setText("");
		this.textfieldName.setText("");
		this.textfieldAddress.setText("");
		this.textfieldDoa.setValue(null);
		this.textfieldInjury.setText("");
		this.textfieldDoctor.setText("");
		this.textfieldMedicalprocedures.setText("");
		
		
		
	}
}
