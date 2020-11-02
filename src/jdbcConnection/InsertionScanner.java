package jdbcConnection;

import java.sql. *;
import java.util.Scanner;


public class InsertionScanner {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter did=");
		int did=sc.nextInt();
		System.out.println("enter dep name=");
		String name=sc.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
String sql="insert into dep values(?,?)";
PreparedStatement ps=con.prepareStatement(sql);
 ps.setInt(1,did);
 ps.setString(2,name);
 int i=ps.executeUpdate();
 if(i!=0)
	   System.out.println("added");
 else
	   System.out.println("failed");
 sc.close();
 con.close();

	}
}