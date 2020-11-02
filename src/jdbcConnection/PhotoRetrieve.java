package jdbcConnection;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class PhotoRetrieve {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oct","root","root");
     Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from photodata");
rs.first();
InputStream in=rs.getBinaryStream("photo");
FileOutputStream fos=new FileOutputStream("C:\\Users\\Ragini\\Desktop\\blob-clob\\1.png ");

int bytesRead=0;
byte[]buffer=new byte[4096];

while((bytesRead=in.read(buffer))!=-1)
{
	fos.write(buffer,0,bytesRead);
}

System.out.println("photo stored");

fos.close();
in.close();
rs.close();
st.close();
con.close();
		
	}

}
