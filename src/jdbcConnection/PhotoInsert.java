package jdbcConnection;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PhotoInsert {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
	
	String sql="insert into photodata values(?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, "aabhas");
	
	File f=new File("C:\\Users\\Ragini\\Desktop\\photos\\aabhascam\\DSC04786.JPG");
	FileInputStream fis=new FileInputStream(f);
	
	ps.setBinaryStream(2, fis,(int)f.length());
//	System.out.println("inserting image"+f.getAbsolutePath());
	ps.executeUpdate();
	 int rc= ps.executeUpdate();
	if(rc==0)
		System.out.println("image  not inserted");		
	else
System.out.println("image inserted");
	
	fis.close();
	ps.close();
	con.close();
	
}
}
