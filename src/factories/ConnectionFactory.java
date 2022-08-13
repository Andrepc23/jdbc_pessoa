package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String url = "jdbc:postgresql://localhost:5432/bd_aula03";
	private static final String user = "postgres";
	private static final String password = "coti";
	private static final String driver = "org.postgresql.Driver";

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);

	}

}
