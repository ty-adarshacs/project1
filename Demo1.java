import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		System.out.println(" connection suceffullly");
		return con;
		
	}

}
