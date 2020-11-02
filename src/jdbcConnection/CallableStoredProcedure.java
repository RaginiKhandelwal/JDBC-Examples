package jdbcConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableStoredProcedure {
	public static void main(String[] args) throws Exception {
		
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
    String sql="{call getProfessorName()}";
	 CallableStatement cs=con.prepareCall(sql);
	 ResultSet rs=cs.executeQuery();
	 
	 while(rs.next())
	 {
		 System.out.println(rs.getString(1));//+" "+rs.getString(2));
	 }
	 con.close();
	}
}