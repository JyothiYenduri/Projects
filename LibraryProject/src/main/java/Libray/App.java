package Libray;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        try {
        	  	DaoInterface dao=new DaoImpl();
                
                
                
                do {
              System.out.println("----------Choices---------");
              System.out.println("[1]. Add new Book");
              System.out.println("[2]. To view all available Books");
              System.out.println("[3]. To delete a book in library");
              System.out.println("[0]. To exit");
              System.out.println("Enter your choice ");
              int n = sc.nextInt();
              switch (n) {
                case 1:
                	Book b=new Book();
                	sc.nextLine();
                    System.out.println("Enter Book title: ");
                    String btitle=sc.nextLine();
                    System.out.println("Enter Author Name: ");
                    String bauthor=sc.nextLine();
                    System.out.println("Enter Year of Publish: ");
                    String byop=sc.nextLine();
                    b.setTitle(btitle);
                    b.setAuthor(bauthor);
                    b.setYop(byop);
                    dao.addNewBook(b);
                  break;
                case 2:
                  dao.viewAllBooks();
                  break;
                case 3:
                	dao.deletBook();
                    dao.viewAllBooks();
                  break;
                case 0:
                  System.exit(0);
                  break;
                default:
                  System.out.println("invalid choice");
              }
            } while (true);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
}
