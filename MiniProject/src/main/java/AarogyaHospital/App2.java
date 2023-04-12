package AarogyaHospital;

import java.util.Scanner;

public class App2 {
	public void patientRecords() {
		Scanner sc=new Scanner(System.in);
    	try {
    	DaoInterface dao=new DaoImpl();
        
    	int i=1;
    	 while (i>0){
      System.out.println("----------Patient Registration---------");
      System.out.println("[1]. Add new Patient");
      System.out.println("[2]. To view all available Patients");
      System.out.println("[3]. To serch Patient by Unique ID");
      System.out.println("[4]. To search a patient from a particular city");
      System.out.println("[5]. To search a patient from a particular age");
      System.out.println("[6]. To mark recovery of a patient");
      System.out.println("[7]. To delete Data of a patient");
      //System.out.println("[0]. To exit");
      System.out.println("Enter your choice ");
      int n = sc.nextInt();
      switch (n) {
        case 1:
        	Patient p=new Patient();
        	sc.nextLine();
            System.out.println("Enter Name of the patient: ");
            String pname=sc.nextLine();
            System.out.println("Enter patient gender: ");
            String pgen=sc.nextLine();
            System.out.println("enter adhar number");
            String paadhar=sc.nextLine();
            while (!((paadhar).length() == 12)) {
              System.out.println("Invlaid aadhar number");
              System.out.println("enter adhar number again");
              paadhar = sc.nextLine();
            }
            System.out.println("Enter your phone number");
            String phnnum = sc.nextLine();
            while (!(phnnum.length() == 10)) {
              System.out.println("Invlaid phone number");
              System.out.println("enter phone number again");
              phnnum = sc.nextLine();
            }
            System.out.println("enter patient city");
            String city = sc.nextLine();
            System.out.println("enter patient address");
            String address = sc.nextLine();
            System.out.println("enter date of admission(dd-mm-yyy)");
            String dateofadmission = sc.nextLine();
            System.out.println("enter guardian name");
            String guardianname = sc.nextLine();
            System.out.println("enter guardian address ");
            String guardianaddress = sc.nextLine();
            System.out.println("Enter guardian phone number");
            String guardianphnnum = sc.nextLine();
            while (!((guardianphnnum).length() == 10)) {
              System.out.println("Invlaid  guardian phone number");
              System.out.println("enter guardian phone number again");
              guardianphnnum = sc.nextLine();
            }
            System.out.println("enter patient age");
            int age = sc.nextInt();
            
            while (!(String.valueOf(age).length() == 1 || String.valueOf(age).length() == 2)) {
              System.out.println("Invalid age");
              System.out.println("enter patient age");
              age = sc.nextInt();
            }
            p.setName(pname);
            p.setGender(pgen);
            p.setAadharNumber(paadhar);
            p.setContactNumber(phnnum);
            p.setCity(city);
            p.setAddress(address);
            p.setDateOfAdmission(dateofadmission);
            p.setGuardianName(guardianname);
            p.setGuardianAddress(guardianaddress);
            p.setGuardianContactNumber(guardianphnnum);
            p.setAge(age);
            p.setstatus("NotRocovered");
            dao.patientRegistration(p);
                    
          break;
        case 2:
          dao.displayAllPatients();
          break;
        case 3:
          dao.searchByID();
          break;
        case 4:
          dao.searchByCity();
          break;
        case 5:
        dao.searchByAge();  
          break;
        case 6:
          
          dao.recoveryStatus();
          dao.displayAllPatients();
          break;
        case 7:
        	dao.deletePatient();
            dao.displayAllPatients();
          break;
        /*case 0:
          System.exit(0);
          break;*/
        default:
          System.out.println("invalid choice");
      }
      i--;
    	 }
        
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
        }
}
