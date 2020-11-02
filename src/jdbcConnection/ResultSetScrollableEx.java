package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetScrollableEx {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
    Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    
//    ResultSet rs=st.executeQuery("select * from department");
//    con.setAutoCommit(false);
//    System.out.println("update 3rd record");
//    rs.first();
//    rs.absolute(3);
//    rs.updateString(1,"aaa");
//    rs.updateRow();
//   
    
    //con.commit();
   // con.setAutoCommit(false);
  //  int i=st.executeUpdate("insert into department values('d3','loss')");
   // con.commit();
    
   // st.executeUpdate("delete from department where d_id='d3'");
    
    ResultSet rs=st.executeQuery("select * from department");
  con.setAutoCommit(false);
  System.out.println("update 3rd record");
  rs.first();
  rs.absolute(3);
  rs.updateString(1,"bbb");
  rs.updateRow();
    
       rs.beforeFirst();
  while(rs.next())
    {
    	System.out.println(rs.getString(1));
    }
    rs.close();
	st.close();
	con.close(); 
}
}
