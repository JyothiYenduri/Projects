package AarogyaHospital;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DaoImpl1 implements DaoInterface1 {
	int id1;
	Scanner sc=new Scanner(System.in);
	Connection con1;
	DaoImpl1(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/aarogya","root","");
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	public void supplierRegistration(Supplierdetails s) {
		try {
		
			PreparedStatement pstmt=con1.prepareStatement("insert into supplierdata (suppliername,dateofsupply,timeofsupply) values(?,?,?)");
			pstmt.setString(1,s.getSuppliername());
			pstmt.setString(2,s.getDateofsupply());
			pstmt.setString(3,s.getTimeofsupply());
			int i=pstmt.executeUpdate();
			if(i!=0) {
			System.out.println("supplier registered successfully");
			}
			else {
			System.out.println("supplier is not registered successfully");
			}
			//con1.close();
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public void viewAllSupplier() {
		try {
			Statement st=con1.createStatement();
			 ResultSet rs=st.executeQuery("SELECT * FROM supplierdata");
			 ResultSetMetaData rsmd=rs.getMetaData();
			 int colscount=rsmd.getColumnCount();
			 
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print("    "+rsmd.getColumnName(i)+"\t ");
			 }
			 System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
			 while(rs.next())
			 {
			 for(int i=1;i<=colscount;i++)
			 {
			 System.out.print("\t"+rs.getString(i)+"\t");
			 }
			 System.out.println();
			 }
			 //con1.close();
			 
			
			
			}
			 catch(Exception e) {
			 System.out.println(e);
			 }
	}
	
		public void searchBySupplierId(){
			System.out.println("Enter supplier ID to search: ");
			int id1=sc.nextInt();
			try {
				Statement st=con1.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM  supplierdata where supplierId="+id1+"");
				 ResultSetMetaData rsmd=rs.getMetaData();
				 int colscount=rsmd.getColumnCount();
				 
				 for(int i=1;i<=colscount;i++)
				 {
				 System.out.print(rsmd.getColumnName(i)+"\t ");
				 }
				 System.out.println("\n-------------------------------------------------------------------------------------------------------");
				 while(rs.next())
				 {
					
				 for(int i=1;i<=colscount;i++)
				 {
				 System.out.print(rs.getString(i)+"\t ");
				 }
				 System.out.println();
				 }
				 
				 //con1.close();
				 }
				 catch(Exception e) {
				 System.out.println(e);
				 }
	}
		 public void deleteBySupplierId() {
				
				try {
					System.out.println("Enter supplier ID to search: ");
					int id2=sc.nextInt();
					PreparedStatement pstmt=con1.prepareStatement("DELETE FROM supplierdata WHERE supplierId="+id2+"");
					
		        

		       int i=pstmt.executeUpdate();
		                if(i==1)
		                {
		                    System.out.println("Record deleted Successfully"); 
		                    
		                }
		                else
		                {
		                  System.out.println("ERROR OCCUR WHILE deleting");
		                }    

		               //con1.close();  
		       }
		       catch(Exception e) {
		           System.out.println(e);
		       }
			}
		 public void medicineRegistration(MedicineDetails s1) {
				try {
				
					PreparedStatement pstmt=con1.prepareStatement("insert into   medicinedata (medicinename,unitprice,quantity,dateofmanufacture,dateofexpiry) values(?,?,?,?,?)");
					pstmt.setString(1,s1.getMedicinename());
					pstmt.setString(2,s1.getUnitprice());
					pstmt.setString(3,s1.getQuantity());
					pstmt.setString(4,s1.getDateofmanufacture());
					pstmt.setString(5,s1.getDateofExpiry());
					int i=pstmt.executeUpdate();
					if(i!=0) {
					System.out.println("medicine registered successfully");
					}
					else {
					System.out.println("medicine is not registered successfully");
					}
					//con1.close();
			}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
			public void viewAllMedicine() {
				try {
					Statement st=con1.createStatement();
					 ResultSet rs=st.executeQuery("SELECT * FROM medicinedata");
					 ResultSetMetaData rsmd=rs.getMetaData();
					 int colscount=rsmd.getColumnCount();
					 
					 for(int i=1;i<=colscount;i++)
					 {
					 System.out.print("    "+rsmd.getColumnName(i)+"\t ");
					 }
					 System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
					 while(rs.next())
					 {
					 for(int i=1;i<=colscount;i++)
					 {
					 System.out.print("\t"+rs.getString(i)+"\t");
					 }
					 System.out.println();
					 }
					 //con1.close();
					 
					
					
					}
					 catch(Exception e) {
					 System.out.println(e);
					 }
			}
			public void searchByMedicineId(){
				System.out.println("Enter medicine ID to search: ");
				int id1=sc.nextInt();
				try {
					Statement st=con1.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM  medicinedata where medicineId="+id1+"");
					 ResultSetMetaData rsmd=rs.getMetaData();
					 int colscount=rsmd.getColumnCount();
					 
					 for(int i=1;i<=colscount;i++)
					 {
					 System.out.print(rsmd.getColumnName(i)+"\t ");
					 }
					 System.out.println("\n-------------------------------------------------------------------------------------------------------");
					 while(rs.next())
					 {
						
					 for(int i=1;i<=colscount;i++)
					 {
					 System.out.print(rs.getString(i)+"\t ");
					 }
					 System.out.println();
					 }
					 
					 //con1.close();
					 }
					 catch(Exception e) {
					 System.out.println(e);
					 }
		}
			 public void deleteByMedicineId() {
					
					try {
						System.out.println("Enter medicine ID to search: ");
						int id2=sc.nextInt();
						PreparedStatement pstmt=con1.prepareStatement("DELETE FROM medicinedata WHERE medicineId="+id2+"");
						
			        

			       int i=pstmt.executeUpdate();
			                if(i==1)
			                {
			                    System.out.println("Record deleted Successfully"); 
			                    
			                }
			                else
			                {
			                  System.out.println("ERROR OCCUR WHILE deleting");
			                }    

			               con1.close();  
			       }
			       catch(Exception e) {
			           System.out.println(e);
			       }
				}
}
