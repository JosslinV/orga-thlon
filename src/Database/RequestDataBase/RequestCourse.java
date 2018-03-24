package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RequestCourse {
	
	private static final String SERVEUR = "intra.info.iut-tlse3.fr/Orgathlon";
	private static final String USER = "ptutas3";
	private static final String MDP = "Mdp2ptutas3";
	
	private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    
	public static String requestNom(int id) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+ SERVEUR + "user="+ USER +"&password="+ MDP);
			statement = connect.createStatement();

			preparedStatement = connect.prepareStatement("SELECT nom_course from testorga.course WHERE id_Course = " + id);
			resultSet = preparedStatement.executeQuery();

			String nom = "";

			while (resultSet.next()) {
				nom = nom + resultSet.getString("nom_course");
			}
			return nom;

		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
		}
	}
	
	
}
