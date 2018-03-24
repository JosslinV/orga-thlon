package Database.RequestDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DatabaseSettings;

public class RequestCourse {
	
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    
	public static String requestNom(int id) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();

			preparedStatement = database.prepareStatement("SELECT nom_course from Orgathlon.Course WHERE id_Course = " + id);
			resultSet = preparedStatement.executeQuery();

			String nom = "";

			while (resultSet.next()) {
				nom = nom + resultSet.getString("nom_course");
			}
			return nom;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
	
	
	
}
