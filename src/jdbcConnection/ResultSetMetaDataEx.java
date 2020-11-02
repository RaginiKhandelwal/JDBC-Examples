package jdbcConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataEx {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
	
	DatabaseMetaData dbmd=con.getMetaData();
	System.out.println("database version="+dbmd.getDatabaseMajorVersion());
	System.out.println("driver name="+dbmd.getDriverName());
	System.out.println("driver minor version="+dbmd.getDriverMinorVersion());
	System.out.println("sql keywords="+dbmd.getSQLKeywords());
	System.out.println("jdbc version="+dbmd.getJDBCMajorVersion());
	System.out.println("user name="+dbmd.getUserName());
	
	String sql="select * from weather";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	ResultSetMetaData rsmd=rs.getMetaData();
	
	System.out.println("total columns="+rsmd.getColumnCount());
	System.out.println("name of first col="+rsmd.getColumnName(1));
	System.out.println("type of first col="+rsmd.getColumnType(1));
	System.out.println("size of col 1="+rsmd.getColumnDisplaySize(1));
	
	
	con.close();
	
}
}
