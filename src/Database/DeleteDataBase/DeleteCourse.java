package Database.DeleteDataBase;

import java.sql.Connection;
import java.sql.Statement;

import Database.DatabaseSettings;

public class DeleteCourse {
	
	public void deleteCourse(int id) {
		try {
			Connection database = DatabaseSettings.connect();
			
			Statement state = database.createStatement();
			state.executeQuery("DELETE * FROM Orgathlon.Course WHERE id_Course = "+ id +";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseSettings.close();
		}
	}
}
