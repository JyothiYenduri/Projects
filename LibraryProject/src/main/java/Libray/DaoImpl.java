package Libray;
import java.sql.*;
import java.util.*;

public class DaoImpl implements DaoInterface {
	int ISBN1;
	Scanner sc=new Scanner(System.in);
	Connection con;
	DaoImpl(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
	}
	catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	public void addNewBook(Book b) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into books(title,author,yop)values(?,?,?)");
			pstmt.setString(1,b.getTitle());
			pstmt.setString(2,b.getAuthor());
			pstmt.setString(3,b.getYop());
						
			int i=pstmt.executeUpdate();
			if(i!=0) {
			System.out.println("book added successfully");
			}
			else {
			System.out.println("book is not added successfully");
			}
			//con.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public void viewAllBooks() {
		try {
		Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("SELECT * FROM books");
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
	public void deletBook() {
		try {
			System.out.println("Enter book ID to search: ");
			ISBN1=sc.nextInt();
			PreparedStatement pstmt=con.prepareStatement("DELETE FROM books WHERE ISBN="+ISBN1+"");
			
        

       int i=pstmt.executeUpdate();
                if(i==1)
                {
                    System.out.println("Book deleted Successfully"); 
                    
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
