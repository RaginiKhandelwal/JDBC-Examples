package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchProcessingEx2 {
public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
           
		 PreparedStatement ps=con.prepareStatement("insert into professor values(?,?)");
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter professor name=");
		 String s1=sc.nextLine();
		 ps.setString(1,s1);
		 
		 System.out.println("enter deptartment name=");
		 String s2=sc.nextLine();
		 ps.setString(2,s2);
		 
		 ps.setString(1,"CCC");
		 ps.setString(2,"maths");
		 ps.addBatch();
		 
//		 System.out.println("want to add more records-yes/no");
//		 String s3=sc.nextLine();
//		 if(s3.equals("no"))
//		 { break;}
//		 
	 	int i[]= ps.executeBatch();
	 	if(i!=null)
	 		
		 System.out.println("record successfully inserted");
	 	else
	 		System.out.println("failed");
     }
}

