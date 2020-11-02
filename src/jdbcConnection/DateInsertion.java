package jdbcConnection;

//import java.io.*;
import java.sql. *;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertion {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");

 
//DataInputStream dis=new DataInputStream(System.in);
// 
//System.out.println("enter date in yyyy-mm-dd ");
//String s1=dis.readLine();
//System.out.println("enter date in dd-mmm-yyyy ");
//String s2=dis.readLine();
//System.out.println("enter date in dd-mm-yyyy ");
//String s3=dis.readLine();

Scanner sc=new Scanner(System.in);
System.out.println("enter date in yyyy-mm-dd ");
String s1= sc.next();
System.out.println("enter date in dd-mmm-yyyy ");
String s2=sc.next();
System.out.println("enter date in dd-mm-yyyy ");
String s3=sc.next();


//yyyy-mm-dd
String sql="insert into datetable values(?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, "yyyy-mm-dd");
	ps.setDate(2,java.sql.Date.valueOf(s1));
	
	int res=ps.executeUpdate();
	if(res==1)
	System.out.println("no problem in yyyy-mm-dd");
	else
		System.out.println("problem in yyyy-mm-dd");
	
	
	//convert string date into java.sql.date class object
	//dd-mmm-yyyy
	ps.setString(1,"DD-MMM-YYYY");
	SimpleDateFormat sdf=new SimpleDateFormat("DD-MMM-YYYY");
	java.util.Date date= sdf.parse(s2);
	
	long ms=date.getTime();
	java.sql.Date sqldate=new java.sql.Date(ms);
	ps.setDate(2,sqldate);
	res=ps.executeUpdate();
	if(res==1)
		System.out.println("no problem in dd-mmm-yyyy");
		else
			System.out.println("problem in dd-mmm-yyyy");
	
	
	//dd-mm-yyyy
	
	ps.setString(1,"DD-MM-YYYY");
	SimpleDateFormat sdf1=new SimpleDateFormat("DD-MM-YYYY");
	java.util.Date date1= sdf1.parse(s3);
	
	long ms1=date1.getTime();
	java.sql.Date sqldate1=new java.sql.Date(ms1);
	ps.setDate(2,sqldate1);
	res=ps.executeUpdate();
	if(res==1)
		System.out.println("no problem in  dd-mm-yyyy");
		else
			System.out.println("problem in dd-mm-yyyy");
	
	ps.close();
	con.close();
	sc.close();
	}
	
}