package jdbcConnection;

 
 
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClobRetrieve {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
     Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select resume from clobdata where name='aabhas khandelwal'");
    rs.first();
     Reader reader=rs.getCharacterStream("resume");// resume is field name in database
    PrintWriter writer= new PrintWriter("C:\\\\Users\\\\Ragini\\\\Desktop\\\\blob-clob\\\\3.txt");
    
    int i=0;
    while((i=reader.read())!=-1)
    {
    	writer.write(i);
    }
    System.out.println("text file stored");
    writer.close();
    rs.close();
    reader.close();
    con.close();
}
}
