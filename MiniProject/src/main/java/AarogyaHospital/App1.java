package AarogyaHospital;

import java.util.Scanner;

public class App1 {
	
	public void  medicineRecords() {
		Scanner sc=new Scanner(System.in);
		Medicine md= new Medicine(); 
			int i=1;
			while(i>0){
			      System.out.println("----------Medicine Records---------");
			      System.out.println("[1]. supplier details ");
			      System.out.println("[2]. medicine details");
			     
		    
			System.out.println("enter your choice");
			int n=sc.nextInt();
			switch(n){
			case 1:
				md.supplierDetails();
				break;
			case 2:
				md.medicineDetails();
				break;
			
			default:
				System.out.println("invalid choice");
				break;
			}
			i--;
		   }
			
		   }
	}

	class Medicine{
		DaoInterface1 s1=new DaoImpl1();
		void supplierDetails() {
			Scanner sc=new Scanner(System.in);
			
			int i=1;
		while (i>0){
		      System.out.println("----------Supplier Details---------");
		      System.out.println("[1]. supplier registartion ");
		      System.out.println("[2]. view all supplier details");
		      System.out.println("[3]. Search by id ");
		      System.out.println("[4]. Delete by id ");
		      //System.out.println("[0].Exit");
	   
		System.out.println("enter your choice");
		int n1=sc.nextInt();
		switch(n1){
		case 1:
			Supplierdetails s=new Supplierdetails();
			System.out.println("enter supplier name");
			 String suppliername=sc.next();
			 System.out.println("enter date of supply");
			 String dateofsupply=sc.next();
			 System.out.println("enter time of supply");
			 String timeofsupply=sc.next();
			 
	    	s.setSuppliername(suppliername);
	    	s.setDateofsupply(dateofsupply);
	    	s.setTimeofsupply(timeofsupply);
			s1.supplierRegistration(s);
			break;
		case 2:
			s1.viewAllSupplier();
			break;
		case 3:
			s1.searchBySupplierId();
			break;
		case 4:
			s1.deleteBySupplierId();
			break;
			default:
				System.out.println("invalid choice");
				break;
	}
		i--;
		}
		}
	void medicineDetails() {
		Scanner sc=new Scanner(System.in);
		int i=1;
	while (i>0){
	      System.out.println("----------Medicine Details---------");
	      System.out.println("[1]. medicine registartion ");
	      System.out.println("[2]. view all medicine details");
	      System.out.println("[3]. Search by id ");
	      System.out.println("[4]. Delete by id ");
	      //System.out.println("[0].Exit");

	System.out.println("enter your choice");
	int n1=sc.nextInt();
	switch(n1){
	case 1:
		MedicineDetails m1=new MedicineDetails();
		System.out.println("enter medicine name");
		 String medicinename=sc.next();
		 System.out.println("enter unit price of medicine");
		 String unitprice=sc.next();
		 System.out.println("enter quantity of medicine");
		 String quantity=sc.next();
		 System.out.println("enter date of manufacture");
		 String dateofmanufacture=sc.next();
		 System.out.println("enter date of expiry");
		 String dateofexpiry=sc.next();
		m1.setMedicinename(medicinename);
		m1.setUnitprice(unitprice);
		m1.setQuantity(quantity);
		m1.setDateofmanufacture(dateofmanufacture);
		m1.setDateofExpiry(dateofexpiry);
		s1.medicineRegistration(m1);
		break;
	case 2:
		s1.viewAllMedicine();
		break;
	case 3:
		s1.searchByMedicineId();
		break;
	case 4:
		s1.deleteByMedicineId();
		break;
	default:
		System.out.println("invalid choice");
		break;
		
	}
	i--;
	}
	}
}

