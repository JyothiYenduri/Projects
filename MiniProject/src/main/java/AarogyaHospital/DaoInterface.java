package AarogyaHospital;

public interface DaoInterface {
	
	public void patientRegistration(Patient p);
	public void displayAllPatients();
	public void searchByID();
	public void searchByCity();
	public void searchByAge();
	public void recoveryStatus();
	public void deletePatient();
}
