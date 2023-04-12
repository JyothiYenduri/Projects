package AarogyaHospital;
import java.sql.*;
import java.util.Scanner;
public class DaoImpl implements DaoInterface{
	int id1;
	Scanner sc=new Scanner(System.in);
	Connection con;
	DaoImpl(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aarogya","root","");
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	public void patientRegistration(Patient p) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into patient(name, gender, aadharNumber, contactNumber, city, address, dateOfAdmission, guardianName, guardianAddress, guardianContactNumber,age,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,p.getName());
			pstmt.setString(2,p.getGender());
			pstmt.setString(3,p.getAadharNumber());
			pstmt.setString(4,p.getContactNumber());
			pstmt.setString(5,p.getCity());
			pstmt.setString(6,p.getAddress());
			pstmt.setString(7,p.getDateOfAdmission());
			pstmt.setString(8,p.getGuardianName());
			pstmt.setString(9,p.getGuardianAddress());
			pstmt.setString(10,p.getContactNumber());
			pstmt.setInt(11,p.getAge());
			pstmt.setString(12,p.isstatus());
			
			
			int i=pstmt.executeUpdate();
			if(i!=0) {
			System.out.println("Patient registered successfully");
			}
			else {
			System.out.println("patient is not registered successfully");
			}
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public void displayAllPatients() {
		try {
		Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("SELECT * FROM patient");
		 ResultSetMetaData rsmd=rs.getMetaData();
		 int colscount=rsmd.getColumnCount();
		 for(int i=1;i<=colscount;i++)
		 {
		 System.out.print(rsmd.getColumnName(i)+"\t ");
		 }
		 System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		 while(rs.next())
		 {
		 for(int i=1;i<=colscount;i++)
		 {
		 System.out.print(rs.getString(i)+"\t");
		 }
		 System.out.println();
		 }
		 //con.close();
		 }
		 catch(Exception e) {
		 System.out.println(e);
		 }
	}
	public void searchByID() {
		System.out.println("Enter patient ID to search: ");
		id1=sc.nextInt();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM patient");
			 ResultSetMetaData rsmd=rs.getMetaData();
			 int colscount=rsmd.getColumnCount();
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rsmd.getColumnName(i)+"\t ");
			 }
			 System.out.println("\n--------------------------------------------------------------------------------");
			 while(rs.next())
			 {
				if(rs.getInt(1)==id1) {
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rs.getString(i)+"\t ");
			 }
			 System.out.println();
			 }
			 }
			 //con.close();
			 }
			 catch(Exception e) {
			 System.out.println(e);
			 }
	}
	public void searchByCity() {
		System.out.println("Enter patient city to search: ");
		String city=sc.nextLine();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM patient");
			 ResultSetMetaData rsmd=rs.getMetaData();
			 int colscount=rsmd.getColumnCount();
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rsmd.getColumnName(i)+"\t ");
			 }
			 System.out.println("\n----------------------------------------");
			 while(rs.next())
			 {
				if(rs.getString(6).equalsIgnoreCase(city)) {
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rs.getString(i)+"\t ");
			 }
			 System.out.println();
			 }
			 }
			 //con.close();
			 }
			 catch(Exception e) {
			 System.out.println(e);
			 }
	}
	public void searchByAge() {
		System.out.println("Enter patient starting age group to search: ");
		int tage1=sc.nextInt();
		System.out.println("Enter patient ending age group to search: ");
		int tage2=sc.nextInt();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM patient");
			 ResultSetMetaData rsmd=rs.getMetaData();
			 int colscount=rsmd.getColumnCount();
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rsmd.getColumnName(i)+"\t ");
			 }
			 System.out.println("\n----------------------------------------");
			 while(rs.next())
			 {
				if(rs.getInt(12)>=tage1&&rs.getInt(12)<=tage2) {
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print(rs.getString(i)+"\t ");
			 }
			 System.out.println();
			 }
			 }
			 //con.close();
			 }
			 catch(Exception e) {
			 System.out.println(e);
			 }	
	}
	public void recoveryStatus() {
		try {
			System.out.println("Enter patient ID to search: ");
			id1=sc.nextInt();
		PreparedStatement pstmt=con.prepareStatement("UPDATE patient SET status='recovered' WHERE id="+id1+"");
			
        

       int i=pstmt.executeUpdate();
                if(i==1)
                {
                    System.out.println("Record Updated Successfully"); 
                    
                }
                else
                {
                  System.out.println("ERROR OCCUR WHILE Updating");
                }    

               //con.close();  
       }
       catch(Exception e) {
           System.out.println(e);
       }
	}
	public void deletePatient() {
		
		try {
			System.out.println("Enter patient ID to search: ");
			id1=sc.nextInt();
			PreparedStatement pstmt=con.prepareStatement("DELETE FROM patient WHERE id="+id1+"");
			
        

       int i=pstmt.executeUpdate();
                if(i==1)
                {
                    System.out.println("Record deleted Successfully"); 
                    
                }
                else
                {
                  System.out.println("ERROR OCCUR WHILE deleting");
                }    

               //con.close();  
       }
       catch(Exception e) {
           System.out.println(e);
       }
	}
}
