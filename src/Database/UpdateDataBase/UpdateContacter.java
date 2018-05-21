package Database.UpdateDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Course;
import modele.contacts.Benevole;

public class UpdateContacter {
	
	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Course course, Benevole oldBenevole, Benevole newBenevole) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Contacter SET id_Contact=? WHERE id_Course =? AND id_Contact=?");
			preparedStatement.setInt(1, newBenevole.getId_personne());
			preparedStatement.setInt(2, course.getId_course());
			preparedStatement.setInt(3, oldBenevole.getId_personne());
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}
