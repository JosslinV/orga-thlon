package InputDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InputCourse {

	private static final String SERVEUR = "intra.info.iut-tlse3.fr/Orgathlon";
	private static final String USER = "ptutas3";
	private static final String MDP = "Mdp2ptutas3";
	
	private static Connection connect = null;
    private static PreparedStatement preparedStatement = null;
    
	public static void inputNom(String nom, boolean predefini) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+ SERVEUR + "user="+ USER +"&password="+ MDP);
			
			preparedStatement = connect.prepareStatement("insert into  Orgathlon.Course values (default, ?, ?, ?, ? , ?, ?,?,?,?,?,?,?)");
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, "");
			preparedStatement.setDate(3, new java.sql.Date(1900, 01, 01));
			preparedStatement.setString(4, "");
			preparedStatement.setString(5, "");
			preparedStatement.setBoolean(6, predefini);
			preparedStatement.setDouble(7, 0);
			preparedStatement.setInt(8, 3);
			preparedStatement.setString(9, "");
			preparedStatement.setString(10, "");
			preparedStatement.setInt(11, 00000);
			preparedStatement.setString(12, "");
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
		}
	}
}
