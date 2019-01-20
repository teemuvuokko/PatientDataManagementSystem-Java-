package patientmanagementsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientData {
	
	private final StringProperty id;
	private final StringProperty name;
	private final StringProperty address;
	private final StringProperty doa;
	private final StringProperty injury;
	private final StringProperty doctor;
	private final StringProperty medicalprocedures;
	
	
	
	public PatientData(String id, String name, String address, String doa, String injury, 
			String doctor, String medicalprocedures) {
		
		// default constructor
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.address =new SimpleStringProperty (address);
		this.doa = new SimpleStringProperty(doa);
		this.injury = new SimpleStringProperty(injury);
		this.doctor = new SimpleStringProperty(doctor);
		this.medicalprocedures = new SimpleStringProperty(medicalprocedures); 
		
	}

		
	// Getters and setters
	public String getName() {
		return name.get();	
	}
	
	public void setName(String value) {
		name.set(value);
		}
	
	public String getId() {
		return id.get();
	}
	
	public void setId(String value) {
		id.set(value);
	}
	
	public String getAddress() {
		return address.get();
	}

	public void setAddress(String value) {
		address.set(value);
	}

	public String getDoa() {
		return doa.get();
	}

	public void setDoa(String value) {
		doa.set(value);
	}

	public String getInjury() {
		return injury.get();
	}

	public void setInjury(String value) {
		injury.set(value);
	}

	public String getDoctor() {
		return doctor.get();
	}

	public void setDoctor(String value) {
		doctor.set(value);
	}

	public String getMedicalprocedures() {
		return medicalprocedures.get();
	}

	public void setMedicalprocedures(String value) {
		medicalprocedures.set(value);
	}

	

	
}
