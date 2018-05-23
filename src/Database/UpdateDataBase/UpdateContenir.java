package Database.UpdateDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DatabaseSettings;
import modele.Course;
import modele.Tache;

public class UpdateContenir {
	
	private static PreparedStatement preparedStatement = null;

	public void updateDatabase(Course course, Tache oldTache, Tache newTache) {
			
		try {
			Connection database = DatabaseSettings.connect();
	
			preparedStatement = database.prepareStatement("UPDATE Orgathlon.Contenir SET id_Tache=? WHERE id_Course =? AND id_Tache=?");
			preparedStatement.setInt(1, newTache.getId_tache());
			preparedStatement.setInt(2, course.getId_course());
			preparedStatement.setInt(3, oldTache.getId_tache());
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
		
	}
}
