package Database.InputDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modele.Course;

import Database.DatabaseSettings;

public class InputCourse {
	
	private PreparedStatement preparedStatement;
    
	public void inputCourse(Course donnees) throws Exception {
		try {
			Connection database = DatabaseSettings.connect();
			
			preparedStatement = database.prepareStatement("INSERT into Orgathlon.Course values (default,?,?,?,?,?,?,?,?,?,?");
			preparedStatement.setString(1, donnees.getNom());
			preparedStatement.setString(2, donnees.getFormat());
			preparedStatement.setDate(3, null);									//TODO date
			preparedStatement.setString(4, donnees.getDescriptionCourse());
			preparedStatement.setString(5, donnees.getLieu());
			preparedStatement.setInt(6, donnees.getNbParticipants());
			preparedStatement.setString(7, donnees.getParcours());
			preparedStatement.setFloat(8, donnees.getBudget());
			preparedStatement.setBoolean(9, donnees.isAgrement());
			preparedStatement.setString(10, donnees.getType_epreuve());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
}
