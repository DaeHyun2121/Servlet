package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static Connection getConn() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		return con;
	}
}
