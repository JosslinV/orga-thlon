package Database.InputDataBase;

import java.sql.Connection;
import java.sql.Date;

import modele.Course;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;

public class InputCourse {

    private static PreparedStatement preparedStatement = null;
    
	public static void input(Course donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("insert into  Orgathlon.Course values (default, ?, ?, ?, ? , ?, ?,?,?,?,?,?,?)");
			preparedStatement.setString(1, donnees.getNom());
			preparedStatement.setString(2, donnees.getFormat());
			preparedStatement.setDate(3,new java.sql.Date(donnees.getDateC().getTime()));
			preparedStatement.setString(4, donnees.getDescriptionCourse());
			preparedStatement.setString(5, donnees.getLieu());
			preparedStatement.setBoolean(6, donnees.isAgrement());
			preparedStatement.setDouble(7, donnees.getBudget());
			preparedStatement.setInt(8, donnees.getNbParticipants());
			preparedStatement.setString(9, donnees.getParcours());
			preparedStatement.setString(10, donnees.getNom_ville());
			preparedStatement.setInt(11, donnees.getCp_ville());
			preparedStatement.setString(12, donnees.getType_epreuve());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
