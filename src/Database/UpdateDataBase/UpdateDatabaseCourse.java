package Database.UpdateDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;

import modele.Course ;

import Database.DatabaseSettings;

public class UpdateDatabaseCourse {

	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Course donnees) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Course SET nom_course=?, format_course=?, date_course=?, description_course=?, lieu=?, nb_participants=?, parcours=?, budget=?, agrementFTTRI=?, type_epreuve=? WHERE id_Course =?");
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
			preparedStatement.setInt(11, donnees.getId_course());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}