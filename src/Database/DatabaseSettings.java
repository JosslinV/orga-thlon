package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseSettings {

	private static final String SERVEUR = "intra.info.iut-tlse3.fr/Orgathlon";
	private static final String USER = "ptutas3";
	private static final String MDP = "Mdp2ptutas3";
	private static Connection connect;
	
	public static Connection connect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://"+ SERVEUR + "user="+ USER +"&password="+ MDP);
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