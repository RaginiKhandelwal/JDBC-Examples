package jdbcConnection;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DateRetrieve {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
		
		con.setAutoCommit(true);
		String sql="select * from datetable";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		//printing dates as recived from database
		while (rs.next())
		{
			String fname=rs.getString(1);
			String fvalue=rs.getString(2);
			System.out.println(fname+" "+fvalue);
		}
		System.out.println("-------------------------------------");
		rs.first();
		//printing dates in dd-mmm-yyyy format
		while(rs.next())
		{
			String fname=rs.getString(1);
			java.sql.Date fdate=rs.getDate(2);
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
			
			java.util.Date utildate=fdate;
			String formattedvalue=sdf.format(utildate);
			System.out.println(fname+" "+formattedvalue);
			//output???
			 
		}
		rs.close();
		con.close();
		st.close();
}
}