package jdbcConnection;

import java.sql.*;


public class PreparedStatementEx1  {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
 		String sql="insert into dep values(?,?)";
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setInt(1, 105);
       ps.setString(2,"account");
 
       int i=ps.executeUpdate();
       if(i!=0)
      	   System.out.println("added");
       else
    	   System.out.println("failed");
       con.close();
}
}
