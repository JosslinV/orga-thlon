package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseSettings {

	private static final String SERVEUR = "Azimut-Pulsar.ddns.net/Orgathlon";
	private static final String USER = "";
	private static final String MDP = "";
	private static Connection connect;
	
	public static Connection connect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://"+ SERVEUR + "?user="+ USER +"&password="+ MDP);
			return connect;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void close() throws SQLException {
		try {
			connect.close();
		} catch (SQLException e) {
			throw e;
		}
	}
}