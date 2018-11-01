package Pack1;
import java.sql.Connection;
import java.lang.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {
	public static void main(String[] args) throws Exception {
		getConnection();
	}

	public static Connection getConnection() throws Exception{
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/oopmproj","akshay_07cf","@kshayps9");

			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Records_MissingPpl");

			while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getLong(2)+" "+rs.getString(3)+" "+rs.getString(4));

			conn.close();
			}catch(Exception e) {System.out.println(e);}
		return null;
}
}
