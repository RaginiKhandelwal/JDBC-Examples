package jdbcConnection;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClobInsert {
public static void main(String[] args) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
	 PreparedStatement ps=con.prepareStatement("insert into clobdata values(?,?)");
	    File file=new File("C:\\Users\\Ragini\\Downloads\\PrestigePoint\\Jdbc-Servlet pendrive\\ResultSetMetaDataDemo.java");
	    long length=file.length();
	    
	    FileReader reader=new FileReader(file);
	    ps.setString(1,"aabhas khandelwal");
	    ps.setCharacterStream(2, reader,(int)length);
	    
	    int res=ps.executeUpdate();
	    if(res==0)
	    
	    	System.out.println("record not inserted");
	    
	    else
	    
	    	System.out.println("record inserted");
	    
	    reader.close();
	       ps.close();
	       con.close();
}
}
