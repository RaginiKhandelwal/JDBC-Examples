package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionEx1 {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
	Statement st=con.createStatement();
	boolean b=st.execute("delete from emp where eid=101");
	System.out.println(b);
	int count=st.getUpdateCount();
	System.out.println(count);
	con.close();
}
}
