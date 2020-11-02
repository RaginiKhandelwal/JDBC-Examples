package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingEx {
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
		 Statement st=con.createStatement();
		 con.setAutoCommit(false);
		 st.addBatch("insert into professor values('BBB','finance')");
		 st.addBatch("insert into committee values('finance','BBB')");
		// st.addBatch("update location set city='ujjain' where country='uttar pradesh' ");
        // st.addBatch("delete from professor where pname='ragini'");
		 st.executeBatch();
         //int res[]=st.executeBatch();
//         boolean flag=false;
//         for(int i=0;i<res.length;i++)
//         {
//        	 if(res[i]==0)
//        		 flag=true;
//        	 if(flag)
//        		 con.rollback();
//        	 else
//        		 flag=false;
//         }

		 con.commit();
		 con.close();
	}
}
