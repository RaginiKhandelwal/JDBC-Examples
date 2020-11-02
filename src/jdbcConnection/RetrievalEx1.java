package jdbcConnection;

import java.sql.*;


public class RetrievalEx1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
		String sql="select * from dep";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
		System.out.println("----Dep Table----");
		while(rs.next())
		{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		System.out.println(id+" "+name);
		}
		
		
		System.out.println("------------------------------------------");
		//select from emp table
		System.out.println("----Emp Table-----");
		String sql1="select *from emp";
		Statement  s1=con.createStatement();
		ResultSet rs1=s1.executeQuery(sql1);
		while(rs1.next())
		{
			int eid=rs1.getInt("eid");
			String name=rs1.getString("name");
			String address=rs1.getString("addtress");
			int salary=rs1.getInt("salary");
			int did=rs1.getInt("did");
			System.out.println(eid+" "+name+" "+address+" "+salary+" "+did);
		}
		con.close();
}
}