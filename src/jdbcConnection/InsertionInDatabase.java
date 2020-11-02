package jdbcConnection;

import java.sql. *;

public class InsertionInDatabase {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
		Statement st=con.createStatement();
		con.setAutoCommit(false);
		int i=st.executeUpdate("insert into emp values(101,'ragini','indore',5000)");
		con.commit();
		System.out.println(con.getClass().getName());
		System.out.println(st.getClass().getName());
		con.close();
		
}
}