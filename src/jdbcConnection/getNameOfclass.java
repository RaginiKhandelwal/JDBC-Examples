package jdbcConnection;

import java.sql.*;
 

public class getNameOfclass {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		System.out.println(con.getClass().getName());
		System.out.println(st.getClass().getName());
		System.out.println(rs.getClass().getName());
	}
}
