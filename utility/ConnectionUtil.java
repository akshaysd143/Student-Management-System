package utility;
import java.sql.*;

public final class ConnectionUtil {
	public static Connection getDBConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akshay" ,"root","");
		return con;
	}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
